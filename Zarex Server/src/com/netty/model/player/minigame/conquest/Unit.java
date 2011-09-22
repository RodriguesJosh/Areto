package com.netty.model.player.minigame.conquest;

public enum Unit {

	SCOUT, FOOT_SOLDIER, HALBERDIER, ARCHER, MAGE, KNIGHT, CHAMPION;

	private int movement;
	private int damage;
	private int health;
	private int range;
	private int cost;

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public int getMovement() {
		return this.movement;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return this.damage;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return this.health;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getRange() {
		return this.range;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return this.cost;
	}
}