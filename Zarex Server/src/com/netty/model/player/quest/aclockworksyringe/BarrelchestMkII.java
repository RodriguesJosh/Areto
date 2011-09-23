package com.netty.model.player.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.update.ForceChat;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 3:53:41 PM
 */
public class BarrelchestMkII {

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private ForceChat firstForceChat;

	/**
	 * 
	 */
	private ForceChat secondForceChat;

	/**
	 * 
	 */
	public BarrelchestMkII() {
		NPC npc = World.getWorld().getNPCList().get(0);
		this.setNPC(npc);
		ForceChat firstForceChat = new ForceChat("Heh heh heh");
		this.setFirstForceChat(firstForceChat);
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
	 * @param firstForceChat
	 * 			The id to set.
	 */
	public void setFirstForceChat(ForceChat firstForceChat) {
		this.firstForceChat = firstForceChat;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ForceChat getFirstForceChat() {
		return this.firstForceChat;
	}

	/**
	 * 
	 * @param secondForceChat
	 * 			The id to set.
	 */
	public void setSecondForceChat(ForceChat secondForceChat) {
		this.secondForceChat = secondForceChat;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ForceChat getSecondForceChat() {
		return this.secondForceChat;
	}
}