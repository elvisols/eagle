/**
 * 
 */
package com.exelon.ee.rs.user;

import java.io.Serializable;
import java.util.List;

/**
 * @author ukaegbu
 *
 */
public class UserResult implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<UserDTO> users;
	private UserSummaryDTO summary;
	/**
	 * @return the users
	 */
	public List<UserDTO> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	/**
	 * @return the summary
	 */
	public UserSummaryDTO getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(UserSummaryDTO summary) {
		this.summary = summary;
	}
	
	

}
