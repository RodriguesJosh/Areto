package com.netty.model.player.skill.fletching;

import com.netty.model.item.Item;

public enum Bow {

	SHORT, LONG, OAK_SHORT, OAK_LONG, WILLOW_SHORT, WILLOW_LONG, MAPLE_SHORT, MAPLE_LONG, YEW_SHORT, YEW_LONG, MAGIC_SHORT, MAGIC_LONG;

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