package com.netty.model.player.dialogue;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:33:52 AM
 */
public class Dialogue {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private String[] text;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param npc
	 * 			The id to set.
	 * @param text
	 * 			The id to set.
	 */
	public Dialogue(Player player, NPC npc, String[] text) {
		this.setPlayer(player);
		this.setNPC(npc);
		this.setText(text);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
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
	 * @param text
	 * 			The id to set.
	 */
	public void setText(String[] text) {
		this.text = text;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String[] getText() {
		return this.text;
	}
}