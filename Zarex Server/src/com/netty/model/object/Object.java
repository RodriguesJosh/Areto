package com.netty.model.object;

import com.netty.model.Entity;

public class Object extends Entity {

	private int id;
	private byte direction;
	private byte type;

	public Object(int id, byte direction, byte type) {
		this.setID(id);
		this.setDirection(direction);
		this.setType(type);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setDirection(byte direction) {
		this.direction = direction;
	}

	public byte getDirection() {
		return this.direction;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public byte getType() {
		return this.type;
	}
}