/**
 * 
 */
package com.exelon.ee.model.finacle;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author OJI
 *
 */
@Embeddable
public class CAddressPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private String addr_b2kid;
	private String addr_id;
	
	/**
	 * 
	 */
	public CAddressPK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the addr_b2kid
	 */
	public String getAddr_b2kid() {
		return addr_b2kid;
	}

	/**
	 * @param addr_b2kid the addr_b2kid to set
	 */
	public void setAddr_b2kid(String addr_b2kid) {
		this.addr_b2kid = addr_b2kid;
	}

	/**
	 * @return the addr_id
	 */
	public String getAddr_id() {
		return addr_id;
	}

	/**
	 * @param addr_id the addr_id to set
	 */
	public void setAddr_id(String addr_id) {
		this.addr_id = addr_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addr_b2kid == null) ? 0 : addr_b2kid.hashCode());
		result = prime * result + ((addr_id == null) ? 0 : addr_id.hashCode());
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
		if (!(obj instanceof CAddressPK))
			return false;
		CAddressPK other = (CAddressPK) obj;
		if (addr_b2kid == null) {
			if (other.addr_b2kid != null)
				return false;
		} else if (!addr_b2kid.equals(other.addr_b2kid))
			return false;
		if (addr_id == null) {
			if (other.addr_id != null)
				return false;
		} else if (!addr_id.equals(other.addr_id))
			return false;
		return true;
	}

}
