/**
 * 
 */
package com.exelon.ee.rs.login;

import java.io.Serializable;

import com.exelon.ee.model.Role;



/**
 * @author ukaegbu
 *
 */
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private Role role;
	private Long personId;
	private boolean mustChangePassword;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	/**
	 * @return the mustChangePassword
	 */
	public boolean isMustChangePassword() {
		return mustChangePassword;
	}
	/**
	 * @param mustChangePassword the mustChangePassword to set
	 */
	public void setMustChangePassword(boolean mustChangePassword) {
		this.mustChangePassword = mustChangePassword;
	}
	
	

}
