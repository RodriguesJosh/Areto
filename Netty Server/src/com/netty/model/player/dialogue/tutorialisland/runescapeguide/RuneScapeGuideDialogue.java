package com.netty.model.player.dialogue.tutorialisland.runescapeguide;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

public class RuneScapeGuideDialogue {

	private Dialogue[] dialogues;

	public RuneScapeGuideDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[8]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Greetings! I see you are a new arrival to this land. My",
				"job is to welcome all new visitors. So welcome!"
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"You have already learned the first thing needed to",
				"succeed in this world: talking to other people!"
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"You will find many inhabitants of this world have useful",
				"things to say to you. By clicking on them with your",
				"mouse you can talk to them."
		});
		this.getDialogues()[3] = new Dialogue(player, npc, new String[] {
				"I would also suggest reading through some of the",
				"supporting information on the website. There you can",
				"find the Knowledge Base, which contains all the",
				"additional information you're ever likely to need. It also"
		});
		this.getDialogues()[4] = new Dialogue(player, npc, new String[] {
				"contains maps and helpful tips to help you on your",
				"journey."
		});
		this.getDialogues()[5] = new Dialogue(player, npc, new String[] {
				"You will notice a flashing icon of a spanner; please click",
				"on this continue the tutorial."
		});
		this.getDialogues()[6] = new Dialogue(player, npc, new String[] {
				"I'm glad you're making progress!"
		});
		this.getDialogues()[7] = new Dialogue(player, npc, new String[] {
				"To continue the tutorial go through the door over",
				"there and speak to your first instructor!"
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