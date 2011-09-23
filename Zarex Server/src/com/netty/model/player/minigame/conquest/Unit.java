package com.netty.model.player.minigame.conquest;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:37:34 PM
 */
public enum Unit {

	/**
	 * 
	 */
	SCOUT,

	/**
	 * 
	 */
	FOOT_SOLDIER,

	/**
	 * 
	 */
	HALBERDIER,

	/**
	 * 
	 */
	ARCHER,

	/**
	 * 
	 */
	MAGE,

	/**
	 * 
	 */
	KNIGHT,

	/**
	 * 
	 */
	CHAMPION;

	/**
	 * 
	 */
	private int movement;

	/**
	 * 
	 */
	private int damage;

	/**
	 * 
	 */
	private int health;

	/**
	 * 
	 */
	private int range;

	/**
	 * 
	 */
	private int cost;

	/**
	 * 
	 * @param movement
	 *			The id to set.
	 */
	public void setMovement(int movement) {
		this.movement = movement;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getMovement() {
		return this.movement;
	}

	/**
	 * 
	 * @param damage
	 *			The id to set.
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getDamage() {
		return this.damage;
	}

	/**
	 * 
	 * @param health
	 *			The id to set.
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getHealth() {
		return this.health;
	}

	/**
	 * 
	 * @param range
	 *			The id to set.
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getRange() {
		return this.range;
	}

	/**
	 * 
	 * @param cost
	 *			The id to set.
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getCost() {
		return this.cost;
	}
}