/**
 * 
 */
package com.exelon.ee.rs.exception;

import java.util.ArrayList;
import java.util.Date;
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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.exelon.ee.AppToken;
import com.exelon.ee.interceptor.LoggedInInterceptor;
import com.exelon.ee.model.AuditException;
import com.exelon.ee.model.Channel;
import com.exelon.ee.model.User;
import com.exelon.ee.model.dao.ChannelDAO;
import com.exelon.ee.model.dao.ExceptionDAO;
import com.exelon.ee.model.finacle.CMG;
import com.exelon.ee.model.finacle.GAM;
import com.exelon.ee.model.finacle.dao.CmgDAO;
import com.exelon.ee.qualifier.LoggedIn;
import com.exelon.ee.rs.EEExclusionStrategy;
import com.exelon.ee.rs.GsonAppResponse;
import com.exelon.ee.rs.RestfulApplication;
import com.exelon.ee.rs.StatusMessage;
import com.exelon.ee.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author ukaegbu
 *
 */
@Interceptors(LoggedInInterceptor.class)
@Path("/exceptions")
@Stateless
public class AuditExceptionService {

	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;
	
	
	
	@Inject
	private ExceptionDAO exceptionDao;
	
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
	public AuditExceptionService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GET
	@LoggedIn
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllExceptions(@HeaderParam("token") String token, @QueryParam("start") Integer start,
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

		
		resp.setPayload(exceptionDao.getAllExceptions(user,start,size));
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
	public Response getExceptionById(@HeaderParam("token") String token, @PathParam("id") Long id) {
		List<StatusMessage> al = new ArrayList<>();
		AppToken appToken  = RestfulApplication.validateToken(token);
		User user = em.find(User.class, appToken.getUserId());
		AuditException ex = em.find(AuditException.class, id);
		if (null == ex) {
			al.add(new StatusMessage("01", "Exception with the id does not exist"));
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

	
	@GET
	@LoggedIn
	@Path("/dashboard")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDashboard(@HeaderParam("token") String token, @QueryParam("start") Integer start,
			@QueryParam("size") Integer size) {
		List<StatusMessage> al = new ArrayList<>();

		AppToken appToken  = RestfulApplication.validateToken(token);
		User user = em.find(User.class, appToken.getUserId());
		
		al.add(new StatusMessage("0", "Success"));
		resp.setPayload(exceptionDao.getDashboard(user, start, size));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}
	
	
	@GET
	@LoggedIn
	@Path("/dashboard/customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDashboardByCustomer(@HeaderParam("token") String token, @PathParam("id") String id, @QueryParam("start") Integer start,
			@QueryParam("size") Integer size) {
		List<StatusMessage> al = new ArrayList<>();

		AppToken appToken  = RestfulApplication.validateToken(token);
		User user = em.find(User.class, appToken.getUserId());
		
		
		CMG ex = em.find(CMG.class, id);
		if (null == ex) {
			al.add(new StatusMessage("01", "Customer with the id does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		al.add(new StatusMessage("0", "Success"));
		resp.setPayload(exceptionDao.getDashboard(ex,user, start, size));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}

	
	@GET
	@LoggedIn
	@Path("/dashboard/account/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDashboardByAccount(@HeaderParam("token") String token, @PathParam("id") String id, @QueryParam("start") Integer start,
			@QueryParam("size") Integer size) {
		List<StatusMessage> al = new ArrayList<>();

		AppToken appToken  = RestfulApplication.validateToken(token);
		User user = em.find(User.class, appToken.getUserId());
		
		
		GAM ex = em.find(GAM.class, id);
		if (null == ex) {
			al.add(new StatusMessage("01", "Customer with the id does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		al.add(new StatusMessage("0", "Success"));
		resp.setPayload(exceptionDao.getDashboard(ex,user, start, size));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}
	
	
	@GET
	@LoggedIn
	@Path("/txns")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllCalloverDetailss(@HeaderParam("token") String token, @QueryParam("start") Integer start,
			@QueryParam("channel") Long c,@QueryParam("currency") String currency,
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

		Exception channel = em.find(Exception.class, c);
		if(null == channel) {
			al.add(new StatusMessage("01", "Exception with requested Id does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}
		resp.setPayload(exceptionDao.getExceptionTxns(user,channel,currency,start,size));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}

}
