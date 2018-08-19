/**
 * 
 */
package com.exelon.ee.event.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.ejb.Asynchronous;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.exelon.ee.event.EventType;
import com.exelon.ee.model.EventNotification;
import com.exelon.ee.model.User;


/**
 * @author ukaegbu
 *
 */
@Named
@RequestScoped
public class UserEventObserver {
	private static final Logger logger = Logger.getLogger(UserEventObserver.class.getCanonicalName());

	
	
	@Inject
	private EntityManager em;
	
	@Asynchronous
	@Transactional
	public void userCreatedNotification(/*@Observes(notifyObserver = Reception.ALWAYS) @UserCreatedEvent*/ User user) {
		//logger.log(Level.INFO, "This is the observer to the user creation "+user.getEmail());
		
		EventNotification en = new EventNotification();
		en.setEventId(Long.toString(user.getId()));
		en.setEventType(EventType.userCreated);
		en.setNotified(false);
		Map<String, String> am = new HashMap<>();
		am.put("password", user.getPlainTextPswd());
		en.setAttributes(am);
		
		em.persist(en);
		
		//
	}
	
	@Asynchronous
	@Transactional
	public void userPasswordChangedNotification(/*@Observes(notifyObserver = Reception.ALWAYS) @UserCreatedEvent*/ User user) {
		//logger.log(Level.INFO, "This is the observer to the user creation "+user.getEmail());
		
		EventNotification en = new EventNotification();
		en.setEventId(Long.toString(user.getId()));
		en.setEventType(EventType.userPswdChanged);
		en.setNotified(false);
		
		
		em.persist(en);
		
		//
	}
	
	@Asynchronous
	@Transactional
	public void userPasswordResetNotification(/*@Observes(notifyObserver = Reception.ALWAYS) @UserCreatedEvent*/ User user) {
		//logger.log(Level.INFO, "This is the observer to the user creation "+user.getEmail());
		
		EventNotification en = new EventNotification();
		en.setEventId(Long.toString(user.getId()));
		en.setEventType(EventType.userPswdReset);
		en.setNotified(false);
		
		Map<String, String> am = new HashMap<>();
		am.put("password", user.getPlainTextPswd());
		en.setAttributes(am);
		
		em.persist(en);
		
		//
	}
	
	
}
