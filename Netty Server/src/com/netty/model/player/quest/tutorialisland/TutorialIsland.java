package com.netty.model.player.quest.tutorialisland;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class TutorialIsland extends Quest {

	public TutorialIsland(Player player, QuestStage questStage) {
		super("Tutorial Island", player, questStage, QuestType.NOVICE);
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