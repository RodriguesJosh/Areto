package com.netty.model.player.quest.priestinperil;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class PriestInPeril extends Quest {

	public PriestInPeril(Player player, QuestStage questStage) {
		super("Priest in Peril", player, questStage, QuestType.NOVICE);
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