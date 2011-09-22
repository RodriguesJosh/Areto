package com.netty.model.player.skill.mining;

import com.netty.model.item.Item;

public enum Ore {

	CLAY(null, 1, 5, 0), RUNE_ESSENCE(null, 1, 5, 0), COPPER(null, 1, 5, 0), TIN(null, 1, 5, 0), LIMESTONE(null, 10, 5, 0), BLURITE(null, 10, 5, 0),
	IRON(null, 15, 5, 0), ELEMENTAL(null, 20, 5, 0), DAEYALT(null, 20, 5, 0), SILVER(null, 20, 5, 0), PURE_ESSENCE(null, 30, 5, 0), COAL(null, 30, 5, 0),
	SANDSTONE(null, 35, 5, 0), GEM_ROCK(null, 40, 5, 0), GOLD(null, 40, 5, 0), PERFECT_GOLD(null, 40, 5, 0), GRANITE(null, 45, 5, 0),
	RUBIUM(null, 46, 5, 0), MITHRIL(null, 55, 5, 0), LUNAR(null, 60, 5, 0), ADAMANTITE(null, 70, 5, 0), LIVING_MINERALS(null, 73, 5, 0),
	CONCENTRATED_COAL(null, 77, 5, 0), CONCENTRATED_GOLD(null, 80, 5, 0), RUNITE(null, 85, 5, 0);

	private Item item;
	private int level;
	private int experience;
	private int respawnTime;
	private String name;

	private Ore(Item item, int level, int experience, int respawnTime) {
		this.setItem(item);
		this.setLevel(level);
		this.setExperience(experience);
		this.setRespawnTime(respawnTime);
	}

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

	public void setRespawnTime(int respawnTime) {
		this.respawnTime = respawnTime;
	}

	public int getRespawnTime() {
		return this.respawnTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}