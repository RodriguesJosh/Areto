package com.netty.model.player.shop;

import java.util.List;

import com.netty.model.item.Item;
import com.netty.model.player.Player;

public class Shop {

	private Player player;
	private List<Item> itemList;
	private ShopSeller shopSeller;

	public Shop(Player player, List<Item> itemList, ShopSeller shopSeller) {
		this.setPlayer(player);
		this.setItemList(itemList);
		this.setShopSeller(shopSeller);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Item> getItemList() {
		return this.itemList;
	}

	public void setShopSeller(ShopSeller shopSeller) {
		this.shopSeller = shopSeller;
	}

	public ShopSeller getShopSeller() {
		return this.shopSeller;
	}
}