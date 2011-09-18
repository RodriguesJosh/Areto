package com.netty.model.player.skill;

public enum SkillType {

	ATTACK((byte) 0, "Attack"), DEFENCE((byte) 1, "Defence"), STRENGTH((byte) 2, "Strength"), HITPOINT((byte) 3, "Hitpoints"), RANGE((byte) 4, "Range"),
	PRAYER((byte) 5, "Prayer"), MAGIC((byte) 6, "Magic"), COOKING((byte) 7, "Cooking"), WOODCUTTING((byte) 8, "Woodcutting"),
	FLETCHING((byte) 9, "Fletching"), FISHING((byte) 10, "Fishing"), FIREMAKING((byte) 11, "Firemaking"), CRAFTING((byte) 12, "Crafting"),
	SMITHING((byte) 13, "Smithing"), MINING((byte) 14, "Mining"), HERBLORE((byte) 15, "Herblore"), AGILITY((byte) 16, "Agility"),
	THIEVING((byte) 17, "Thieving"), SLAYER((byte) 18, "Slayer"), FARMING((byte) 19, "Farming"), RUNECRAFTING((byte) 20, "Runecrafting"),
	DUNGEONEERING((byte) 21, "Dungeoneering"), CONSTRUCTION((byte) 22, "Construction");

	private byte id;
	private String name;

	private SkillType(byte id, String name) {
		this.setID(id);
		this.setName(name);
	}

	public void setID(byte id) {
		this.id = id;
	}

	public byte getID() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}