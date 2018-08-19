/**
 * 
 */
package com.exelon.ee.rs.region;

import java.io.Serializable;
import java.util.List;

import com.exelon.ee.model.Region;


/**
 * @author ukaegbu
 *
 */
public class RegionResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Region> regions;
	private RegionSummaryDTO summary;
	
	
	
	
	public List<Region> getRegions() {
		return regions;
	}
	public void setRegions(List<Region> customers) {
		this.regions = customers;
	}
	public RegionSummaryDTO getSummary() {
		return summary;
	}
	public void setSummary(RegionSummaryDTO summary) {
		this.summary = summary;
	}
	
	

}
