package com.qiekang.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MD5Util {
	
	public static String getMD5(byte[] source) {
		String s = null;
		    char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); 
			char str[] = new char[16 * 2]; 
			int k = 0; 
			for (int i = 0; i < 16; i++) { 				
				byte byte0 = tmp[i]; 
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; 				
				str[k++] = hexDigits[byte0 & 0xf]; 
			}
			s = new String(str); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	/**
	 * 用MD5进行加密
	 */
	public static String getMd5(String plainText) {
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			byte[] btInput = plainText.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getMd5Code(String inString) {

		// 要加密的字符串字节型数组
		byte defaultBytes[] = null;
		try {
			defaultBytes = inString.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 加密后的字符串
		StringBuffer hexString;
		// 得到MessageDigest加密对象
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 重置上面字节数
		algorithm.reset();
		// 使用指定的字节数组更新
		algorithm.update(defaultBytes);

		byte messageDigest[] = algorithm.digest();
		hexString = new StringBuffer();
		for (int i = 0; i < messageDigest.length; i++) {
			String hex = Integer.toHexString(0xff & messageDigest[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}


	public static void main(String args[]){
		System.out.println(getMD5("PasswordAppkey20160102135600".getBytes()));
		
		String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		System.out.println(getMd5Code("key"+"content"));
		System.out.println(format);
	}
}
