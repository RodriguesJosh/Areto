package com.netty.model.player.skill;

import com.netty.model.player.shop.ShopSeller;

public enum SkillCape {

	AGILITY(ShopSeller.CAPN_IZZY_NO_BEARD), ATTACK(ShopSeller.AJJAT);

	private ShopSeller shopSeller;

	private SkillCape(ShopSeller shopSeller) {
		this.setShopSeller(shopSeller);
	}

	public void setShopSeller(ShopSeller shopSeller) {
		this.shopSeller = shopSeller;
	}

	public ShopSeller getShopSeller() {
		return this.shopSeller;
	}
}