package com.netty.model.player.dialogue.tutorialisland.brotherbrace;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

public class PlayerDialogue {

	private Dialogue[] dialogues;

	public PlayerDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[3]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Good day brother, my name's " + player.getName() + "."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"Are there rules on in-game behavior?"
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"Okay, thanks. I'll keep that in mind."
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