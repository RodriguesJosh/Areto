package com.netty.lobby;

import java.util.List;

import com.netty.model.update.Chat;

/**
 * A clan chat panel Object for the
 * lobby.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 5:22:00 PM
 */
public class ClanChat {

	/**
	 * A list of chatting for the clan chat
	 * you are in.
	 */
	private List<Chat> chatList;

	/**
	 * Sets the list of clan chat's chat.
	 * 
	 * @param chatList
	 * 			The chat list to set.
	 */
	public void setChatList(List<Chat> chatList) {
		this.chatList = chatList;
	}

	/**
	 * Gets the list of clan chat's chat.
	 * 
	 * @return chatList
	 * 			Returns a list of the clan's chat
	 * 			chat.
	 */
	public List<Chat> getChatList() {
		return this.chatList;
	}
}