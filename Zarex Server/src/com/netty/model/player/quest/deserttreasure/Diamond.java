package com.netty.model.player.quest.deserttreasure;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:31:32 PM
 */
public class Diamond {

	/**
	 * 
	 */
	private Boss boss;

	/**
	 * 
	 */
	private Item diamondItem;

	/**
	 * 
	 * @param boss
	 * 			The id to set.
	 */
	public Diamond(Boss boss) {
		this.setBoss(boss);
	}

	/**
	 * 
	 * @param boss
	 * 			The id to set.
	 */
	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Boss getBoss() {
		return this.boss;
	}

	/**
	 * 
	 * @param diamondItem
	 * 			The id to set.
	 */
	public void setDiamondItem(Item diamondItem) {
		this.diamondItem = diamondItem;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getDiamondItem() {
		return this.diamondItem;
	}
}