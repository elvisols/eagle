/**
 * 
 */
package com.exelon.ee.rs;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.exelon.ee.model.User;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * @author ukaegbu
 *
 */
public class EEExclusionStrategy implements ExclusionStrategy {
	
	@Inject
	private Logger logger;

	/* (non-Javadoc)
	 * @see com.google.gson.ExclusionStrategy#shouldSkipField(com.google.gson.FieldAttributes)
	 */
	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return (
				 (f.getDeclaringClass() == User.class && f.getName().equals("password"))
				|| (f.getDeclaringClass() == User.class && f.getName().equals("person")))
				;
				

	}

	/* (non-Javadoc)
	 * @see com.google.gson.ExclusionStrategy#shouldSkipClass(java.lang.Class)
	 */
	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

}
