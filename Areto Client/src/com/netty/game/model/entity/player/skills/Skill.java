package com.netty.game.model.entity.player.skills;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:55:30 PM
 */
public class Skill {

	/**
	 * 
	 */
	private byte id;

	/**
	 * 
	 */
	private short level;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param level
	 * 			The id to set.
	 * @param experience
	 * 			The id to set.
	 */
	public Skill(byte id, short level, int experience) {
		this.setID(id);
		this.setLevel(level);
		this.setExperience(experience);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(byte id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getID() {
		return this.id;
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(short level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getLevel() {
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