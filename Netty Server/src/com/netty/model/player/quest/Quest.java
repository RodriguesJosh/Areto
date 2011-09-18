package com.netty.model.player.quest;

import com.netty.model.player.Player;

public abstract class Quest {

	private Player player;
	private QuestStage questStage;
	private QuestType questType;

	public Quest(String name, Player player, QuestStage questStage, QuestType questType) {
		this.setPlayer(player);
		this.setQuestStage(questStage);
		this.setQuestType(questType);
		player.setAttribute(name, this);
	}

	public abstract int[][] rewards();
	public abstract int getQuestPoints();

	public void changeQuestType(String text) {
		if (this.getQuestStage() == QuestStage.NOT_STARTED) {
			this.getPlayer().getPacketSender().getText("@red@" + text, 0 /** Gotta' change this. */);
		} else if (this.getQuestStage() == QuestStage.BUSY) {
			this.getPlayer().getPacketSender().getText("@yel@" + text, 0 /** Gotta' change this. */);
		} else if (this.getQuestStage() == QuestStage.FINISHED) {
			this.getPlayer().getPacketSender().getText("@gre@" + text, 0 /** Gotta' change this. */);
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setQuestStage(QuestStage questStage) {
		this.questStage = questStage;
	}

	public QuestStage getQuestStage() {
		return this.questStage;
	}

	public void setQuestType(QuestType questType) {
		this.questType = questType;
	}

	public QuestType getQuestType() {
		return this.questType;
	}
}