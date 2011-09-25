package com.netty.model.player.distractionsdiversions.phoenixlairs;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 6:26:08 PM
 */
public class PhoenixLair {

	/**
	 * 
	 */
	private Phoenix phoenix;

	/**
	 * 
	 */
	private Monsters[] monsters;

	/**
	 * 
	 * @param phoenix
	 * 			The phoenix to set.
	 */
	public void setPhoenix(Phoenix phoenix) {
		this.phoenix = phoenix;
	}

	/**
	 * 
	 * @return phoenix
	 * 			Returns the phoenix to get.
	 */
	public Phoenix getPhoenix() {
		return this.phoenix;
	}

	/**
	 * 
	 * @param monsters
	 * 			The monsters to set.
	 */
	public void setMonsters(Monsters... monsters) {
		this.monsters = monsters;
	}

	/**
	 * 
	 * @return monsters
	 * 			Returns the monsters to get.
	 */
	public Monsters[] getMonsters() {
		return this.monsters;
	}
}