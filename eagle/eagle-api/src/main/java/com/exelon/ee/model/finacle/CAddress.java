/**
 * 
 */
package com.exelon.ee.model.finacle;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="finacle.cnma")
@NamedQueries( {
	@NamedQuery(name = "CAddress.findMailingAddressByCifId", 
			query = "select c from CAddress c  where  c.id.addr_b2kid = :cifId and c.id.addr_id = 'Mailing'")
})
public class CAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CAddressPK id;
	
	private String bank_id;
	private Date start_date;
	private Date end_date;
	private String name;
	private String alt1_name;
	private String cust_title_code;
	private String address1;
	private String address2;
	private String address3;
	private String city_code;
	private String state_code;
	private String cntry_code;
	private String pin_code;
	private String phone_num1;
	private String phone_num2;
	private String fax_num1;
	private String fax_num2;
	private String email_id;
	private String swift_code;
	private String tlx_num;
	private String pager_no;
	private String preferredaddress;
	private String preferredformat;
	private String hold_mail_flag;
	private String hold_mail_initiated_by;
	private String is_address_proof_rcvd;
	
	/**
	 * 
	 */
	public CAddress() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public CAddressPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CAddressPK id) {
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
	 * @return the start_date
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the end_date
	 */
	public Date getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the alt1_name
	 */
	public String getAlt1_name() {
		return alt1_name;
	}

	/**
	 * @param alt1_name the alt1_name to set
	 */
	public void setAlt1_name(String alt1_name) {
		this.alt1_name = alt1_name;
	}

	/**
	 * @return the cust_title_code
	 */
	public String getCust_title_code() {
		return cust_title_code;
	}

	/**
	 * @param cust_title_code the cust_title_code to set
	 */
	public void setCust_title_code(String cust_title_code) {
		this.cust_title_code = cust_title_code;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}

	/**
	 * @param address3 the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	/**
	 * @return the city_code
	 */
	public String getCity_code() {
		return city_code;
	}

	/**
	 * @param city_code the city_code to set
	 */
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	/**
	 * @return the state_code
	 */
	public String getState_code() {
		return state_code;
	}

	/**
	 * @param state_code the state_code to set
	 */
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	/**
	 * @return the cntry_code
	 */
	public String getCntry_code() {
		return cntry_code;
	}

	/**
	 * @param cntry_code the cntry_code to set
	 */
	public void setCntry_code(String cntry_code) {
		this.cntry_code = cntry_code;
	}

	/**
	 * @return the pin_code
	 */
	public String getPin_code() {
		return pin_code;
	}

	/**
	 * @param pin_code the pin_code to set
	 */
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	/**
	 * @return the phone_num1
	 */
	public String getPhone_num1() {
		return phone_num1;
	}

	/**
	 * @param phone_num1 the phone_num1 to set
	 */
	public void setPhone_num1(String phone_num1) {
		this.phone_num1 = phone_num1;
	}

	/**
	 * @return the phone_num2
	 */
	public String getPhone_num2() {
		return phone_num2;
	}

	/**
	 * @param phone_num2 the phone_num2 to set
	 */
	public void setPhone_num2(String phone_num2) {
		this.phone_num2 = phone_num2;
	}

	/**
	 * @return the fax_num1
	 */
	public String getFax_num1() {
		return fax_num1;
	}

	/**
	 * @param fax_num1 the fax_num1 to set
	 */
	public void setFax_num1(String fax_num1) {
		this.fax_num1 = fax_num1;
	}

	/**
	 * @return the fax_num2
	 */
	public String getFax_num2() {
		return fax_num2;
	}

	/**
	 * @param fax_num2 the fax_num2 to set
	 */
	public void setFax_num2(String fax_num2) {
		this.fax_num2 = fax_num2;
	}

	/**
	 * @return the email_id
	 */
	public String getEmail_id() {
		return email_id;
	}

	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	/**
	 * @return the swift_code
	 */
	public String getSwift_code() {
		return swift_code;
	}

	/**
	 * @param swift_code the swift_code to set
	 */
	public void setSwift_code(String swift_code) {
		this.swift_code = swift_code;
	}

	/**
	 * @return the tlx_num
	 */
	public String getTlx_num() {
		return tlx_num;
	}

	/**
	 * @param tlx_num the tlx_num to set
	 */
	public void setTlx_num(String tlx_num) {
		this.tlx_num = tlx_num;
	}

	/**
	 * @return the pager_no
	 */
	public String getPager_no() {
		return pager_no;
	}

	/**
	 * @param pager_no the pager_no to set
	 */
	public void setPager_no(String pager_no) {
		this.pager_no = pager_no;
	}

	/**
	 * @return the preferredaddress
	 */
	public String getPreferredaddress() {
		return preferredaddress;
	}

	/**
	 * @param preferredaddress the preferredaddress to set
	 */
	public void setPreferredaddress(String preferredaddress) {
		this.preferredaddress = preferredaddress;
	}

	/**
	 * @return the preferredformat
	 */
	public String getPreferredformat() {
		return preferredformat;
	}

	/**
	 * @param preferredformat the preferredformat to set
	 */
	public void setPreferredformat(String preferredformat) {
		this.preferredformat = preferredformat;
	}

	/**
	 * @return the hold_mail_flag
	 */
	public String getHold_mail_flag() {
		return hold_mail_flag;
	}

	/**
	 * @param hold_mail_flag the hold_mail_flag to set
	 */
	public void setHold_mail_flag(String hold_mail_flag) {
		this.hold_mail_flag = hold_mail_flag;
	}

	/**
	 * @return the hold_mail_initiated_by
	 */
	public String getHold_mail_initiated_by() {
		return hold_mail_initiated_by;
	}

	/**
	 * @param hold_mail_initiated_by the hold_mail_initiated_by to set
	 */
	public void setHold_mail_initiated_by(String hold_mail_initiated_by) {
		this.hold_mail_initiated_by = hold_mail_initiated_by;
	}

	/**
	 * @return the is_address_proof_rcvd
	 */
	public String getIs_address_proof_rcvd() {
		return is_address_proof_rcvd;
	}

	/**
	 * @param is_address_proof_rcvd the is_address_proof_rcvd to set
	 */
	public void setIs_address_proof_rcvd(String is_address_proof_rcvd) {
		this.is_address_proof_rcvd = is_address_proof_rcvd;
	}

}
