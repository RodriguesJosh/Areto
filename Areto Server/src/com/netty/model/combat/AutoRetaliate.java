package com.netty.model.combat;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 8:12:23 PM
 */
public class AutoRetaliate {

	/**
	 * 
	 */
	private byte id;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public AutoRetaliate(byte id) {
		this.setID(id);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(byte id) {
		this.id = id;
	}

	/**
	 * 
	 * @return id
	 */
	public byte getID() {
		return this.id;
	}
}