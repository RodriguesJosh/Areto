package com.netty.model.player.minigame.conquest;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:34:40 PM
 */
public enum Command {

	/**
	 * 
	 */
	BATTLE_CRY,

	/**
	 * 
	 */
	STOICISM,

	/**
	 * 
	 */
	REGENERATE,

	/**
	 * 
	 */
	BOMBARD,

	/**
	 * 
	 */
	WINDS_OF_FATE,

	/**
	 * 
	 */
	CHARGE,

	/**
	 * 
	 */
	CHASTISE,

	/**
	 * 
	 */
	VIGILANCE,

	/**
	 * 
	 */
	SHIELD_WALL;

	/**
	 * 
	 */
	private int cooldown;

	/**
	 * 
	 */
	private int cost;

	/**
	 * 
	 * @param cooldown
	 *			The id to set.
	 */
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getCooldown() {
		return this.cooldown;
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