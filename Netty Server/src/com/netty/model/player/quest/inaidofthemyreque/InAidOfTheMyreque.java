package com.netty.model.player.quest.inaidofthemyreque;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class InAidOfTheMyreque extends Quest {

	public InAidOfTheMyreque(String name, Player player, QuestStage questStage, QuestType questType) {
		super(name, player, questStage, questType);
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