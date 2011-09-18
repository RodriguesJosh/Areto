package com.netty.model.player.skill.farming;

public enum Flower {

	PASTEL_FLOWERS, RED_FLOWERS, BLUE_FLOWERS, YELLOW_FLOWERS, PURPLE_FLOWERS, ORANGE_FLOWERS, MIXED_FLOWERS, WHITE_FLOWERS, BLACK_FLOWERS;

	private int id;
	private int price;
	private int lowAlch;
	private int highAlch;
	private int storePrice;

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setLowAlch(int lowAlch) {
		this.lowAlch = lowAlch;
	}

	public int getLowAlch() {
		return this.lowAlch;
	}

	public void setHighAlch(int highAlch) {
		this.highAlch = highAlch;
	}

	public int getHighAlch() {
		return this.highAlch;
	}

	public void setStorePrice(int storePrice) {
		this.storePrice = storePrice;
	}

	public int getStorePrice() {
		return this.storePrice;
	}
}