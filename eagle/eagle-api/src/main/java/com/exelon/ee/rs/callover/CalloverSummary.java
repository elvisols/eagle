/**
 * 
 */
package com.exelon.ee.rs.callover;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ukaegbu
 *
 */
public class CalloverSummary implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date tran_date;
	private String tran_id;
	private String entry_user_id;
	private String sol_id;
	private Integer num_entries;
	private BigDecimal total_credit;
	private BigDecimal total_debit;
	private BigDecimal difference;
	
	
	private String txnType;
	private Long txnCount;
	private Date txnDate;
	

	public Date getTran_date() {
		return tran_date;
	}




	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}




	public String getTran_id() {
		return tran_id;
	}




	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}




	public String getEntry_user_id() {
		return entry_user_id;
	}




	public void setEntry_user_id(String entry_user_id) {
		this.entry_user_id = entry_user_id;
	}




	public Integer getNum_entries() {
		return num_entries;
	}




	public void setNum_entries(Integer num_entries) {
		this.num_entries = num_entries;
	}




	public BigDecimal getTotal_credit() {
		return total_credit;
	}




	public void setTotal_credit(BigDecimal total_credit) {
		this.total_credit = total_credit;
	}




	public BigDecimal getTotal_debit() {
		return total_debit;
	}




	public void setTotal_debit(BigDecimal total_debit) {
		this.total_debit = total_debit;
	}




	public BigDecimal getDifference() {
		return difference;
	}




	public void setDifference(BigDecimal difference) {
		this.difference = difference;
	}




	/**
	 * 
	 */
	public CalloverSummary() {
		// TODO Auto-generated constructor stub
	}




	public String getSol_id() {
		return sol_id;
	}




	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}




	public String getTxnType() {
		return txnType;
	}




	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}




	public Long getTxnCount() {
		return txnCount;
	}




	public void setTxnCount(Long txnCount) {
		this.txnCount = txnCount;
	}




	public Date getTxnDate() {
		return txnDate;
	}




	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

}
