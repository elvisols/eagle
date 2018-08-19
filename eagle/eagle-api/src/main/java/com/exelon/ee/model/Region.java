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
@Table(name = "core_region")
@NamedQueries( {
	@NamedQuery(name = "Region.findAll", 	query = "select c from Region c where c.deleted = false order by c.id  "),
})
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="region_id_gen",  sequenceName="region_id_seq", initialValue = 1, allocationSize = 1)
	@Id	@GeneratedValue(generator="region_id_gen")
	private long id;
	
	@Column(length = 30, name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(length = 150, name = "description", unique = false, nullable = true)
	private String description;
	
	private boolean deleted;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_date", nullable = true)
	protected Date deletedDate;
	
	@ManyToOne
	@JoinColumn(name="deleted_by")
	protected User deletedBy;
	
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isDeleted() {
		return deleted;
	}



	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	public Date getDeletedDate() {
		return deletedDate;
	}



	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}



	public User getDeletedBy() {
		return deletedBy;
	}



	public void setDeletedBy(User deletedBy) {
		this.deletedBy = deletedBy;
	}



	/**
	 * 
	 */
	public Region() {
		// TODO Auto-generated constructor stub
	}

}
