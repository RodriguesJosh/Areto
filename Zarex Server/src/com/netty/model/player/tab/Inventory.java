package com.netty.model.player.tab;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.container.Container;
import com.netty.model.player.container.ContainerType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:02:44 AM
 */
public class Inventory {

	/**
	 * 
	 */
	private Container inventoryContainer;
	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Inventory(Player player) {
		this.setInventoryContainer(new Container(TabConstants.MAX_INVENTORY_SLOTS, ContainerType.STANDARD));
		this.setPlayer(player);
	}

	/**
	 * 
	 * @param item
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean registerItem(Item item) {
		if (item.getAmount() >= 13404) {
			this.getPlayer().getPacketSender().getMessage("Amount is too high.");
			return false;
		}
		if (item.getAmount() < 0) {
			this.getPlayer().getPacketSender().getMessage("Amount is too low.");
			return false;
		}
		if (!this.getInventoryContainer().registerItem(item)) {
			this.getPlayer().getPacketSender().getMessage("Not enough space in your inventory.");
			return false;
		}
		this.refresh();
		return true;
	}

	/**
	 * 
	 */
	public void refresh() {
		// this.getPlayer().getPacketSender().sendItems(149, 0, 93, this.inventoryContainer);
	}

	/**
	 * 
	 * @param item
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean hasRoomFor(Item item) {
		Container inventoryContainer = this.getInventoryContainer();
		boolean isStackable = inventoryContainer.getContainerType() == ContainerType.STACKABLE;
		boolean isNoteable = inventoryContainer.getContainerType() == ContainerType.NOTEABLE;
		if (isStackable || isNoteable) {
			return inventoryContainer.getFreeSlots() >= 1;
		}
		return inventoryContainer.getFreeSlots() >= item.getAmount();
	}

	/**
	 * 
	 * @param inventoryContainer
	 * 			The id to set.
	 */
	public void setInventoryContainer(Container inventoryContainer) {
		this.inventoryContainer = inventoryContainer;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Container getInventoryContainer() {
		return this.inventoryContainer;
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
}