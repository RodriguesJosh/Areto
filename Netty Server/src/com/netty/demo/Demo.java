package com.netty.demo;

import com.netty.model.Entity;
import com.netty.model.player.Character;
import com.netty.model.player.Player;
import com.netty.model.player.quest.unstablefoundations.Account;

/**
 * Creates a new <code>Demo</code> used
 * throughout the gameplay of the RuneScape
 * Netty Server. This is very much optional
 * because not everyone will want to play/try
 * it out.
 * @author Josh
 * @since 0.1
 */
public class Demo {

	/**
	 * The class used to represent a bunch
	 * of {@link Quest}s.
	 */
	private Quests quests;

	/**
	 * Indicates that an {@link Entity} is
	 * allowed to speak through your speakers.
	 */
	private Speechable speechable;

	/**
	 * Whether or not the {@link Player} is
	 * allowed to {@link Upgrade} his/her
	 * account to the full play of the RuneScape
	 * Netty Server.
	 */
	private Upgrade upgrade;

	/**
	 * Constructs a new <code>Demo</code> so that
	 * <code>Player</code>s are allowed to try
	 * the RSPS out without having to actually make
	 * a full in-game {@link Account}. Again, this
	 * is very much optional when it comes to playing.
	 * @param speechable
	 * 			Whether or not an <code>Entity</code>
	 * 			is allowed to speak when the <code>Object</code>
	 * 			is chatting via the chat box.
	 * @param upgrade
	 * 			Whether or not the <code>Player</code>
	 * 			is allowed to <code>Upgrade</code> his/her
	 * 			{@link Character} to a newly found adventure.
	 */
	public Demo(Speechable speechable, Upgrade upgrade) {
		this.setQuests(new Quests());
		this.setSpeechable(speechable);
		this.setUpgrade(upgrade);
	}

	public void setQuests(Quests quests) {
		this.quests = quests;
	}

	public Quests getQuests() {
		return this.quests;
	}

	public void setSpeechable(Speechable speechable) {
		this.speechable = speechable;
	}

	public Speechable getSpeechable() {
		return this.speechable;
	}

	public void setUpgrade(Upgrade upgrade) {
		this.upgrade = upgrade;
	}

	public Upgrade getUpgrade() {
		return this.upgrade;
	}
}
