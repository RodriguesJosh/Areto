package com.netty.model.player.dialogue.tutorialisland.nemarti;

import com.netty.model.player.dialogue.Dialogue;

public class NemartiDialogue {

	private Dialogue[] dialogues;

	public NemartiDialogue() {
		this.setDialogues(new Dialogue[10]);
	}

	public void setDialogues(Dialogue[] dialogues) {
		this.dialogues = dialogues;
	}

	public Dialogue[] getDialogues() {
		return this.dialogues;
	}
}