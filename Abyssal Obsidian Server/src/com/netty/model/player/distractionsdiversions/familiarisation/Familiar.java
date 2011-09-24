package com.netty.model.player.distractionsdiversions.familiarisation;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 7:35:18 PM
 */
public enum Familiar {

	/** YOUR FORM - OPPOSING FORM #1 - OPPOSING FORM #2 */

	/**
	 * 
	 */
	SPIRIT_WOLF,

	/**
	 * 
	 */
	DREADFOWL,

	/**
	 * 
	 */
	SPIRIT_SPIDER,

	/**
	 * 
	 */
	THORNY_SNAIL,

	/**
	 * 
	 */
	GRANITE_CRAB,

	/**
	 * 
	 */
	SPIRIT_MOSQUITO,

	/**
	 * 
	 */
	DESERT_WYRM,

	/**
	 * 
	 */
	SPIRIT_SCORPION,

	/**
	 * 
	 */
	SPIRIT_TZ_KIH,

	/**
	 * 
	 */
	ALBINO_RAT,

	/**
	 * 
	 */
	SPIRIT_KALPHITE,

	/**
	 * 
	 */
	COMPOST_MOUND,

	/**
	 * 
	 */
	GIANT_CHINCHOMPA,

	/**
	 * 
	 */
	VAMPIRE_BAT,

	/**
	 * 
	 */
	HONEY_BADGER,

	/**
	 * 
	 */
	BEAVER,

	/**
	 * 
	 */
	VOID_RAVAGER,

	/**
	 * 
	 */
	VOID_SPINNER,

	/**
	 * 
	 */
	VOID_SHIFTER,

	/**
	 * 
	 */
	VOID_TORCHER,

	/**
	 * 
	 */
	BRONZE_MINOTAUR,

	/**
	 * 
	 */
	BULL_ANT,

	/**
	 * 
	 */
	MACAW,

	/**
	 * 
	 */
	EVIL_TURNIP,

	/**
	 * 
	 */
	SPIRIT_COCKATRICE,

	/**
	 * 
	 */
	SPIRIT_GUTHATRICE,

	/**
	 * 
	 */
	SPIRIT_SARATRICE,

	/**
	 * 
	 */
	SPIRIT_ZAMATRICE,

	/**
	 * 
	 */
	SPIRIT_PENGATRICE,

	/**
	 * 
	 */
	SPIRIT_CORAXATRICE,

	/**
	 * 
	 */
	SPIRIT_VULATRICE,

	/**
	 * 
	 */
	IRON_MINOTAUR,

	/**
	 * 
	 */
	PYRELORD,

	/**
	 * 
	 */
	MAGPIE,

	/**
	 * 
	 */
	BLOATED_LEECH,

	/**
	 * 
	 */
	SPIRIT_TERRORBIRD,

	/**
	 * 
	 */
	ABYSSAL_PARASITE,

	/**
	 * 
	 */
	SPIRIT_JELLY,

	/**
	 * 
	 */
	STEEL_MINOTAUR,

	/**
	 * 
	 */
	IBIS,

	/**
	 * 
	 */
	SPIRIT_GRAAHK,

	/**
	 * 
	 */
	SPIRIT_KYATT,

	/**
	 * 
	 */
	SPIRIT_LARUPIA,

	/**
	 * 
	 */
	KARAMTHULHU_OVERLOAD,

	/**
	 * 
	 */
	SMOKE_DEVIL,

	/**
	 * 
	 */
	ABYSSAL_LURKER,

	/**
	 * 
	 */
	SPIRIT_COBRA,

	/**
	 * 
	 */
	STRANGER_PLANT,

	/**
	 * 
	 */
	MITHRIL_MINOTAUR,

	/**
	 * 
	 */
	BARKER_TOAD,

	/**
	 * 
	 */
	WAR_TORTOISE,

	/**
	 * 
	 */
	BUNYIP,

	/**
	 * 
	 */
	FRUIT_BAT,

	/**
	 * 
	 */
	RAVENOUS_LOCUST,

	/**
	 * 
	 */
	ARCTIC_BEAR,

	/**
	 * 
	 */
	PHOENIX,

	/**
	 * 
	 */
	OBSIDIAN_GOLEM,

	/**
	 * 
	 */
	GRANITE_LOBSTER,

	/**
	 * 
	 */
	PRAYING_MANTIS,

	/**
	 * 
	 */
	ADAMANT_MINOTAUR,

	/**
	 * 
	 */
	FORGE_REGENT,

	/**
	 * 
	 */
	TALON_BEAST,

	/**
	 * 
	 */
	GIANT_ENT,

	/**
	 * 
	 */
	FIRE_TITAN,

	/**
	 * 
	 */
	ICE_TITAN,

	/**
	 * 
	 */
	MOSS_TITAN,

	/**
	 * 
	 */
	HYDRA,

	/**
	 * 
	 */
	SPIRIT_DAGANNOTH,

	/**
	 * 
	 */
	LAVA_TITAN,

	/**
	 * 
	 */
	SWAMP_TITAN,

	/**
	 * 
	 */
	RUNE_MINOTAUR,

	/**
	 * 
	 */
	UNICORN_STALLION,

	/**
	 * 
	 */
	GEYSER_TITAN,

	/**
	 * 
	 */
	WOLPERTINGER,

	/**
	 * 
	 */
	ABYSSAL_TITAN,

	/**
	 * 
	 */
	IRON_TITAN,

	/**
	 * 
	 */
	PACK_YAK,

	/**
	 * 
	 */
	STEEL_TITAN;

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
	private byte time;

	/**
	 * 
	 */
	private byte pointCost;

	// private SpecialMove specialMove;

	/**
	 * 
	 * @param npc
	 * 			The npc to set.
	 */
	public void setNpc(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return npc
	 * 			Returns the npc to get.
	 */
	public NPC getNpc() {
		return this.npc;
	}

	/**
	 * 
	 * @param level
	 * 			The level to set.
	 */
	public void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * 
	 * @return level
	 * 			Returns the level to get.
	 */
	public byte getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param time
	 * 			The time to set.
	 */
	public void setTime(byte time) {
		this.time = time;
	}

	/**
	 * 
	 * @return time
	 * 			Returns the time to get.
	 */
	public byte getTime() {
		return this.time;
	}
	/**
	 * 
	 * @param pointCost
	 * 			The pointCost to set.
	 */
	public void setPointCost(byte pointCost) {
		this.pointCost = pointCost;
	}

	/**
	 * 
	 * @return pointCost
	 * 			Returns the pointCost to get.
	 */
	public byte getPointCost() {
		return this.pointCost;
	}
}