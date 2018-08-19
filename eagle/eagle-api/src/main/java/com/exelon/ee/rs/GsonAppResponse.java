/**
 * 
 */
package com.exelon.ee.rs;

import java.io.Serializable;
import java.util.List;

import com.exelon.ee.rs.login.UserDTO;

/**
 * @author ukaegbu
 *
 */
public class GsonAppResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private List<StatusMessage> statusMessages;
	private Object payload;
	
	
	private String jwt;
	private UserDTO user;
	
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the statusMessages
	 */
	public List<StatusMessage> getStatusMessages() {
		return statusMessages;
	}
	/**
	 * @param statusMessages the statusMessages to set
	 */
	public void setStatusMessages(List<StatusMessage> statusMessages) {
		this.statusMessages = statusMessages;
	}
	/**
	 * @return the payload
	 */
	public Object getPayload() {
		return payload;
	}
	/**
	 * @param payload the payload to set
	 */
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	
	
}
