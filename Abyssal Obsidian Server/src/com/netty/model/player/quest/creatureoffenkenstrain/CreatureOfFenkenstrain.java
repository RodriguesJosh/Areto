package com.netty.model.player.quest.creatureoffenkenstrain;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:33:55 PM
 */
public class CreatureOfFenkenstrain extends Quest {

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 * @param questStage
	 * 			The id to set.
	 * @param questType
	 * 			The id to set.
	 */
	public CreatureOfFenkenstrain(String name, Player player, QuestStage questStage, QuestType questType) {
		super(name, player, questStage, questType);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.quest.Quest#rewards()
	 */
	@Override
	public int[][] rewards() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.quest.Quest#getQuestPoints()
	 */
	@Override
	public int getQuestPoints() {
		return 0;
	}
}