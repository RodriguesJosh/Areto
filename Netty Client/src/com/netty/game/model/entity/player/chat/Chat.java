package com.netty.game.model.entity.player.chat;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.netty.game.graphics.image.RGBImage;

public class Chat {

	private ChatInputState chatInputState;
	private Queue<ChatMessage> chatMessageList;
	private RGBImage chatRGBImage;

	public Chat(ChatInputState chatInputState, RGBImage chatRGBImage) {
		this.setChatInputState(chatInputState);
		this.setChatMessageList((Queue<ChatMessage>) Collections.unmodifiableCollection(new ConcurrentLinkedQueue<ChatMessage>()));
		this.setChatRGBImage(chatRGBImage);
	}

	public void setChatInputState(ChatInputState chatInputState) {
		this.chatInputState = chatInputState;
	}

	public ChatInputState getChatInputState() {
		return this.chatInputState;
	}

	public void setChatMessageList(Queue<ChatMessage> chatMessageList) {
		this.chatMessageList = chatMessageList;
	}

	public Queue<ChatMessage> getChatMessageList() {
		return this.chatMessageList;
	}

	public RGBImage getChatRGBImage() {
		return this.chatRGBImage;
	}

	public void setChatRGBImage(RGBImage chatRGBImage) {
		this.chatRGBImage = chatRGBImage;
	}
}