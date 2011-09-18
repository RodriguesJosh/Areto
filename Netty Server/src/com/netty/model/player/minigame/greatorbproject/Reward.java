package com.netty.model.player.minigame.greatorbproject;

import com.netty.model.item.Item;

public enum Reward {

	NONE, RUNECRAFTER_HAT, RUNECRAFTER_ROBE, RUNECRAFTER_SKIRT, RUNECRAFTER_GLOVES;

	private Item item;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}
}