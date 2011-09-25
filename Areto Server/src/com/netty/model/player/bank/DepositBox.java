package com.netty.model.player.bank;

import java.util.List;

import com.netty.model.item.Item;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:24:36 AM
 */
public class DepositBox {

	/**
	 * 
	 */
	private List<Item> itemList;

	/**
	 * 
	 * @param itemList
	 * 			The itemList to set.
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 
	 * @return itemList
	 * 			Returns the itemList to get.
	 */
	public List<Item> getItemList() {
		return this.itemList;
	}
}