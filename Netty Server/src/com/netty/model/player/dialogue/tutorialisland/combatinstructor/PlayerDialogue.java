package com.netty.model.player.dialogue.tutorialisland.combatinstructor;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

public class PlayerDialogue {

	private Dialogue[] dialogues;

	public PlayerDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[2]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Hi! My name's " + player.getName() + "."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"I did it! I killed a giant rat!"
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