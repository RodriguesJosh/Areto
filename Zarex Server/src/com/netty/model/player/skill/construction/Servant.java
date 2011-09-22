package com.netty.model.player.skill.construction;

import com.netty.model.item.Item;

public enum Servant {

	RICK, MAID, COOK, BUTLER, DEMON_BUTTLER;

	private int level;
	private int price;
	private Item[] foodServed;
	private int carryLimit;
	private int time;

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setFoodServed(Item[] foodServed) {
		this.foodServed = foodServed;
	}

	public Item[] getFoodServed() {
		return this.foodServed;
	}

	public void setCarryLimit(int carryLimit) {
		this.carryLimit = carryLimit;
	}

	public int getCarryLimit() {
		return this.carryLimit;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return this.time;
	}
}