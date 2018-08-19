/**
 * 
 */
package com.exelon.ee.util.event;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ukaegbu
 *
 */
public class RemitaEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String eventId;
	private String description;
	private Date timeOfEvent;
	private String ipAddress;
	

	/**
	 * 
	 */
	public RemitaEvent() {
		// TODO Auto-generated constructor stub
	}


	public String getEventId() {
		return eventId;
	}


	public void setEventId(String eventId) {
		this.eventId = eventId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getTimeOfEvent() {
		return timeOfEvent;
	}


	public void setTimeOfEvent(Date timeOfEvent) {
		this.timeOfEvent = timeOfEvent;
	}


	public String getIpAddress() {
		return ipAddress;
	}


	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
