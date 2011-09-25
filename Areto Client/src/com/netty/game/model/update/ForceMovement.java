package com.netty.game.model.update;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:03:12 PM
 */
public class ForceMovement {

	/**
	 * 
	 */
	private Location startLocation;

	/**
	 * 
	 */
	private Location endLocation;

	/**
	 * 
	 */
	private int startSpeed;

	/**
	 * 
	 */
	private int endSpeed;

	/**
	 * 
	 */
	private int facingDirection;

	/**
	 * 
	 * @param startLocation
	 * 			The id to set.
	 * @param endLocation
	 * 			The id to set.
	 * @param startSpeed
	 * 			The id to set.
	 * @param endSpeed
	 * 			The id to set.
	 * @param facingDirection
	 * 			The id to set.
	 */
	public ForceMovement(Location startLocation, Location endLocation, int startSpeed, int endSpeed, int facingDirection) {
		this.setStartLocation(startLocation);
		this.setEndLocation(endLocation);
		this.setStartSpeed(startSpeed);
		this.setEndSpeed(endSpeed);
		this.setFacingDirection(facingDirection);
	}

	/**
	 * 
	 * @param startLocation
	 * 			The id to set.
	 */
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getStartLocation() {
		return this.startLocation;
	}

	/**
	 * 
	 * @param endLocation
	 * 			The id to set.
	 */
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getEndLocation() {
		return this.endLocation;
	}

	/**
	 * 
	 * @param startSpeed
	 * 			The id to set.
	 */
	public void setStartSpeed(int startSpeed) {
		this.startSpeed = startSpeed;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getStartSpeed() {
		return this.startSpeed;
	}

	/**
	 * 
	 * @param endSpeed
	 * 			The id to set.
	 */
	public void setEndSpeed(int endSpeed) {
		this.endSpeed = endSpeed;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getEndSpeed() {
		return this.endSpeed;
	}

	/**
	 * 
	 * @param facingDirection
	 * 			The id to set.
	 */
	public void setFacingDirection(int facingDirection) {
		this.facingDirection = facingDirection;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getFacingDirection() {
		return this.facingDirection;
	}
}