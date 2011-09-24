package com.netty.model.player.quest.dragonslayer;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:28:21 PM
 */
public class DragonSlayer extends Quest {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param questStage
	 * 			The id to set.
	 */
	public DragonSlayer(Player player, QuestStage questStage) {
		super("Dragon Slayer", player, questStage, QuestType.EXPERIENCED);
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