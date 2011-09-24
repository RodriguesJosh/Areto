package com.netty.model.player.skill.firemaking;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:34:17 AM
 */
public class Fire {

	/**
	 * 
	 */
	private Location fireLocation;

	/**
	 * 
	 */
	private long fireTime;

	/**
	 * 
	 */
	private int animationID;

	/**
	 * 
	 * @param fireLocation
	 * 			The id to set.
	 * @param fireTime
	 * 			The id to set.
	 * @param animationID
	 * 			The id to set.
	 */
	public Fire(Location fireLocation, long fireTime, int animationID) {
		this.setFireLocation(fireLocation);
		this.setFireTime(fireTime);
		this.setAnimationID(animationID);
	}

	/**
	 * 
	 * @param fireLocation
	 * 			The id to set.
	 */
	public void setFireLocation(Location fireLocation) {
		this.fireLocation = fireLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getFireLocation() {
		return this.fireLocation;
	}

	/**
	 * 
	 * @param fireTime
	 * 			The id to set.
	 */
	public void setFireTime(long fireTime) {
		this.fireTime = fireTime;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public long getFireTime() {
		return this.fireTime;
	}

	/**
	 * 
	 * @param animationID
	 * 			The id to set.
	 */
	public void setAnimationID(int animationID) {
		this.animationID = animationID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getAnimationID() {
		return this.animationID;
	}
}