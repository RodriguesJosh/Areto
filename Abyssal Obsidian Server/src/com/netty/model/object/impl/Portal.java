package com.netty.model.object.impl;

import com.netty.model.object.Object;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:07:59 AM
 */
public class Portal extends Object {

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param direction
	 * 			The id to set.
	 * @param type
	 * 			The id to set.
	 * @param location
	 * 			The id to set.
	 */
	public Portal(int id, byte direction, byte type, Location location) {
		super(id, direction, type);
		this.setLocation(location);
	}
}