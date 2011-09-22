package com.netty.lobby;

import java.util.List;

import com.netty.model.update.Chat;

public class FriendsChat {

	private List<Chat> chatList;

	public void setChatList(List<Chat> chatList) {
		this.chatList = chatList;
	}

	public List<Chat> getChatList() {
		return this.chatList;
	}
}