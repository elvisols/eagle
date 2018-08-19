/**
 * 
 */
package com.exelon.ee.model.callover;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "ee_callover")
@NamedQueries( {
	@NamedQuery(name = "UserActivity.findByDate", 	
			query = "select c from Callover c where c.txnDate = :date ")
})
public class Callover implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="callover_id_gen",  sequenceName="callover_id_seq",initialValue = 1, allocationSize = 1)
	@Id	@GeneratedValue(generator="callover_id_gen")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "txn_date")
	private Date txnDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "txn_time")
	private Date txnTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	public Date getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(Date txnTime) {
		this.txnTime = txnTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
