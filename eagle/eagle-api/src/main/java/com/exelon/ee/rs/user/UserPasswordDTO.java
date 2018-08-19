/**
 * 
 */
package com.exelon.ee.rs.user;

import java.io.Serializable;

/**
 * @author ukaegbu
 *
 */
public class UserPasswordDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String oldPassword;
	private String newPassword;
	private String newPasswordRepeat;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return the newPasswordRepeat
	 */
	public String getNewPasswordRepeat() {
		return newPasswordRepeat;
	}
	/**
	 * @param newPasswordRepeat the newPasswordRepeat to set
	 */
	public void setNewPasswordRepeat(String newPasswordRepeat) {
		this.newPasswordRepeat = newPasswordRepeat;
	}
	
	

}
