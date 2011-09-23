package com.netty.model.player.quest.unstablefoundations;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:46:43 PM
 */
public class Goblin {

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