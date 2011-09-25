package com.netty.model.player.skill;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:57:14 PM
 */
public class Skill {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private byte id;

	/**
	 * 
	 */
	private byte level;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param id
	 * 			The id to set.
	 */
	public Skill(Player player, byte id) {
		this.setPlayer(player);
		this.setID(id);
		if (this.getID() == 3) {
			this.setLevel((byte) 10);
			this.setExperience(1184);
		} else {
			this.setLevel((byte) 1);
			this.setExperience(83);
		}
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
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
	public void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getLevel() {
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
	 * @param level
	 * 			The id to set.
	 */
	public void addLevel(int level) {
		byte addedLevel = this.getLevel();
		addedLevel += level;
		this.setLevel(addedLevel);
		// this.getPlayer().getPacketSender().getSkills(this.getID());
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void removeLevel(int level) {
		byte removedLevel = this.getLevel();
		removedLevel -= level;
		this.setLevel(removedLevel);
		// this.getPlayer().getPacketSender().getSkills(this.getID());
	}

	/**
	 * 
	 * @param experience
	 * 			The id to set.
	 */
	public void addExperience(int experience) {
		int addedExperience = this.getExperience();
		addedExperience += experience;
		this.setExperience(addedExperience);
		// this.getPlayer().getPacketSender().getSkills(this.getID());
	}

	/**
	 * 
	 * @param experience
	 * 			The id to set.
	 */
	public void removeExperience(int experience) {
		int removedExperience = this.getExperience();
		removedExperience -= experience;
		this.setExperience(removedExperience);
		// this.getPlayer().getPacketSender().getSkills(this.getID());
	}
}