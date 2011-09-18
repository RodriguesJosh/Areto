package com.netty.model.player.minigame.allfiredup;

import com.netty.model.item.Item;

public enum Reward {

	NONE(null, (byte) -1), RING_OF_FIRE(null, (byte) 62), FLAME_GLOVES(null, (byte) 79),
	INFERNO_ADZE(null, (byte) 92);

	private Item item;
	private byte level;

	private Reward(Item item, byte level) {
		this.setItem(item);
		this.setLevel(level);
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public byte getLevel() {
		return this.level;
	}
}