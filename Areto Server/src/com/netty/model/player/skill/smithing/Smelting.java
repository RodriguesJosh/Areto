package com.netty.model.player.skill.smithing;

import com.netty.model.player.skill.mining.Ore;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:34:57 AM
 */
public enum Smelting {

	/**
	 * 
	 */
	BRONZE,

	/**
	 * 
	 */
	BLURITE,

	/**
	 * 
	 */
	IRON,

	/**
	 * 
	 */
	ELEMENTAL,

	/**
	 * 
	 */
	SILVER,

	/**
	 * 
	 */
	STEEL,

	/**
	 * 
	 */
	GOLD,

	/**
	 * 
	 */
	MITHRIL,

	/**
	 * 
	 */
	ADAMANT,

	/**
	 * 
	 */
	RUNE;

	/**
	 * 
	 */
	private Ore[] firstOres;

	/**
	 * 
	 */
	private Ore[] secondOres;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 * @param firstOres
	 * 			The id to set.
	 */
	public void setFirstOres(Ore[] firstOres) {
		this.firstOres = firstOres;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Ore[] getFirstOres() {
		return this.firstOres;
	}

	/**
	 * 
	 * @param secondOres
	 * 			The id to set.
	 */
	public void setSecondOres(Ore[] secondOres) {
		this.secondOres = secondOres;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Ore[] getSecondOres() {
		return this.secondOres;
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param experience
	 * 			The id to set.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getExperience() {
		return this.experience;
	}
}