package com.netty.model.player.dialogue.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:35:41 AM
 */
public class PlayerDialogue {

	/**
	 * 
	 */
	private Dialogue[] dialogues;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param npc
	 * 			The id to set.
	 */
	public PlayerDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[10]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Thanks, Pete!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"See you around!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"What are you doing here?"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Repairs?"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"How much is all this going to cost me?"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Is it that much of a widespread problem that the policy",
				"needs to include it?"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"That's fine. I was about to have a quiet word with him",
				"anyway..."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"That's fine, here, take it. Good day!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Who sent you? Why did you attack me and smash up",
				"my stuff?"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"We'll soon see about that!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Tell me what you know! Who sent you?"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Rabid Jack!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"..."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Where's the factory? Where are they being made?"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"And you're coming with me."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Now I need to go and warn Bill Teach before it's too",
				"late!"
		});
		player.getDialogueList().addDialogues(this.getDialogues());
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