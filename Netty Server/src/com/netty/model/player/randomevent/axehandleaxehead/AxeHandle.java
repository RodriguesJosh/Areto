package com.netty.model.player.randomevent.axehandleaxehead;

import com.netty.model.item.Item;
import com.netty.world.World;

public class AxeHandle {

	private Item axeHandleItem;

	public AxeHandle() {
		Item axeHandleItem = World.getWorld().getItemList().get(0);
		this.setAxeHandleItem(axeHandleItem);
	}

	public void setAxeHandleItem(Item axeHandleItem) {
		this.axeHandleItem = axeHandleItem;
	}

	public Item getAxeHandleItem() {
		return this.axeHandleItem;
	}
}