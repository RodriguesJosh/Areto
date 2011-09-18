package com.netty.net.cache.cacheable;

import com.netty.net.packet.Packet;

public interface Cacheable {

	public void unpackCache(Packet packet);
}