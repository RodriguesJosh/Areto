package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.agility;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 2:23:59 PM
 */
public enum JugglingEquipment {

	/**
	 * 
	 */
	BALLS,

	/**
	 * 
	 */
	PLATES,

	/**
	 * 
	 */
	EGGS,

	/**
	 * 
	 */
	KNIVES,

	/**
	 * 
	 */
	SPADES,

	/**
	 * 
	 */
	TUNA,

	/**
	 * 
	 */
	SOAP,

	/**
	 * 
	 */
	CANNON_BALLS,

	/**
	 * 
	 */
	TORCHES,

	/**
	 * 
	 */
	CHINCHOMPAS;

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