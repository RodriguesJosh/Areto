package com.netty.model.player.dialogue.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:36:27 AM
 */
public class EstateAgentDialogue {

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
	public EstateAgentDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[10]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"I'm just here to make sure the repairs are all satisfactory."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Yes, I heard all the commotion and sent out our",
				"repairmen. They should have restored everything in",
				"your house to the way it was before your little incident."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Cost you? Nothing at all! This is all on insurance!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Luckily for you, the standard player-owned house",
				"contents insurance policy was recently updated to",
				"include acts of zombio-mechanical piracy."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"In all honesty, no. I never thought it would happen, so",
				"I put it in to make the list of covered circumstances",
				"seem more attractive. So I took a gamble and lost on",
				"that one."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Ah, well. You can't win them all! Unfortunately, the",
				"insurance policy doesn't include removal of the",
				"perpetrator of the attack. You'll have to deal with him",
				"yourself."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"In that case, I shall bid you good day, and return to",
				"the office. I'll just be taking that delivery note. As",
				"evidence for your claim, you see."
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