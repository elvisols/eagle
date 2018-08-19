/**
 * 
 */
package com.exelon.ee.rs.account;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.exelon.ee.AppToken;
import com.exelon.ee.interceptor.LoggedInInterceptor;
import com.exelon.ee.model.User;
import com.exelon.ee.model.finacle.GAM;
import com.exelon.ee.model.finacle.dao.CmgDAO;
import com.exelon.ee.model.finacle.dao.GamDAO;
import com.exelon.ee.qualifier.LoggedIn;
import com.exelon.ee.rs.EEExclusionStrategy;
import com.exelon.ee.rs.GsonAppResponse;
import com.exelon.ee.rs.RestfulApplication;
import com.exelon.ee.rs.StatusMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author ukaegbu
 *
 */
@Interceptors(LoggedInInterceptor.class)
@Path("/accounts")
@Stateless
public class AccountService {

	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;
	
	
	
	@Inject
	private GamDAO gamDao;
	
	private Gson gson;
	private GsonAppResponse resp = new GsonAppResponse();
	
	
	@PostConstruct
	public void initValues() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setExclusionStrategies(new EEExclusionStrategy());
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		gson = gsonBuilder.create();
	}
	
	/**
	 * 
	 */
	public AccountService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GET
	@LoggedIn
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllUsers(@HeaderParam("token") String token, @QueryParam("start") Integer start,
			@QueryParam("size") Integer size) {
		//AppResponse response = new AppResponse();
		List<StatusMessage> al = new ArrayList<>();
		AppToken appToken  = RestfulApplication.validateToken(token);
		resp = new GsonAppResponse();
		
		User user = em.find(User.class, appToken.getUserId());
		if (!"admin".equalsIgnoreCase(user.getRole().getId())) {
			al.add(new StatusMessage("01", "Insufficient Privilege to execute"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		} 

		
		resp.setPayload(gamDao.getAllAccounts(user,start,size));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}
	
	
	@GET
	@LoggedIn
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserById(@HeaderParam("token") String token, @PathParam("id") String id) {
		List<StatusMessage> al = new ArrayList<>();

		GAM ex = em.find(GAM.class, id);
		if (null == ex) {
			al.add(new StatusMessage("01", "Account with the id does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		
		al.add(new StatusMessage("0", "Success"));
		resp.setPayload(ex);
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		// logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response search(@HeaderParam("token") String token, AccountSearchDTO query,
			@QueryParam("start") Integer start, @QueryParam("size") Integer size) {
		List<StatusMessage> al = new ArrayList<>();
		AppToken appToken  = RestfulApplication.validateToken(token);
		if (null == appToken) {
			al.add(new StatusMessage("01", "Session does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}
		
		//logger.info("start is "+start+" size is "+size);
		
		if (null == start)
			start = 0;
		if (null == size)
			size = 20;
		
			
		User user = em.find(User.class, appToken.getUserId());
		
		resp = new GsonAppResponse();

		al.add(new StatusMessage("0", "Successfully retrieved"));
		resp.setPayload(gamDao.search(user,start, size, query));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();
	}



}
