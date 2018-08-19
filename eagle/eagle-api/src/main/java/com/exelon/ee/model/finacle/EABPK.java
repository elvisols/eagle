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
 * @author OJI
 *
 */
@Embeddable
public class EABPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(length=20)
	private String acid                 ;//varchar2(11 char),
	
	@Temporal(TemporalType.DATE)
	private Date eod_date             ;//date,

	/**
	 * @return the acid
	 */
	public String getAcid() {
		return acid;
	}

	/**
	 * @param acid the acid to set
	 */
	public void setAcid(String acid) {
		this.acid = acid;
	}

	/**
	 * @return the eod_date
	 */
	public Date getEod_date() {
		return eod_date;
	}

	/**
	 * @param eod_date the eod_date to set
	 */
	public void setEod_date(Date eod_date) {
		this.eod_date = eod_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acid == null) ? 0 : acid.hashCode());
		result = prime * result
				+ ((eod_date == null) ? 0 : eod_date.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EABPK))
			return false;
		EABPK other = (EABPK) obj;
		if (acid == null) {
			if (other.acid != null)
				return false;
		} else if (!acid.equals(other.acid))
			return false;
		if (eod_date == null) {
			if (other.eod_date != null)
				return false;
		} else if (!eod_date.equals(other.eod_date))
			return false;
		return true;
	}
	

}
