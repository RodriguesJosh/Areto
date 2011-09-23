package com.nio.net;

import com.netty.net.NetworkConstants;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:54:05 AM
 */
public class BootNIO {

	/**
	 * 
	 */
	public BootNIO() {
		this.bindPort(NetworkConstants.PORT);
	}

	/**
	 * 
	 * @param port
	 * 			The id to set.
	 */
	public void bindPort(int port) {
		this.bindPort(port);
	}
}