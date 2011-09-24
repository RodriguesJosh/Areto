package com.netty.lobby;

import java.util.List;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;
import com.netty.model.update.Chat;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 5:40:18 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public class FriendsChat {

	/**
	 * 
	 */
	private List<Chat> chatList;

	/**
	 * 
	 * 
	 * @param chatList
	 * 			The chat list to set.
	 */
	public void setChatList(List<Chat> chatList) {
		this.chatList = chatList;
	}

	/**
	 * 
	 * 
	 * @return chatList
	 */
	public List<Chat> getChatList() {
		return this.chatList;
	}
}