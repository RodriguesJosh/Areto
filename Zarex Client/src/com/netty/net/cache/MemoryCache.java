package com.netty.net.cache;

import com.netty.net.SignLink;

public class MemoryCache {

	public MemoryCache(int i) {
		this.emptyNodeSub = new CacheableNode();
		this.queue = new Queue();
		this.initialCount = i;
		this.spaceLeft = i;
		this.hashTable = new HashTable();
	}

	public CacheableNode insertFromCache(long l) {
		CacheableNode cacheableNode = (CacheableNode) this.hashTable.findNodeByID(l);
		if (cacheableNode != null) {
			this.queue.insertHead(cacheableNode);
		}
		return cacheableNode;
	}

	public void removeFromCache(CacheableNode cacheableNode, long l) {
		try {
			if (this.spaceLeft == 0) {
				CacheableNode nodeSub_1 = this.queue.popTail();
				nodeSub_1.unlink();
				nodeSub_1.unlinkSub();
				if (nodeSub_1 == this.emptyNodeSub) {
					CacheableNode nodeSub_2 = this.queue.popTail();
					nodeSub_2.unlink();
					nodeSub_2.unlinkSub();
				}
			} else {
				this.spaceLeft--;
			}
			this.hashTable.removeFromCache(cacheableNode, l);
			this.queue.insertHead(cacheableNode);
			return;
		} catch (RuntimeException runtimeexception) {
			SignLink.reporterror("47547, " + cacheableNode + ", " + l + ", " + (byte)2 + ", " + runtimeexception.toString());
		}
		throw new RuntimeException();
	}

	public void unlinkAll() {
		do {
			CacheableNode cacheableNode = this.queue.popTail();
			if (cacheableNode != null) {
				cacheableNode.unlink();
				cacheableNode.unlinkSub();
			} else {
				this.spaceLeft = this.initialCount;
				return;
			}
		} while (true);
	}

	private CacheableNode emptyNodeSub;
	private int initialCount;
	private int spaceLeft;
	private HashTable hashTable;
	private Queue queue;
}