package com.netty.model.player.minigame.barrows;

import com.netty.world.Location;

public enum BrothersLocation {

	VERAC(new Location((short) 3554, (short) 3294, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1)), AHRIM(new Location((short) 3561, (short) 3286, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1)),
	TORAG(new Location((short) 3570, (short) 3293, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1)), KARIL(new Location((short) 3570, (short) 3293, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1)),
	GUTHAN(new Location((short) 3570, (short) 3293, (byte) 1), new Location((short) 3576, (short) 3299, (byte) 1));

	private Location startLocation;
	private Location endLocation;

	private BrothersLocation(Location startLocation, Location endLocation) {
		this.setStartLocation(startLocation);
		this.setEndLocation(endLocation);
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
}