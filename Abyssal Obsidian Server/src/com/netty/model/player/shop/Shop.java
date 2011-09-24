package com.netty.model.player.shop;

import java.util.List;

import com.netty.model.item.Item;
import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:01:11 PM
 */
public class Shop {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private List<Item> itemList;

	/**
	 * 
	 */
	private ShopSeller shopSeller;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param itemList
	 * 			The id to set.
	 * @param shopSeller
	 * 			The id to set.
	 */
	public Shop(Player player, List<Item> itemList, ShopSeller shopSeller) {
		this.setPlayer(player);
		this.setItemList(itemList);
		this.setShopSeller(shopSeller);
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
	 * @param shopSeller
	 * 			The id to set.
	 */
	public void setShopSeller(ShopSeller shopSeller) {
		this.shopSeller = shopSeller;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ShopSeller getShopSeller() {
		return this.shopSeller;
	}
}