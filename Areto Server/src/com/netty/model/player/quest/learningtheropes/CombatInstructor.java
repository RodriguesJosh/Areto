package com.netty.model.player.quest.learningtheropes;

import com.netty.model.npc.NPC;
import com.netty.model.player.dialogue.DialogueList;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 5:20:21 PM
 */
public class CombatInstructor {

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