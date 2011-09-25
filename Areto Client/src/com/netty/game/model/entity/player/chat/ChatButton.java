package com.netty.game.model.entity.player.chat;

import com.netty.game.graphics.image.RGBImage;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:42:16 PM
 */
public class ChatButton {

	/**
	 * 
	 */
	private ChatButtonType chatButtonType;

	/**
	 * 
	 */
	private RGBImage chatButtonRGBImage;

	/**
	 * 
	 * @param chatButtonType
	 * 			The id to set.
	 */
	public void setChatButtonType(ChatButtonType chatButtonType) {
		this.chatButtonType = chatButtonType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ChatButtonType getChatButtonType() {
		return this.chatButtonType;
	}

	/**
	 * 
	 * @param chatButtonRGBImage
	 * 			The id to set.
	 */
	public void setChatButtonRGBImage(RGBImage chatButtonRGBImage) {
		this.chatButtonRGBImage = chatButtonRGBImage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RGBImage getChatButtonRGBImage() {
		return this.chatButtonRGBImage;
	}
}