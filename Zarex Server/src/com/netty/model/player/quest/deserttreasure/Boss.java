package com.netty.model.player.quest.deserttreasure;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:32:17 PM
 */
public class Boss {

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