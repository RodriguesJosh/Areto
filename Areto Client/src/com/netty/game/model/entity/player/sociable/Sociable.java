package com.netty.game.model.entity.player.sociable;

import com.netty.game.model.update.Chat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:56:32 PM
 */
public interface Sociable {

	/**
	 * 
	 * @param chat
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean addConversation(Chat chat);

	/**
	 * 
	 * @param chat
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean removeConversation(Chat chat);

	/**
	 * 
	 * @param socialist
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean addSocialist(Socialist socialist);

	/**
	 * 
	 * @param socialist
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean removeSocialist(Socialist socialist);
}