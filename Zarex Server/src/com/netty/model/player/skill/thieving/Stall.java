package com.netty.model.player.skill.thieving;

import com.netty.model.item.Item;
import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:22:43 AM
 */
public enum Stall {

	/**
	 * 
	 */
	VEGETABLE,

	/**
	 * 
	 */
	BAKERS,

	/**
	 * 
	 */
	CRAFTING,

	/**
	 * 
	 */
	MONKEY_FOOD,

	/**
	 * 
	 */
	MONKEY_GENERAL_STORE,

	/**
	 * 
	 */
	TEA,

	/**
	 * 
	 */
	SILK,

	/**
	 * 
	 */
	WINE,

	/**
	 * 
	 */
	SEED,

	/**
	 * 
	 */
	FUR,

	/**
	 * 
	 */
	FISH,

	/**
	 * 
	 */
	CROSSBOW,

	/**
	 * 
	 */
	SILVER,

	/**
	 * 
	 */
	EVIDENCE_FILES,

	/**
	 * 
	 */
	SPICE,

	/**
	 * 
	 */
	MAGIC,

	/**
	 * 
	 */
	SCIMITAR,

	/**
	 * 
	 */
	GEM;

	/**
	 * 
	 */
	private byte level;

	/**
	 * 
	 */
	private int experience;

	/**
	 * 
	 */
	private byte respawnTime;

	/**
	 * 
	 */
	private NPC[] eludeNPCs;

	/**
	 * 
	 */
	private Item[] loot;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private byte chance;

	/**
	 * 
	 * @param level
	 * 			The id to set.
	 */
	public void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getLevel() {
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
	 * @param respawnTime
	 * 			The id to set.
	 */
	public void setRespawnTime(byte respawnTime) {
		this.respawnTime = respawnTime;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getRespawnTime() {
		return this.respawnTime;
	}

	/**
	 * 
	 * @param eludeNPCs
	 * 			The id to set.
	 */
	public void setEludeNPCs(NPC[] eludeNPCs) {
		this.eludeNPCs = eludeNPCs;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public NPC[] getEludeNPCs() {
		return this.eludeNPCs;
	}

	/**
	 * 
	 * @param loot
	 * 			The id to set.
	 */
	public void setLoot(Item[] loot) {
		this.loot = loot;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item[] getLoot() {
		return this.loot;
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

	/**
	 * 
	 * @param chance
	 * 			The id to set.
	 */
	public void setChance(byte chance) {
		this.chance = chance;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getChance() {
		return this.chance;
	}
}