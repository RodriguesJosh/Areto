package com.netty.model.player.skill.thieving;

import com.netty.model.item.Item;
import com.netty.model.npc.NPC;

public enum Stall {

	VEGETABLE, BAKERS, CRAFTING, MONKEY_FOOD, MONKEY_GENERAL_STORE, TEA, SILK, WINE, SEED, FUR, FISH, CROSSBOW, SILVER, EVIDENCE_FILES, SPICE, MAGIC,
	SCIMITAR, GEM;

	private int level;
	private int experience;
	private int respawnTime;
	private NPC[] eludeNPCs;
	private Item[] loot;
	private String name;
	private int chance;

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

	public void setRespawnTime(int respawnTime) {
		this.respawnTime = respawnTime;
	}

	public int getRespawnTime() {
		return this.respawnTime;
	}

	public void setEludeNPCs(NPC[] eludeNPCs) {
		this.eludeNPCs = eludeNPCs;
	}

	public NPC[] getEludeNPCs() {
		return this.eludeNPCs;
	}

	public void setLoot(Item[] loot) {
		this.loot = loot;
	}

	public Item[] getLoot() {
		return this.loot;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public int getChance() {
		return this.chance;
	}
}