package com.netty.model.player.quest.learningtheropes;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class LearningTheRopes extends Quest {

	public LearningTheRopes(Player player, QuestStage questStage) {
		super("Learning the Ropes", player, questStage, QuestType.NOVICE);
	}

	@Override
	public int[][] rewards() {
		return null;
	}

	@Override
	public int getQuestPoints() {
		return 0;
	}
}