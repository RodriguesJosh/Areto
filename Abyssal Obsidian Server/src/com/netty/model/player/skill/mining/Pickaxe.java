package com.netty.model.player.skill.mining;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:56:16 AM
 */
public enum Pickaxe {

	/**
	 * 
	 */
	BRONZE(1349, 879, 1),

	/**
	 * 
	 */
	IRON(1351, 877, 1),

	/**
	 * 
	 */
	STEEL(1353, 875, 6),

	/**
	 * 
	 */
	MITHRIL(1355, 871, 21),

	/**
	 * 
	 */
	ADAMANT(1357, 869, 31),

	/**
	 * 
	 */
	RUNE(1359, 867, 41),

	/**
	 * 
	 */
	DRAGON(6739, 2846, 61),

	/**
	 * 
	 */
	SACRED_CLAY(0, 0, 40),

	/**
	 * 
	 */
	INFERNO_ADZE(0, 0, 41);

	/**
	 * 
	 */
	private int pickaxeID;

	/**
	 * 
	 */
	private int animationID;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 * @param pickaxeID
	 * 			The id to set.
	 * @param animationID
	 * 			The id to set.
	 * @param level
	 * 			The id to set.
	 */
	private Pickaxe(int pickaxeID, int animationID, int level) {
		this.setPickaxeID(pickaxeID);
		this.setAnimationID(animationID);
		this.setLevel(level);
	}

	/**
	 * 
	 * @param pickaxeID
	 * 			The id to set.
	 */
	public void setPickaxeID(int pickaxeID) {
		this.pickaxeID = pickaxeID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getPickaxeID() {
		return this.pickaxeID;
	}

	/**
	 * 
	 * @param animationID
	 * 			The id to set.
	 */
	public void setAnimationID(int animationID) {
		this.animationID = animationID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getAnimationID() {
		return this.animationID;
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
}