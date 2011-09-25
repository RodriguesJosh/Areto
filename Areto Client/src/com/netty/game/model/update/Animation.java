package com.netty.game.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:03:52 PM
 */
public class Animation {

	/**
	 * 
	 */
	private short id;

	/**
	 * 
	 */
	private byte delay;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param delay
	 * 			The id to set.
	 */
	public Animation(short id, byte delay) {
		this.setID(id);
		this.setDelay(delay);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(short id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getID() {
		return this.id;
	}

	/**
	 * 
	 * @param delay
	 * 			The id to set.
	 */
	public void setDelay(byte delay) {
		this.delay = delay;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getDelay() {
		return this.delay;
	}
}