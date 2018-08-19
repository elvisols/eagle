/**
 * 
 */
package com.exelon.ee.model.channel;

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

import com.exelon.ee.model.Channel;
import com.exelon.ee.model.finacle.CMG;
import com.exelon.ee.model.finacle.GAM;

/**
 * @author ukaegbu
 *
 */
@Entity
@Table(name = "core_txn_by_channel")
@NamedQueries( {
	@NamedQuery(name = "CTC.findAll", 	query = "select c from Region c where c.deleted = false order by c.id  "),
})
public class AccountTxnByChannel implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="ctxn_id_gen",  sequenceName="ctxn_id_seq", initialValue = 1, allocationSize = 1)
	@Id	@GeneratedValue(generator="ctxn_id_gen")
	private long id;

	@ManyToOne
	@JoinColumn(name="account_number", nullable = false)
	private GAM account;
	
	
	@ManyToOne
	@JoinColumn(name="customer", nullable = true)
	private CMG customer;
	
	@Temporal(TemporalType.DATE)
	@Column(name="tran_date", nullable = false)
	private Date tranDate;
	
	@Column(nullable=false, length=3)
	private String currency;
	
	@ManyToOne
	@JoinColumn(name="channel", nullable = false)
	private Channel channel;
	
	@Column(name="dr_amount")
	private BigDecimal drAmount;
	
	@Column(name="cr_amount")
	private BigDecimal crAmount;
	
	@Column(name="txn_count")
	private Long txnCount;
	
	
	
	/**
	 * 
	 */
	public AccountTxnByChannel() {
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public CMG getCustomer() {
		return customer;
	}



	public void setCustomer(CMG customer) {
		this.customer = customer;
	}



	public Date getTranDate() {
		return tranDate;
	}



	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}



	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public Channel getChannel() {
		return channel;
	}



	public void setChannel(Channel channel) {
		this.channel = channel;
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

}
