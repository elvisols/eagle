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
@Table(name = "core_ws_response")
public class WSReponseCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10,name="code")
	private String code;
	
	@Column(length = 40,name="description")
	private String description;
	
	
	/**
	 * 
	 */
	public WSReponseCode() {
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String ipAddress) {
		this.code = ipAddress;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



}
