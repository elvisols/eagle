/**
 * 
 */
package com.exelon.ee.rs.user;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.exelon.ee.AppToken;
import com.exelon.ee.enums.UserStatus;
import com.exelon.ee.event.observer.UserEventObserver;
import com.exelon.ee.model.Role;
import com.exelon.ee.model.User;
import com.exelon.ee.model.dao.UserDAO;
import com.exelon.ee.qualifier.LoggedIn;
import com.exelon.ee.rs.EEExclusionStrategy;
import com.exelon.ee.rs.GsonAppResponse;
import com.exelon.ee.rs.RestfulApplication;
import com.exelon.ee.rs.StatusMessage;
import com.exelon.ee.util.PasswordService;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author ukaegbu
 *
 */

@Path("/users")
// @Interceptors(LoggedInInterceptor.class)
@Stateless
public class UserService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;

	@Inject
	private EntityManager em;

	/*
	 * @Inject
	 * 
	 * @UserCreatedEvent private Event<User> userCreatedEvent;
	 */

	@Inject
	private UserEventObserver userEvent;

	
	
	@Inject
	private UserDAO userDao;
	
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
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Asynchronous
	 * 
	 * @Lock(LockType.READ) private void sendMail(@Observes(during =
	 * TransactionPhase.AFTER_SUCCESS) User user){
	 * 
	 * }
	 */

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

		
		resp.setPayload(userDao.getAllUsers(user,start,size));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}

	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@HeaderParam("token") String token, @PathParam("id") Long id,
			@QueryParam("start") Integer start, @QueryParam("size") Integer size) {
		//AppResponse response = new AppResponse();
		List<StatusMessage> al = new ArrayList<>();

		AppToken appToken = RestfulApplication.validateToken(token);
		User actor = em.find(User.class, appToken.getUserId());
		if (!"admin".equalsIgnoreCase(actor.getRole().getId())) {
			al.add(new StatusMessage("01", "Insufficient Privilege to execute"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		} 
		
		//User actor = em.find(User.class, appToken.getUserId());
		User user = em.find(User.class, id);
		if (null == user) {
			al.add(new StatusMessage("01", "User with id does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		user.setDeleted(true);
		user.setDeletedBy(actor);
		user.setDeletedDate(new Date());

		em.merge(user);

		
		
		
		al.add(new StatusMessage("0", "Successfully deleted the user"));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		// logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}

	
	@PUT
	@Path("/enable")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response enableUser(User u, @HeaderParam("token") String token) {
		//AppResponse response = new AppResponse();
		List<StatusMessage> al = new ArrayList<>();

		AppToken appToken = RestfulApplication.validateToken(token);
		User actor = em.find(User.class, appToken.getUserId());
		User user = em.find(User.class, u.getId());
		if (null == user) {
			al.add(new StatusMessage("01", "User with id does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		if(!user.isDeleted()) {
			al.add(new StatusMessage("01", "User with id is disabled"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}
		user.setDeleted(false);
		user.setDeletedBy(actor);
		user.setDeletedDate(new Date());

		em.merge(user);

		al.add(new StatusMessage("0", "Successfully enabled the user"));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		// logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}

	
	
	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@LoggedIn
	public Response createUser(User user, @HeaderParam("token") String token) {
		// logger.log(Level.INFO, "The User sex type is "+user.getSex());
		//AppResponse response = new AppResponse();
		List<StatusMessage> al = new ArrayList<>();

		// does the email exist?
		if(userDao.emailExists(user)) {
			logger.log(Level.INFO,"User with email already exists "+user.getEmail());
			al.add(new StatusMessage("01", "User with email already exists"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}
		
		if(userDao.phoneExists(user)) {
			logger.log(Level.INFO,"User with mobile already exists"+user.getMobileNumber());
			al.add(new StatusMessage("01", "User with mobile already exists"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}


	
		Role r = em.find(Role.class, user.getRole().getId());
		// now check if the validations are okay
		user.setRole(r);

		// now get the plain text password
		String plainText = PasswordService.getInstance().generateRandomPassword();
		user.setPassword(PasswordService.getInstance().encrypt(plainText));

		user.setUserStatus(UserStatus.MUST_CHANGE_PASSWORD);
		// okay
		em.persist(user);

		
		user.setPlainTextPswd(plainText);

		Instant start = Instant.now();

		// userCreatedEvent.fire(user);
		userEvent.userCreatedNotification(user);

		Instant end = Instant.now();
		logger.log(Level.INFO, "" + Duration.between(start, end));

		// em.refresh(user);;
		logger.log(Level.INFO, "Successfully created user " + user.getEmail());

		al.add(new StatusMessage("0", "Successfully created the user " + user.getEmail()));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		// logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@LoggedIn
	public Response updateUser(User user, @HeaderParam("token") String token) {
		List<StatusMessage> al = new ArrayList<>();

		User u = em.find(User.class, user.getId());
		u.setEmail(user.getEmail());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setMiddleName(user.getMiddleName());
		u.setMobileNumber(user.getMobileNumber());
		u.setProfileEndDate(user.getProfileEndDate());
		u.setProfileStartDate(user.getProfileStartDate());

		Role r = em.find(Role.class, user.getRole().getId());
		// now check if the validations are okay
		u.setRole(r);

		// okay
		em.merge(u);
		// userCreatedEvent.fire(user);

		// em.refresh(user);;

		al.add(new StatusMessage("0", "Successfully updated the user"));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		// logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();
	}


	
	@PUT
	@Path("/changePassword")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(UserPasswordDTO user, @HeaderParam("token") String token) {
		//AppResponse response = new AppResponse();
		List<StatusMessage> al = new ArrayList<>();

		User u = em.find(User.class, user.getId());

		String opswd = PasswordService.getInstance().encrypt(user.getOldPassword());
		if (!u.getPassword().equals(opswd)) {
			/**
			 * TODO: Send a security message here
			 */
			al.add(new StatusMessage("01", "Invalid User password"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		if (!user.getNewPassword().equals(user.getNewPasswordRepeat())) {
			al.add(new StatusMessage("01", "Invalid Password Match"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		// does the password confirm
		try {
			PasswordService.validatePassword(user.getNewPassword());
		} catch (Exception e) {
			al.add(new StatusMessage("01", e.getMessage()));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}
		String pswd = PasswordService.getInstance().encrypt(user.getNewPassword());
		u.setPassword(pswd);
		u.setUserStatus(UserStatus.PASSWORD_CHANGED);
		// okay
		em.merge(u);

		userEvent.userPasswordChangedNotification(u);

		// userPasswordEvent.fire(u);
		// em.refresh(user);;

		al.add(new StatusMessage("0", "Successfully changed password"));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();
	}

	
	@PUT
	@Path("/resetPassword")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response resetPassword(User user, @HeaderParam("token") String token) {
		List<StatusMessage> al = new ArrayList<>();

		AppToken appToken = RestfulApplication.validateToken(token); // getPartnerCurrentYearAttendance
		User u = em.find(User.class, appToken.getUserId());

		if (!"admin".equalsIgnoreCase(u.getRole().getId())) {
			al.add(new StatusMessage("01", "You must be an admin to reset user password"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}
		// log.info("Email address is "+email.trim().toLowerCase());

		user = em.find(User.class, user.getId()); 
		if (null == user) {
			al.add(new StatusMessage("01", "User does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}

		String plainText = PasswordService.getInstance().generateRandomPassword();
		user.setPassword(PasswordService.getInstance().encrypt(plainText));

		user.setUserStatus(UserStatus.MUST_CHANGE_PASSWORD);
		// okay
		em.merge(user);
		user.setPlainTextPswd(plainText);

		// userCreatedEvent.fire(user);
		userEvent.userPasswordResetNotification(user);
		
		// em.refresh(user);;

		al.add(new StatusMessage("0", "Successfully sent password to email"));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		String j = gson.toJson(resp);
		// logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();
	}
	
	@SuppressWarnings("unchecked")
	@PUT
	@Path("/resendPassword")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response resendUserPassword(String email, @HeaderParam("token") String token) {
		List<StatusMessage> al = new ArrayList<>();

		// log.info("Email address is "+email.trim().toLowerCase());

		List<User> ul = em.createNamedQuery("User.findUserByEmail").setParameter("email", email.trim().toLowerCase())
				.getResultList();
		if (ul.isEmpty()) {
			al.add(new StatusMessage("01", "User with email does not exist"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		}
		User user = ul.get(0); // it is only one

		String plainText = PasswordService.getInstance().generateRandomPassword();
		user.setPassword(PasswordService.getInstance().encrypt(plainText));

		user.setUserStatus(UserStatus.MUST_CHANGE_PASSWORD);
		// okay
		em.merge(user);
		user.setPlainTextPswd(plainText);

		// userCreatedEvent.fire(user);
		userEvent.userPasswordResetNotification(user);
		
		
		// em.refresh(user);;

		al.add(new StatusMessage("0", "Successfully sent password to email"));
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
	@LoggedIn
	public Response search(@HeaderParam("token") String token, SearchUserDTO query, @QueryParam("start") Integer start,
			@QueryParam("size") Integer size) {
		//AppResponse response = new AppResponse();
		List<StatusMessage> al = new ArrayList<>();

		AppToken appToken  = RestfulApplication.validateToken(token);
		resp = new GsonAppResponse();
		
		User user = em.find(User.class, appToken.getUserId());
		if (!("admin".equalsIgnoreCase(user.getRole().getId()) || "googler".equalsIgnoreCase(user.getRole().getId()))) {
			al.add(new StatusMessage("01", "Insufficient Privilege to execute"));
			resp.setStatusMessages(al);
			resp.setStatus(400);
			return Response.status(200).entity(gson.toJson(resp)).build();
		} 

		al.add(new StatusMessage("0", "Success"));
		resp.setStatusMessages(al);
		resp.setStatus(200);

		resp.setPayload(userDao.search(user,start, size, query));
		String j = gson.toJson(resp);
		//logger.info("the value is"+j);

		return Response.status(200).entity(j.trim()).build();

	}

	@GET
	@LoggedIn
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserById(@HeaderParam("token") String token, @PathParam("id") Long id) {
		List<StatusMessage> al = new ArrayList<>();

		User ex = em.find(User.class, id);
		if (null == ex) {
			al.add(new StatusMessage("01", "User with the id does not exist"));
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

	@SuppressWarnings("unchecked")
	private List<User> getUsers() {
		return em.createNamedQuery("User.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	private List<User> getUsers(String term) {
		/*
		 * String sql =
		 * "select c.* from ds_course c where lower(c.name) like %:name% order by c.name "
		 * ; return em.createNativeQuery(sql, User.class).setParameter("name",
		 * term.toLowerCase()).getResultList();
		 */

		return em.createNamedQuery("User.findAllByUserName").setParameter("name", "%" + term.trim().toLowerCase() + "%")
				.getResultList();
	}

	private List<UserDTO> search(Integer start, Integer size, SearchUserDTO search) {
		if (null == start)
			start = 0;
		if (null == size)
			size = 20;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> q = cb.createQuery(User.class);
		Root<User> c = q.from(User.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		

		String fn = search.getFirstName();
		if (null != fn && fn.length() != 0) {
			
			predicates.add(
	                cb.like(cb.lower(c.get("firstName")), "%" + fn.toLowerCase() + "%"));
		}

		String ln = search.getLastName();
		if (null != ln && ln.length() != 0) {
			
			predicates.add(
	                cb.like(cb.lower(c.get("lastName")), "%" + ln.toLowerCase() + "%"));
		}

		Date st, ed;
		st = search.getStartDate();
		ed = search.getEndDate();
		if (null != st || null != ed) {
			if (null == ed)
				ed = st;
			if (null == st)
				st = ed; // UserDateType

			predicates.add(
	                cb.between(c.get("profileStartDate"), st, ed));
		}

		String rol = search.getUserRole();
		if (null != rol && rol.length() != 0) {
			Role r = em.find(Role.class, rol);
			
			predicates.add(
	                cb.equal(c.get("role"), r));
		
		}

		
		List<UserDTO> ul = new ArrayList<>();


		 q.select(c)
         .where(predicates.toArray(new Predicate[]{}));
		TypedQuery<User> query = em.createQuery(q);

		List<User> results = query.setFirstResult(start).setMaxResults(size).getResultList();

		results.forEach(r -> {
			ul.add(userDao.getUserDTO(r));
		});
		return ul;

	}

}
