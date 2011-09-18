package com.netty.model.player.skill.slayer;

import com.netty.model.npc.NPC;

public enum Creature {

	CRAWLING_HAND, CAVE_BUG, CAVE_CRAWLER, BANSHEE, CAVE_SLIME, ROCKSLUG, DESERT_LIZARD, COCKATRICE, PYREFIEND, MOGRE, HARPIE_BUG_SWARM, WALL_BEAST,
	KILLERWATT, MOLANISK, BASILISK, TERROR_DOG, FEVER_SPIDER, INFERNAL_MAGE, BRINE_RAT, BLOODVELD, JELLY, TUROTH, WARPED_TORTOISE, WARPED_TERRORBIRD,
	ZYGOMITE, CAVE_HORROR, ABERRANT_SPECTRE, SPRITUAL_RANGER, DUST_DEVIL, SPIRITUAL_WARRIOR, KURASK, SKELETAL_WYVERN, JUNGLE_STRYKEWYRM, GARGOYLE,
	DESERT_STRKEWYRM, AQUANITE, NECHRYAEL, SPIRITUAL_MAGE, ABYSSAL_DEMON, DARK_BEAST, ICE_STRYKEWYRM;

	private NPC npc;
	private int level;

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
}