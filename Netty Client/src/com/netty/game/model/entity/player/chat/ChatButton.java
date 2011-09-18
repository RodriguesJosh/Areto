package com.netty.game.model.entity.player.chat;

import com.netty.game.graphics.image.RGBImage;

public class ChatButton {

	private ChatButtonType chatButtonType;
	private RGBImage chatButtonRGBImage;

	public void setChatButtonType(ChatButtonType chatButtonType) {
		this.chatButtonType = chatButtonType;
	}

	public ChatButtonType getChatButtonType() {
		return this.chatButtonType;
	}

	public void setChatButtonRGBImage(RGBImage chatButtonRGBImage) {
		this.chatButtonRGBImage = chatButtonRGBImage;
	}

	public RGBImage getChatButtonRGBImage() {
		return this.chatButtonRGBImage;
	}
}