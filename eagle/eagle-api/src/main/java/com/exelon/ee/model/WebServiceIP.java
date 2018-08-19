/**
 * 
 */
package com.exelon.ee.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author ukaegbu
 *
 */
@Entity
@Table(name = "core_ws_ip")
public class WebServiceIP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 40,name="ip_address")
	private String ipAddress;
	
	private boolean allow;
	
	
	/**
	 * 
	 */
	public WebServiceIP() {
	}


	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}


	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}


	/**
	 * @return the allow
	 */
	public boolean isAllow() {
		return allow;
	}


	/**
	 * @param allow the allow to set
	 */
	public void setAllow(boolean allow) {
		this.allow = allow;
	}

}
