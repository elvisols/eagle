/**
 * 
 */
package com.exelon.ee.util.event;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.exelon.ee.model.User;
import com.exelon.ee.qualifier.LoggedIn;

/**
 * @author ukaegbu
 *
 */
public class EventConsumer {
	@Inject private Logger log;
	/**
	 * 
	 */
	public EventConsumer() {
	}

	
	public void userLoggedIn(@Observes RemitaEvent evt, @LoggedIn User user){
		log.info("User logged event consumer "+evt.getEventId());
		
	}
}
