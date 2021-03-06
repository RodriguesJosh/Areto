package com.netty.model.player.quest.learningtheropes;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;
import com.netty.model.player.dialogue.DialogueList;
import com.netty.model.player.dialogue.tutorialisland.nemarti.NemartiDialogue;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 5:19:40 PM
 */
public class Nemarti extends CombatInstructor {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Nemarti(Player player) {
		NPC npc = World.getWorld().getNPCList().get(0);
		DialogueList dialogueList = new DialogueList(player);
		this.setNPC(npc);
		this.setDialogueList(dialogueList);
		NemartiDialogue nemartiDialogue = new NemartiDialogue();
		Dialogue[] dialogues = nemartiDialogue.getDialogues();
		this.getDialogueList().addDialogues(dialogues);
	}
}