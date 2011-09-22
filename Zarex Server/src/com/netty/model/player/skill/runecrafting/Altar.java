package com.netty.model.player.skill.runecrafting;

import com.netty.world.Location;

public enum Altar {

	AIR_ALTAR, MIND, WATER, EARTH, FIRE, BODY, COSMIC, CHAOS, ASTRAL, NATURE, LAW, DEATH, BLOOD, SOUL, OURANIA;

	private Location startLocation;
	private Location endLocation;

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