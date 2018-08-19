/**
 * 
 */
package ng.exelon.ee.finacle.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author OJI
 *
 */
@Embeddable
public class CPhonePK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String phone_b2kid;
	private String phone_type;
	
	
	/**
	 * 
	 */
	public CPhonePK() {
	}


	/**
	 * @return the phone_b2kid
	 */
	public String getPhone_b2kid() {
		return phone_b2kid;
	}


	/**
	 * @param phone_b2kid the phone_b2kid to set
	 */
	public void setPhone_b2kid(String phone_b2kid) {
		this.phone_b2kid = phone_b2kid;
	}


	/**
	 * @return the phone_type
	 */
	public String getPhone_type() {
		return phone_type;
	}


	/**
	 * @param phone_type the phone_type to set
	 */
	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((phone_b2kid == null) ? 0 : phone_b2kid.hashCode());
		result = prime * result
				+ ((phone_type == null) ? 0 : phone_type.hashCode());
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
		if (!(obj instanceof CPhonePK))
			return false;
		CPhonePK other = (CPhonePK) obj;
		if (phone_b2kid == null) {
			if (other.phone_b2kid != null)
				return false;
		} else if (!phone_b2kid.equals(other.phone_b2kid))
			return false;
		if (phone_type == null) {
			if (other.phone_type != null)
				return false;
		} else if (!phone_type.equals(other.phone_type))
			return false;
		return true;
	}

}
