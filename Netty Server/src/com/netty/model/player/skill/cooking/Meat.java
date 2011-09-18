package com.netty.model.player.skill.cooking;

public enum Meat {

	COOKED_MEAT(0, 0, 0, 0, 0, 0), COOKED_CHICKEN(0, 0, 0, 0, 0, 0), UGTHANKI_MEAT(0, 0, 0, 0, 0, 0), COOKED_RABBIT(0, 0, 0, 0, 0, 0),
	ROASTED_BIRD_MEAT(0, 0, 0, 0, 0, 0), ROASTED_RABBIT(0, 0, 0, 0, 0, 0), SPIDER_ON_STICK(0, 0, 0, 0, 0, 0), SPIDER_ON_SHAFT(0, 0, 0, 0, 0, 0),
	CRAB_MEAT(0, 0, 0, 0, 0, 0), ROASTED_BEAST_MEAT(0, 0, 0, 0, 0, 0), COOKED_CHOMPY(0, 0, 0, 0, 0, 0), COOKED_JUBBLY(0, 0, 0, 0, 0, 0),
	OOMLIE_WRAP(0, 0, 0, 0, 0, 0);

	private int level;
	private int experience;
	private int raw;
	private int cooked;
	private int burnt;
	private int healthGained;

	private Meat(int level, int experience, int raw, int cooked, int burnt, int healthGained) {
		this.setLevel(level);
		this.setExperience(experience);
		this.setRaw(raw);
		this.setCooked(cooked);
		this.setBurnt(burnt);
		this.setHealthGained(healthGained);
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

	public void setRaw(int raw) {
		this.raw = raw;
	}

	public int getRaw() {
		return this.raw;
	}

	public void setCooked(int cooked) {
		this.cooked = cooked;
	}

	public int getCooked() {
		return this.cooked;
	}

	public void setBurnt(int burnt) {
		this.burnt = burnt;
	}

	public int getBurnt() {
		return this.burnt;
	}

	public void setHealthGained(int healthGained) {
		this.healthGained = healthGained;
	}

	public int getHealthGained() {
		return this.healthGained;
	}
}