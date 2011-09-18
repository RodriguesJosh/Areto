package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

public enum Pottery {

	POT, CLAY_RING, PIE_DISH, BOWL, PLANT_POT, POT_LID;

	private Item item;
	private int level;
	private int mouldingExperience;
	private int firingExperience;

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

	public void setMouldingExperience(int mouldingExperience) {
		this.mouldingExperience = mouldingExperience;
	}

	public int getMouldingExperience() {
		return this.mouldingExperience;
	}

	public void setFiringExperience(int firingExperience) {
		this.firingExperience = firingExperience;
	}

	public int getFiringExperience() {
		return this.firingExperience;
	}
}