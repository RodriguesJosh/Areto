package com.netty.model.player.skill.cooking;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:42:58 PM
 */
public enum Fish {

	/**
	 * 
	 */
	SHRIMP(0, 0, null, null, null);

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
	private Item raw;

	/**
	 * 
	 */
	private Item cooked;

	/**
	 * 
	 */
	private Item burnt;

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 * @param experience
	 * 			The id to set.
	 * @param raw
	 * 			The id to set.
	 * @param cooked
	 * 			The id to set.
	 * @param burnt
	 * 			The id to set.
	 */
	private Fish(int level, int experience, Item raw, Item cooked, Item burnt) {
		this.setLevel(level);
		this.setExperience(experience);
		this.setRaw(raw);
		this.setCooked(cooked);
		this.setBurnt(burnt);
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
	 * @param raw
	 * 			The id to set.
	 */
	public void setRaw(Item raw) {
		this.raw = raw;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getRaw() {
		return this.raw;
	}

	/**
	 * 
	 * @param cooked
	 * 			The id to set.
	 */
	public void setCooked(Item cooked) {
		this.cooked = cooked;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getCooked() {
		return this.cooked;
	}

	/**
	 * 
	 * @param burnt
	 * 			The id to set.
	 */
	public void setBurnt(Item burnt) {
		this.burnt = burnt;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getBurnt() {
		return this.burnt;
	}
}