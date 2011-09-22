package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

public enum Gem {

	OPAL, JADE, RED_TOPAZ;

	private Item item;
	private int level;
	private int cutExperience;
	private int crushedExperience;

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

	public void setCutExperience(int cutExperience) {
		this.cutExperience = cutExperience;
	}

	public int getCutExperience() {
		return this.cutExperience;
	}

	public void setCrushedExperience(int crushedExperience) {
		this.crushedExperience = crushedExperience;
	}

	public int getCrushedExperience() {
		return this.crushedExperience;
	}
}