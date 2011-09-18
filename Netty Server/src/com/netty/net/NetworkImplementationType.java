package com.netty.net;

/**
 * A type of networking API to use for
 * bench marking purposes.
 * @author josh
 * @version 1.0
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