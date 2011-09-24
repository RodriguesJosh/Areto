package com.netty.model.player.tab.quest;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:14:07 AM
 */
public class Quest {

	/**
	 * 
	 */
	private String questName;

	/**
	 * 
	 */
	private QuestType questType;

	/**
	 * 
	 * @param questName
	 * 			The id to set.
	 * @param questType
	 * 			The id to set.
	 */
	public Quest(String questName, QuestType questType) {
		this.setQuestName(questName);
		this.setQuestType(questType);
	}

	/**
	 * 
	 * @param questName
	 * 			The id to set.
	 */
	public void setQuestName(String questName) {
		this.questName = questName;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getQuestName() {
		return this.questName;
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