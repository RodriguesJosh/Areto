package com.netty.model.player.minigame.greatorbproject;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:53:49 PM
 */
public enum Team {

	/**
	 * 
	 */
	GREEN,

	/**
	 * 
	 */
	YELLOW;

	/**
	 * 
	 */
	private Item runecrafterHat;

	/**
	 * 
	 */
	private Item repellerWand;

	/**
	 * 
	 */
	private Item attractorWand;

	/**
	 * 
	 */
	private Item barrierGenerator;

	/**
	 * 
	 * @param runecrafterHat
	 *			The id to set.
	 */
	public void setRunecrafterHat(Item runecrafterHat) {
		this.runecrafterHat = runecrafterHat;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Item getRunecrafterHat() {
		return this.runecrafterHat;
	}

	/**
	 * 
	 * @param repellerWand
	 *			The id to set.
	 */
	public void setRepellerWand(Item repellerWand) {
		this.repellerWand = repellerWand;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Item getRepellerWand() {
		return this.repellerWand;
	}

	/**
	 * 
	 * @param attractorWand
	 *			The id to set.
	 */
	public void setAttractorWand(Item attractorWand) {
		this.attractorWand = attractorWand;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Item getAttractorWand() {
		return this.attractorWand;
	}

	/**
	 * 
	 * @param barrierGenerator
	 *			The id to set.
	 */
	public void setBarrierGenerator(Item barrierGenerator) {
		this.barrierGenerator = barrierGenerator;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Item getBarrierGenerator() {
		return this.barrierGenerator;
	}
}