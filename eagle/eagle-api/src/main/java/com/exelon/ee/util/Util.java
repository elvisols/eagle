/**
 * 
 */
package com.exelon.ee.util;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author ukaegbu
 *
 */
public class Util {

	public static XMLGregorianCalendar gregorianToXmlCalendar(Date date) {
	    java.util.GregorianCalendar calDate = new java.util.GregorianCalendar();        
	    calDate.setTime(date);
	    javax.xml.datatype.XMLGregorianCalendar calendar = null;
	        try {
	            javax.xml.datatype.DatatypeFactory factory = javax.xml.datatype.DatatypeFactory.newInstance();
	            calendar = factory.newXMLGregorianCalendar(
	            calDate.get(java.util.GregorianCalendar.YEAR),
	            calDate.get(java.util.GregorianCalendar.MONTH) + 1,
	            calDate.get(java.util.GregorianCalendar.DAY_OF_MONTH),
	            calDate.get(java.util.GregorianCalendar.HOUR_OF_DAY),
	            calDate.get(java.util.GregorianCalendar.MINUTE),
	            calDate.get(java.util.GregorianCalendar.SECOND),
	            calDate.get(java.util.GregorianCalendar.MILLISECOND), 0);
	        } catch (DatatypeConfigurationException dce) {
	            //handle or throw
	        }   
	    return calendar;
	}
	
	public static Date parseDate(String date, String pattern) {
		java.util.Date dt = null;
		try {
			// check if the date is the correct date. use a better algorithm later
			java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
			d.applyPattern(pattern); //"yyyy-MM-dd" ; "MMdd"
			dt = d.parse(date);
		} catch (Exception e) {
			//log.error(e.getMessage());
			return null;
		}
		return dt;
	}
	
	public static String convertDateToString(java.util.Date date, String pattern) {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();

		if (date == null)
			date = new Date(-1);
		d.applyPattern(pattern); //dd/MM/yyyy
		return d.format(date);
	}
	
	public static String padNumber(String id, int len) {

		//DecimalFormat df = new DecimalFormat("###00");
		//String num = df.format(amount.abs());
		if (id.matches("\\d+")) {
			Integer i = Integer.decode(id);
			id = i.toString();
		}
		String ret = id.toString();
		String num = ret;
		if (num.length() < len) {
			StringBuffer buf = new StringBuffer();
			int dif = len - num.length();
			for (int i = 0; i < dif; i++)
				buf.append("0");
			ret = buf.toString() + num;
		}
		return ret;
	}

}
