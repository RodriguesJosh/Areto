package com.netty.model.player.container;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:32:02 AM
 */
public class Container {

	/**
	 * 
	 */
	private int capacity;

	/**
	 * 
	 */
	private Item[] items;

	/**
	 * 
	 */
	private List<Item> itemList;

	/**
	 * 
	 */
	private ContainerType containerType;

	/**
	 * 
	 * @param capacity
	 * 			The id to set.
	 * @param containerType
	 * 			The id to set.
	 */
	public Container(int capacity, ContainerType containerType) {
		this.setCapacity(capacity);
		this.setContainerType(containerType);
		this.setItems(new Item[capacity]);
	}

	/**
	 * 
	 * @param registeredItem
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean registerItem(Item registeredItem) {
		if ((this.getContainerType() == ContainerType.STACKABLE) || (this.getContainerType() == ContainerType.NOTEABLE)) {
			for (Item item : this.getItemList()) {
				if ((item != null) && (item.getID() == registeredItem.getID())) {
					int totalAmount = item.getAmount() + registeredItem.getAmount();
					if ((totalAmount > Integer.MAX_VALUE) || (totalAmount < 1)) {
						return false;
					}
					item = new Item(item.getID(), totalAmount);
					return true;
				}
			}
		} else {
			if (registeredItem.getAmount() > 1) {
				if (this.getFreeSlots() >= registeredItem.getAmount()) {
					for (int i = 0; i < registeredItem.getAmount(); i++) {
						int index = this.getFreeSlot();
						this.getItems()[index] = new Item(registeredItem.getID(), 1);
					}
					return true;
				}
				return false;
			}
		}
		int index = this.getFreeSlot();
		if (index == -1) {
			return false;
		}
		this.getItems()[index] = registeredItem;
		return true;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getFreeSlots() {
		return this.getCapacity() - this.getItemList().size();
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getFreeSlot() {
		for (int i = 0; i < this.getItems().length; i++) {
			if (this.getItems()[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param givenSlot
	 * 			The id to set.
	 * @param unregisteredItem
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public int unregisterItem(int givenSlot, Item unregisteredItem) {
		int removed = 0;
		if (this.getContainerType() == ContainerType.STACKABLE) {
			int slot = this.getSlotByID(unregisteredItem);
			Item stack = this.getItem(slot);
			if (stack.getAmount() > unregisteredItem.getAmount()) {
				removed = unregisteredItem.getAmount();
				this.getItems()[slot] = new Item(stack.getID(), stack.getAmount() - unregisteredItem.getAmount());
			} else {
				removed = stack.getAmount();
				this.getItems()[slot] = null;
			}
		} else {
			for (int i = 0; i < unregisteredItem.getAmount(); i++) {
				int slot = this.getSlotByID(unregisteredItem);
				if ((i == 0) && (givenSlot != -1)) {
					Item inSlot = this.getItem(givenSlot);
					if (inSlot.getID() == unregisteredItem.getID()) {
						slot = givenSlot;
					}
				}
				if (slot != -1) {
					removed++;
					this.getItems()[slot] = null;
				} else {
					break;
				}
			}
		}
		return removed;
	}

	/**
	 * 
	 * @param item
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean containsItem(Item item) {
		return this.getSlotByID(item) != -1;
	}

	/**
	 * 
	 * @param amountForItem
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public int getItemAmount(Item amountForItem) {
		for (Item item : this.getItemList()) {
			if (item != null) {
				if (item.getID() == amountForItem.getID()) {
					return item.getAmount();
				}
			}
		}
		return -1;
	}

	/**
	 * 
	 */
	public void shiftItems() {
		List<Item> oldItemList = this.getItemList();
		this.setItemList(new ArrayList<Item>(oldItemList.size()));
		int newIndex = 0;
		for (Item item : this.getItemList()) {
			if (item != null) {
				// @SuppressWarnings("unused")
				// Item oldItem = this.getItemList().get(newIndex);
				// oldItem = item;
				newIndex++;
			}
		}
	}

	/**
	 * 
	 * @param slot
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public Item getItem(int slot) {
		if ((slot < 0) || (slot >= this.getItemList().size())) {
			return null;
		}
		Item item = this.getItemList().get(slot);
		return item;
	}

	/**
	 * 
	 * @param slotForItem
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public int getSlotByID(Item slotForItem) {
		for (Item item : this.getItemList()) {
			if (item == null) {
				continue;
			}
			if (item.getID() == slotForItem.getID()) {
				return this.getItemList().indexOf(item);
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param amountForItem
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public int getAmount(Item amountForItem) {
		int total = 0;
		for (Item item : this.getItemList()) {
			if (item != null) {
				if (item == amountForItem) {
					total += item.getAmount();
				}
			}
		}
		return total;
	}

	/**
	 * 
	 * @param capacity
	 * 			The id to set.
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * 
	 * @param items
	 * 			The id to set.
	 */
	public void setItems(Item[] items) {
		this.items = items;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item[] getItems() {
		return this.items;
	}

	/**
	 * 
	 * @param itemList
	 * 			The id to set.
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Item> getItemList() {
		return this.itemList;
	}

	/**
	 * 
	 * @param containerType
	 * 			The id to set.
	 */
	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ContainerType getContainerType() {
		return this.containerType;
	}
}