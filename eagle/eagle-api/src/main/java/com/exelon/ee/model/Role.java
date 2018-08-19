/**
 * 
 */
package com.exelon.ee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author ukaegbu
 *
 */
@Entity
@Table(name = "core_role")
@NamedQueries( {
	
	@NamedQuery(name = "Role.findAll", query = "select c from Role c  order by c.id ")
	
})
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id", length=15, nullable = false)
	private String id;
	
	@Column(name="name", length=20, nullable = false)
	private String name;
	
	@Column(name="description", length=20, nullable = true)
	private String description;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
