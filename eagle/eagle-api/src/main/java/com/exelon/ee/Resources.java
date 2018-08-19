/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.exelon.ee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.jboss.logging.Logger.Level;

import com.exelon.ee.model.Parameter;
import com.exelon.ee.qualifier.SystemParameter;


/**
 * This class uses CDI to alias Java EE resources, such as the persistence context, to CDI beans
 *
 * <p>
 * Example injection on a managed bean field:
 * </p>
 *
 * <pre>
 * &#064;Inject
 * private EntityManager em;
 * </pre>
 */
public class Resources {
	@Inject
	private EntityManager em;
	
	@Inject
	private Logger logger;
	
  
    @Produces
    @ApplicationScoped
    public Properties loadEmailProperties() {
    	InputStream inputStream = null;
    	
    	Properties prop = null;
		try {
			prop = new Properties();
			String propFileName = "./properties/application.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        return prop;
    }
    
    @Produces
    @ApplicationScoped
    @SystemParameter
    public Parameter systemParameter() {
    	Parameter p = em.find(Parameter.class, Parameter.DEFAULT);
    	return p;
    }

    //@ApplicationScoped
    public void iniHibernateSearch() {
    	try {
			FullTextEntityManager fullTextEntityManager 
			  = Search.getFullTextEntityManager(em);
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			//logger.log(Level.FATAL,"",e);
			e.printStackTrace();
		}
    }
    
    /*@Produces
    @RequestScoped
    @UserEvent
    public UserEventObserver userEvent() {
    	UserEventObserver u = new UserEventObserver();
    	return u;
    }*/
}
