package com.netty.model.player.skill.cooking;

import com.netty.model.item.Item;

public enum Fish {

	SHRIMP(0, 0, null, null, null);

	private int level;
	private int experience;
	private Item raw;
	private Item cooked;
	private Item burnt;

	private Fish(int level, int experience, Item raw, Item cooked, Item burnt) {
		this.setLevel(level);
		this.setExperience(experience);
		this.setRaw(raw);
		this.setCooked(cooked);
		this.setBurnt(burnt);
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

	public void setRaw(Item raw) {
		this.raw = raw;
	}

	public Item getRaw() {
		return this.raw;
	}

	public void setCooked(Item cooked) {
		this.cooked = cooked;
	}

	public Item getCooked() {
		return this.cooked;
	}

	public void setBurnt(Item burnt) {
		this.burnt = burnt;
	}

	public Item getBurnt() {
		return this.burnt;
	}
}