package com.netty.model.player.quest;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:13:50 PM
 */
public abstract class Quest {

	/**
	 * 
	 */
	private Player player;
	/**
	 * 
	 */
	private QuestStage questStage;
	/**
	 * 
	 */
	private QuestType questType;

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 * @param questStage
	 * 			The id to set.
	 * @param questType
	 * 			The id to set.
	 */
	public Quest(String name, Player player, QuestStage questStage, QuestType questType) {
		this.setPlayer(player);
		this.setQuestStage(questStage);
		this.setQuestType(questType);
		player.setAttribute(name, this);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract int[][] rewards();
	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract int getQuestPoints();

	/**
	 * 
	 * @param text
	 * 			The id to set.
	 */
	public void changeQuestType(String text) {
		if (this.getQuestStage() == QuestStage.NOT_STARTED) {
			this.getPlayer().getPacketSender().getText("@red@" + text, 0 /** Gotta' change this. */);
		} else if (this.getQuestStage() == QuestStage.STARTED) {
			this.getPlayer().getPacketSender().getText("@yel@" + text, 0 /** Gotta' change this. */);
		} else if (this.getQuestStage() == QuestStage.FINISHED) {
			this.getPlayer().getPacketSender().getText("@gre@" + text, 0 /** Gotta' change this. */);
		}
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * @param questStage
	 * 			The id to set.
	 */
	public void setQuestStage(QuestStage questStage) {
		this.questStage = questStage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public QuestStage getQuestStage() {
		return this.questStage;
	}

	/**
	 * 
	 * @param questType
	 * 			The id to set.
	 */
	public void setQuestType(QuestType questType) {
		this.questType = questType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public QuestType getQuestType() {
		return this.questType;
	}
}