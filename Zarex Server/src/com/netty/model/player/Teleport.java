package com.netty.model.player;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:20:34 AM
 */
public enum Teleport {

	/**
	 * 
	 */
	HOME(new Location((short) 3254, (short) 3437, (byte) 0), false),

	/**
	 * 
	 */
	LUMBRIDGE(new Location((short) 3200, (short) 3200, (byte) 0), false),

	/**
	 * 
	 */
	DUEL_ARENA(new Location((short) 3200, (short) 3200, (byte) 0), false),

	/**
	 * 
	 */
	VARROCK(new Location((short) 3200, (short) 3200, (byte) 0), false),

	/**
	 * 
	 */
	FALLADOR(new Location((short) 3200, (short) 3200, (byte) 0), false),

	/**
	 * 
	 */
	FIGHT_CAVES(new Location((short) 3200, (short) 3200, (byte) 0), false),

	/**
	 * 
	 */
	FIGHT_PITS(new Location((short) 3200, (short) 3200, (byte) 0), false),

	/**
	 * 
	 */
	GREAT_ORB_PROJECT(new Location((short) 3200, (short) 3200, (byte) 0), false),

	/**
	 * 
	 */
	MAGE_ARENA(new Location((short) 3200, (short) 3200, (byte) 0), false);

	/**
	 * 
	 */
	private Location teleportingLocation;
	/**
	 * 
	 */
	private boolean isAncients;

	/**
	 * 
	 * @param teleportingLocation
	 * 			The id to set.
	 * @param isAncients
	 * 			The id to set.
	 */
	private Teleport(Location teleportingLocation, boolean isAncients) {
		this.setTeleportingLocation(teleportingLocation);
		this.setAncients(isAncients);
	}

	/**
	 * 
	 * @param teleportingLocation
	 * 			The id to set.
	 */
	public void setTeleportingLocation(Location teleportingLocation) {
		this.teleportingLocation = teleportingLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getTeleportingLocation() {
		return this.teleportingLocation;
	}

	/**
	 * 
	 * @param isAncients
	 * 			The id to set.
	 */
	public void setAncients(boolean isAncients) {
		this.isAncients = isAncients;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isAncients() {
		return this.isAncients;
	}
}