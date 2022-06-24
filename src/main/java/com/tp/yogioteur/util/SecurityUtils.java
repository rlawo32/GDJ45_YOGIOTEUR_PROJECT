package com.tp.yogioteur.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class SecurityUtils {

	// XSS
	public static String xss(String str) {
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("\'", "&#x27;");
		str = str.replaceAll("&", "&amp;");
		return str;
	}
	
	// 인증코드
	public static String authCode(int length) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			if(Math.random() < 0.5) {
				sb.append( (char)((int)(Math.random() * 10) + '0') );
			} else {
				sb.append( (char)((int)(Math.random() * 26) + 'A') );
			}
		}
		return sb.toString();
	}
	
	public static String sha256(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		byte[] bytes = md.digest();
		StringBuilder sb = new StringBuilder();
		for(byte b : bytes) {
			sb.append(String.format("%02X", b));  
		}
		return sb.toString();
	}
	
	public static String encodeBase64(String str) {
		return new String(Base64.encodeBase64(str.getBytes()));
	}

	public static String decodeBase64(String str) {
		return new String(Base64.decodeBase64(str.getBytes()));
	}
}
