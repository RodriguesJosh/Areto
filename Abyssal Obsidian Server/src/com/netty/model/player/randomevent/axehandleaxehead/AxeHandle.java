package com.netty.model.player.randomevent.axehandleaxehead;

import com.netty.model.item.Item;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:47:28 PM
 */
public class AxeHandle {

	/**
	 * 
	 */
	private Item axeHandleItem;

	/**
	 * 
	 */
	public AxeHandle() {
		Item axeHandleItem = World.getWorld().getItemList().get(0);
		this.setAxeHandleItem(axeHandleItem);
	}

	/**
	 * 
	 * @param axeHandleItem
	 * 			The id to set.
	 */
	public void setAxeHandleItem(Item axeHandleItem) {
		this.axeHandleItem = axeHandleItem;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getAxeHandleItem() {
		return this.axeHandleItem;
	}
}