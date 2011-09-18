package com.netty.model.player.skill.cooking;

public enum GnomeCooking {

	FRUIT_BLAST, PINEAPPLET_PUNCH, TOAD_CRUNCHIES, SPICY_CRUNCHIES, WORM_CRUNCHIES, CHOCOLATECHIP_CRUNCHIES, WIZARD_BLIZZARD, SHORT_GREEN_GUY,
	FRUIT_BATTA, TOAD_BATTA, WORM_BATTA, VEGETABLE_BATTA, CHEESE_TOMATO_BATTA, WORM_HOLE, DRUNK_DRAGON, CHOCOLATE_SATURDAY, VEGETABLE_BALL,
	BLURBERRY_SPECIAL, TANGLED_TOADS_LEGS, CHOCOLATE_BOMB;

	private int id;
	private int experience;
	private int healthGained;

	private GnomeCooking() {

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

	public void setHealthGained(int healthGained) {
		this.healthGained = healthGained;
	}

	public int getHealthGained() {
		return this.healthGained;
	}
}