package com.netty.model.player.skill.construction;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:05:00 PM
 */
public enum HouseStyle {

	/**
	 * 
	 */
	BASIC_WOOD,

	/**
	 * 
	 */
	BASIC_STONE,

	/**
	 * 
	 */
	WHITEWASHED_STONE,

	/**
	 * 
	 */
	FREMENNIK_WOOD,

	/**
	 * 
	 */
	TROPICAL_WOOD,

	/**
	 * 
	 */
	FANCY_STONE,

	/**
	 * 
	 */
	ZENEVIVIA_DARK_STONE;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private int price;

	/**
	 * 
	 */
	private String areaName;

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

	/**
	 * 
	 * @param price
	 * 			The id to set.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param areaName
	 * 			The id to set.
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getAreaName() {
		return this.areaName;
	}
}