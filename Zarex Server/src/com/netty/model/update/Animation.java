package com.netty.model.update;

public class Animation {

	private int id;
	private int delay;

	public Animation(int id, int delay) {
		this.setID(id);
		this.setDelay(delay);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getDelay() {
		return this.delay;
	}
}