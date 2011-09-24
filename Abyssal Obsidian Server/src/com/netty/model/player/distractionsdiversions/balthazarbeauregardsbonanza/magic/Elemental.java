package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.magic;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 12:51:33 PM
 */
public enum Elemental {

	/**
	 * 
	 */
	ITEM,

	/**
	 * 
	 */
	BOOK,

	/**
	 * 
	 */
	TREE_STUMP,

	/**
	 * 
	 */
	HELM,

	/**
	 * 
	 */
	SHIELD,

	/**
	 * 
	 */
	ARMOUR;

	/**
	 * 
	 */
	private byte level;

	/**
	 * 
	 */
	private short experience;

	/**
	 * 
	 * @param level
	 * 			The level to set.
	 */
	public void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * 
	 * @return level
	 * 			Returns the level to get.
	 */
	public byte getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param experience
	 * 			The experience to set.
	 */
	public void setExperience(short experience) {
		this.experience = experience;
	}

	/**
	 * 
	 * @return experience
	 * 			Returns the experience to get.
	 */
	public short getExperience() {
		return this.experience;
	}
}