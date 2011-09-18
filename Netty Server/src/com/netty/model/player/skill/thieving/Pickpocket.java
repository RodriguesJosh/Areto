package com.netty.model.player.skill.thieving;

import com.netty.model.item.Item;
import com.netty.model.npc.NPC;

public enum Pickpocket {

	MAN_WOMAN, FARMER, FEMALE_HAM, MALE_HAM, HAM_GUARD, WOMAN_WARRIOR, ROGUE, CAVE_GOBLIN, MASTER_FARMER, GUARD, FREMENNIK_CITIZEN,
	BEARDED_POLLNIVIAN_BANDIT, DESERT_BANDIT, KNIGHT_ARDOUGNE, POLLNIVIAN_BANDIT, YANILLE_WATCHMAN, MENAPHITE_THUG, PALADIN, GNOME, HERO, ELF,
	DRAWF_TRADER;

	private NPC npc;
	private int level;
	private int experience;
	private int damage;
	private Item[] loot;
	private int chance;

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
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

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return this.damage;
	}

	public void setLoot(Item[] loot) {
		this.loot = loot;
	}

	public Item[] getLoot() {
		return this.loot;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public int getChance() {
		return this.chance;
	}
}