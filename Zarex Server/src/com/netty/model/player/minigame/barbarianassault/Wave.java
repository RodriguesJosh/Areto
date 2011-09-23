package com.netty.model.player.minigame.barbarianassault;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:02:18 PM
 */
public class Wave {

	/**
	 * 
	 */
	private PenanceCreature[] penanceCreature;

	/**
	 * 
	 * @param penanceCreature
	 * 			The id to set.
	 */
	public void setPenanceCreature(PenanceCreature[] penanceCreature) {
		this.penanceCreature = penanceCreature;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PenanceCreature[] getPenanceCreature() {
		return this.penanceCreature;
	}
}