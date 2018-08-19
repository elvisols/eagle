/**
 * 
 */
package com.exelon.ee.util;

/**
 * @author Administrator
 *
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import sun.misc.BASE64Encoder;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class PasswordService {
	private static Log log = LogFactory.getLog(PasswordService.class);
	private static PasswordService instance;

	private static final int PASSWORD_THRESHOLD = 8;

	private PasswordService() {
	}

	/*
	 * Set of characters that is valid. Must be printable, memorable, and "won't
	 * break HTML" (i.e., not ' <', '>', '&', '=', ...). or break shell commands
	 * (i.e., not ' <', '>', '$', '!', ...). I, L and O are good to leave out,
	 * as are numeric zero and one.
	 */
	protected static char[] goodChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
			'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '@', };

	/** Minimum length for a decent password */
	public static final int MIN_LENGTH = 10;

	/* Generate a Password object with a random password. */
	public synchronized String generateRandomPassword() {
		/*Random r = new java.util.Random(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < MIN_LENGTH; i++) {
			sb.append(goodChar[r.nextInt(goodChar.length)]);
		}
		return sb.toString();*/
		return getSaltString();
	}

	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < MIN_LENGTH) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public synchronized String encrypt(String plaintext)/* throws Exception*/ {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA"); // step 2
			md.update(plaintext.getBytes("UTF-8")); // step 3
			byte raw[] = md.digest(); // step 4
			String hash = (new Base64()).encodeToString(raw); //.encode(raw); // step 5
			return hash; // step 6
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public static synchronized PasswordService getInstance() // step 1
	{
		if (instance == null) {
			return new PasswordService();
		} else {
			return instance;
		}
	}

	public synchronized String getSession(String sessionid) throws Exception {
		byte[] defaultBytes = sessionid.getBytes();
		String hxString = null;
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			hxString = hexString.toString();

		} catch (NoSuchAlgorithmException nsae) {

		}
		return hxString;
	}

	// 014004582315-- henry

	public synchronized String generateSecurePassword() throws Exception {
		String pswd = null;
		// Random rand = new Random();
		Random rand = null;
		try {
			rand = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			log.debug(e,e);
		}

		int length = rand.nextInt(6) + 6;
		char[] password = new char[length];

		for (int x = 0; x < length; x++) {
			int randDecimalAsciiVal = rand.nextInt(93) + 33;
			password[x] = (char) randDecimalAsciiVal;
		}
		pswd = String.valueOf(password);
		// log.debug(String.valueOf(password));

		return pswd;

	}

	public static void validatePassword(String password) throws Exception {
		String pattern = "^\\S*(?=\\S{8,})(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*[\\d])(?=\\S*[\\W])\\S*$";
		
		if (null == password || password.trim().length() == 0)
			throw new Exception(" Password cannot be null or empty");
		
		
		/*if(!password.matches(pattern)){
			throw new Exception("password does not match the password policy ");
		}*/
		
		if (password.length() < PASSWORD_THRESHOLD)
			throw new Exception(" Password length must be at least "
					+ PASSWORD_THRESHOLD);
		
		// check for existence of the some special xters

	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("audit  ===> "+PasswordService.getInstance().encrypt("audit"));
		
	}
}