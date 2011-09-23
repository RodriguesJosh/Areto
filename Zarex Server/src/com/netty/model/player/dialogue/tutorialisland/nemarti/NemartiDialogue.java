package com.netty.model.player.dialogue.tutorialisland.nemarti;

import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:45:50 AM
 */
public class NemartiDialogue {

	/**
	 * 
	 */
	private Dialogue[] dialogues;

	/**
	 * 
	 */
	public NemartiDialogue() {
		this.setDialogues(new Dialogue[10]);
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