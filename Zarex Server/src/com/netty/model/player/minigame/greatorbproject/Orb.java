package com.netty.model.player.minigame.greatorbproject;

import com.netty.world.Location;

public class Orb {

	private Team team;
	private Location location;

	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}
}