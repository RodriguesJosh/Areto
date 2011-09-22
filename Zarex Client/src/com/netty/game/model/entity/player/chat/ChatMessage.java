package com.netty.game.model.entity.player.chat;

public class ChatMessage {

	private ChatColor chatColor;
	private ChatEffect chatEffect;

	public ChatMessage(ChatColor chatColor, ChatEffect chatEffect) {
		this.setChatColor(chatColor);
		this.setChatEffect(chatEffect);
	}

	public void setChatColor(ChatColor chatColor) {
		this.chatColor = chatColor;
	}

	public ChatColor getChatColor() {
		return this.chatColor;
	}

	public void setChatEffect(ChatEffect chatEffect) {
		this.chatEffect = chatEffect;
	}

	public ChatEffect getChatEffect() {
		return this.chatEffect;
	}
}