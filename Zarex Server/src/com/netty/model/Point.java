package com.netty.model;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 7:48:47 PM
 */
public class Point {

	/**
	 * 
	 */
	private Location location;

	/**
	 * 
	 */
	private byte direction;

	/**
	 * 
	 * 
	 * @param location
	 * 			The location to set.
	 * @param direction
	 * 			The direction to set.
	 */
	public Point(Location location, byte direction) {
		this.setLocation(location);
		this.setDirection(direction);
	}

	/**
	 * 
	 * 
	 * @param location
	 * 			The location to set.
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * 
	 * 
	 * @return direction
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * 
	 * 
	 * @param direction
	 * 			The direction to set.
	 */
	public void setDirection(byte direction) {
		this.direction = direction;
	}

	/**
	 * 
	 * 
	 * @return direction
	 */
	public byte getDirection() {
		return this.direction;
	}
}