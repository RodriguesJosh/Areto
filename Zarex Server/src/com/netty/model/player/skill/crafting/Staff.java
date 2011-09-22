package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

public enum Staff {

	WATER_BATTLESTAFF, EARTH_BATTLESTAFF, FIRE_BATTLESTAFF, AIR_BATTLESTAFF;

	private Item item;
	private byte level;
	private int experience;
	private byte magicLevel;

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

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setMagicLevel(byte magicLevel) {
		this.magicLevel = magicLevel;
	}

	public byte getMagicLevel() {
		return this.magicLevel;
	}
}