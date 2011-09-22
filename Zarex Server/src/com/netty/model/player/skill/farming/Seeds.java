package com.netty.model.player.skill.farming;

import com.netty.model.item.Item;

public enum Seeds {

	POTATO_SEED, ONION_SEED, CABBAGE_SEED, TOMATO_SEED, SWEETCORN_SEED, STRAWBERRY_SEED, WATERMELON_SEED, MARIGOLD_SEED, ROSEMARY_SEED, NASTURTIUM_SEED,
	WOAD_SEED, LIMPWURT_SEED, WHITE_LILY_SEED, BARLEY_SEED, HAMMERSTONE_SEED, ASGARNIAN_SEED, JUTE_SEED, YANILLIAN_SEED, KRANDORIAN_SEED, WILDBLOOD_SEED,
	REDBERRY_SEED, CADAVABERRY_SEED, DWELLBERRY_SEED, JANGERBERRY_SEED, WHITEBERRY_SEED, POISON_IVY_SEED, ACORN_SEED, WILLOW_SEED, MAPLE_SEED, YEW_SEED,
	MAGIC_SEED, APPLE_SEED, BANANA_SEED, ORANGE_SEED, CURRY_SEED, PINEAPPLE_SEED, PAPAYA_SEED, PALM_SEED, GUAM_SEED, MARRENTILL_SEED, TARROMIN_SEED,
	HARRALANDER_SEED, GOUT_TUBER_SEED, RANARR_SEED, SPIRIT_WEED_SEED, TOADFLAX_SEED, IRIT_SEED, WERGALI_SEED, AVANTOE_SEED, KWUARM_SEED, SNAPDRAGON_SEED,
	CADANTINE_SEED, LANTADYME_SEED, DWARF_WEED_SEED, TORSTOL_SEED, EVIL_TURNIP_SEED, MUSHROOM_SPORE_SEED, JADE_VINE_SEED, CACTUS_SEED, BELLADONNA_SEED,
	CALQUAT_TREE_SEED, SPIRIT_SEED;

	private Item item;
	private Item[] payment;
	private int level;
	private int experience;
	private int grandExchangePrice;
	private int harvest;
	private int checkHealth;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setPayment(Item[] payment) {
		this.payment = payment;
	}

	public Item[] getPayment() {
		return this.payment;
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

	public void setGrandExchangePrice(int grandExchangePrice) {
		this.grandExchangePrice = grandExchangePrice;
	}

	public int getGrandExchangePrice() {
		return this.grandExchangePrice;
	}

	public void setHarvest(int harvest) {
		this.harvest = harvest;
	}

	public int getHarvest() {
		return this.harvest;
	}

	public void setCheckHealth(int checkHealth) {
		this.checkHealth = checkHealth;
	}

	public int getCheckHealth() {
		return this.checkHealth;
	}
}