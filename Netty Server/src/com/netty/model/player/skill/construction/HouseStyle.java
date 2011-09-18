package com.netty.model.player.skill.construction;

public enum HouseStyle {

	BASIC_WOOD, BASIC_STONE, WHITEWASHED_STONE, FREMENNIK_WOOD, TROPICAL_WOOD, FANCY_STONE, ZENEVIVIA_DARK_STONE;

	private int level;
	private int price;
	private String areaName;

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

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaName() {
		return this.areaName;
	}
}