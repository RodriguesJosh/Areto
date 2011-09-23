package com.netty.model.player.quest.bloodpact;

import com.netty.model.npc.NPC;
import com.netty.model.player.dialogue.DialogueList;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 3:58:18 PM
 */
public class Xenia {

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private DialogueList dialogueList;

	/**
	 * 
	 * @param npc
	 * 			The id to set.
	 */
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public NPC getNPC() {
		return this.npc;
	}

	/**
	 * 
	 * @param dialogueList
	 * 			The id to set.
	 */
	public void setDialogueList(DialogueList dialogueList) {
		this.dialogueList = dialogueList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public DialogueList getDialogueList() {
		return this.dialogueList;
	}
}