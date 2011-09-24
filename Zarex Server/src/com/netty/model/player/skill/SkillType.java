package com.netty.model.player.skill;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:55:27 PM
 */
public enum SkillType {

	/**
	 * 
	 */
	ATTACK((byte) 0, "Attack"),

	/**
	 * 
	 */
	DEFENCE((byte) 1, "Defence"),

	/**
	 * 
	 */
	STRENGTH((byte) 2, "Strength"),

	/**
	 * 
	 */
	HITPOINT((byte) 3, "Hitpoints"),

	/**
	 * 
	 */
	RANGE((byte) 4, "Range"),

	/**
	 * 
	 */
	PRAYER((byte) 5, "Prayer"),

	/**
	 * 
	 */
	MAGIC((byte) 6, "Magic"),

	/**
	 * 
	 */
	COOKING((byte) 7, "Cooking"),

	/**
	 * 
	 */
	WOODCUTTING((byte) 8, "Woodcutting"),

	/**
	 * 
	 */
	FLETCHING((byte) 9, "Fletching"),

	/**
	 * 
	 */
	FISHING((byte) 10, "Fishing"),

	/**
	 * 
	 */
	FIREMAKING((byte) 11, "Firemaking"),

	/**
	 * 
	 */
	CRAFTING((byte) 12, "Crafting"),

	/**
	 * 
	 */
	SMITHING((byte) 13, "Smithing"),

	/**
	 * 
	 */
	MINING((byte) 14, "Mining"),

	/**
	 * 
	 */
	HERBLORE((byte) 15, "Herblore"),

	/**
	 * 
	 */
	AGILITY((byte) 16, "Agility"),

	/**
	 * 
	 */
	THIEVING((byte) 17, "Thieving"),

	/**
	 * 
	 */
	SLAYER((byte) 18, "Slayer"),

	/**
	 * 
	 */
	FARMING((byte) 19, "Farming"),

	/**
	 * 
	 */
	RUNECRAFTING((byte) 20, "Runecrafting"),

	/**
	 * 
	 */
	DUNGEONEERING((byte) 21, "Dungeoneering"),

	/**
	 * 
	 */
	CONSTRUCTION((byte) 22, "Construction"),

	/**
	 * 
	 */
	SUMMONING((byte) 23, "Summoning"),

	/**
	 * 
	 */
	HUNTER((byte) 24, "Hunter");

	/**
	 * 
	 */
	private byte id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 * @param name
	 * 			The id to set.
	 */
	private SkillType(byte id, String name) {
		this.setID(id);
		this.setName(name);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(byte id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getID() {
		return this.id;
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getName() {
		return this.name;
	}
}