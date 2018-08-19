/**
 * 
 */
package com.exelon.ee.rs.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jwk.JsonWebKey.Factory;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;

import com.exelon.ee.Credential;
import com.exelon.ee.JsonSecurity;
import com.exelon.ee.enums.UserStatus;
import com.exelon.ee.exception.JsonGenerationException;
import com.exelon.ee.exception.JsonMappingException;
import com.exelon.ee.model.Parameter;
import com.exelon.ee.model.User;
import com.exelon.ee.model.UserActivity;
import com.exelon.ee.qualifier.JSONSecurity;
import com.exelon.ee.qualifier.SystemParameter;
import com.exelon.ee.rs.EEExclusionStrategy;
import com.exelon.ee.rs.GsonAppResponse;
import com.exelon.ee.rs.StatusMessage;
import com.exelon.ee.util.PasswordService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * @author ukaegbu
 *
 */
@Path("/login")
@Stateless
public class LoginService {

	@Inject
	private Logger logger;

	@Inject
	@SystemParameter
	private Parameter parameter;

	@Inject
	private EntityManager em;
	
	@Inject
	@JSONSecurity
	private JsonSecurity json;

	@Context
	private HttpServletRequest request;

	public static JsonWebKey jwKey = null;

	private Gson gson;
	private GsonAppResponse resp = new GsonAppResponse();
	

	@PostConstruct
	public void initValues() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setExclusionStrategies(new EEExclusionStrategy());
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		gson = gsonBuilder.create();
	}
	
	
	// @Path("/authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Find person by e-mail", notes = "Find person by e-mail", response = User.class)
	@ApiResponses({ @ApiResponse(code = 404, message = "Person with such e-mail doesn't exist") })
	public Response authenticateCredentials(Credential cr)
			throws JsonGenerationException, JsonMappingException, IOException {

		List<StatusMessage> al = new ArrayList<>();
		logger.info("Authenticating User Credentials..." + cr.getUsername());
		//AuthJsonResponse res = new AuthJsonResponse();
		if (cr.getUsername() == null) {
			
			al.add(new StatusMessage("01", "User name does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		if (cr.getPassword() == null) {
			al.add(new StatusMessage("01", "No password was specified"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		User user = getUser(cr);
		if (user == null) {
			//logger.info("validating the user ... user is null");
			al.add(new StatusMessage("01", "Invalid Email/Password Combination"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
			
		} 
		
		if(user.isDeleted()) {
			al.add(new StatusMessage("01", "ou have been disabled from the system. Contact the Admin"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
			
		}
		
		if (user.getLastLoggedInDate() != null) {
			UserActivity ua = new UserActivity();
			ua.setLastLoggedInDate(user.getLastLoggedInDate());
			ua.setLastLoggedInTime(user.getLastLoggedInTime());
			ua.setLoggedInIp(user.getLoggedInIp());
			ua.setUser(user);

			em.persist(ua);
		}
		Date dt = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, parameter.getTimeout());
		
		user.setLastActiveTime(dt);
		user.setExpectedExpiryTime(cal.getTime());
		
		user.setLastLoggedInDate(dt);
		user.setLastLoggedInTime(dt);
		user.setLoggedInIp(request.getRemoteAddr());
		em.merge(user);
		

		String jwt = null;
		try {
			jwt = json.createUserToken(user);
		} catch (Exception e) {
			e.printStackTrace();
			al.add(new StatusMessage("01", e.getMessage()));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
			
		}


		// return Response.status(200).entity(jwt).build();
		UserDTO u = new UserDTO();
		u.setId(user.getId());
		u.setEmail(user.getEmail());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setMiddleName(user.getMiddleName());
		u.setMobileNumber(user.getMobileNumber());
		u.setRole(user.getRole());
		
		
		if(user.getUserStatus() == UserStatus.MUST_CHANGE_PASSWORD) {
			u.setMustChangePassword(true);
			
		}

		resp.setJwt(jwt); // jweSerialization
		resp.setUser(u);

		

		al.add(new StatusMessage("0", "Successfully retrieved"));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		// logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();
	}

	@SuppressWarnings("unchecked")
	private User getUser(Credential cr) {
		List<User> ul = new ArrayList<>();
		try {
			ul = em.createNamedQuery("User.findUserByIdAndPassword").setParameter("id", cr.getUsername().toLowerCase())
					.setParameter("password", PasswordService.getInstance().encrypt(cr.getPassword())).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ul.isEmpty())
			return null;
		return ul.get(0);
	}

	/**
	 * 
	 */
	public LoginService() {
		// TODO Auto-generated constructor stub
	}

}
