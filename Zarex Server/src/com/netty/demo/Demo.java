package com.netty.demo;

/**
 * Creates a new demo used throughout the
 * gameplay of the RuneScape Netty Server.
 * This is very much optional because not
 * everyone will want to play/try it out.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 5:25:51 PM
 */
public class Demo {

	/**
	 * The class used to represent a bunch
	 * of quests.
	 */
	private Quests quests;

	/**
	 * Indicates that an entity is allowed to
	 * speak through your speakers.
	 */
	private Speechable speechable;

	/**
	 * Whether or not the player is allowed to
	 * upgrade his/her account to the full play
	 * of the RuneScape Netty Server.
	 */
	private Upgrade upgrade;

	/**
	 * Constructs a new demo so that players are
	 * allowed to try the RSPS out without having
	 * to actually make a full in-game account. Again,
	 * this is very much optional when it comes to
	 * playing.
	 * 
	 * @param speechable
	 * 			Whether or not an entity is allowed
	 * 			to speak when the object is chatting
	 * 			via the chat box.
	 * @param upgrade
	 * 			Whether or not the player is allowed to
	 * 			upgrade his/her character to a newly found
	 * 			adventure.
	 */
	public Demo(Speechable speechable, Upgrade upgrade) {
		this.setQuests(new Quests());
		this.setSpeechable(speechable);
		this.setUpgrade(upgrade);
	}

	/**
	 * Sets the quests object for the amount
	 * of quests allowed.
	 * 
	 * @param quests
	 * 			The quests to set.
	 */
	public void setQuests(Quests quests) {
		this.quests = quests;
	}

	/**
	 * Gets the amount of quests allowed in
	 * the demo stage of the Netty Server.
	 * 
	 * @return quests
	 * 			Returns the amount of quests
	 * 			allowed in the demo.
	 */
	public Quests getQuests() {
		return this.quests;
	}

	/**
	 * Sets the speechable interface for NPCs to
	 * literally talk via headphones/speakers.
	 * 
	 * @param speechable
	 * 			The speechable to set.
	 */
	public void setSpeechable(Speechable speechable) {
		this.speechable = speechable;
	}

	/**
	 * Gets the speechable for an NPC to speak.
	 * 
	 * @return speechable
	 * 			Returns the speechable for the
	 * 			NPCs.
	 */
	public Speechable getSpeechable() {
		return this.speechable;
	}

	/**
	 * Sets the upgrading of the account for a specific
	 * player.
	 * 
	 * @param upgrade
	 * 			The upgrade to set.
	 */
	public void setUpgrade(Upgrade upgrade) {
		this.upgrade = upgrade;
	}

	/**
	 * Gets the upgrading of a player's account.
	 * 
	 * @return upgrade
	 * 			Returns the upgrading of the
	 * 			player's account.
	 */
	public Upgrade getUpgrade() {
		return this.upgrade;
	}
}