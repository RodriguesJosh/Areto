package com.netty.model.player.skill;

import com.netty.model.player.shop.ShopSeller;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:57:53 PM
 */
public enum SkillCape {

	/**
	 * 
	 */
	AGILITY(ShopSeller.CAPN_IZZY_NO_BEARD),

	/**
	 * 
	 */
	ATTACK(ShopSeller.AJJAT);

	/**
	 * 
	 */
	private ShopSeller shopSeller;

	/**
	 * 
	 * @param shopSeller
	 * 			The id to set.
	 */
	private SkillCape(ShopSeller shopSeller) {
		this.setShopSeller(shopSeller);
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