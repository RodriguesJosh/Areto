package com.netty.model.player.tab;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.container.Container;
import com.netty.model.player.container.ContainerType;

public class Inventory {

	private Container inventoryContainer;
	private Player player;

	public Inventory(Player player) {
		this.setInventoryContainer(new Container(TabConstants.MAX_INVENTORY_SLOTS, ContainerType.STANDARD));
		this.setPlayer(player);
	}

	public boolean registerItem(Item item) {
		if ((item.getAmount() < 0) || (item.getAmount() >= 13404)) {
			return false;
		}
		if (!this.getInventoryContainer().registerItem(item)) {
			this.getPlayer().getPacketSender().getMessage("Not enough space in your inventory.");
			return false;
		}
		this.refresh();
		return true;
	}

	public void refresh() {
		// this.getPlayer().getPacketSender().sendItems(149, 0, 93, this.inventoryContainer);
	}

	public boolean hasRoomFor(Item item) {
		Container inventoryContainer = this.getInventoryContainer();
		boolean isStackable = inventoryContainer.getContainerType() == ContainerType.STACKABLE;
		boolean isNoteable = inventoryContainer.getContainerType() == ContainerType.NOTEABLE;
		if (isStackable || isNoteable) {
			return inventoryContainer.getFreeSlots() >= 1;
		}
		return inventoryContainer.getFreeSlots() >= item.getAmount();
	}

	public void setInventoryContainer(Container inventoryContainer) {
		this.inventoryContainer = inventoryContainer;
	}

	public Container getInventoryContainer() {
		return this.inventoryContainer;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}