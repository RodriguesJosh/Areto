package com.netty.model.player.guild;

import com.netty.model.item.Item;
import com.netty.model.player.quest.Quest;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 7:40:15 PM
 */
public abstract class Guild {

	/**
	 * 
	 * @return
	 * 			Returns the skill level to get.
	 */
	public abstract byte getSkillLevel();

	/**
	 * 
	 * @return
	 * 			Returns the quest points to get.
	 */
	public abstract short getQuestPoints();

	/**
	 * 
	 * @return
	 * 			Returns the Quests to get.
	 */
	public abstract Quest getQuest();

	/**
	 * 
	 * @return
	 * 			Returns the items to get.
	 */
	public abstract Item[] getItems();
}