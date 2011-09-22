package com.netty.net.cache;

import com.netty.net.SignLink;

class HashTable {

	public HashTable() {
		int i = 1024;
		this.size = i;
		this.cache = new Node[i];
		for (int k = 0; k < i; k++) {
			Node node = this.cache[k] = new Node();
			node.prev = node;
			node.next = node;
		}
	}

	public Node findNodeByID(long l) {
		Node node = this.cache[(int)(l & (this.size - 1))];
		for (Node node_1 = node.prev; node_1 != node; node_1 = node_1.prev) {
			if (node_1.id == l) {
				return node_1;
			}
		}
		return null;
	}

	public void removeFromCache(Node node, long l) {
		try {
			if (node.next != null) {
				node.unlink();
			}
			Node node_1 = this.cache[(int)(l & (this.size - 1))];
			node.next = node_1.next;
			node.prev = node_1;
			node.next.prev = node;
			node.prev.next = node;
			node.id = l;
			return;
		} catch (RuntimeException runtimeexception) {
			SignLink.reporterror("Error removing from cache.");
		}
		throw new RuntimeException();
	}

	private int size;
	private Node[] cache;
}