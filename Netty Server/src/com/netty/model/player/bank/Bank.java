package com.netty.model.player.bank;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.container.Container;
import com.netty.model.player.container.ContainerType;

public class Bank {

	private Container bankContainer;
	private Player player;

	public Bank(Player player) {
		if (player == null) {
			return;
		}
		boolean isMember = player.getMembership() != null;
		int maxBankItems = (isMember ? BankConstants.MEMBERS_MAX_BANK_ITEMS : BankConstants.NORMAL_MEMBERS_MAX_BANK_ITEMS);
		this.setBankContainer(new Container(maxBankItems, ContainerType.STANDARD));
		this.setPlayer(player);
	}

	public void openBank() {
		this.getBankContainer().shiftItems();
	}

	public int unregisterItem(int slot, Item item) {
		return this.getBankContainer().unregisterItem(slot, item);
		// this.refresh();
	}

	public void refresh() {
		// this.getPlayer().getPacketSender().sendItems(149, 0, 93, this.inventoryContainer);
	}

	public boolean hasRoomFor(Item item) {
		/** if (ItemDefinition.forId(id).isStackable()) {
			return this.getFreeSlots() >= 1;
		} */
		return this.getBankContainer().getFreeSlots() >= item.getAmount();
	}

	public void withdrawItem(Player player, int slot, int id, int amount) {
		Item item = this.getBankContainer().getItem(slot);
		if (item == null) {
			return;
		}
		if (item.getID() != id) {
			return;
		}
		int transferAmount = item.getAmount();
		if (transferAmount >= amount) {
			transferAmount = amount;
		} else if (transferAmount == 0) {
			return;
		}
		int newID = item.getID();
		if (this.getBankContainer().getContainerType() == ContainerType.STACKABLE) {
			if((player.getInventory().getInventoryContainer().getFreeSlots() <= 0) && (player.getInventory().getInventoryContainer().getSlotByID(item) == -1)) {
				player.getPacketSender().getMessage("You don't have enough inventory space to withdraw that many.");
			}
		} else {
			int free = player.getInventory().getInventoryContainer().getFreeSlots();
			if(transferAmount > free) {
				player.getPacketSender().getMessage("You don't have enough inventory space to withdraw that many.");
				transferAmount = free;
			}
		}
		if (player.getInventory().registerItem(new Item(newID, transferAmount))) {
			int newAmount = item.getAmount() - transferAmount;
			if (newAmount <= 0) {
				this.getBankContainer().getItems()[slot] = null;
			} else {
				this.getBankContainer().getItems()[slot] = new Item(item.getID(), newAmount);
			}
		} else {
			player.getPacketSender().getMessage("You don't have enough inventory space to withdraw that many.");
		}
	}

	public void depositItem(Player player, int slot, Item mainItem) {
		Item item = this.getBankContainer().getItem(slot);
		if (item == null) {
			return;
		}
		if (item != mainItem) {
			return;
		}
		int transferAmount = this.getBankContainer().getAmount(mainItem);
		if (transferAmount >= mainItem.getAmount()) {
			transferAmount = mainItem.getAmount();
		} else if (transferAmount == 0) {
			return;
		}
		if (this.getBankContainer().getContainerType() == ContainerType.NOTEABLE) {
			if ((this.getBankContainer().getFreeSlots() < 1) && (this.getBankContainer().getSlotByID(item) == -1)) {
				player.getPacketSender().getMessage("You don't have enough space in your bank account.");
			}
			int newInventoryAmount = item.getAmount() - transferAmount;
			Item newItem;
			if (newInventoryAmount <= 0) {
				newItem = null;
			} else {
				newItem = new Item(item.getID(), newInventoryAmount);
			}
			if (!this.getBankContainer().registerItem(new Item(item.getID(), transferAmount))) {
				player.getPacketSender().getMessage("You don't have enough space in your bank account.");
			} else {
				player.getInventory().getInventoryContainer().getItems()[slot] = newItem;
			}
		} else {
			if (player.getBank().getBankContainer().getFreeSlots() < transferAmount) {
				player.getPacketSender().getMessage("You don't have enough space in your bank account.");
			}
			if (!this.getBankContainer().registerItem(new Item(item.getID(), transferAmount))) {
				player.getPacketSender().getMessage("You don't have enough space in your bank account.");
			} else {
				for (int i = 0; i < transferAmount; i++) {
					player.getInventory().getInventoryContainer().getItems()[player.getInventory().getInventoryContainer().getSlotByID(item)] = null;
				}
			}
		}
	}

	public void setBankContainer(Container bankContainer) {
		this.bankContainer = bankContainer;
	}

	public Container getBankContainer() {
		return this.bankContainer;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}