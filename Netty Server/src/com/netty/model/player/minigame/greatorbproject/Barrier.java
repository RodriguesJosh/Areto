package com.netty.model.player.minigame.greatorbproject;

import com.netty.world.Location;

public class Barrier {

	private Team team;
	private Location location;

	public Barrier(Team team, Location location) {
		this.setTeam(team);
		this.setLocation(location);
	}

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