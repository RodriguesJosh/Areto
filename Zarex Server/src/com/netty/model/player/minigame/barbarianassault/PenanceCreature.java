package com.netty.model.player.minigame.barbarianassault;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:01:04 PM
 */
public enum PenanceCreature {

	/**
	 * 
	 */
	PENANCE_RANGER,

	/**
	 * 
	 */
	PENANCE_FIGHTER,

	/**
	 * 
	 */
	PENANCE_RUNNER,

	/**
	 * 
	 */
	PENANCE_HEALER;

	/**
	 * 
	 */
	private NPC npc;

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
}