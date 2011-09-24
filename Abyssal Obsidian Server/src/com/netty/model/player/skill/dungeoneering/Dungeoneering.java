package com.netty.model.player.skill.dungeoneering;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:04:29 AM
 */
public class Dungeoneering {

	/**
	 * 
	 */
	private Floor[] floors;

	/**
	 * 
	 */
	public Dungeoneering() {
		this.setFloors(new Floor[61]);
	}

	/**
	 * 
	 * @param floors
	 * 			The id to set.
	 */
	public void setFloors(Floor[] floors) {
		this.floors = floors;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Floor[] getFloors() {
		return this.floors;
	}
}