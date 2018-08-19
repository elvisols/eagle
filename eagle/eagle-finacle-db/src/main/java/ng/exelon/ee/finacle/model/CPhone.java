/**
 * 
 */
package ng.exelon.ee.finacle.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * @author OJI
 *
 */
@Entity
@Table(name="tbaadm.cphone")
@NamedQueries( {
	@NamedQuery(name = "CPhone.findByCifId", query = "select c from CPhone c  where  c.id.phone_b2kid = :cifId")
})
public class CPhone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CPhonePK id;
	
	private String bank_id;
	private String phoneno;
	private String phonenolocalcode;
	private String phonenocitycode;
	private String phonenocountrycode;
	private String workextension;
	private String preferredflag;
	

	/**
	 * 
	 */
	public CPhone() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the id
	 */
	public CPhonePK getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(CPhonePK id) {
		this.id = id;
	}


	/**
	 * @return the bank_id
	 */
	public String getBank_id() {
		return bank_id;
	}


	/**
	 * @param bank_id the bank_id to set
	 */
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}


	/**
	 * @return the phoneno
	 */
	public String getPhoneno() {
		return phoneno;
	}


	/**
	 * @param phoneno the phoneno to set
	 */
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	/**
	 * @return the phonenolocalcode
	 */
	public String getPhonenolocalcode() {
		return phonenolocalcode;
	}


	/**
	 * @param phonenolocalcode the phonenolocalcode to set
	 */
	public void setPhonenolocalcode(String phonenolocalcode) {
		this.phonenolocalcode = phonenolocalcode;
	}


	/**
	 * @return the phonenocitycode
	 */
	public String getPhonenocitycode() {
		return phonenocitycode;
	}


	/**
	 * @param phonenocitycode the phonenocitycode to set
	 */
	public void setPhonenocitycode(String phonenocitycode) {
		this.phonenocitycode = phonenocitycode;
	}


	/**
	 * @return the phonenocountrycode
	 */
	public String getPhonenocountrycode() {
		return phonenocountrycode;
	}


	/**
	 * @param phonenocountrycode the phonenocountrycode to set
	 */
	public void setPhonenocountrycode(String phonenocountrycode) {
		this.phonenocountrycode = phonenocountrycode;
	}


	/**
	 * @return the workextension
	 */
	public String getWorkextension() {
		return workextension;
	}


	/**
	 * @param workextension the workextension to set
	 */
	public void setWorkextension(String workextension) {
		this.workextension = workextension;
	}


	/**
	 * @return the preferredflag
	 */
	public String getPreferredflag() {
		return preferredflag;
	}


	/**
	 * @param preferredflag the preferredflag to set
	 */
	public void setPreferredflag(String preferredflag) {
		this.preferredflag = preferredflag;
	}

}
