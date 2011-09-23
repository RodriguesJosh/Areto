package com.netty.model.object.impl;

import com.netty.model.object.Object;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:07:03 AM
 */
public class Door extends Object {

	/**
	 * 
	 */
	private boolean isOpen;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param location
	 * 			The id to set.
	 * @param direction
	 * 			The id to set.
	 * @param type
	 * 			The id to set.
	 * @param isOpen
	 * 			The id to set.
	 */
	public Door(int id, Location location, byte direction, byte type, boolean isOpen) {
		super(id, direction, type);
		this.setLocation(location);
		this.setOpen(isOpen);
	}

	/**
	 * 
	 * @param isOpen
	 * 			The id to set.
	 */
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isOpen() {
		return this.isOpen;
	}
}