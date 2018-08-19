/**
 * 
 */
package com.exelon.ee.rs.callover;

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
import com.exelon.ee.model.User;
import com.exelon.ee.model.dao.CalloverDAO;
import com.exelon.ee.model.dao.CalloverDAO;
import com.exelon.ee.model.finacle.DTD;
import com.exelon.ee.model.finacle.dao.GamDAO;
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
@Path("/callovers")
@Stateless
public class CalloverService {

	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;
	
	
	
	@Inject
	private CalloverDAO calloverDao;
	
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
	public CalloverService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GET
	@LoggedIn
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllCallovers(@HeaderParam("token") String token,@QueryParam("category") String category, 
			@QueryParam("tranDate") String tranDate, 
			@QueryParam("start") Integer start,	@QueryParam("size") Integer size) {
		
		//logger.info("Category is "+category+" date is "+tranDate);
		
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

		Date dt = null;
		if(null != tranDate) {
			dt = Util.parseDate(tranDate, "yyyy-MM-dd");
		}
		
		
		
		resp.setPayload(calloverDao.getAllCalloverSummaries(user,category,dt, start, size));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}
	
	
	@GET
	@Path("/categories")
	@LoggedIn
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCalloverCategories(@HeaderParam("token") String token, @QueryParam("start") Integer start,
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

		
		resp.setPayload(calloverDao.getCalloverCategories(user,start,size));
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
			@QueryParam("tranDate") String tranDate,@QueryParam("tranId") String tranId,
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

		Date dt = Util.parseDate(tranDate, "yyyy-MM-dd");
		resp.setPayload(calloverDao.getAllCalloverTxns(user,dt,tranId,start,size));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}
	
	
	@GET
	@LoggedIn
	@Path("/txn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTxn(@HeaderParam("token") String token, @QueryParam("serialNum") String serialNum,
			@QueryParam("tranDate") String tranDate,@QueryParam("tranId") String tranId) {
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

		Date dt = Util.parseDate(tranDate, "yyyy-MM-dd");
		resp.setPayload(calloverDao.getTxn(user,dt,tranId,serialNum));
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
	public Response getCalloverById(@HeaderParam("token") String token, @PathParam("id") Long id) {
		List<StatusMessage> al = new ArrayList<>();

		DTD ex = em.find(DTD.class, id);
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



}
