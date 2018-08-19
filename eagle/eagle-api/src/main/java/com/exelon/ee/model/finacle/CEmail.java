/**
 * 
 */
package com.exelon.ee.model.finacle;

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
@Table(name="finacle.cemail")
@NamedQueries( {
	@NamedQuery(name = "CEmail.findByCifId", query = "select c from CEmail c  where  c.id.email_b2kid = :cifId")
})
public class CEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CEmailPK id;
	
	private String bank_id;
	private String email;
	private String emailpalm;
	private String url;
	private String preferredflag;
	
	/**
	 * 
	 */
	public CEmail() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public CEmailPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CEmailPK id) {
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the emailpalm
	 */
	public String getEmailpalm() {
		return emailpalm;
	}

	/**
	 * @param emailpalm the emailpalm to set
	 */
	public void setEmailpalm(String emailpalm) {
		this.emailpalm = emailpalm;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
