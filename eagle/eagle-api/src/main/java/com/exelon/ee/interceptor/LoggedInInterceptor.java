/**
 * 
 */
package com.exelon.ee.interceptor;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;


import org.joda.time.DateTime;
import org.joda.time.Minutes;

import com.exelon.ee.AppToken;
import com.exelon.ee.JsonSecurity;
import com.exelon.ee.enums.UserStatus;
import com.exelon.ee.model.Parameter;
import com.exelon.ee.model.User;
import com.exelon.ee.qualifier.JSONSecurity;
import com.exelon.ee.qualifier.SystemParameter;
import com.exelon.ee.rs.RestfulApplication;

/**
 * @author ukaegbu
 *
 */
@Interceptor
@LoggedIn
public class LoggedInInterceptor {
	@Resource
	private EJBContext context;

	@Inject
	private Logger logger;

	@Inject
	HttpServletRequest request;
	
	
	
	@Inject
	@JSONSecurity
	private JsonSecurity json;

	@Inject
	private EntityManager em;
	
	@Inject
	@SystemParameter
	private Parameter parameter;

	
	@AroundInvoke
	protected Object audit(InvocationContext ctx) throws Exception {
		//logger.log(Level.INFO, "We are intercepting the call here");
		//Principal p = context.getCallerPrincipal();
		String token = request.getHeader("token");
		if(null == token) {
			JsonObject obj = Json.createObjectBuilder().add("messages", "Token must be specified").build();
			return Response.status(403).entity(obj).build();
		}
		AppToken appToken = RestfulApplication.validateToken(token);
		
		if (null == appToken || null == appToken.getUserId()) {
			//Long last = 
			JsonObject obj = Json.createObjectBuilder().add("messages", "Not Logged in").build();
			return Response.status(401).entity(obj).build();
		}
		User u = em.find(User.class, appToken.getUserId());
		if(u.getUserStatus() == UserStatus.MUST_CHANGE_PASSWORD) {
			JsonObject obj = Json.createObjectBuilder()
					.add("messages", "You still have not chnaged your password").build();
			return Response.status(506).entity(obj).build();
		}
		
		// check if the token is about to expire
		
		
		u.setLastActiveTime(new Date());
		em.merge(u);
		
		// brute force approch for now
		
		// do some logging... } else {
		// logging and raising exception... }
		return ctx.proceed();
		
	}

}
