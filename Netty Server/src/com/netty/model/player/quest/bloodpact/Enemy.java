package com.netty.model.player.quest.bloodpact;

import com.netty.model.npc.NPC;
import com.netty.model.player.dialogue.DialogueList;

public class Enemy {

	private NPC npc;
	private DialogueList dialogueList;

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	public void setDialogueList(DialogueList dialogueList) {
		this.dialogueList = dialogueList;
	}

	public DialogueList getDialogueList() {
		return this.dialogueList;
	}
}