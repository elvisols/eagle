/**
 * 
 */
package com.exelon.ee.rs.customer;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ukaegbu
 *
 */
public class CustomerSearchDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String  startDate;
	private String endDate;
	private String role;
	private Long userId;
	private String dateType;
	private String customerName;
	private String customerNumber;
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String accountName) {
		this.customerName = accountName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	

}
