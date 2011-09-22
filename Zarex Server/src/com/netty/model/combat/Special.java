package com.netty.model.combat;

public class Special {

	private short id;

	public Special(short id) {
		this.setID(id);
	}

	public void setID(short id) {
		this.id = id;
	}

	public short getID() {
		return this.id;
	}
}