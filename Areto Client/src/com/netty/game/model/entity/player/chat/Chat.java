package com.netty.game.model.entity.player.chat;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.netty.game.graphics.image.RGBImage;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:41:52 PM
 */
public class Chat {

	/**
	 * 
	 */
	private ChatInputState chatInputState;

	/**
	 * 
	 */
	private Queue<ChatMessage> chatMessageList;

	/**
	 * 
	 */
	private RGBImage chatRGBImage;

	/**
	 * 
	 * @param chatInputState
	 * 			The id to set.
	 * @param chatRGBImage
	 * 			The id to set.
	 */
	public Chat(ChatInputState chatInputState, RGBImage chatRGBImage) {
		this.setChatInputState(chatInputState);
		this.setChatMessageList((Queue<ChatMessage>) Collections.unmodifiableCollection(new ConcurrentLinkedQueue<ChatMessage>()));
		this.setChatRGBImage(chatRGBImage);
	}

	/**
	 * 
	 * @param chatInputState
	 * 			The id to set.
	 */
	public void setChatInputState(ChatInputState chatInputState) {
		this.chatInputState = chatInputState;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ChatInputState getChatInputState() {
		return this.chatInputState;
	}

	/**
	 * 
	 * @param chatMessageList
	 * 			The id to set.
	 */
	public void setChatMessageList(Queue<ChatMessage> chatMessageList) {
		this.chatMessageList = chatMessageList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Queue<ChatMessage> getChatMessageList() {
		return this.chatMessageList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RGBImage getChatRGBImage() {
		return this.chatRGBImage;
	}

	/**
	 * 
	 * @param chatRGBImage
	 * 			The id to set.
	 */
	public void setChatRGBImage(RGBImage chatRGBImage) {
		this.chatRGBImage = chatRGBImage;
	}
}