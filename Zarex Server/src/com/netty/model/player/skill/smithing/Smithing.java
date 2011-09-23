package com.netty.model.player.skill.smithing;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:35:34 AM
 */
public class Smithing {

	/**
	 * 
	 */
	private Smelting smelting;

	/**
	 * 
	 */
	private Forging forging;

	/**
	 * 
	 * @param smelting
	 * 			The id to set.
	 * @param forging
	 * 			The id to set.
	 */
	public Smithing(Smelting smelting, Forging forging) {
		this.setSmelting(smelting);
		this.setForging(forging);
	}

	/**
	 * 
	 * @param smelting
	 * 			The id to set.
	 */
	public void setSmelting(Smelting smelting) {
		this.smelting = smelting;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Smelting getSmelting() {
		return this.smelting;
	}

	/**
	 * 
	 * @param forging
	 * 			The id to set.
	 */
	public void setForging(Forging forging) {
		this.forging = forging;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Forging getForging() {
		return this.forging;
	}
}