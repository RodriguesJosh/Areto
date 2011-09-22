package com.netty.net.database.forums;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

	private static String convertToHex(byte[] buffer) {
		StringBuffer stringBuffer = new StringBuffer();
		for (byte b : buffer) {
			int halfByte = (b >>> 4) & 0x0F;
			int twoHalves = 0;
			do {
				if ((0 <= halfByte) && (halfByte <= 9)) {
					stringBuffer.append((char) ('0' + halfByte));
				} else {
					stringBuffer.append((char) ('a' + (halfByte - 10)));
				}
				halfByte = b & 0x0F;
			} while (twoHalves++ < 1);
		}
		return stringBuffer.toString();
	}

	public static String encrypt(String text, String instance) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
		byte[] hash = new byte[32];
		try {
			messageDigest.update(text.getBytes("iso-8859-1"), 0, text.length());
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		hash = messageDigest.digest();
		return Encryption.convertToHex(hash);
	}
}