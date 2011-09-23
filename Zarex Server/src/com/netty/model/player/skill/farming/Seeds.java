package com.netty.model.player.skill.farming;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:07:06 AM
 */
public enum Seeds {

	/**
	 * 
	 */
	POTATO_SEED,

	/**
	 * 
	 */
	ONION_SEED,

	/**
	 * 
	 */
	CABBAGE_SEED,

	/**
	 * 
	 */
	TOMATO_SEED,

	/**
	 * 
	 */
	SWEETCORN_SEED,

	/**
	 * 
	 */
	STRAWBERRY_SEED,

	/**
	 * 
	 */
	WATERMELON_SEED,

	/**
	 * 
	 */
	MARIGOLD_SEED,

	/**
	 * 
	 */
	ROSEMARY_SEED,

	/**
	 * 
	 */
	NASTURTIUM_SEED,

	/**
	 * 
	 */
	WOAD_SEED,

	/**
	 * 
	 */
	LIMPWURT_SEED,

	/**
	 * 
	 */
	WHITE_LILY_SEED,

	/**
	 * 
	 */
	BARLEY_SEED,

	/**
	 * 
	 */
	HAMMERSTONE_SEED,

	/**
	 * 
	 */
	ASGARNIAN_SEED,

	/**
	 * 
	 */
	JUTE_SEED,

	/**
	 * 
	 */
	YANILLIAN_SEED,

	/**
	 * 
	 */
	KRANDORIAN_SEED,

	/**
	 * 
	 */
	WILDBLOOD_SEED,
	/**
	 * 
	 */
	REDBERRY_SEED,

	/**
	 * 
	 */
	CADAVABERRY_SEED,

	/**
	 * 
	 */
	DWELLBERRY_SEED,

	/**
	 * 
	 */
	JANGERBERRY_SEED,

	/**
	 * 
	 */
	WHITEBERRY_SEED,

	/**
	 * 
	 */
	POISON_IVY_SEED,

	/**
	 * 
	 */
	ACORN_SEED,

	/**
	 * 
	 */
	WILLOW_SEED,

	/**
	 * 
	 */
	MAPLE_SEED,

	/**
	 * 
	 */
	YEW_SEED,

	/**
	 * 
	 */
	MAGIC_SEED,

	/**
	 * 
	 */
	APPLE_SEED,

	/**
	 * 
	 */
	BANANA_SEED,

	/**
	 * 
	 */
	ORANGE_SEED,

	/**
	 * 
	 */
	CURRY_SEED,

	/**
	 * 
	 */
	PINEAPPLE_SEED,

	/**
	 * 
	 */
	PAPAYA_SEED,

	/**
	 * 
	 */
	PALM_SEED,

	/**
	 * 
	 */
	GUAM_SEED,

	/**
	 * 
	 */
	MARRENTILL_SEED,

	/**
	 * 
	 */
	TARROMIN_SEED,

	/**
	 * 
	 */
	HARRALANDER_SEED,

	/**
	 * 
	 */
	GOUT_TUBER_SEED,

	/**
	 * 
	 */
	RANARR_SEED,

	/**
	 * 
	 */
	SPIRIT_WEED_SEED,

	/**
	 * 
	 */
	TOADFLAX_SEED,

	/**
	 * 
	 */
	IRIT_SEED,

	/**
	 * 
	 */
	WERGALI_SEED,

	/**
	 * 
	 */
	AVANTOE_SEED,

	/**
	 * 
	 */
	KWUARM_SEED,

	/**
	 * 
	 */
	SNAPDRAGON_SEED,

	/**
	 * 
	 */
	CADANTINE_SEED,

	/**
	 * 
	 */
	LANTADYME_SEED,

	/**
	 * 
	 */
	DWARF_WEED_SEED,

	/**
	 * 
	 */
	TORSTOL_SEED,

	/**
	 * 
	 */
	EVIL_TURNIP_SEED,

	/**
	 * 
	 */
	MUSHROOM_SPORE_SEED,

	/**
	 * 
	 */
	JADE_VINE_SEED,

	/**
	 * 
	 */
	CACTUS_SEED,

	/**
	 * 
	 */
	BELLADONNA_SEED,

	/**
	 * 
	 */
	CALQUAT_TREE_SEED,

	/**
	 * 
	 */
	SPIRIT_SEED;

	/**
	 * 
	 */
	private Item item;

	/**
	 * 
	 */
	private Item[] payment;

	/**
	 * 
	 */
	private int level;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 */
	private int grandExchangePrice;

	/**
	 * 
	 */
	private int harvest;

	/**
	 * 
	 */
	private int checkHealth;

	/**
	 * 
	 * @param item
	 * 			The id to set.
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * 
	 * @param payment
	 * 			The id to set.
	 */
	public void setPayment(Item[] payment) {
		this.payment = payment;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item[] getPayment() {
		return this.payment;
	}

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param experience
	 * 			The id to set.
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getExperience() {
		return this.experience;
	}

	/**
	 * 
	 * @param grandExchangePrice
	 * 			The id to set.
	 */
	public void setGrandExchangePrice(int grandExchangePrice) {
		this.grandExchangePrice = grandExchangePrice;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getGrandExchangePrice() {
		return this.grandExchangePrice;
	}

	/**
	 * 
	 * @param harvest
	 * 			The id to set.
	 */
	public void setHarvest(int harvest) {
		this.harvest = harvest;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getHarvest() {
		return this.harvest;
	}

	/**
	 * 
	 * @param checkHealth
	 * 			The id to set.
	 */
	public void setCheckHealth(int checkHealth) {
		this.checkHealth = checkHealth;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCheckHealth() {
		return this.checkHealth;
	}
}