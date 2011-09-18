package com.netty.model.player.dialogue.tutorialisland.magicinstructor;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

public class MagicInstructorDialogue {

	private Dialogue[] dialogues;

	public MagicInstructorDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[6]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Good day, newcomer. My name is Terrova. I'm here",
				"to tell you about Magic. Let's start by opening your",
				"spell list."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Good. This is a list of your spells. Currently you can",
				"only cast one offensive spell called Wind Strike. Let's",
				"try it out on one of those chickens.",
				"Here, take these combat runs."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"When you go to the mainland you find yourself in",
				"town of Lumbridge. If you want some ideas on",
				"where to go next, talk to my friend the Lumbridge",
				"Guide. You can't miss him, he's holding a big staff with"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"a question mark on the end. He also has a white beard",
				"and carries a rocksack full of scrolls. There are also",
				"many tutors willing to teach you about the many skills",
				"you could learn."
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