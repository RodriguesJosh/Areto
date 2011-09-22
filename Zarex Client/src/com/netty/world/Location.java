package com.netty.world;

public class Location {

	private int x;
	private int y;
	private int z;

	public Location(int x, int y, int z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getZ() {
		return this.z;
	}
}