package com.netty.net.cache.cacheable;

import com.netty.net.packet.Packet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:08:33 PM
 */
public interface Cacheable {

	/**
	 * 
	 * @param packet
	 * 			The id to set.
	 */
	public void unpackCache(Packet packet);
}