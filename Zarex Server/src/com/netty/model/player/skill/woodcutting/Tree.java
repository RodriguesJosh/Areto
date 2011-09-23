package com.netty.model.player.skill.woodcutting;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:19:23 AM
 */
public enum Tree {

	/**
	 * 
	 */
	NORMAL(1511, 1, 25, 45),

	/**
	 * 
	 */
	OAK(1521, 15, 38, 15),

	/**
	 * 
	 */
	WILLOW(1519, 30, 68, 15),

	/**
	 * 
	 */
	MAPLE(1517, 45, 100, 60),

	/**
	 * 
	 */
	YEW(1515, 60, 175, 100),

	/**
	 * 
	 */
	MAGIC(1513, 75, 250, 190);

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
	 */
	private int respawnTime;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 * @param logID
	 * 			The id to set.
	 * @param level
	 * 			The id to set.
	 * @param experience
	 * 			The id to set.
	 * @param respawnTime
	 * 			The id to set.
	 */
	private Tree(int logID, int level, int experience, int respawnTime) {
		this.setLogID(logID);
		this.setLevel(level);
		this.setExperience(experience);
		this.setRespawnTime(respawnTime);
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

	/**
	 * 
	 * @param respawnTime
	 * 			The id to set.
	 */
	public void setRespawnTime(int respawnTime) {
		this.respawnTime = respawnTime;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getRespawnTime() {
		return this.respawnTime;
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getName() {
		return this.name;
	}
}