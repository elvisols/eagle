/**
 * 
 */
package com.exelon.ee.rs.exception;

import java.io.Serializable;
import java.util.List;

import com.exelon.ee.model.AuditException;
import com.exelon.ee.model.Channel;
import com.exelon.ee.model.finacle.CMG;

/**
 * @author ukaegbu
 *
 */
public class ExceptionResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<AuditException> exceptions;
	private ExceptionSummaryDTO summary;
	
	
	
	
	public ExceptionSummaryDTO getSummary() {
		return summary;
	}
	public void setSummary(ExceptionSummaryDTO summary) {
		this.summary = summary;
	}
	public List<AuditException> getExceptions() {
		return exceptions;
	}
	public void setExceptions(List<AuditException> exceptions) {
		this.exceptions = exceptions;
	}
	
	

}
