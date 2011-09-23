package com.netty.model.player.skill.summoning;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:27:38 AM
 */
public enum Pouch {

	/**
	 * 
	 */
	SPIRIT_WOLF,

	/**
	 * 
	 */
	DREADFOWL,

	/**
	 * 
	 */
	SPIRIT_SPIDER,

	/**
	 * 
	 */
	THORNY_SNAIL,

	/**
	 * 
	 */
	GRANITE_CRAB,

	/**
	 * 
	 */
	MOSQUITO,

	/**
	 * 
	 */
	DESERT_WYRM;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private Charm charm;

	/**
	 * 
	 */
	private int shardAmount;

	/**
	 * 
	 */
	private Item secondIngredient;

	/**
	 * 
	 */
	private int experience;


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
	 * @param charm
	 * 			The id to set.
	 */
	public void setCharm(Charm charm) {
		this.charm = charm;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Charm getCharm() {
		return this.charm;
	}

	/**
	 * 
	 * @param shardAmount
	 * 			The id to set.
	 */
	public void setShardAmount(int shardAmount) {
		this.shardAmount = shardAmount;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getShardAmount() {
		return this.shardAmount;
	}

	/**
	 * 
	 * @param secondIngredient
	 * 			The id to set.
	 */
	public void setSecondIngredient(Item secondIngredient) {
		this.secondIngredient = secondIngredient;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getSecondIngredient() {
		return this.secondIngredient;
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