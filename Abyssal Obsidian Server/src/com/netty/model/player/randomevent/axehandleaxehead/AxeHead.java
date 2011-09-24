package com.netty.model.player.randomevent.axehandleaxehead;

import com.netty.model.item.Item;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:46:55 PM
 */
public class AxeHead {

	/**
	 * 
	 */
	private Item axeHeadItem;

	/**
	 * 
	 */
	public AxeHead() {
		Item axeHeadItem = World.getWorld().getItemList().get(0);
		this.setAxeHeadItem(axeHeadItem);
	}

	/**
	 * 
	 * @param axeHeadItem
	 * 			The id to set.
	 */
	public void setAxeHeadItem(Item axeHeadItem) {
		this.axeHeadItem = axeHeadItem;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getAxeHeadItem() {
		return this.axeHeadItem;
	}
}