package com.netty.model.player.dialogue.tutorialisland.financialadvisor;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:42:18 AM
 */
public class FinancialAdvisorDialogue {

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
	public FinancialAdvisorDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[6]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"I'm the Financial Advisor. I'm here to tell people how to",
				"make money."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"How you can make money? Quite."
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"Well, there are three basic ways of making money here:",
				"combat, quests and trading. I will talk to you through each",
				"of them very quickly."
		});
		this.getDialogues()[3] = new Dialogue(player, npc, new String[] {
				"Now, the next way to earn money quickly is by quests.",
				"Many people on RuneScape have things they need",
				"doing, which they will reward you for."
		});
		this.getDialogues()[4] = new Dialogue(player, npc, new String[] {
				"By getting a high level in skills such as Cooking, Mining,",
				"Smithing or Fishing, you can create or catch your own",
				"items and sell them for pure profit."
		});
		this.getDialogues()[5] = new Dialogue(player, npc, new String[] {
				"Well, that about covers it. Come back if you'd like to go",
				"over this again."
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