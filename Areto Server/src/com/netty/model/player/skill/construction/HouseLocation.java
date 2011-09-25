package com.netty.model.player.skill.construction;

import com.netty.model.player.Teleport;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:05:42 PM
 */
public enum HouseLocation {

	/**
	 * 
	 */
	RIMMINGTON,

	/**
	 * 
	 */
	TAVERLY,

	/**
	 * 
	 */
	POLLNIVNEACH,

	/**
	 * 
	 */
	RELLEKKA,

	/**
	 * 
	 */
	BRIMHAVEN,

	/**
	 * 
	 */
	YANILLE;

	/**
	 * 
	 */
	private Teleport teleport;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private int relocatePrice;

	/**
	 * 
	 * @param teleport
	 * 			The id to set.
	 */
	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Teleport getTeleport() {
		return this.teleport;
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

	/**
	 * 
	 * @param relocatePrice
	 * 			The id to set.
	 */
	public void setRelocatePrice(int relocatePrice) {
		this.relocatePrice = relocatePrice;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getRelocatePrice() {
		return this.relocatePrice;
	}
}