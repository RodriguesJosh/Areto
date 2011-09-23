package com.netty.model.player.quest.blackknightsfortress;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 3:59:31 PM
 */
public class BlackKnightsFortress extends Quest {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param questStage
	 * 			The id to set.
	 */
	public BlackKnightsFortress(Player player, QuestStage questStage) {
		super("Black Knights Fortress", player, questStage, QuestType.NOVICE);
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