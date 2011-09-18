package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

public enum Glass {

	BEER_GLASS, CANDLE_LANTERN, OIL_LAMP, VIAL, FISH_BOWL, UNPOWERED_ORB, LANTERN_LENS, EMPTY_LIGHT_ORB;

	private Item item;
	private int level;
	private int experience;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}
}