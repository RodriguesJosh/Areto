package com.netty.game.model.entity.player.chat;

public enum ChatButtonType {

	PUBLIC, PRIVATE, TRADE_DUEL;

	private ChatButtonStatus chatButtonStatus;

	public void setChatButtonStatus(ChatButtonStatus chatButtonStatus) {
		this.chatButtonStatus = chatButtonStatus;
	}

	public ChatButtonStatus getChatButtonStatus() {
		return this.chatButtonStatus;
	}
}