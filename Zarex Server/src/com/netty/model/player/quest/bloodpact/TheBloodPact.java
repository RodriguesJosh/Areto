package com.netty.model.player.quest.bloodpact;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class TheBloodPact extends Quest {

	public TheBloodPact(String name, Player player, QuestStage questStage, QuestType questType) {
		super(name, player, questStage, questType);
	}

	@Override
	public int[][] rewards() {
		return new int[][] {

		};
	}

	@Override
	public int getQuestPoints() {
		return 0;
	}
}