package com.netty.net;

/**
 * A type of networking API to use for
 * bench marking purposes.
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:33:54 PM
 */
public enum NetworkImplementationType {

	/**
	 * Represents the JBoss Netty networking
	 * framework.
	 */
	NETTY,

	/**
	 * Represents the Apache MINA networking
	 * framework.
	 */
	MINA,

	/**
	 * Represents the standard IO networking
	 * framework.
	 */
	IO,

	/**
	 * Represents the NIO networking
	 * framework.
	 */
	NIO,

	/**
	 * Represents the Grizzly networking
	 * framework.
	 */
	GRIZZLY,

	/**
	 * Represents the xSocket networking
	 * framework.
	 */
	XSOCKET;
}