package com.exelon.ee.rs.channel;

import java.io.Serializable;
import java.math.BigDecimal;

public class ChannelResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String currency;
	private BigDecimal drAmount;
	private BigDecimal crAmount;
	private Long txnCount;
	

	public ChannelResponse() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public BigDecimal getDrAmount() {
		return drAmount;
	}


	public void setDrAmount(BigDecimal drAmount) {
		this.drAmount = drAmount;
	}


	public BigDecimal getCrAmount() {
		return crAmount;
	}


	public void setCrAmount(BigDecimal crAmount) {
		this.crAmount = crAmount;
	}


	public Long getTxnCount() {
		return txnCount;
	}


	public void setTxnCount(Long txnCount) {
		this.txnCount = txnCount;
	}

}
