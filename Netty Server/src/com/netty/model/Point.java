package com.netty.model;

import com.netty.world.Location;

public class Point {

	private Location location;
	private byte direction;

	public Point(Location location, byte direction) {
		this.setLocation(location);
		this.setDirection(direction);
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setDirection(byte direction) {
		this.direction = direction;
	}

	public byte getDirection() {
		return this.direction;
	}
}