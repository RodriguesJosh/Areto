package com.netty.model.player.dungeon;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 9:41:04 PM
 */
public abstract class Dungeon {

	/**
	 * 
	 * @param location
	 * 			The location to set.
	 */
	public abstract void setLocation(Location location);

	/**
	 * 
	 * @return
	 * 			Returns the location to get.
	 */
	public abstract Location getLocation();
}