package com.netty.model.player.skill.crafting;

public enum Cape {

	RED_CAPE(0, 2), YELLOW_CAPE(0, 2), BLUE_CAPE(0, 2), PINK_CAPE(0, 2), ORANGE_CAPE(0, 2), PURPLE_CAPE(0, 2), GREEN_CAPE(0, 2), BLACK_CAPE(0, 2);

	private int id;
	private int experience;

	private Cape(int id, int experience) {
		this.setID(id);
		this.setExperience(experience);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}
}