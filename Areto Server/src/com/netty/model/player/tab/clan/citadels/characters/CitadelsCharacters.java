package com.netty.model.player.tab.clan.citadels.characters;

import com.netty.model.npc.NPC;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:45:20 PM
 */
public enum CitadelsCharacters {

	/**
	 * 
	 */
	AVALANI,

	/**
	 * 
	 */
	ARTISAN,

	/**
	 * 
	 */
	BATTLEMASTER,

	/**
	 * 
	 */
	QUARTERMASTER,

	/**
	 * 
	 */
	MASTER_GUARD;

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