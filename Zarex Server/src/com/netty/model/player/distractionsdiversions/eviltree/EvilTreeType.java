/**
 * 
 */
package com.netty.model.player.distractionsdiversions.eviltree;


/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 8:51:56 PM
 */
public enum EvilTreeType {

	/**
	 * 
	 */
	NORMAL_EVIL_TREE,

	/**
	 * 
	 */
	EVIL_OAK_TREE,

	/**
	 * 
	 */
	WILLOW_EVIL_TREE,

	/**
	 * 
	 */
	MAPLE_EVIL_TREE,

	/**
	 * 
	 */
	YEW_EVIL_TREE,

	/**
	 * 
	 */
	MAGIC_EVIL_TREE,

	/**
	 * 
	 */
	ELDER_EVIL_TREE;

	/**
	 * 
	 */
	private byte woodcuttingLevel;

	/**
	 * 
	 */
	private byte farmingLevel;

	/**
	 * 
	 */
	private short farmingExperience;

	/**
	 * 
	 */
	private byte firemakingLevel;

	/**
	 * 
	 */
	private Hint hint;

	/**
	 * 
	 * @param woodcuttingLevel
	 * 			The woodcuttingLevel to set.
	 */
	public void setWoodcuttingLevel(byte woodcuttingLevel) {
		this.woodcuttingLevel = woodcuttingLevel;
	}

	/**
	 * 
	 * @return woodcuttingLevel
	 * 			Returns the woodcuttingLevel to get.
	 */
	public byte getWoodcuttingLevel() {
		return this.woodcuttingLevel;
	}

	/**
	 * 
	 * @param farmingLevel
	 * 			The farmingLevel to set.
	 */
	public void setFarmingLevel(byte farmingLevel) {
		this.farmingLevel = farmingLevel;
	}

	/**
	 * 
	 * @return farmingLevel
	 * 			Returns the farmingLevel to get.
	 */
	public byte getFarmingLevel() {
		return this.farmingLevel;
	}

	/**
	 * 
	 * @param farmingExperience
	 * 			The farmingExperience to set.
	 */
	public void setFarmingExperience(short farmingExperience) {
		this.farmingExperience = farmingExperience;
	}

	/**
	 * 
	 * @return farmingExperience
	 * 			Returns the farmingExperience to get.
	 */
	public short getFarmingExperience() {
		return this.farmingExperience;
	}

	/**
	 * 
	 * @param firemakingLevel
	 * 			The firemakingLevel to set.
	 */
	public void setFiremakingLevel(byte firemakingLevel) {
		this.firemakingLevel = firemakingLevel;
	}

	/**
	 * 
	 * @return firemakingLevel
	 * 			Returns the firemakingLevel to get.
	 */
	public byte getFiremakingLevel() {
		return this.firemakingLevel;
	}

	/**
	 * 
	 * @param hint
	 * 			The hint to set.
	 */
	public void setHint(Hint hint) {
		this.hint = hint;
	}

	/**
	 * 
	 * @return hint
	 * 			Returns the hint to get.
	 */
	public Hint getHint() {
		return this.hint;
	}
}