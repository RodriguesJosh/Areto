package com.netty.net.cache;

public class Node {

	public void unlink() {
		if (this.next == null) {
		} else {
			this.next.prev = this.prev;
			this.prev.next = this.next;
			this.prev = null;
			this.next = null;
		}
	}

	public Node() {}

	public long id;
	public Node prev;
	public Node next;
}