package com.netty.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:41:12 PM
 */
public class Transform {

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public Transform(int id) {
		this.setID(id);
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
}