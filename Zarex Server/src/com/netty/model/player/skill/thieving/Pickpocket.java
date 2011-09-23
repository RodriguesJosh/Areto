package com.netty.model.player.skill.thieving;

import com.netty.model.item.Item;
import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:20:53 AM
 */
public enum Pickpocket {

	/**
	 * 
	 */
	MAN_WOMAN,

	/**
	 * 
	 */
	FARMER,

	/**
	 * 
	 */
	FEMALE_HAM,

	/**
	 * 
	 */
	MALE_HAM,

	/**
	 * 
	 */
	HAM_GUARD,

	/**
	 * 
	 */
	WOMAN_WARRIOR,

	/**
	 * 
	 */
	ROGUE,

	/**
	 * 
	 */
	CAVE_GOBLIN,

	/**
	 * 
	 */
	MASTER_FARMER,

	/**
	 * 
	 */
	GUARD,

	/**
	 * 
	 */
	FREMENNIK_CITIZEN,

	/**
	 * 
	 */
	BEARDED_POLLNIVIAN_BANDIT,

	/**
	 * 
	 */
	DESERT_BANDIT,

	/**
	 * 
	 */
	KNIGHT_ARDOUGNE,

	/**
	 * 
	 */
	POLLNIVIAN_BANDIT,

	/**
	 * 
	 */
	YANILLE_WATCHMAN,

	/**
	 * 
	 */
	MENAPHITE_THUG,

	/**
	 * 
	 */
	PALADIN,

	/**
	 * 
	 */
	GNOME,

	/**
	 * 
	 */
	HERO,

	/**
	 * 
	 */
	ELF,

	/**
	 * 
	 */
	DRAWF_TRADER;

	/**
	 * 
	 */
	private NPC npc;

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
	private byte damage;

	/**
	 * 
	 */
	private Item[] loot;

	/**
	 * 
	 */
	private byte chance;

	/**
	 * 
	 * @param npc
	 * 			The id to set.
	 */
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public NPC getNPC() {
		return this.npc;
	}

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
	 * @param damage
	 * 			The id to set.
	 */
	public void setDamage(byte damage) {
		this.damage = damage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getDamage() {
		return this.damage;
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