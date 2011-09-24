package com.xsocket.net;

import com.netty.net.NetworkConstants;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:51:50 AM
 */
public class BootXSocket {

	/**
	 * 
	 */
	public BootXSocket() {
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