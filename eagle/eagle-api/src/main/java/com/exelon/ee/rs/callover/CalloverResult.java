/**
 * 
 */
package com.exelon.ee.rs.callover;

import java.io.Serializable;
import java.util.List;

import com.exelon.ee.model.finacle.DTD;


/**
 * @author ukaegbu
 *
 */
public class CalloverResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<CalloverSummary> summaries;
	private List<DTD> txns;
	private CalloverSummaryDTO summary;
	
	
	
	public List<CalloverSummary> getSummaries() {
		return summaries;
	}
	public void setSummaries(List<CalloverSummary> summaries) {
		this.summaries = summaries;
	}

	public CalloverSummaryDTO getSummary() {
		return summary;
	}
	public void setSummary(CalloverSummaryDTO summary) {
		this.summary = summary;
	}
	public List<DTD> getTxns() {
		return txns;
	}
	public void setTxns(List<DTD> txns) {
		this.txns = txns;
	}
	
	

}
