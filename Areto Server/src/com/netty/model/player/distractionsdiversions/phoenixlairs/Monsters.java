package com.netty.model.player.distractionsdiversions.phoenixlairs;

import com.netty.model.combat.CombatType;
import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 7:12:50 PM
 */
public enum Monsters {

	/**
	 * 
	 */
	LESSER_REBORN_MAGE,

	/**
	 * 
	 */
	GREATER_REBORN_MAGE,

	/**
	 * 
	 */
	LESSER_REBORN_WARRIOR,

	/**
	 * 
	 */
	GREATER_REBORN_WARRIOR,

	/**
	 * 
	 */
	LESSER_REBORN_RANGER,

	/**
	 * 
	 */
	GREATER_REBORN_RANGER;

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

	/**
	 * 
	 * @param combatType
	 * 			The combatType to set.
	 */
	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}

	/**
	 * 
	 * @return combatType
	 * 			Returns the combatType to get.
	 */
	public CombatType getCombatType() {
		return this.combatType;
	}
}