package com.netty.model.player.skill.crafting;

import com.netty.model.item.Item;

public enum GoldJewellery {

	NO_GEM, SAPPHIRE, EMERALD, RUBY, DIAMOND, DRAGONSTONE, ONYX;

	private Item item;
	private int cuttingLevel;
	private int cuttingExperience;
	private int ringLevel;
	private int ringExperience;
	private int necklaceLevel;
	private int necklaceExperience;
	private int braceletLevel;
	private int braceletExperience;
	private int amuletLevel;
	private int amuletExperience;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setCuttingLevel(int cuttingLevel) {
		this.cuttingLevel = cuttingLevel;
	}

	public int getCuttingLevel() {
		return this.cuttingLevel;
	}

	public void setCuttingExperience(int cuttingExperience) {
		this.cuttingExperience = cuttingExperience;
	}

	public int getCuttingExperience() {
		return this.cuttingExperience;
	}

	public void setRingLevel(int ringLevel) {
		this.ringLevel = ringLevel;
	}

	public int getRingLevel() {
		return this.ringLevel;
	}

	public void setRingExperience(int ringExperience) {
		this.ringExperience = ringExperience;
	}

	public int getRingExperience() {
		return this.ringExperience;
	}

	public void setNecklaceLevel(int necklaceLevel) {
		this.necklaceLevel = necklaceLevel;
	}

	public int getNecklaceLevel() {
		return this.necklaceLevel;
	}

	public void setNecklaceExperience(int necklaceExperience) {
		this.necklaceExperience = necklaceExperience;
	}

	public int getNecklaceExperience() {
		return this.necklaceExperience;
	}

	public void setBraceletLevel(int braceletLevel) {
		this.braceletLevel = braceletLevel;
	}

	public int getBraceletLevel() {
		return this.braceletLevel;
	}

	public void setBraceletExperience(int braceletExperience) {
		this.braceletExperience = braceletExperience;
	}

	public int getBraceletExperience() {
		return this.braceletExperience;
	}

	public void setAmuletLevel(int amuletLevel) {
		this.amuletLevel = amuletLevel;
	}

	public int getAmuletLevel() {
		return this.amuletLevel;
	}

	public void setAmuletExperience(int amuletExperience) {
		this.amuletExperience = amuletExperience;
	}

	public int getAmuletExperience() {
		return this.amuletExperience;
	}
}