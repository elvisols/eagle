package com.exelon.ee.enums;

public enum AccountDateType {
	
	OD("Opened Date"),
	CD("Closed Date");
	
	private final String type;
	AccountDateType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}

}
