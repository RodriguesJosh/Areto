package com.netty.model.player.shop.impl;

import java.util.ArrayList;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.shop.Shop;
import com.netty.model.player.shop.ShopConstants;
import com.netty.model.player.shop.ShopSeller;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:58:37 PM
 */
public class Bob extends Shop {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Bob(Player player) {
		super(player, new ArrayList<Item>(ShopConstants.MAX_SHOP_SLOTS), ShopSeller.BOB);
	}
}