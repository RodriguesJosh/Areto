package com.netty.model.player.minigame.greatorbproject;

import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:55:18 PM
 */
public class Barrier {

	/**
	 * 
	 */
	private Team team;

	/**
	 * 
	 */
	private Location location;

	/**
	 * 
	 * @param team
	 *			The id to set.
	 * @param location
	 *			The id to set.
	 */
	public Barrier(Team team, Location location) {
		this.setTeam(team);
		this.setLocation(location);
	}

	/**
	 * 
	 * @param team
	 *			The id to set.
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Team getTeam() {
		return this.team;
	}

	/**
	 * 
	 * @param location
	 *			The id to set.
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Location getLocation() {
		return this.location;
	}
}