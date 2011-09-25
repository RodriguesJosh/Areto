package com.netty.model.player.skill.farming;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:10:40 AM
 */
public enum Flower {

	/**
	 * 
	 */
	PASTEL_FLOWERS,

	/**
	 * 
	 */
	RED_FLOWERS,

	/**
	 * 
	 */
	BLUE_FLOWERS,

	/**
	 * 
	 */
	YELLOW_FLOWERS,

	/**
	 * 
	 */
	PURPLE_FLOWERS,

	/**
	 * 
	 */
	ORANGE_FLOWERS,

	/**
	 * 
	 */
	MIXED_FLOWERS,

	/**
	 * 
	 */
	WHITE_FLOWERS,

	/**
	 * 
	 */
	BLACK_FLOWERS;

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private int price;

	/**
	 * 
	 */
	private int lowAlch;

	/**
	 * 
	 */
	private int highAlch;

	/**
	 * 
	 */
	private int storePrice;

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
	 * @param lowAlch
	 * 			The id to set.
	 */
	public void setLowAlch(int lowAlch) {
		this.lowAlch = lowAlch;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLowAlch() {
		return this.lowAlch;
	}

	/**
	 * 
	 * @param highAlch
	 * 			The id to set.
	 */
	public void setHighAlch(int highAlch) {
		this.highAlch = highAlch;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getHighAlch() {
		return this.highAlch;
	}

	/**
	 * 
	 * @param storePrice
	 * 			The id to set.
	 */
	public void setStorePrice(int storePrice) {
		this.storePrice = storePrice;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getStorePrice() {
		return this.storePrice;
	}
}