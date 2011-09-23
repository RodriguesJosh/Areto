package com.netty.model.player.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.update.ForceChat;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 3:54:08 PM
 */
public class EstateAgent {

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private ForceChat forceChat;

	/**
	 * 
	 */
	public EstateAgent() {
		NPC npc = World.getWorld().getNPCList().get(0);
		this.setNPC(npc);
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

	/**
	 * 
	 * @param forceChat
	 * 			The id to set.
	 */
	public void setForceChat(ForceChat forceChat) {
		this.forceChat = forceChat;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ForceChat getForceChat() {
		return this.forceChat;
	}
}