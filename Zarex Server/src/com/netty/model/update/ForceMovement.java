package com.netty.model.update;

import com.netty.world.Location;

public class ForceMovement {

	private Location startLocation;
	private Location endLocation;
	private int startSpeed;
	private int endSpeed;
	private int facingDirection;

	public ForceMovement(Location startLocation, Location endLocation, int startSpeed, int endSpeed, int facingDirection) {
		this.setStartLocation(startLocation);
		this.setEndLocation(endLocation);
		this.setStartSpeed(startSpeed);
		this.setEndSpeed(endSpeed);
		this.setFacingDirection(facingDirection);
	}

	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	public Location getStartLocation() {
		return this.startLocation;
	}

	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	public Location getEndLocation() {
		return this.endLocation;
	}

	public void setStartSpeed(int startSpeed) {
		this.startSpeed = startSpeed;
	}

	public int getStartSpeed() {
		return this.startSpeed;
	}

	public void setEndSpeed(int endSpeed) {
		this.endSpeed = endSpeed;
	}

	public int getEndSpeed() {
		return this.endSpeed;
	}

	public void setFacingDirection(int facingDirection) {
		this.facingDirection = facingDirection;
	}

	public int getFacingDirection() {
		return this.facingDirection;
	}
}