package com.netty.model.player.dialogue.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.dialogue.Dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:37:01 AM
 */
public class ZombieHeadDialogue {

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
	public ZombieHeadDialogue(Player player, NPC npc) {
		this.setDialogues(new Dialogue[1]);
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"I'll never tell ye anything!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Ye've made some powerful enemies thanks te that",
				"inquisitive nose o' yours, " + player.getName() + ". I was sent here te",
				"eliminate ye on behalf o' the one most powerful."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Ye know of whom I speak, " + player.getName() + "! Captain of This",
				"Albatross, condemned to te depths by those friends a",
				"yourn. He's back to wreak his vengeance on all o' ye!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"Aye, " + player.getName() + ". Ye've caught his eye now, with all the",
				"trouble ye've been causing us."
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"I'm one o' many, " + player.getName() + ". Tell me how ye think Mos",
				"Le'Harmless will fare against an army o' us",
				"barrelchests!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"That's right! They be bein' made even as we speak!",
				"Ye're doomed! All doomed!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"I'll never tell ye', even through torture worse than ye've",
				"already given me!"
		});
		this.getDialogues()[0] = new Dialogue(player, npc, new String[] {
				"What? Ye can't be serious!"
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