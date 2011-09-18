package com.netty.model.player.quest.avoiddance;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class AVoidDance extends Quest {

	public AVoidDance(Player player, QuestStage questStage) {
		super("A Void Dance", player, questStage, QuestType.EXPERIENCED);
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