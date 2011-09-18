package com.netty.game.model.entity.player.chat;

public enum ChatEffect {

	NONE(0), WAVE_ONE(1), WAVE_TWO(2), SHAKE(3), SCROLL(4), SLIDE(5);

	private int id;

	private ChatEffect(int id) {
		this.setID(id);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}
}