package com.netty.model.player.quest.cooksassistant;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class CooksAssistant extends Quest {

	public CooksAssistant(Player player, QuestStage questStage) {
		super("Cooks Assistant", player, questStage, QuestType.NOVICE);
	}

	@Override
	public int[][] rewards() {
		return new int[][] {
				{ }
		};
	}

	@Override
	public int getQuestPoints() {
		return 0;
	}
}