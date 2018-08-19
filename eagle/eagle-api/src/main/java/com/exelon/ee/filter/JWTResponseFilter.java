package com.exelon.ee.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

import com.exelon.ee.AppToken;
import com.exelon.ee.JsonSecurity;
import com.exelon.ee.model.Parameter;
import com.exelon.ee.model.User;
import com.exelon.ee.qualifier.JSONSecurity;
import com.exelon.ee.qualifier.SystemParameter;
import com.exelon.ee.rs.RestfulApplication;


@Provider
public class JWTResponseFilter implements ContainerResponseFilter {

	@Inject
    private Logger logger;
	
	@Inject
	@JSONSecurity
	private JsonSecurity json;

	@Inject
	private EntityManager em;
	
	@Inject
	HttpServletRequest request;
	
	@Inject
	@SystemParameter
	private Parameter parameter;
	
    @Override
    @Transactional
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    	//responseContext.getHeaders().add("Access-Control-Allow-Headers", " x-requested-with,client-security-token,origin, content-type, accept, authorization, token, oauth2, x-auth-token");
        String token = request.getHeader("token");
        
        if(null == token)return;
        
        //logger.info("response filter invoked..."+token);
        AppToken appToken = RestfulApplication.validateToken(token);
        if (null == appToken) {
        	return;
        }
        User user = em.find(User.class, appToken.getUserId());
        if(null != user.getLastActiveTime()) {
			DateTime now = new DateTime(user.getLastActiveTime());
			DateTime last = new DateTime(user.getExpectedExpiryTime());
			
			Integer minutes = Minutes.minutesBetween(now, last).getMinutes() % 60;
			
			if(minutes <= 1) {
				String jwt;
				try {
					jwt = json.createUserToken(user);
					//logger.info("The new jwt is "+jwt);
					
					if(null != jwt) {
						responseContext.getHeaders().add("token", jwt);
						Date dt = new Date();
						Calendar cal = Calendar.getInstance();
						cal.add(Calendar.MINUTE, parameter.getTimeout());
						
						user.setLastActiveTime(dt);
						user.setExpectedExpiryTime(cal.getTime());
						
						em.merge(user);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
			
		}
       

    }
}
