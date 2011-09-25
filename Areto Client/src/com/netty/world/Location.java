package com.netty.world;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:51:19 PM
 */
public class Location {

	/**
	 * 
	 */
	private int x;

	/**
	 * 
	 */
	private int y;

	/**
	 * 
	 */
	private int z;

	/**
	 * 
	 * @param x
	 * 			The id to set.
	 * @param y
	 * 			The id to set.
	 * @param z
	 * 			The id to set.
	 */
	public Location(int x, int y, int z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}

	/**
	 * 
	 * @param x
	 * 			The id to set.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * 
	 * @param y
	 * 			The id to set.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * 
	 * @param z
	 * 			The id to set.
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getZ() {
		return this.z;
	}
}