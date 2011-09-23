package com.netty.model.player.skill.construction;

import com.netty.model.player.eat.Food;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:03:47 PM
 */
public enum Servant {

	/**
	 * 
	 */
	RICK,

	/**
	 * 
	 */
	MAID,

	/**
	 * 
	 */
	COOK,

	/**
	 * 
	 */
	BUTLER,

	/**
	 * 
	 */
	DEMON_BUTTLER;

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
	private Food[] foodServed;

	/**
	 * 
	 */
	private int carryLimit;

	/**
	 * 
	 */
	private int time;

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
	 * @param foodServed
	 * 			The id to set.
	 */
	public void setFoodServed(Food[] foodServed) {
		this.foodServed = foodServed;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Food[] getFoodServed() {
		return this.foodServed;
	}

	/**
	 * 
	 * @param carryLimit
	 * 			The id to set.
	 */
	public void setCarryLimit(int carryLimit) {
		this.carryLimit = carryLimit;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCarryLimit() {
		return this.carryLimit;
	}

	/**
	 * 
	 * @param time
	 * 			The id to set.
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getTime() {
		return this.time;
	}
}