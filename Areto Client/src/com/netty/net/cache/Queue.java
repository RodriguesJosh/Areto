package com.netty.net.cache;

class Queue {

	public Queue() {
		this.head = new CacheableNode();
		this.head.prevNodeSub = this.head;
		this.head.nextNodeSub = this.head;
	}

	public void insertHead(CacheableNode cacheableNode) {
		if (cacheableNode.nextNodeSub != null) {
			cacheableNode.unlinkSub();
		}
		cacheableNode.nextNodeSub = this.head.nextNodeSub;
		cacheableNode.prevNodeSub = this.head;
		cacheableNode.nextNodeSub.prevNodeSub = cacheableNode;
		cacheableNode.prevNodeSub.nextNodeSub = cacheableNode;
	}

	public CacheableNode popTail() {
		CacheableNode cacheableNode = this.head.prevNodeSub;
		if (cacheableNode == this.head) {
			return null;
		}
		cacheableNode.unlinkSub();
		return cacheableNode;
	}

	public CacheableNode reverseGetFirst() {
		CacheableNode cacheableNode = this.head.prevNodeSub;
		if (cacheableNode == this.head) {
			this.current = null;
			return null;
		}
		this.current = cacheableNode.prevNodeSub;
		return cacheableNode;
	}

	public CacheableNode reverseGetNext() {
		CacheableNode cacheableNode = this.current;
		if (cacheableNode == this.head) {
			this.current = null;
			return null;
		}
		this.current = cacheableNode.prevNodeSub;
		return cacheableNode;
	}

	public int getNodeCount() {
		int i = 0;
		for (CacheableNode cacheableNode = this.head.prevNodeSub; cacheableNode != this.head; cacheableNode = cacheableNode.prevNodeSub) {
			i++;
		}
		return i;
	}

	private CacheableNode head;
	private CacheableNode current;
}