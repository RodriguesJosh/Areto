package com.netty.model.player.minigame.allfiredup;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:57:53 PM
 */
public enum Log {

	/**
	 * 
	 */
	REGULAR(13.0),

	/**
	 * 
	 */
	OAK(13.5),

	/**
	 * 
	 */
	WILLOW(14.5),

	/**
	 * 
	 */
	MAPLE(15.75),

	/**
	 * 
	 */
	YEW(16.5),

	/**
	 * 
	 */
	MAGIC(18.0);

	/**
	 * 
	 */
	private double burnTime;

	/**
	 * 
	 * @param burnTime
	 * 			The id to set.
	 */
	private Log(double burnTime) {
		this.setBurnTime(burnTime);
	}

	/**
	 * 
	 * @param burnTime
	 * 			The id to set.
	 */
	public void setBurnTime(double burnTime) {
		this.burnTime = burnTime;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public double getBurnTime() {
		return this.burnTime;
	}
}