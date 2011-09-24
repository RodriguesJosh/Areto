package com.netty.util;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:02:26 PM
 */
public class LoginUtility {

	/**
	 * 
	 * @param cb
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public static String getString(ChannelBuffer cb) {
		StringBuffer stringBuffer = new StringBuffer();
		byte b;
		while ((b = cb.readByte()) != '\n') {
			stringBuffer.append((char) b);
		}
		return stringBuffer.toString();
	}
}