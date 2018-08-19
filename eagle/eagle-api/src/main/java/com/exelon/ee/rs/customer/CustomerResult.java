/**
 * 
 */
package com.exelon.ee.rs.customer;

import java.io.Serializable;
import java.util.List;

import com.exelon.ee.model.finacle.CMG;

/**
 * @author ukaegbu
 *
 */
public class CustomerResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<CMG> customers;
	private CustomerSummaryDTO summary;
	
	
	
	
	public List<CMG> getCustomers() {
		return customers;
	}
	public void setCustomers(List<CMG> customers) {
		this.customers = customers;
	}
	public CustomerSummaryDTO getSummary() {
		return summary;
	}
	public void setSummary(CustomerSummaryDTO summary) {
		this.summary = summary;
	}
	
	

}
