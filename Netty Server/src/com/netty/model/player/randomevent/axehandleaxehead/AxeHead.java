package com.netty.model.player.randomevent.axehandleaxehead;

import com.netty.model.item.Item;
import com.netty.world.World;

public class AxeHead {

	private Item axeHeadItem;

	public AxeHead() {
		Item axeHeadItem = World.getWorld().getItemList().get(0);
		this.setAxeHeadItem(axeHeadItem);
	}

	public void setAxeHeadItem(Item axeHeadItem) {
		this.axeHeadItem = axeHeadItem;
	}

	public Item getAxeHeadItem() {
		return this.axeHeadItem;
	}
}