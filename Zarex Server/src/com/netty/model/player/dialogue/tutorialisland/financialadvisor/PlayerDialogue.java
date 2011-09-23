package com.netty.model.player.dialogue.tutorialisland.financialadvisor;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:42:35 AM
 */
public class PlayerDialogue {

	/**
	 * 
	 */
	private Dialogue[] dialogues;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param npc
	 * 			The id to set.
	 */
	public PlayerDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[2]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Hello. Who are you?"
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"Okay. How can I make money then?"
		});
		player.getDialogueList().addDialogues(this.getDialogues());
	}

	/**
	 * 
	 * @param dialogues
	 * 			The id to set.
	 */
	public void setDialogues(Dialogue[] dialogues) {
		this.dialogues = dialogues;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Dialogue[] getDialogues() {
		return this.dialogues;
	}
}