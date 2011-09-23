package com.netty.model.player.skill.woodcutting;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:20:03 AM
 */
public enum Hatchet {

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
	BLACK(1351, 873, 6),

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
	DRAGON(6739, 2846, 61);

	/**
	 * 
	 */
	private int hatchetID;

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
	 * @param hatchetID
	 * 			The id to set.
	 * @param animationID
	 * 			The id to set.
	 * @param level
	 * 			The id to set.
	 */
	private Hatchet(int hatchetID, int animationID, int level) {
		this.setHatchetID(hatchetID);
		this.setAnimationID(animationID);
		this.setLevel(level);
	}

	/**
	 * 
	 * @param hatchetID
	 * 			The id to set.
	 */
	public void setHatchetID(int hatchetID) {
		this.hatchetID = hatchetID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getHatchetID() {
		return this.hatchetID;
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