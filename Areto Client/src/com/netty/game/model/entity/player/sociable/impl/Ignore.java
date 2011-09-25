package com.netty.game.model.entity.player.sociable.impl;

import com.netty.game.model.entity.player.sociable.Sociable;
import com.netty.game.model.entity.player.sociable.Socialist;
import com.netty.game.model.update.Chat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:59:43 PM
 */
public class Ignore extends Socialist implements Sociable {

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public Ignore(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.player.sociable.Sociable#addConversation(com.netty.game.model.update.Chat)
	 */
	@Override
	public boolean addConversation(Chat chat) {
		if (chat == null) {
			throw new NullPointerException();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.player.sociable.Sociable#removeConversation(com.netty.game.model.update.Chat)
	 */
	@Override
	public boolean removeConversation(Chat chat) {
		if (chat == null) {
			throw new NullPointerException();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.player.sociable.Sociable#addSocialist(com.netty.game.model.entity.player.sociable.Socialist)
	 */
	@Override
	public boolean addSocialist(Socialist socialist) {
		if (socialist == null) {
			throw new NullPointerException();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.player.sociable.Sociable#removeSocialist(com.netty.game.model.entity.player.sociable.Socialist)
	 */
	@Override
	public boolean removeSocialist(Socialist socialist) {
		if (socialist == null) {
			throw new NullPointerException();
		}
		return false;
	}
}