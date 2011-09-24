package com.netty.model.player.distractionsdiversions.phoenixlairs;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 6:51:45 PM
 */
public class Phoenix {

	/** Dialogue here. */

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