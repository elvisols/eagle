package com.exelon.ee.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Parameter
 *
 */
@Entity
@Table(name="core_parameter")
public class Parameter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT="system";
	
	@Id
	@Column(length=10)
	@JsonIgnore
	private String id;
	
	
	/**
	 * This is the login timeout per user session
	 */
	@Column()
	private Integer timeout;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getTimeout() {
		return timeout;
	}


	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	
	
	
}
