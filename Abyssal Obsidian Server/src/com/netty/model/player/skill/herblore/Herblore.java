package com.netty.model.player.skill.herblore;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:57:55 AM
 */
public class Herblore {

	/**
	 * 
	 */
	private BarbarianPotion barbarianPotion;

	/**
	 * 
	 */
	private Potion potion;

	/**
	 * 
	 * @param barbarianPotion
	 * 			The id to set.
	 */
	public void setBarbarianPotion(BarbarianPotion barbarianPotion) {
		this.barbarianPotion = barbarianPotion;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BarbarianPotion getBarbarianPotion() {
		return this.barbarianPotion;
	}

	/**
	 * 
	 * @param potion
	 * 			The id to set.
	 */
	public void setPotion(Potion potion) {
		this.potion = potion;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Potion getPotion() {
		return this.potion;
	}
}