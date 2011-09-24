package com.netty.model.player.skill.farming;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:12:27 AM
 */
public enum Allotment {

	/**
	 * 
	 */
	POTATOES_ALLOTMENT,

	/**
	 * 
	 */
	ONIONS_ALLOTMENT,

	/**
	 * 
	 */
	CABBAGES_ALLOTMENT,

	/**
	 * 
	 */
	TOMATOS_ALLOTMENT,

	/**
	 * 
	 */
	SWEETCORN_ALLOTMENT,

	/**
	 * 
	 */
	STRAWBERRY_ALLOTMENT,

	/**
	 * 
	 */
	WATERMELONS_ALLOTMENT;

	/**
	 * 
	 */
	private int level;

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