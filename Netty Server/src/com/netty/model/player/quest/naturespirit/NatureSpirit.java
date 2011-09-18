package com.netty.model.player.quest.naturespirit;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class NatureSpirit extends Quest {

	public NatureSpirit(String name, Player player, QuestStage questStage, QuestType questType) {
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