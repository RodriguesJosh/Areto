package com.netty.model.player.minigame.fightcaves;

import com.netty.model.combat.CombatType;
import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:40:41 PM
 */
public enum Monster {

	/**
	 * 
	 */
	TZ_KIH,

	/**
	 * 
	 */
	TZ_KEK,

	/**
	 * 
	 */
	TZ_KEK_MINI,

	/**
	 * 
	 */
	TOK_XIL,

	/**
	 * 
	 */
	YT_MEJKOT,

	/**
	 * 
	 */
	KET_ZEK,

	/**
	 * 
	 */
	TZTOK_JAD,

	/**
	 * 
	 */
	YT_HURKOT;

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private CombatType combatType;

	/**
	 * 
	 */
	private int maxHit;

	/**
	 * 
	 * @param npc
	 *			The id to set.
	 */
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public NPC getNPC() {
		return this.npc;
	}

	/**
	 * 
	 * @param combatType
	 *			The id to set.
	 */
	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public CombatType getCombatType() {
		return this.combatType;
	}

	/**
	 * 
	 * @param maxHit
	 *			The id to set.
	 */
	public void setMaxHit(int maxHit) {
		this.maxHit = maxHit;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public int getMaxHit() {
		return this.maxHit;
	}
}