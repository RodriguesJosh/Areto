package com.netty.game.model.entity.player.chat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:43:02 PM
 */
public enum ChatColor {

	/**
	 * 
	 */
	YELLOW(0),

	/**
	 * 
	 */
	RED(1),

	/**
	 * 
	 */
	GREEN(2),

	/**
	 * 
	 */
	CYAN(3),

	/**
	 * 
	 */
	PURPLE(4),

	/**
	 * 
	 */
	WHITE(5),

	/**
	 * 
	 */
	FLASH_ONE(6),

	/**
	 * 
	 */
	FLASH_TWO(7),

	/**
	 * 
	 */
	FLASH_THREE(8),

	/**
	 * 
	 */
	GLOW_ONE(9),

	/**
	 * 
	 */
	GLOW_TWO(10),

	/**
	 * 
	 */
	GLOW_THREE(11);

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	private ChatColor(int id) {
		this.setID(id);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getID() {
		return this.id;
	}
}