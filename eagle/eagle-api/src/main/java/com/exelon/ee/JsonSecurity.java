/**
 * 
 */
package com.exelon.ee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwa.AlgorithmConstraints.ConstraintType;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import com.exelon.ee.model.Parameter;
import com.exelon.ee.model.User;
import com.exelon.ee.qualifier.JSONSecurity;
import com.exelon.ee.qualifier.SystemParameter;
import com.exelon.ee.rs.RestfulApplication;


/**
 * @author ukaegbu
 *
 */
@ApplicationScoped
@JSONSecurity
public class JsonSecurity {
	
	@Inject
	private Logger logger;

	
	@Inject
	@SystemParameter
	private Parameter parameter;
	
	@PostConstruct
	public void appStarted() {
		startJwt(); // that is the f
		//log.info("This is successfully started");
	}

	static List<JsonWebKey> jwkList = null;
	
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
	
	public AppToken validateToken(String token){
		logger.log(Level.INFO, "Validating the token here ");
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
			e.printStackTrace();
			//Logger.getLogger(RestfulApplication.class.getName()).log(Level.SEVERE, "JWT is Invalid", e);
			return null;
		}
		return appToken;
		
	}
	
	public  String createUserToken(User user) throws Exception{
		List<JsonWebKey> jwkList = RestfulApplication.getJwkList();
		RsaJsonWebKey senderJwk = (RsaJsonWebKey) jwkList.get(0);

		Long id = user.getId();
		senderJwk.setKeyId("1");  //jwKey.getKeyId()
		// log.info("JWK (1) ===> " + senderJwk.toJson());

		// Create the Claims, which will be the content of the JWT
		JwtClaims claims = new JwtClaims();
		claims.setIssuer("exelon.ng");
		claims.setExpirationTimeMinutesInTheFuture(parameter.getTimeout()); //parameter.getTimeout()
		claims.setGeneratedJwtId();
		claims.setIssuedAtToNow();
		claims.setNotBeforeMinutesInThePast(2);
		claims.setSubject(user.getEmail());
		claims.setClaim("userId", user.getId());

		List<String> roles = new ArrayList<>();
		roles.add(user.getRole().getId());
		claims.setStringListClaim("roles", roles);

		JsonWebSignature jws = new JsonWebSignature();

		jws.setPayload(claims.toJson());
		/*jws.setKeyIdHeaderValue(jwKey.getKeyId());
	    jws.setKey(jwKey.getKey());*/

		jws.setKeyIdHeaderValue(senderJwk.getKeyId());
		jws.setKey(senderJwk.getPrivateKey());

		jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

		String jwt = null;
		try {
			jwt = jws.getCompactSerialization();
		} catch (JoseException e) {
			e.printStackTrace();
			throw e;
		}
		
		/*JsonWebEncryption jwe = new JsonWebEncryption();
	    jwe.setAlgorithmHeaderValue(
	        KeyManagementAlgorithmIdentifiers.DIRECT);
	    jwe.setEncryptionMethodHeaderParameter(
	        ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
	    jwe.setKey(jwKey.getKey());
	    jwe.setKeyIdHeaderValue(jwKey.getKeyId());
	    jwe.setContentTypeHeaderValue("JWT");
	    jwe.setPayload(jwt);

	    String jweSerialization = null;
	    try {
	      jweSerialization = jwe.getCompactSerialization();
	    } catch (JoseException e) {
	      e.printStackTrace();
	    }
*/

		
		return jwt;
	}
	
	

}
