package com.netty.model.player.quest.unstablefoundations;

import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:44:38 PM
 */
public class UnstableFoundations extends Quest {

	/**
	 * 
	 */
	private EscapeCellarLocation escapeCellarLocation;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param questStage
	 * 			The id to set.
	 */
	public UnstableFoundations(Player player, QuestStage questStage) {
		super("Unstable Foundations", player, questStage, QuestType.NOVICE);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.quest.Quest#rewards()
	 */
	@Override
	public int[][] rewards() {
		return new int[][] {
				{ 20000 } // Experience.. I hate multidimensional arrays so I'm going to find a better way.
		};
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.quest.Quest#getQuestPoints()
	 */
	@Override
	public int getQuestPoints() {
		return 1;
	}

	/**
	 * 
	 * @param escapeCellarLocation
	 * 			The id to set.
	 */
	public void setEscapeCellarLocation(EscapeCellarLocation escapeCellarLocation) {
		this.escapeCellarLocation = escapeCellarLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public EscapeCellarLocation getEscapeCellarLocation() {
		return this.escapeCellarLocation;
	}
}