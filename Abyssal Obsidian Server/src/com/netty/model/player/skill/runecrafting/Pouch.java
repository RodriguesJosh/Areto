package com.netty.model.player.skill.runecrafting;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:37:20 AM
 */
public enum Pouch {

	/**
	 * 
	 */
	SMALL(3, 1),

	/**
	 * 
	 */
	MEDIUM(6, 25),

	/**
	 * 
	 */
	LARGE(9, 50),

	/**
	 * 
	 */
	GIANT(12, 75);

	/**
	 * 
	 * @param amount
	 * 			The id to set.
	 * @param level
	 * 			The id to set.
	 */
	private Pouch(int amount, int level) {
		this.setAmount(amount);
		this.setLevel(level);
	}

	/**
	 * 
	 */
	private int amount;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 * @param amount
	 * 			The id to set.
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getAmount() {
		return this.amount;
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