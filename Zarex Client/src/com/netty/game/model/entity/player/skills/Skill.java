package com.netty.game.model.entity.player.skills;

public class Skill {

	private byte id;
	private int level;
	private int experience;

	public Skill(byte id, int level, int experience) {
		this.setID(id);
		this.setLevel(level);
		this.setExperience(experience);
	}

	public void setID(byte id) {
		this.id = id;
	}

	public byte getID() {
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
}