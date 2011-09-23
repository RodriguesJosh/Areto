package com.netty.model.player.skill.farming;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:09:26 AM
 */
public enum Herb {

	/**
	 * 
	 */
	GUAM,

	/**
	 * 
	 */
	MARRENTILL,

	/**
	 * 
	 */
	TARROMIN,

	/**
	 * 
	 */
	HARRALANDER,

	/**
	 * 
	 */
	RANARR,

	/**
	 * 
	 */
	TOADFLAX,

	/**
	 * 
	 */
	SPIRIT_WEED,

	/**
	 * 
	 */
	IRIT,

	/**
	 * 
	 */
	WERGALI,

	/**
	 * 
	 */
	AVANTOE,

	/**
	 * 
	 */
	KWUARM,

	/**
	 * 
	 */
	SNAPDRAGON,

	/**
	 * 
	 */
	CADANTINE,

	/**
	 * 
	 */
	LANTADYME,

	/**
	 * 
	 */
	DWARF_WEED,

	/**
	 * 
	 */
	TORSTOL,

	/**
	 * 
	 */
	ARDRIGAL,

	/**
	 * 
	 */
	ROGUES_PURSE,

	/**
	 * 
	 */
	SITO_FOIL,

	/**
	 * 
	 */
	SNAKE_WEED,

	/**
	 * 
	 */
	VOLENCIA_MOSS,

	/**
	 * 
	 */
	SAGEWORT,

	/**
	 * 
	 */
	VALERIAN,

	/**
	 * 
	 */
	ALOE,

	/**
	 * 
	 */
	WORDWOOD_LEAF,

	/**
	 * 
	 */
	MAGEBANE,

	/**
	 * 
	 */
	FEATHERFOIL,

	/**
	 * 
	 */
	WINTERS_GRIP,

	/**
	 * 
	 */
	LYCOPUS,

	/**
	 * 
	 */
	BUCKTHORN;

	/**
	 * 
	 */
	private Item cleanHerb;

	/**
	 * 
	 */
	private Item grimyHerb;

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
	private int cleanPrice;

	/**
	 * 
	 */
	private int grimyPrice;

	/**
	 * 
	 * @param cleanHerb
	 * 			The id to set.
	 */
	public void setCleanHerb(Item cleanHerb) {
		this.cleanHerb = cleanHerb;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getCleanHerb() {
		return this.cleanHerb;
	}

	/**
	 * 
	 * @param grimyHerb
	 * 			The id to set.
	 */
	public void setGrimyHerb(Item grimyHerb) {
		this.grimyHerb = grimyHerb;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getGrimyHerb() {
		return this.grimyHerb;
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
	 * @param cleanPrice
	 * 			The id to set.
	 */
	public void setCleanPrice(int cleanPrice) {
		this.cleanPrice = cleanPrice;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCleanPrice() {
		return this.cleanPrice;
	}

	/**
	 * 
	 * @param grimyPrice
	 * 			The id to set.
	 */
	public void setGrimyPrice(int grimyPrice) {
		this.grimyPrice = grimyPrice;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getGrimyPrice() {
		return this.grimyPrice;
	}
}