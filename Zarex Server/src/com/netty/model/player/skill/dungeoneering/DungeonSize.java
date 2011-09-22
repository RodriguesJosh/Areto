package com.netty.model.player.skill.dungeoneering;

public enum DungeonSize {

	SMALL((byte) 16), MEDIUM((byte) 32), LARGE((byte) 64);

	private byte size;

	private DungeonSize(byte size) {
		this.setSize(size);
	}

	public void setSize(byte size) {
		this.size = size;
	}

	public byte getSize() {
		return this.size;
	}
}