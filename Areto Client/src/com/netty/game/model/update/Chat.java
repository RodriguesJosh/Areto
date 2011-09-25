package com.netty.game.model.update;

import com.netty.game.model.entity.player.chat.ChatColor;
import com.netty.game.model.entity.player.chat.ChatEffect;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:04:24 PM
 */
public class Chat {

	/**
	 * 
	 */
	private String text;

	/**
	 * 
	 */
	private ChatEffect chatEffect;

	/**
	 * 
	 */
	private ChatColor chatColor;

	/**
	 * 
	 * @param text
	 * 			The id to set.
	 * @param chatEffect
	 * 			The id to set.
	 * @param chatColor
	 * 			The id to set.
	 */
	public Chat(String text, ChatEffect chatEffect, ChatColor chatColor) {
		this.setText(text);
		this.setChatEffect(chatEffect);
		this.setChatColor(chatColor);
	}

	/**
	 * 
	 * @param text
	 * 			The id to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * 
	 * @param chatEffect
	 * 			The chatEffect to set.
	 */
	public void setChatEffect(ChatEffect chatEffect) {
		this.chatEffect = chatEffect;
	}

	/**
	 * 
	 * @return chatEffect
	 * 			Returns the chatEffect to get.
	 */
	public ChatEffect getChatEffect() {
		return this.chatEffect;
	}

	/**
	 * 
	 * @param chatColor
	 * 			The chatColor to set.
	 */
	public void setChatColor(ChatColor chatColor) {
		this.chatColor = chatColor;
	}

	/**
	 * 
	 * @return chatColor
	 * 			Returns the chatColor to get.
	 */
	public ChatColor getChatColor() {
		return this.chatColor;
	}
}