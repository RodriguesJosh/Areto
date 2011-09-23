package com.netty.world;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:59:59 AM
 */
public class Location {

	/**
	 * 
	 */
	private short x;

	/**
	 * 
	 */
	private short y;

	/**
	 * 
	 */
	private byte z;

	/**
	 * 
	 * @param x
	 * 			The id to set.
	 * @param y
	 * 			The id to set.
	 * @param z
	 * 			The id to set.
	 */
	public Location(short x, short y, byte z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}

	/**
	 * 
	 * @param x
	 * 			The id to set.
	 */
	public void setX(short x) {
		this.x = x;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getX() {
		return this.x;
	}

	/**
	 * 
	 * @param y
	 * 			The id to set.
	 */
	public void setY(short y) {
		this.y = y;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getY() {
		return this.y;
	}

	/**
	 * 
	 * @param z
	 * 			The id to set.
	 */
	public void setZ(byte z) {
		this.z = z;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getZ() {
		return this.z;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getLocalX() {
		return this.getLocalX(this);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getLocalY() {
		return this.getLocalY(this);
	}

	/**
	 * 
	 * @param l
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public short getLocalX(Location l) {
		return (short) (this.getX() - (8 * l.getRegionX()));
	}

	/**
	 * 
	 * @param l
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public short getLocalY(Location l) {
		return (short) (this.getY() - (8 * l.getRegionY()));
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getRegionX() {
		return (short) ((this.getX() >> 3) - 6);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getRegionY() {
		return (short) ((this.getY() >> 3) - 6);
	}

	/**
	 * 
	 * @param otherLocation
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param location
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public Location addLocation(Location location) {
		if (location == null) {
			return null;
		}
		short x = location.getX();
		short y = location.getY();
		byte z = location.getZ();
		return new Location((short) (this.getX() + x), (short) (this.getY() + y), (byte) (this.getZ() + z));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object otherLocation) {
		if (otherLocation == null) {
			return false;
		}
		Location location = (Location) otherLocation;
		return (this.getX() == location.getX()) && (this.getY() == location.getY()) && (this.getZ() == location.getZ());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}