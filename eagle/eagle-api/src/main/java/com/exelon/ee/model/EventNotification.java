/**
 * 
 */
package com.exelon.ee.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.exelon.ee.event.EventType;


/**
 * @author ukaegbu
 *
 */
@Entity
@Table(name = "core_event_notification")
@NamedQueries( {
	@NamedQuery(name = "EventNotification.findByEvent", 	
			query = "select c from EventNotification c where c.eventType = :eventType and c.notified = false ")
})
public class EventNotification implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="event_activity_id_gen",  sequenceName="user_activity_id_seq",initialValue = 1, allocationSize = 1)
	@Id	@GeneratedValue(generator="event_activity_id_gen")
	private long id;
	
	/*@ManyToOne
	@JoinColumn(name="user_id", nullable = false)*/
	@Column(name="event_id", length=20, nullable=false)
	private String eventId;
	
	private boolean notified; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="notified_date", nullable = true)
	private Date notifiedDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="event_type", length=30, nullable=false)
	private EventType eventType;
	
	@ElementCollection(/*fetch = FetchType.EAGER*/)
    @MapKeyColumn(name="name", length=100)
    @Column(name="value", length=120)
    @CollectionTable(name="core_event_notification_attribute", joinColumns=@JoinColumn(name="id"))
    Map<String, String> attributes = new HashMap<String, String>(); // maps from attribute name to value

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	

	/**
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the notified
	 */
	public boolean isNotified() {
		return notified;
	}

	/**
	 * @param notified the notified to set
	 */
	public void setNotified(boolean notified) {
		this.notified = notified;
	}

	/**
	 * @return the notifiedDate
	 */
	public Date getNotifiedDate() {
		return notifiedDate;
	}

	/**
	 * @param notifiedDate the notifiedDate to set
	 */
	public void setNotifiedDate(Date notifiedDate) {
		this.notifiedDate = notifiedDate;
	}

	/**
	 * @return the eventType
	 */
	public EventType getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	
	

}
