/**
 * 
 */
package com.exelon.ee.model.exception;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.exelon.ee.model.AuditException;
import com.exelon.ee.model.Channel;
import com.exelon.ee.model.finacle.CMG;
import com.exelon.ee.model.finacle.GAM;

/**
 * @author ukaegbu
 *
 */
@Entity
@Table(name = "core_txn_exception")
@NamedQueries( {
	@NamedQuery(name = "ATE.findAll", 	query = "select c from AuditTxnException c  order by c.id  "),
})
public class AuditTxnException implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="audit_txn_exception_id_gen",  sequenceName="audit_txn_exception_id_seq", initialValue = 1, allocationSize = 1)
	@Id	@GeneratedValue(generator="audit_txn_exception_id_gen")
	private long id;

	@ManyToOne
	@JoinColumn(name="account_number", nullable = false)
	private GAM account;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="tran_date", nullable = false)
	private Date tranDate;
	
	@Column(nullable=false, length=15)
	private String tranId;
	
	@ManyToOne
	@JoinColumn(name="exception", nullable = false)
	private AuditException exception;
	
	@Column(name="dr_amount")
	private BigDecimal drAmount;
	
	@Column(name="cr_amount")
	private BigDecimal crAmount;
	
	@Column(name="txn_count")
	private Long txnCount;
	
	
	
	/**
	 * 
	 */
	public AuditTxnException() {
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}




	public Date getTranDate() {
		return tranDate;
	}



	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}





	public BigDecimal getDrAmount() {
		return drAmount;
	}



	public void setDrAmount(BigDecimal drAmount) {
		this.drAmount = drAmount;
	}



	public BigDecimal getCrAmount() {
		return crAmount;
	}



	public void setCrAmount(BigDecimal crAmount) {
		this.crAmount = crAmount;
	}



	public Long getTxnCount() {
		return txnCount;
	}



	public void setTxnCount(Long txnCount) {
		this.txnCount = txnCount;
	}



	public GAM getAccount() {
		return account;
	}



	public void setAccount(GAM account) {
		this.account = account;
	}



	public String getTranId() {
		return tranId;
	}



	public void setTranId(String tranId) {
		this.tranId = tranId;
	}



	public AuditException getException() {
		return exception;
	}



	public void setException(AuditException exception) {
		this.exception = exception;
	}

}
