package com.crm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.primefaces.util.Base64;

public class Utility {
	
	public static String getHashedPassword(String plain) {
	
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(plain.getBytes());
			String hashedPassword = Base64.encodeToString(hash, false);
			return hashedPassword;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plain;
	}
}
