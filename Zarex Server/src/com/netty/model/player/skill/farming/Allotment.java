package com.netty.model.player.skill.farming;

public enum Allotment {

	POTATOES_ALLOTMENT,
	ONIONS_ALLOTMENT,
	CABBAGES_ALLOTMENT,
	TOMATOS_ALLOTMENT,
	SWEETCORN_ALLOTMENT,
	STRAWBERRY_ALLOTMENT,
	WATERMELONS_ALLOTMENT;

	private int level;

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}