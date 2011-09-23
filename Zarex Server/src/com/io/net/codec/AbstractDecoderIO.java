package com.io.net.codec;

/**
 * An abstract class to represent decoding
 * for the packets that were sent from the
 * client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:15:54 AM
 */
public abstract class AbstractDecoderIO {

	/**
	 * Decode the packets.
	 * @return
	 * 			Returns the decoded object.
	 */
	public abstract Object decode();
}