package com.netty.model.player.quest.unstablefoundations;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

public class UnstableFoundations extends Quest {

	private EscapeCellarLocation escapeCellarLocation;

	public UnstableFoundations(Player player, QuestStage questStage) {
		super("Unstable Foundations", player, questStage, QuestType.NOVICE);
	}

	@Override
	public int[][] rewards() {
		return new int[][] {
				{ 20000 } // Experience.. I hate multidimensional arrays so I'm going to find a better way.
		};
	}

	@Override
	public int getQuestPoints() {
		return 1;
	}

	public void setEscapeCellarLocation(EscapeCellarLocation escapeCellarLocation) {
		this.escapeCellarLocation = escapeCellarLocation;
	}

	public EscapeCellarLocation getEscapeCellarLocation() {
		return this.escapeCellarLocation;
	}
}