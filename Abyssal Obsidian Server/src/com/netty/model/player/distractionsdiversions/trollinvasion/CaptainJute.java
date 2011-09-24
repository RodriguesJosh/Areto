package com.netty.model.player.distractionsdiversions.trollinvasion;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 4:41:52 PM
 */
public class CaptainJute {

	/**
	 * 
	 */
	private Item rewardBook;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 * @param rewardBook
	 * 			The rewardBook to set.
	 */
	public void setRewardBook(Item rewardBook) {
		this.rewardBook = rewardBook;
	}

	/**
	 * 
	 * @return rewardBook
	 * 			Returns the rewardBook to get.
	 */
	public Item getRewardBook() {
		return this.rewardBook;
	}

	/**
	 * 
	 * @param experience
	 * 			The experience to set.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * 
	 * @return experience
	 * 			Returns the experience to get.
	 */
	public int getExperience() {
		return this.experience;
	}
}