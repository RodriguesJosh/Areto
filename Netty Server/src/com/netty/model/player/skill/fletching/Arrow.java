package com.netty.model.player.skill.fletching;

import com.netty.model.item.Item;

public enum Arrow {

	SHAFTS, HEADLESS, BRONZE, IRON, STEEL, MITHRIL, BROAD_LEAF, ADAMANT, RUNE, DRAGON;

	private Item item;
	private int level;
	private int experience;
	private int experienceSet;

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

	public void setExperienceSet(int experienceSet) {
		this.experienceSet = experienceSet;
	}

	public int getExperienceSet() {
		return this.experienceSet;
	}
}