package com.netty.model.player.dialogue.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:36:43 AM
 */
public class PostiePeteDialogue {

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
	public PostiePeteDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[1]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"I've delivered a package to your player-owned house.",
				"The delivery note is stuck to the player-owned house",
				"portal!"
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