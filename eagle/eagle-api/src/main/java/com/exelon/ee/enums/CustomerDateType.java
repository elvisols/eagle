package com.exelon.ee.enums;

public enum CustomerDateType {
	
	OD("Opened Date"),
	CD("Closed Date");
	
	private final String type;
	CustomerDateType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}

}
