package com.netty.model.player.skill.cooking;

public enum Pie {

	REDBERRY_PIE(0, 0, 0, 0), MEAT_PIE(0, 0, 0, 0), MUD_PIE(0, 0, 0, 0), APPLE_PIE(0, 0, 0, 0), GARDEN_PIE(0, 0, 0, 0), FISH_PIE(0, 0, 0, 0),
	ADMIRAL_PIE(0, 0, 0, 0), WILD_PIE(0, 0, 0, 0), SUMMER_PIE(0, 0, 0, 0);

	private int id;
	private int level;
	private int experience;
	private int healthGained;

	private Pie(int id, int level, int experience, int healthGained) {
		this.setID(id);
		this.setLevel(level);
		this.setExperience(experience);
		this.setHealthGained(healthGained);
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
}