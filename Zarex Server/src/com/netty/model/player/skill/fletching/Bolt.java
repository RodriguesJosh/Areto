package com.netty.model.player.skill.fletching;

import com.netty.model.item.Item;

public enum Bolt {

	BRONZE, OPAL, BLURITE, JADE_TIPPED, KEBBIT, IRON, PEARL_TIPPED, LONG_KEBBIT, SILVER, STEEL, RED_TOPAZ_TIPPED, BARB_TIPPED, MITHRIL, BROAD_TIPPED,
	SAPPHIRE_TIPPED, EMERALD_TIPPED, ADAMANT, RUBY_TIPPED, DIAMOND_TIPPED, RUNITE, DRAGONSTONE_TIPPED, ONYX_TIPPED;

	private Item item;
	private int level;
	private int experience;
	private BoltType boltType;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setBoltType(BoltType boltType) {
		this.boltType = boltType;
	}

	public BoltType getBoltType() {
		return this.boltType;
	}
}