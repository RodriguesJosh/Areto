package com.netty.model.player.skill.cooking;

public enum PotatoToppings {

	SPICY_SAUCE, CHILLI_CON_CARNE, SCRAMBLED_EGG, EGG_TOMATO, FRIED_ONIONS, FRIED_MUSHROOMS, MUSHROOM_AND_ONION, TUNA_AND_CORN;

	private int id;
	private int level;
	private int experience;
	private int healthGained;

	private PotatoToppings() {

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