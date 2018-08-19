package com.exelon.ee.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

   @Override
   public void filter(final ContainerRequestContext requestContext,
                      final ContainerResponseContext cres) throws IOException {
	   //System.out.println("Checking the CORS for the servlet");
      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
      cres.getHeaders().add("Access-Control-Allow-Headers", " x-requested-with,client-security-token,origin, content-type, accept, authorization, token, oauth2, x-auth-token");
      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, CONNECT");
      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
      
      cres.getHeaders().add("Access-Control-Expose-Headers", "authorization,token");
   }
   
   
}