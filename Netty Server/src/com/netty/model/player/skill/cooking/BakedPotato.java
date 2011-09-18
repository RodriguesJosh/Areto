package com.netty.model.player.skill.cooking;

public enum BakedPotato {

	BAKED_POTATO(0, 17, 15, 40), POTATO_WITH_BUTTER(0, 39, 95, 140), CHILLI_POTATO(0, 41, 165, 140), POTATO_WITH_CHEESE(0, 47, 199, 160),
	EGG_POTATO(0, 51, 195, 160), MUSHROOM_ONION_POTATO(0, 64, 270, 200), TUNA_POTATO(0, 68, 309, 220);

	private int id;
	private int level;
	private int experience;
	private int healthGained;

	private BakedPotato(int id, int level, int experience, int healthGained) {
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