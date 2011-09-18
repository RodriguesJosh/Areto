package com.netty.model.player.quest.dragonslayer;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class DragonSlayer extends Quest {

	public DragonSlayer(Player player, QuestStage questStage) {
		super("Dragon Slayer", player, questStage, QuestType.EXPERIENCED);
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