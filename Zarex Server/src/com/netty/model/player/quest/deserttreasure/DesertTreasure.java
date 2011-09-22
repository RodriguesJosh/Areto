package com.netty.model.player.quest.deserttreasure;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class DesertTreasure extends Quest {

	public DesertTreasure(Player player, QuestStage questStage) {
		super("Desert Treasure", player, questStage, QuestType.MASTER);
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