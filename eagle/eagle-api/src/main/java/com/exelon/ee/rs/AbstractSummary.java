/**
 * 
 */
package com.exelon.ee.rs;

import java.io.Serializable;

/**
 * @author ukaegbu
 *
 */
public abstract class AbstractSummary implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Integer totalSize;

	/**
	 * 
	 */
	public AbstractSummary() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return the totalSize
	 */
	public Integer getTotalSize() {
		return totalSize;
	}
	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
}
