package com.netty.game.model.entity.player.chat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:42:44 PM
 */
public enum ChatButtonType {

	/**
	 * 
	 */
	PUBLIC,

	/**
	 * 
	 */
	PRIVATE,

	/**
	 * 
	 */
	TRADE_DUEL;

	/**
	 * 
	 */
	private ChatButtonStatus chatButtonStatus;

	/**
	 * 
	 * @param chatButtonStatus
	 * 			The id to set.
	 */
	public void setChatButtonStatus(ChatButtonStatus chatButtonStatus) {
		this.chatButtonStatus = chatButtonStatus;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ChatButtonStatus getChatButtonStatus() {
		return this.chatButtonStatus;
	}
}