package com.netty.model.player.tab.quest;

public class Quest {

	private String questName;
	private QuestType questType;

	public Quest(String questName, QuestType questType) {
		this.setQuestName(questName);
		this.setQuestType(questType);
	}

	public void setQuestName(String questName) {
		this.questName = questName;
	}

	public String getQuestName() {
		return this.questName;
	}

	public void setQuestType(QuestType questType) {
		this.questType = questType;
	}

	public QuestType getQuestType() {
		return this.questType;
	}
}