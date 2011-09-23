package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:30:22 AM
 */
public enum GoldJewellery {

	/**
	 * 
	 */
	NO_GEM,

	/**
	 * 
	 */
	SAPPHIRE,

	/**
	 * 
	 */
	EMERALD,

	/**
	 * 
	 */
	RUBY,

	/**
	 * 
	 */
	DIAMOND,

	/**
	 * 
	 */
	DRAGONSTONE,

	/**
	 * 
	 */
	ONYX;

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 */
	private int cuttingLevel;

	/**
	 * 
	 */
	private int cuttingExperience;

	/**
	 * 
	 */
	private int ringLevel;

	/**
	 * 
	 */
	private int ringExperience;

	/**
	 * 
	 */
	private int necklaceLevel;

	/**
	 * 
	 */
	private int necklaceExperience;

	/**
	 * 
	 */
	private int braceletLevel;

	/**
	 * 
	 */
	private int braceletExperience;

	/**
	 * 
	 */
	private int amuletLevel;

	/**
	 * 
	 */
	private int amuletExperience;

	/**
	 * 
	 * @param item
	 * 			The id to set.
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * 
	 * @param cuttingLevel
	 * 			The id to set.
	 */
	public void setCuttingLevel(int cuttingLevel) {
		this.cuttingLevel = cuttingLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCuttingLevel() {
		return this.cuttingLevel;
	}

	/**
	 * 
	 * @param cuttingExperience
	 * 			The id to set.
	 */
	public void setCuttingExperience(int cuttingExperience) {
		this.cuttingExperience = cuttingExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCuttingExperience() {
		return this.cuttingExperience;
	}

	/**
	 * 
	 * @param ringLevel
	 * 			The id to set.
	 */
	public void setRingLevel(int ringLevel) {
		this.ringLevel = ringLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getRingLevel() {
		return this.ringLevel;
	}

	/**
	 * 
	 * @param ringExperience
	 * 			The id to set.
	 */
	public void setRingExperience(int ringExperience) {
		this.ringExperience = ringExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getRingExperience() {
		return this.ringExperience;
	}

	/**
	 * 
	 * @param necklaceLevel
	 * 			The id to set.
	 */
	public void setNecklaceLevel(int necklaceLevel) {
		this.necklaceLevel = necklaceLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getNecklaceLevel() {
		return this.necklaceLevel;
	}

	/**
	 * 
	 * @param necklaceExperience
	 * 			The id to set.
	 */
	public void setNecklaceExperience(int necklaceExperience) {
		this.necklaceExperience = necklaceExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getNecklaceExperience() {
		return this.necklaceExperience;
	}

	/**
	 * 
	 * @param braceletLevel
	 * 			The id to set.
	 */
	public void setBraceletLevel(int braceletLevel) {
		this.braceletLevel = braceletLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getBraceletLevel() {
		return this.braceletLevel;
	}

	/**
	 * 
	 * @param braceletExperience
	 * 			The id to set.
	 */
	public void setBraceletExperience(int braceletExperience) {
		this.braceletExperience = braceletExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getBraceletExperience() {
		return this.braceletExperience;
	}

	/**
	 * 
	 * @param amuletLevel
	 * 			The id to set.
	 */
	public void setAmuletLevel(int amuletLevel) {
		this.amuletLevel = amuletLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getAmuletLevel() {
		return this.amuletLevel;
	}

	/**
	 * 
	 * @param amuletExperience
	 * 			The id to set.
	 */
	public void setAmuletExperience(int amuletExperience) {
		this.amuletExperience = amuletExperience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getAmuletExperience() {
		return this.amuletExperience;
	}
}