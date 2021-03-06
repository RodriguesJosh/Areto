package com.netty.model.player.dialogue;

import java.util.LinkedList;
import java.util.Queue;

import com.netty.model.Entity;
import com.netty.model.npc.NPC;
import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:34:57 AM
 */
public class DialogueList {

	/**
	 * 
	 */
	private Entity entity;

	/**
	 * 
	 */
	private Queue<Dialogue> dialogueList;

	/**
	 * 
	 * @param entity
	 * 			The id to set.
	 */
	public DialogueList(Entity entity) {
		this.setEntity(entity);
		this.setDialogueList(new LinkedList<Dialogue>());
	}

	/**
	 * 
	 * @param dialogue
	 * 			The id to set.
	 */
	public void addDialogue(Dialogue dialogue) {
		if (dialogue == null) {
			return;
		}
		if (this.getDialogueList().add(dialogue)) {
			this.showDialogue(this.getDialogueList().remove());
		}
	}

	/**
	 * 
	 * @param dialogues
	 * 			The id to set.
	 */
	public void addDialogues(Dialogue[] dialogues) {
		if (dialogues == null) {
			return;
		}
		for (Dialogue dialogue : dialogues) {
			this.getDialogueList().add(dialogue);
		}
		this.showDialogue(this.getDialogueList().poll());
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Dialogue getNextDialogue() {
		Dialogue nextDialogue = this.getDialogueList().poll();
		if (nextDialogue == null) {
			return null;
		}
		this.showDialogue(nextDialogue);
		return nextDialogue;
	}

	/**
	 * 
	 * @param dialogue
	 * 			The id to set.
	 */
	public void showDialogue(Dialogue dialogue) {
		if (dialogue == null) {
			return;
		}
		String[] parts = dialogue.getText();
		byte text = (byte) parts.length;
		if ((text < 1) || (text > 5)) {
			return;
		}
		String firstPart = parts[0];
		String secondPart = parts[1];
		String thirdPart = parts[2];
		String fourthPart = parts[3];
		switch (text) {
			case 0:
				break;
			case 1:
				if (this.getEntity() instanceof NPC) {
					((Player) this.getEntity()).getPacketSender().getNPCTalk(firstPart, this.getEntity().getID(), this.getEntity().getName());
				} else if (this.getEntity() instanceof Player) {
					((Player) this.getEntity()).getPacketSender().playerTalk(firstPart);
				}
				break;
			case 2:
				if (this.getEntity() instanceof NPC) {
					((Player) this.getEntity()).getPacketSender().getNPCTalk(firstPart, secondPart, this.getEntity().getID(), this.getEntity().getName());
				} else if (this.getEntity() instanceof Player) {
					((Player) this.getEntity()).getPacketSender().playerTalk(firstPart, secondPart);
				}
				break;
			case 3:
				if (this.getEntity() instanceof NPC) {
					((Player) this.getEntity()).getPacketSender().getNPCTalk(firstPart, secondPart, thirdPart, this.getEntity().getID(), this.getEntity().getName());
				} else if (this.getEntity() instanceof Player) {
					((Player) this.getEntity()).getPacketSender().getPlayerTalk(firstPart, secondPart, thirdPart);
				}
				break;
			case 4:
				if (this.getEntity() instanceof NPC) {
					((Player) this.getEntity()).getPacketSender().getNPCTalk(firstPart, secondPart, thirdPart, fourthPart, this.getEntity().getID(), this.getEntity().getName());
				} else if (this.getEntity() instanceof Player) {
					((Player) this.getEntity()).getPacketSender().getPlayerTalk(firstPart, secondPart, thirdPart, fourthPart);
				}
				break;
		}
	}

	/**
	 * 
	 * @param entity
	 * 			The id to set.
	 */
	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Entity getEntity() {
		return this.entity;
	}

	/**
	 * 
	 * @param dialogueList
	 * 			The id to set.
	 */
	public void setDialogueList(Queue<Dialogue> dialogueList) {
		this.dialogueList = dialogueList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Queue<Dialogue> getDialogueList() {
		return this.dialogueList;
	}
}