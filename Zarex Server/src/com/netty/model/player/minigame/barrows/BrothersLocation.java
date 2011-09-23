package com.netty.model.player.minigame.barrows;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:04:22 PM
 */
public enum BrothersLocation {

	/**
	 * 
	 */
	VERAC(new Location((short) 3554, (short) 3294, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1)),

	/**
	 * 
	 */
	AHRIM(new Location((short) 3561, (short) 3286, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1)),

	/**
	 * 
	 */
	TORAG(new Location((short) 3570, (short) 3293, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1)),

	/**
	 * 
	 */
	KARIL(new Location((short) 3570, (short) 3293, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1)),

	/**
	 * 
	 */
	GUTHAN(new Location((short) 3570, (short) 3293, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1));

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
	 * @param startLocation
	 * 			The id to set.
	 * @param endLocation
	 * 			The id to set.
	 */
	private BrothersLocation(Location startLocation, Location endLocation) {
		this.setStartLocation(startLocation);
		this.setEndLocation(endLocation);
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
}