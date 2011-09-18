package com.netty.net.cache;

public class OnDemandData extends CacheableNode {

	public OnDemandData() {
		this.incomplete = true;
	}

	public int dataType;
	public byte buffer[];
	public int id;
	public boolean incomplete;
	public int loopCycle;
}