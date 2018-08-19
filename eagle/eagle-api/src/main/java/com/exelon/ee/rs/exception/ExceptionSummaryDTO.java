/**
 * 
 */
package com.exelon.ee.rs.exception;

import java.io.Serializable;

import com.exelon.ee.rs.AbstractSummary;

/**
 * @author ukaegbu
 *
 */
public class ExceptionSummaryDTO extends AbstractSummary implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numOfPartners;
	
	
	/**
	 * @return the numOfPartners
	 */
	public Integer getNumOfPartners() {
		return numOfPartners;
	}
	/**
	 * @param numOfPartners the numOfPartners to set
	 */
	public void setNumOfPartners(Integer numOfPartners) {
		this.numOfPartners = numOfPartners;
	}

}
