package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

public enum Silver {

	UNSTRUNG_SYMBOL, UNSTRUNG_EMBLEM, SICKLE, LIGHTNING_CONDUCTOR, UNFINISHED_SILVER_BOLTS, TIARA, SILVTHRILL_ROD, DEMONIC_SIGIL;

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