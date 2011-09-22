package com.netty.model.player.skill.cooking;

public enum Brewing {

	CIDER,
	DWARVEN_STOUT,
	ASGARNIAN_ALE,
	GREENMANS_ALE,
	WIZARDS_MIND_BOMB,
	DRAGON_BITTER,
	MOONLIGHT_MEAD,
	AXEMANS_FOLLY,
	CHEFS_DELIGHT,
	SLAYERS_RESPITE;

	private int id;
	private int level;
	private int experience;
	private int healthGained;
	private int[] boost;

	private Brewing() {

	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
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

	public void setHealthGained(int healthGained) {
		this.healthGained = healthGained;
	}

	public int getHealthGained() {
		return this.healthGained;
	}

	public void setBoost(int[] boost) {
		this.boost = boost;
	}

	public int[] getBoost() {
		return this.boost;
	}
}