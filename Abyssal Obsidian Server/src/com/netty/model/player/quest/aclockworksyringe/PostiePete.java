package com.netty.model.player.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.update.ForceChat;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 3:54:28 PM
 */
public class PostiePete {

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
	 * @param player
	 * 			The id to set.
	 */
	public PostiePete(Player player) {
		NPC npc = World.getWorld().getNPCList().get(0);
		this.setNPC(npc);
		ForceChat firstForceChat = new ForceChat("Hey there!" + player.getName() + "!");
		this.setFirstForceChat(firstForceChat);
		this.getNPC().setForceChat(this.getFirstForceChat());
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