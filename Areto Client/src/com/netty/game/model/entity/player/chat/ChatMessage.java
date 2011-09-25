package com.netty.game.model.entity.player.chat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:44:20 PM
 */
public class ChatMessage {

	/**
	 * 
	 */
	private ChatColor chatColor;

	/**
	 * 
	 */
	private ChatEffect chatEffect;

	/**
	 * 
	 * @param chatColor
	 * 			The id to set.
	 * @param chatEffect
	 * 			The id to set.
	 */
	public ChatMessage(ChatColor chatColor, ChatEffect chatEffect) {
		this.setChatColor(chatColor);
		this.setChatEffect(chatEffect);
	}

	/**
	 * 
	 * @param chatColor
	 * 			The id to set.
	 */
	public void setChatColor(ChatColor chatColor) {
		this.chatColor = chatColor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ChatColor getChatColor() {
		return this.chatColor;
	}

	/**
	 * 
	 * @param chatEffect
	 * 			The id to set.
	 */
	public void setChatEffect(ChatEffect chatEffect) {
		this.chatEffect = chatEffect;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ChatEffect getChatEffect() {
		return this.chatEffect;
	}
}