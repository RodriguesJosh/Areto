package com.netty.model.combat;

public class AutoRetaliate {

	private byte id;

	public AutoRetaliate(byte id) {
		this.setID(id);
	}

	public void setID(byte id) {
		this.id = id;
	}

	public byte getID() {
		return this.id;
	}
}