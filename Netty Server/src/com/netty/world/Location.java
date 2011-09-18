package com.netty.world;

public class Location {

	private short x;
	private short y;
	private byte z;

	public Location(short x, short y, byte z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}

	public void setX(short x) {
		this.x = x;
	}

	public short getX() {
		return this.x;
	}

	public void setY(short y) {
		this.y = y;
	}

	public short getY() {
		return this.y;
	}

	public void setZ(byte z) {
		this.z = z;
	}

	public byte getZ() {
		return this.z;
	}

	public short getLocalX() {
		return this.getLocalX(this);
	}

	public short getLocalY() {
		return this.getLocalY(this);
	}

	public short getLocalX(Location l) {
		return (short) (this.getX() - (8 * l.getRegionX()));
	}

	public short getLocalY(Location l) {
		return (short) (this.getY() - (8 * l.getRegionY()));
	}

	public short getRegionX() {
		return (short) ((this.getX() >> 3) - 6);
	}

	public short getRegionY() {
		return (short) ((this.getY() >> 3) - 6);
	}

	public boolean isWithinDistance(Location otherLocation) {
		if (otherLocation == null) {
			return false;
		}
		if (this.getZ() != otherLocation.getZ()) {
			return false;
		}
		int x = otherLocation.getX() - this.getX();
		int y = otherLocation.getY() - this.getY();
		return (x <= 14) && (x >= -15) && (y <= 14) && (y >= -15);
	}

	public Location addLocation(Location location) {
		if (location == null) {
			return null;
		}
		short x = location.getX();
		short y = location.getY();
		byte z = location.getZ();
		return new Location((short) (this.getX() + x), (short) (this.getY() + y), (byte) (this.getZ() + z));
	}

	@Override
	public boolean equals(Object otherLocation) {
		if (otherLocation == null) {
			return false;
		}
		Location location = (Location) otherLocation;
		return (this.getX() == location.getX()) && (this.getY() == location.getY()) && (this.getZ() == location.getZ());
	}
}