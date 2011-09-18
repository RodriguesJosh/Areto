package com.netty.model.player.skill.farming;

import com.netty.model.item.Item;

public enum Tools {

	RAKE, DIBBER, SPADE, TROWEL, SECATEURS, WATERING_CAN, SCARECROW, BUCKET, COMPOST, SUPER_COMPOST, PLANT_POTS, HATCHET, SACKS, BASKETS, PLANT_CURE,
	GARDENING_BOOTS;

	private Item item;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}
}