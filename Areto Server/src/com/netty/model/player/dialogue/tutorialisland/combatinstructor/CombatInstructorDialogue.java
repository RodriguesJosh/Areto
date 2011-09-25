package com.netty.model.player.dialogue.tutorialisland.combatinstructor;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:39:05 AM
 */
public class CombatInstructorDialogue {

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
	public CombatInstructorDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[5]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Do I look like I care? To me you're just another",
				"newcomer who thinks they're ready to fight."
		});
		this.getDialogues()[1] = new Dialogue(player, npc, new String[] {
				"I am Vannaka, the greatest swordsman alive."
		});
		this.getDialogues()[2] = new Dialogue(player, npc, new String[] {
				"Very good, but that little butter knife isn't going to",
				"protect you much. Here take these."
		});
		this.getDialogues()[3] = new Dialogue(player, npc, new String[] {
				"I saw, " + player.getName() + ". You seem better at this than I",
				"thought. Now that you have graved basic swordplay,",
				"let's move on."
		});
		this.getDialogues()[4] = new Dialogue(player, npc, new String[] {
				"Let's try some range attacking, with this you can kill",
				"foes from a distance. Also, foes unable to teach you are",
				"as good as dead. You'll be able to attack the rats",
				"without entering the pit."
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