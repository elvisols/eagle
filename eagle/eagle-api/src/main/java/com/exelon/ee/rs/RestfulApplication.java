/**
 * 
 */
package com.exelon.ee.rs;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import com.exelon.ee.AppToken;

/**
 * @author ukaegbu
 *
 */
@ApplicationPath("/api")
public class RestfulApplication extends Application {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	static List<JsonWebKey> jwkList = null;

	


	@PostConstruct
	public void appStarted() {
		startJwt(); // that is the f
		//log.info("This is successfully started");
	}

	private static void startJwt() {
		if (jwkList == null) {
			
			jwkList = new LinkedList<>();
			for (int kid = 1; kid <= 3; kid++) {
				JsonWebKey jwk = null;
				try {
					jwk = RsaJwkGenerator.generateJwk(2048);
					/*Logger.getLogger(RestfulApplication.class.getName()).log(Level.INFO, null, 
							"PUBLIC KEY (" + kid + "): " + jwk.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY));*/
				} catch (JoseException e) {
					e.printStackTrace();
				}
				jwk.setKeyId(String.valueOf(kid));
				jwkList.add(jwk);
			}
		}

	}
	
	
	public static AppToken validateToken(String token){
		List<JsonWebKey> jwkList = RestfulApplication.getJwkList();
		JsonWebKeySet jwks = new JsonWebKeySet(jwkList);
		JsonWebKey jwk = jwks.findJsonWebKey("1", null, null, null);
		//Logger.getLogger(RestfulApplication.class.getName()).info("JWK (1) ===> " + jwk.toJson());

		// Validate Token's authenticity and check claims
		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
				.setRequireExpirationTime()
				.setAllowedClockSkewInSeconds(30).setRequireSubject()
				.setExpectedIssuer("exelon.ng")
				.setVerificationKey(jwk.getKey()).build();

		AppToken appToken = null;
		try {
			// Validate the JWT and process it to the Claims
			JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
			String subject = jwtClaims.getSubject();
			//Logger.getLogger(RestfulApplication.class.getName()).info("JWT validation succeeded for user  " + subject);
			appToken = new AppToken();
			appToken.setEmail(subject);
			appToken.setUserId((Long)jwtClaims.getClaimValue("userId"));
			
		} catch (Exception e) {
			//Logger.getLogger(RestfulApplication.class.getName()).log(Level.SEVERE, "JWT is Invalid", e);
			return null;
		}
		return appToken;
		
	}
	
	
	

	/**
	 * 
	 */
	public RestfulApplication() {
		// TODO Auto-generated constructor stub
	}

	public static List<JsonWebKey> getJwkList() {
		startJwt();
		return jwkList;
	}

}
