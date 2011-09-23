package com.netty.model.player.quest.avoiddance;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 3:58:01 PM
 */
public class AVoidDance extends Quest {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param questStage
	 * 			The id to set.
	 */
	public AVoidDance(Player player, QuestStage questStage) {
		super("A Void Dance", player, questStage, QuestType.EXPERIENCED);
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