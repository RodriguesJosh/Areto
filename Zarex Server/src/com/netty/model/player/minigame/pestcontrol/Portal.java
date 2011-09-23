package com.netty.model.player.minigame.pestcontrol;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:33:14 PM
 */
public class Portal {

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Portal(Player player) {
		this.setNPC(new NPC(0));
	}

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