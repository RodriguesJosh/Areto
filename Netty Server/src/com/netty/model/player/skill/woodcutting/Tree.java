package com.netty.model.player.skill.woodcutting;

public enum Tree {

	NORMAL(1511, 1, 25, 45), OAK(1521, 15, 38, 15), WILLOW(1519, 30, 68, 15), MAPLE(1517, 45, 100, 60), YEW(1515, 60, 175, 100),
	MAGIC(1513, 75, 250, 190);

	private int logID;
	private int level;
	private int experience;
	private int respawnTime;
	private String name;

	private Tree(int logID, int level, int experience, int respawnTime) {
		this.setLogID(logID);
		this.setLevel(level);
		this.setExperience(experience);
		this.setRespawnTime(respawnTime);
	}

	public void setLogID(int logID) {
		this.logID = logID;
	}

	public int getLogID() {
		return this.logID;
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