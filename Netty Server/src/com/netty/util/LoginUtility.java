package com.netty.util;

import org.jboss.netty.buffer.ChannelBuffer;

public class LoginUtility {

	public static String getString(ChannelBuffer cb) {
		StringBuffer stringBuffer = new StringBuffer();
		byte b;
		while ((b = cb.readByte()) != '\n') {
			stringBuffer.append((char) b);
		}
		return stringBuffer.toString();
	}
}