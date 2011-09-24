package com.netty.model.player.dialogue.tutorialisland.masterchef;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:44:17 AM
 */
public class MasterChefDialogue {

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
	public MasterChefDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[3]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Ah! Welcome, newcomer. I am the Master Chef, Leo. It",
				"is here I will teach you how to cook food truely fit for a",
				"king."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"Hahahahahaha! You call THAT cooking? Some shrimp",
				"on an open fire log? Oh, no, no ,no. I am going to",
				"teach you the first art of cooking bread."
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"And no fine meal is complete without good music, so",
				"we'll cover that while you're in here too."
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