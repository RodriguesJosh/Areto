package com.netty.net.cache;

public class CacheableNode extends Node {

	public void unlinkSub() {
		if (this.nextNodeSub == null) {
		} else {
			this.nextNodeSub.prevNodeSub = this.prevNodeSub;
			this.prevNodeSub.nextNodeSub = this.nextNodeSub;
			this.prevNodeSub = null;
			this.nextNodeSub = null;
		}
	}

	public CacheableNode() {}

	public CacheableNode prevNodeSub;
	CacheableNode nextNodeSub;
}