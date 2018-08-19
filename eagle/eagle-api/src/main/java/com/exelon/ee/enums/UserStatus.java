/**
 * 
 */
package com.exelon.ee.enums;

/**
 * @author ukaegbu
 *
 */
public enum UserStatus {
	MUST_CHANGE_PASSWORD("User Must Change Password"),
	PASSWORD_CHANGED("Password Changed"),
	USER_DISABLED("User Is Disabled");
	
	private final String type;
	
	UserStatus(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}

}
