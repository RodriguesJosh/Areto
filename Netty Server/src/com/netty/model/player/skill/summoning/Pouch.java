package com.netty.model.player.skill.summoning;

import com.netty.model.item.Item;

public enum Pouch {

	SPIRIT_WOLF, DREADFOWL, SPIRIT_SPIDER, THORNY_SNAIL, GRANITE_CRAB, MOSQUITO, DESERT_WYRM;

	private int level;
	private Charm charm;
	private int shardAmount;
	private Item secondIngredient;
	private int experience;

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setCharm(Charm charm) {
		this.charm = charm;
	}

	public Charm getCharm() {
		return this.charm;
	}

	public void setShardAmount(int shardAmount) {
		this.shardAmount = shardAmount;
	}

	public int getShardAmount() {
		return this.shardAmount;
	}

	public void setSecondIngredient(Item secondIngredient) {
		this.secondIngredient = secondIngredient;
	}

	public Item getSecondIngredient() {
		return this.secondIngredient;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}
}