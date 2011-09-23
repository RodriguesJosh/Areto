package com.netty.model.player.dialogue.randomevent.beekeeper;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:37:53 AM
 */
public class BeeKeeperDialogue {

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
	public BeeKeeperDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[10]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Ah, " + player.getName() + ". I'm sorry to drag you away like",
				"this, but I need some help building a new hive for my",
				"bees."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"All the components of the beehive are jumbled up.",
				"You've got to put them in the correct order for",
				"building a hive."
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"No, that doesn't look right. You have to put the",
				"components in the right order, otherwise it'll be no good",
				"as a beehive."
		});
		this.getDialogues()[3] = new Dialogue(player, npc, new String[] {
				"I'll let you have five more tries."
		});
		this.getDialogues()[4] = new Dialogue(player, npc, new String[] {
				"That's perfect! I'll get some bees moved in immediately."
		});
		this.getDialogues()[5] = new Dialogue(player, npc, new String[] {
				"Now, I'm sure I have something to offer you for",
				"all your help..."
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