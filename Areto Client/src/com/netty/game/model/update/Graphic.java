package com.netty.game.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:02:53 PM
 */
public class Graphic {

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private int delay;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param delay
	 * 			The id to set.
	 */
	public Graphic(int id, int delay) {
		this.setID(id);
		this.setDelay(delay);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * 
	 * @param delay
	 * 			The id to set.
	 */
	public void setDelay(int delay) {
		this.delay = delay;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getDelay() {
		return this.delay;
	}
}