package com.netty.model.player.dialogue.tutorialisland.mininginstructor;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

public class MiningInstructorDialogue {

	private Dialogue[] dialogues;

	public MiningInstructorDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[10]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Hi there. You must be new around here. So what do I",
				"call you? 'Newcomer' seems so impersonal, and if we're",
				"going to be working together, I'd rather call you by",
				"name."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"Okay then, " + player.getName() + ". My name is Derrick and I'm a",
				"miner by trade. Let's prospect some of those rocks."
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"Absolutely right, " + player.getName() + ". These two ore types can",
				"be smelted together to make bronze."
		});
		this.getDialogues()[3] = new Dialogue(player, npc, new String[] {
				"So now that you know what ore is in the rocks over there",
				"why don't you have a go at mining some tin and",
				"copper? Here, you'll need this to start with."
		});
		this.getDialogues()[4] = new Dialogue(player, npc, new String[] {
				"Okay. I'll show you how to make a dagger out of it.",
				"You'll be needing this..."
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