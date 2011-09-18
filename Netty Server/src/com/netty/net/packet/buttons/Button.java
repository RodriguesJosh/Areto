package com.netty.net.packet.buttons;

public class Button {

	private int id;

	public Button(int id) {
		this.setID(id);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}
}