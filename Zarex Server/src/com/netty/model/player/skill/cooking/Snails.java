package com.netty.model.player.skill.cooking;

public enum Snails {

	THIN_SNAIL(0, 0, 0, 0), LEAN_SNAIL(0, 0, 0, 0), FAT_SNAIL(0, 0, 0, 0);

	private int id;
	private int level;
	private int experience;
	private int healthGained;

	private Snails(int id, int level, int experience, int healthGained) {
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