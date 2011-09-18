package com.netty.model.player.skill.cooking;

public enum Dairy {

	CHOCOLATE_MILK(0, 4, 0, 40), POT_OF_CREAM(0, 21, 18, 10), PAT_OF_BUTTER(0, 38, 40, 0), CHEESE_WHEEL(0, 48, 68, 20);

	private int id;
	private int level;
	private int experience;
	private int healthGained;

	private Dairy(int id, int level, int experience, int healthGained) {
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