package com.netty.demo;

import com.netty.model.player.quest.Quest;

/**
 * A class to represent the amount
 * of {@link Quest}s allowed in the
 * {@link Demo} part of the RuneScape
 * game.
 * @author Josh
 * @since 0.1
 */
public class Quests {

	/**
	 * An array of full of <code>Quest</code>s
	 * to play for the <code>Demo</code> stage of
	 * the game.
	 */
	private Quest[] quests;

	/**
	 * Constructs a new set of <code>Quest</code>s
	 * to play.
	 */
	public Quests() {
		this.setQuests(new Quest[] {

		});
	}

	/**
	 * Creates a new array filled with
	 * <code>Quest</code>s to fullfill
	 * @param quests
	 * 			The quests that you'll be playing
	 * 			throughout the <code>Demo</code>.
	 */
	public void setQuests(Quest[] quests) {
		this.quests = quests;
	}

	/**
	 * Returns the amount of quests and only
	 * a limited amount seeing how you're not
	 * allowed to go play all of them.
	 * @return quests
	 * 			The amount of quests to play.
	 */
	public Quest[] getQuests() {
		return this.quests;
	}
}