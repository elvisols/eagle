/**
 * 
 */
package com.exelon.ee;

import java.io.Serializable;

/**
 * @author ukaegbu
 *
 */
public class AppToken implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private Long userId;
	private Long role;
	

	/**
	 * 
	 */
	public AppToken() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	/**
	 * @return the tutorId
	 */
	public Long getRole() {
		return role;
	}


	/**
	 * @param tutorId the tutorId to set
	 */
	public void setRole(Long tutorId) {
		this.role = tutorId;
	}

}
