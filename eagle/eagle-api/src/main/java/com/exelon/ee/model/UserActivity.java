/**
 * 
 */
package com.exelon.ee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ukaegbu
 *
 */
@Entity
@Table(name = "core_user_activity")
@NamedQueries( {
	@NamedQuery(name = "UserActivity.findByUser", 	
			query = "select c from UserActivity c where c.user = :user ")
})
public class UserActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="user_activity_id_gen",  sequenceName="user_activity_id_seq",initialValue = 1, allocationSize = 1)
	@Id	@GeneratedValue(generator="user_activity_id_gen")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "last_log_date")
	private Date lastLoggedInDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "last_log_time")
	private Date lastLoggedInTime;
	
	@Column(length = 30, name = "logged_in_ip", unique = false, nullable = true)
	private String loggedInIp;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	
	/**
	 * 
	 */
	public UserActivity() {
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getLastLoggedInDate() {
		return lastLoggedInDate;
	}


	public void setLastLoggedInDate(Date lastLoggedInDate) {
		this.lastLoggedInDate = lastLoggedInDate;
	}


	public Date getLastLoggedInTime() {
		return lastLoggedInTime;
	}


	public void setLastLoggedInTime(Date lastLoggedInTime) {
		this.lastLoggedInTime = lastLoggedInTime;
	}


	public String getLoggedInIp() {
		return loggedInIp;
	}


	public void setLoggedInIp(String loggedInIp) {
		this.loggedInIp = loggedInIp;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
