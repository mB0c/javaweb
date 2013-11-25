package com.insigma.guobo.tbk.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import sun.misc.BASE64Encoder;

@Entity
public class PwdMd5Util {
	
	public static String md5(String message){
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(message.getBytes());
			//通过base64从新编码
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static String md52Code(String message){
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(message.getBytes());

			return md5.toString();
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}		
	}
	
}
