package com.grizzly.net;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * Boots up the connection for the port
 * via the Grizzly implementation.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:56:07 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class BootGrizzly {

	/**
	 * Constructs a new BootGrizzly to set the
	 * connection.
	 */
	public BootGrizzly() {
		this.bindPort(0);
	}

	/**
	 * Binds the port for the Grizzly implementation
	 * to actually connect to the client.
	 * 
	 * @param port
	 * 			The port to use to connect with
	 * 			the client.
	 */
	public void bindPort(int port) {
		int bindedPort = port;
		this.bindPort(bindedPort);
	}
}