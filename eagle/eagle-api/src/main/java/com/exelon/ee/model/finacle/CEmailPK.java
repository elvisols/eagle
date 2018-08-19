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
public class CEmailPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email_b2kid;
	private String email_type;
	
	
	/**
	 * 
	 */
	public CEmailPK() {
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((email_b2kid == null) ? 0 : email_b2kid.hashCode());
		result = prime * result
				+ ((email_type == null) ? 0 : email_type.hashCode());
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
		if (!(obj instanceof CEmailPK))
			return false;
		CEmailPK other = (CEmailPK) obj;
		if (email_b2kid == null) {
			if (other.email_b2kid != null)
				return false;
		} else if (!email_b2kid.equals(other.email_b2kid))
			return false;
		if (email_type == null) {
			if (other.email_type != null)
				return false;
		} else if (!email_type.equals(other.email_type))
			return false;
		return true;
	}


	/**
	 * @return the email_b2kid
	 */
	public String getEmail_b2kid() {
		return email_b2kid;
	}


	/**
	 * @param email_b2kid the email_b2kid to set
	 */
	public void setEmail_b2kid(String email_b2kid) {
		this.email_b2kid = email_b2kid;
	}


	/**
	 * @return the email_type
	 */
	public String getEmail_type() {
		return email_type;
	}


	/**
	 * @param email_type the email_type to set
	 */
	public void setEmail_type(String email_type) {
		this.email_type = email_type;
	}

}
