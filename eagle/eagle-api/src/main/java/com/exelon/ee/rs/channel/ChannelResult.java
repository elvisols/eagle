/**
 * 
 */
package com.exelon.ee.rs.channel;

import java.io.Serializable;
import java.util.List;

import com.exelon.ee.model.Channel;
import com.exelon.ee.model.finacle.CMG;

/**
 * @author ukaegbu
 *
 */
public class ChannelResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Channel> channels;
	private ChannelSummaryDTO summary;
	
	
	
	
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> customers) {
		this.channels = customers;
	}
	public ChannelSummaryDTO getSummary() {
		return summary;
	}
	public void setSummary(ChannelSummaryDTO summary) {
		this.summary = summary;
	}
	
	

}
