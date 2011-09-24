package com.netty.model.player.distractionsdiversions.trollinvasion;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 4:42:57 PM
 */
public enum EnemyTrolls {

	/**
	 * 
	 */
	MOUNTAIN_TROLL,

	/**
	 * 
	 */
	TROLL_RANGER,

	/**
	 * 
	 */
	POORLY_COOKED_KARAMBWAN,

	/**
	 * 
	 */
	TROLL_GENERAL,

	/**
	 * 
	 */
	WIZARD,

	/**
	 * 
	 */
	TROLL_FATHER,

	/**
	 * 
	 */
	TROLL_RUNT,

	/**
	 * 
	 */
	SUMMONER,

	/**
	 * 
	 */
	DYNAMITE,

	/**
	 * 
	 */
	CLIFF;

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 * @param npc
	 * 			The npc to set.
	 */
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return npc
	 * 			Returns the npc to get.
	 */
	public NPC getNPC() {
		return this.npc;
	}
}