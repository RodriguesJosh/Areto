package com.netty.model.player.distractionsdiversions.trollinvasion;

import com.netty.model.player.distractionsdiversions.trollinvasion.combat.Combat;
import com.netty.model.player.distractionsdiversions.trollinvasion.skilling.Repair;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 4:47:58 PM
 */
public enum Gameplay {

	/**
	 * 
	 */
	COMBAT(new Combat()),

	/**
	 * 
	 */
	SKILLING(new Repair());

	/**
	 * 
	 */
	private Object gameplay;

	/**
	 * 
	 * 
	 * @param gameplay
	 * 			The gameplay to set.
	 */
	private Gameplay(Object gameplay) {
		this.setGameplay(gameplay);
	}

	/**
	 * 
	 * @param gameplay
	 * 			The gameplay to set.
	 */
	public void setGameplay(Object gameplay) {
		this.gameplay = gameplay;
	}

	/**
	 * 
	 * @return gameplay
	 * 			Returns the gameplay to get.
	 */
	public Object getGameplay() {
		return this.gameplay;
	}
}