package com.netty.model.player.dialogue.tutorialisland.brotherbrace;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:38:47 AM
 */
public class BrotherBraceDialogue {

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
	public BrotherBraceDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[10]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Hello, " + player.getName() + ". I'm Brother Brace. I'm here to tell",
				"you all about Prayer."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"This is your Prayer list. Prayer can help a lot in",
				"combat. Click on the Prayer you wish to use to activate",
				"it, and click it again to deactivate it."
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"Activate Prayers will drain your Prayer points, which",
				"you can recharge by finding an altar or a holy spot",
				"and praying these."
		});
		this.getDialogues()[3] = new Dialogue(player, npc, new String[] {
				"As you noticed, most enemies will drop bones when",
				"defeated. Burying bones by clicking them in your",
				"inventory will give you Prayer experience."
		});
		this.getDialogues()[4] = new Dialogue(player, npc, new String[] {
				"I'm also the community officer 'round here so it's my",
				"job to tell you about your friends and ignore list."
		});
		this.getDialogues()[5] = new Dialogue(player, npc, new String[] {
				"Good, now you have both menus open. I'll tell you a",
				"little about each. You can add people to either list by",
				"clicking the add button then typing their name into the",
				"box that appears."
		});
		this.getDialogues()[6] = new Dialogue(player, npc, new String[] {
				"You remove people from the lists in the same way. If",
				"you add someone to your ignore list they will not be",
				"able to talk to you or send any form of message to",
				"you."
		});
		this.getDialogues()[7] = new Dialogue(player, npc, new String[] {
				"Yes, you should read the rules of conduct on the",
				"website to make sure you do nothing to get yourself",
				"banned."
		});
		this.getDialogues()[8] = new Dialogue(player, npc, new String[] {
				"But in general, always try to be courteous to other",
				"players - remember the people in the game are real",
				"people with feelings."
		});
		this.getDialogues()[9] = new Dialogue(player, npc, new String[] {
				"If you go 'round abusing or causing trouble, your",
				"character could end up being the one in trouble."
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