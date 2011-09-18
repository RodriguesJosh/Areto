package com.netty.model.player.quest.blackknightsfortress;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class BlackKnightsFortress extends Quest {

	public BlackKnightsFortress(Player player, QuestStage questStage) {
		super("Black Knights Fortress", player, questStage, QuestType.NOVICE);
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