/**
 * 
 */
package com.exelon.ee.model.finacle;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Administrator
 *
 */
@Embeddable
public class TransactionPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1127034989157153236L;
	
	@Column(length=9)
	private String tran_id;
	
	@Temporal(TemporalType.DATE)
	private Date tran_date;
	
	@Column(length=4)
	private String part_tran_srl_num;
	
	
	/**
	 * 
	 */
	public TransactionPK() {
	}


	/**
	 * @return the part_tran_srl_num
	 */
	
	public String getPart_tran_srl_num() {
		return part_tran_srl_num;
	}


	/**
	 * @param part_tran_srl_num the part_tran_srl_num to set
	 */
	public void setPart_tran_srl_num(String pART_TRAN_SRL_NUM) {
		this.part_tran_srl_num = pART_TRAN_SRL_NUM;
	}


	/**
	 * @return the tran_id
	 */
	
	public String getTran_id() {
		return tran_id;
	}


	/**
	 * @param tran_id the tran_id to set
	 */
	public void setTran_id(String tranDate) {
		this.tran_id = tranDate;
	}


	/**
	 * @return the tran_date
	 */
	public Date getTran_date() {
		return tran_date;
	}


	/**
	 * @param tran_date the tran_date to set
	 */
	public void setTran_date(Date tranId) {
		this.tran_date = tranId;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this) return true;
		if (!(obj instanceof TransactionPK)) return false;
		if (obj == null) return false;
		
		TransactionPK pk = (TransactionPK) obj;
		return part_tran_srl_num == pk.part_tran_srl_num && tran_date.equals(pk.tran_date)
			&& tran_id.equals(pk.tran_id);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return tran_id.hashCode()+tran_date.hashCode()+part_tran_srl_num.hashCode();
	}

	
	
}
