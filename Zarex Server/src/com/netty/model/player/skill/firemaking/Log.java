package com.netty.model.player.skill.firemaking;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:36:21 AM
 */
public enum Log {

	/**
	 * 
	 */
	NORMAL(1511, 1, 40),

	/**
	 * 
	 */
	ACHEY(2862, 1, 40),

	/**
	 * 
	 */
	OAK(1521, 15, 60),

	/**
	 * 
	 */
	WILLOW(1519, 30, 90),

	/**
	 * 
	 */
	TEAK(6333, 35, 105),

	/**
	 * 
	 */
	ARCTIC_PINE(0, 42, 125),

	/**
	 * 
	 */
	MAPLE(1516, 45, 135),

	/**
	 * 
	 */
	MAHOGANY(6332, 50, 157),

	/**
	 * 
	 */
	EUCALYPTUS(0, 58, 193),

	/**
	 * 
	 */
	YEW(1515, 60, 202),

	/**
	 * 
	 */
	MAGIC(1513, 75, 303),

	/**
	 * 
	 */
	CURSED_MAGIC(0, 82, 303);

	/**
	 * 
	 */
	private int logID;

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
	 * @param logID
	 * 			The id to set.
	 * @param level
	 * 			The id to set.
	 * @param experience
	 * 			The id to set.
	 */
	private Log(int logID, int level, int experience) {
		this.setLogID(logID);
		this.setLevel(level);
		this.setExperience(experience);
	}

	/**
	 * 
	 * @param logID
	 * 			The id to set.
	 */
	public void setLogID(int logID) {
		this.logID = logID;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLogID() {
		return this.logID;
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