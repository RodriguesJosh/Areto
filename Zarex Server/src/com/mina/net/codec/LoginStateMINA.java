package com.mina.net.codec;

/**
 * Here, we will handle the state of the login
 * procedure.
 * @author josh
 * @version 1.0
 */
public enum LoginStateMINA {

	/**
	 * Request a few things before actually
	 * connecting to the client.
	 */
	REQUEST,

	/**
	 * Connect to the client that we are
	 * trying to connect to. If this is
	 * successful, move forward.
	 */
	CONNECT,

	/**
	 * Login so that the game play can
	 * actually take place.
	 */
	LOGIN;
}