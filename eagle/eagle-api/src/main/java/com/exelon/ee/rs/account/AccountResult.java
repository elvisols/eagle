/**
 * 
 */
package com.exelon.ee.rs.account;

import java.io.Serializable;
import java.util.List;

import com.exelon.ee.model.finacle.GAM;

/**
 * @author ukaegbu
 *
 */
public class AccountResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<GAM> accounts;
	private AccountSummaryDTO summary;
	
	
	
	
	public List<GAM> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<GAM> customers) {
		this.accounts = customers;
	}
	public AccountSummaryDTO getSummary() {
		return summary;
	}
	public void setSummary(AccountSummaryDTO summary) {
		this.summary = summary;
	}
	
	

}
