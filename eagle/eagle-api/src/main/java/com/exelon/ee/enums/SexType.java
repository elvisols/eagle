/**
 * 
 */
package com.exelon.ee.enums;

/**
 * @author ukaegbu
 *
 */
public enum SexType {
	M("MALE"),
	F("FEMALE");
	
	private final String type;
	
	SexType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}

}
