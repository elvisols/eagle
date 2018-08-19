package com.exelon.ee.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.exelon.ee.model.User;
import com.exelon.ee.qualifier.LoggedIn;
import com.exelon.ee.qualifier.UserDatabase;
import com.exelon.ee.util.event.RemitaEvent;

@Named("login")
@SessionScoped
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	@Any
	private Event<RemitaEvent> event;

	@Inject
	Credentials credentials;
	
	@Inject
	private FacesContext ctx;
	
	@Inject Logger log;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	@UserDatabase
	EntityManager userDatabase;
	private User user;

	@SuppressWarnings("unchecked")
	public void login() {
		List<User> results = userDatabase
				.createQuery("select u from User u where u.username = :username and u.password = :password")
				.setParameter("username", credentials.getUsername()).setParameter("password", credentials.getPassword())
				.getResultList();
		if (!results.isEmpty()) {
			user = results.get(0);
			String uri = "home.xhtml";
		    try {
		    	ctx.getExternalContext().redirect(uri);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    log.info("User "+user.getFirstName()+" logged in successfully");
		    
		    // fire the vent
		    RemitaEvent e = new RemitaEvent();
		    e.setDescription("Successfully Logged In");
		    e.setEventId("LOGGED_IN");
		    e.setTimeOfEvent(new Date());
		    e.setIpAddress(request.getRemoteAddr());
		    event.fire(e);
		} else {
			// perhaps add code here to report a failed login
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Invalid Username or passsword."));
		}
	}

	public void logout() {
		user = null;
	}

	public boolean isLoggedIn() {
		return user != null;
	}

	@Produces
	@LoggedIn
	User getCurrentUser() {
		return user;
	}
}
