package com.netty.model.player.quest.deserttreasure;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:31:59 PM
 */
public class DesertTreasure extends Quest {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param questStage
	 * 			The id to set.
	 */
	public DesertTreasure(Player player, QuestStage questStage) {
		super("Desert Treasure", player, questStage, QuestType.MASTER);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.quest.Quest#rewards()
	 */
	@Override
	public int[][] rewards() {
		return new int[][] {
				{ }
		};
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.quest.Quest#getQuestPoints()
	 */
	@Override
	public int getQuestPoints() {
		return 0;
	}
}