package com.netty.model.object;

import com.netty.model.Entity;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:05:16 AM
 */
public class Object extends Entity {

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private byte direction;

	/**
	 * 
	 */
	private byte type;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param direction
	 * 			The id to set.
	 * @param type
	 * 			The id to set.
	 */
	public Object(int id, byte direction, byte type) {
		this.setID(id);
		this.setDirection(direction);
		this.setType(type);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.Entity#setID(int)
	 */
	@Override
	public void setID(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.Entity#getID()
	 */
	@Override
	public int getID() {
		return this.id;
	}

	/**
	 * 
	 * @param direction
	 * 			The id to set.
	 */
	public void setDirection(byte direction) {
		this.direction = direction;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getDirection() {
		return this.direction;
	}

	/**
	 * 
	 * @param type
	 * 			The id to set.
	 */
	public void setType(byte type) {
		this.type = type;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getType() {
		return this.type;
	}
}