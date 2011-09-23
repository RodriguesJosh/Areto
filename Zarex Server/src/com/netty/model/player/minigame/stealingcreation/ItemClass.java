package com.netty.model.player.minigame.stealingcreation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:27:14 PM
 */
public enum ItemClass {

	/**
	 * 
	 */
	ONE(1),

	/**
	 * 
	 */
	TWO(20),

	/**
	 * 
	 */
	THREE(40),

	/**
	 * 
	 */
	FOUR(60),

	/**
	 * 
	 */
	FIVE(80);

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	private ItemClass(int level) {
		this.setLevel(level);
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}
}