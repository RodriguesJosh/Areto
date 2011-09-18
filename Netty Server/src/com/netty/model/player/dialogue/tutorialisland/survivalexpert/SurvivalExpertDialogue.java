package com.netty.model.player.dialogue.tutorialisland.survivalexpert;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

public class SurvivalExpertDialogue {

	private Dialogue[] dialogues;

	public SurvivalExpertDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[2]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Hello there, newcomer. My name is Brynna. My job is",
				"to teach you a few survival tips and tricks. First off",
				"we're going to start with the most basic survival skill of",
				"all: making a fire."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"Well done! Next we need to get some food in our",
				"bellies. We'll need something to cook. There are shrimp",
				"in the pond there, so let's catch and cook some."
		});
		player.getDialogueList().addDialogues(this.getDialogues());
	}

	public void setDialogues(Dialogue[] dialogues) {
		this.dialogues = dialogues;
	}

	public Dialogue[] getDialogues() {
		return this.dialogues;
	}
}