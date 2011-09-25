package com.netty.model.player.dialogue.tutorialisland.questguide;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:45:44 AM
 */
public class QuestGuideDialogue {

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
	public QuestGuideDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[6]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Ah. Welcome, adventurer. I'm here to tell you all about",
				"quests. Let's start by openning the quest side panel."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"Now you have the journal open I'll tell you a bit about",
				"it. At the moment all the quests are shown in red, which",
				"means you have not started them yet."
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"When you start a quest it will change colour to yellow,",
				"and to green when you've finished. This is so you can",
				"easily see what's complete, what's started and what's left",
				"to begin."
		});
		this.getDialogues()[3] = new Dialogue(player, npc, new String[] {
				"The start of quests are easy to find. Look out for the",
				"star icons on the minimap, just like the one you should",
				"see making my house."
		});
		this.getDialogues()[4] = new Dialogue(player, npc, new String[] {
				"The quests themselves can vary greatly from collecting",
				"beads to hunting down dragons. Generally quests are",
				"started by talking to a non-player character like me,",
				"and will involve a series of tasks."
		});
		this.getDialogues()[5] = new Dialogue(player, npc, new String[] {
				"There's not a lot more I can tell you about questing.",
				"You have to experience the thrill of it yourself to fully",
				"understand. You may find some adventure in the caves",
				"under my house."
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