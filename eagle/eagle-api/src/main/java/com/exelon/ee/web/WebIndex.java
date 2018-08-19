/**
 * 
 */
package com.exelon.ee.web;

import java.io.IOException;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.exelon.ee.model.User;
import com.exelon.ee.qualifier.LoggedIn;


/**
 * @author ukaegbu
 *
 */
@Named("home")
@RequestScoped
public class WebIndex {

	@Inject @LoggedIn User currentUser;
	
	@Inject private EntityManager em;
	
	@Inject private Logger log;
	/**
	 * 
	 */
	public WebIndex() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void systemDashboard(ActionEvent evt){
		//log.info("This is the system dashboard");
		String uri = "dashboard/dashboard.xhtml";
	    try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(uri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void systemReports(ActionEvent evt){
		//log.info("This is the system reports");
		String uri = "report/report.xhtml";
	    try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(uri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
