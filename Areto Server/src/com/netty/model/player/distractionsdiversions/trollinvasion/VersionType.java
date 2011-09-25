package com.netty.model.player.distractionsdiversions.trollinvasion;

import com.netty.model.player.distractionsdiversions.trollinvasion.combat.Wave;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 4:46:13 PM
 */
public enum VersionType {

	/**
	 * 
	 */
	NORMAL(new Wave[20]),

	/**
	 * 
	 */
	HARD(new Wave[7]);

	/**
	 * 
	 */
	private Wave[] waves;

	/**
	 * 
	 * 
	 * @param waves
	 * 			The waves to set.
	 */
	private VersionType(Wave[] waves) {
		this.setWaves(waves);
	}

	/**
	 * 
	 * @param waves
	 * 			The waves to set.
	 */
	public void setWaves(Wave[] waves) {
		this.waves = waves;
	}

	/**
	 * 
	 * @return waves
	 * 			Returns the waves to get.
	 */
	public Wave[] getWaves() {
		return this.waves;
	}
}