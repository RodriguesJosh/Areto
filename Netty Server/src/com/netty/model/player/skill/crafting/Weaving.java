package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

public enum Weaving {

	CLOTH, SACK, BASKET, UNFINISHED_SEAWEED_NET;

	private Item item;
	private int level;
	private int experience;
	private Item[] materials;

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

	public void setMaterials(Item[] materials) {
		this.materials = materials;
	}

	public Item[] getMaterials() {
		return this.materials;
	}
}