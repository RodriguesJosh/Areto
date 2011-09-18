package com.netty.model.player.shop.impl;

import java.util.ArrayList;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.shop.Shop;
import com.netty.model.player.shop.ShopConstants;
import com.netty.model.player.shop.ShopSeller;

public class Bob extends Shop {

	public Bob(Player player) {
		super(player, new ArrayList<Item>(ShopConstants.MAX_SHOP_SLOTS), ShopSeller.BOB);
	}
}