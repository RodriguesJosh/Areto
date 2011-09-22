package com.netty.model.player.dialogue.tutorialisland.mininginstructor;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

public class PlayerDialogue {

	private Dialogue[] dialogues;

	public PlayerDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[2]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"You can call me " + player.getName() + "."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"I prospected both types of rock! One set contains tin",
				"and the other has copper ore inside."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"How do I make a weapon out of this?"
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