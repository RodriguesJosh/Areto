package com.netty.net.cache.cacheable.unpack;

import com.netty.net.cache.cacheable.Cacheable;
import com.netty.net.packet.Packet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:09:34 PM
 */
public class SettingUsagePointersUnpack implements Cacheable {

	/* (non-Javadoc)
	 * @see com.netty.net.cache.cacheable.Cacheable#unpackCache(com.netty.net.packet.Packet)
	 */
	@Override
	public void unpackCache(Packet packet) {
		if (packet == null) {
			throw new NullPointerException();
		}
	}
}