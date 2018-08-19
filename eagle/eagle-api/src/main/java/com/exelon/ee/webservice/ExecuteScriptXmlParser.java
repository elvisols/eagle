/**
 * 
 */
package com.exelon.ee.webservice;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


/**
 * @author oji
 *
 */

public class ExecuteScriptXmlParser implements Serializable {
	private static final long serialVersionUID = 1L;

	private HashMap<String,String> map;
	
	@Inject
	private Logger log;
	

	
	public HashMap<String,String> parseXMLEvents(String response) {
		//log.info("");
		
		if(null == response)return null;
		response = response.trim();
		if(!response.startsWith("<"))return null;
		
		ByteArrayInputStream bais = new ByteArrayInputStream(response.trim().getBytes());
		
		map = new HashMap<String,String>();
		boolean isError = false;
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// InputStream input = new FileInputStream(new
			// File("E:\\DOWNLOAD\\NIBSS\\switch\\settlement\\test1.xml"));
			XMLEventReader xmlEventReader = inputFactory
					.createXMLEventReader(bais);

			String key = null, value=null;
			while (xmlEventReader.hasNext()) {
				boolean isAttrib = false;
				
				
				XMLEvent event = xmlEventReader.nextEvent();
				int eventType = event.getEventType();
				//key = null; value = null;
				if (event.isStartDocument()) {
					//System.out.println("Event Type:Start Document");

				}
				if (event.isStartElement()) {
					//System.out.println("Event Type: Start Element");
					StartElement startElement = event.asStartElement();
					key = startElement.getName().toString();
					//System.out.println("key is "+key);
					
					//System.out.println("Element Name:"	+ startElement.getName().toString());
					if("Exception".equalsIgnoreCase(key)){
						isError = true;
					}

					
					Iterator attributes = startElement.getAttributes();
					while (attributes.hasNext()) {
						Attribute	attribute = (javax.xml.stream.events.Attribute) (attributes	.next());
						
						if("Name".equalsIgnoreCase(attribute.getName().toString())){
							isAttrib = true;
							key = attribute.getValue();
						}
						/*System.out.println("Attribute Name:"
								+ attribute.getName().toString());
						System.out.println("Attribute Value:"
								+ attribute.getValue());
						*/
						

					}

				}
				if (event.isAttribute()) {
					//System.out.println("Event Type:Attribute");
				}

				if (event.isCharacters()) {
					//System.out.println("Event Type: Characters");
					Characters text = event.asCharacters();
					if (!text.isWhiteSpace()) {
						//System.out.println("Text:" + text.getData());
						value = text.getData();
					}

					/*if (text.isWhiteSpace()) {
						System.out.println("Characters is White Space");
					}*/
				}

				if (event.isEndDocument()) {
					//System.out.println("Event Type:End Document");
					if(!map.isEmpty()){
						Set<String> keys = map.keySet();
						for(String k : keys){
							//System.out.println(k+", "+map.get(k));
						}
					}
				}
				if (event.isEndElement()) {
					if(null != key){
						//System.out.println("Event Type:End Element and key is "+ key+". And value is "+value  );
						key = key.replace("{http://www.finacle.com/fixml}", "");
						map.put(key.trim(), value);
						key = null;
						value = null;
					}
				}

				if (event.isNamespace()) {
					//System.out.println("Event Type:Namespace");
				}

				if (event.isProcessingInstruction()) {
					//System.out.println("Event Type: Processing Instruction");

				}
			}

		} catch (FactoryConfigurationError	e) {
			//log.log(Level.SEVERE, e, );
			e.printStackTrace();
			isError = true;
		} catch (XMLStreamException	e) {
			//log.fatal(e, e);
			e.printStackTrace();
			isError = true;
		}
		
		/**
		 * CreditAccount = 5000028242
			Narration = Fuel Payment
			Currency = NGN
			Amount = 200.00
			TransRef = 6778789909
			DebitAccount = 6500378985
			TransactionDate = 16-02-2012 16:00:00


		 */
		
		if(isError)return null;
		

		return map;
	}
	
	
	public static void main(String[] args) throws Exception{
		ExecuteScriptXmlParser parser = new ExecuteScriptXmlParser();
		 InputStream input = new FileInputStream(new File("C:\\projects\\suntrust\\remita\\remita-banks-service\\resourse\\transfer.xml"));
		 
		 BufferedInputStream bis = new BufferedInputStream(input);
		 ByteArrayOutputStream buf = new ByteArrayOutputStream();
		 int result = bis.read();
		 while(result != -1) {
		     buf.write((byte) result);
		     result = bis.read();
		 }
		 bis.close();
		 String request =  buf.toString();
		 HashMap<String, String> res = parser.parseXMLEvents(request);
		 res.forEach((k,v) -> {
			 System.out.println(k+" = "+v);
		 });
		 
	}
}
