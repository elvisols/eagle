/**
 * 
 */
package com.exelon.ee.rs;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author ukaegbu
 *
 */
public abstract class AbstractEndPoint {

	protected Gson gson;
	protected GsonAppResponse resp = new GsonAppResponse();

	
	public AbstractEndPoint() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setExclusionStrategies(new EEExclusionStrategy());
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		gson = gsonBuilder.create();
	}
	
}
