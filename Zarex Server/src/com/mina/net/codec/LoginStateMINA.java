package com.mina.net.codec;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;

/**
 * Here, we will handle the state of the login
 * procedure.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 11:26:22 AM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
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