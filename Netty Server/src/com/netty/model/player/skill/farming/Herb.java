package com.netty.model.player.skill.farming;

import com.netty.model.item.Item;

public enum Herb {

	GUAM, MARRENTILL, TARROMIN, HARRALANDER, RANARR, TOADFLAX, SPIRIT_WEED, IRIT, WERGALI, AVANTOE, KWUARM, SNAPDRAGON, CADANTINE, LANTADYME, DWARF_WEED,
	TORSTOL, ARDRIGAL, ROGUES_PURSE, SITO_FOIL, SNAKE_WEED, VOLENCIA_MOSS, SAGEWORT, VALERIAN, ALOE, WORDWOOD_LEAF, MAGEBANE, FEATHERFOIL, WINTERS_GRIP,
	LYCOPUS, BUCKTHORN;

	private Item cleanHerb;
	private Item grimyHerb;
	private int level;
	private int experience;
	private int cleanPrice;
	private int grimyPrice;

	public void setCleanHerb(Item cleanHerb) {
		this.cleanHerb = cleanHerb;
	}

	public Item getCleanHerb() {
		return this.cleanHerb;
	}

	public void setGrimyHerb(Item grimyHerb) {
		this.grimyHerb = grimyHerb;
	}

	public Item getGrimyHerb() {
		return this.grimyHerb;
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

	public void setCleanPrice(int cleanPrice) {
		this.cleanPrice = cleanPrice;
	}

	public int getCleanPrice() {
		return this.cleanPrice;
	}

	public void setGrimyPrice(int grimyPrice) {
		this.grimyPrice = grimyPrice;
	}

	public int getGrimyPrice() {
		return this.grimyPrice;
	}
}