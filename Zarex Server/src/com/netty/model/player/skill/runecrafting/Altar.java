package com.netty.model.player.skill.runecrafting;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:37:49 AM
 */
public enum Altar {

	/**
	 * 
	 */
	AIR_ALTAR,

	/**
	 * 
	 */
	MIND,

	/**
	 * 
	 */
	WATER,

	/**
	 * 
	 */
	EARTH,

	/**
	 * 
	 */
	FIRE,

	/**
	 * 
	 */
	BODY,

	/**
	 * 
	 */
	COSMIC,

	/**
	 * 
	 */
	CHAOS,

	/**
	 * 
	 */
	ASTRAL,

	/**
	 * 
	 */
	NATURE,

	/**
	 * 
	 */
	LAW,

	/**
	 * 
	 */
	DEATH,

	/**
	 * 
	 */
	BLOOD,

	/**
	 * 
	 */
	SOUL,

	/**
	 * 
	 */
	OURANIA;

	/**
	 * 
	 */
	private Location startLocation;

	/**
	 * 
	 */
	private Location endLocation;

	/**
	 * 
	 * @param startLocation
	 * 			The id to set.
	 */
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getStartLocation() {
		return this.startLocation;
	}

	/**
	 * 
	 * @param endLocation
	 * 			The id to set.
	 */
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getEndLocation() {
		return this.endLocation;
	}
}