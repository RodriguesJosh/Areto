package com.netty.game.model.entity.player.chat;

public enum ChatInputState {

	NONE(null), AMOUNT(""), NAME("");

	private String input;

	private ChatInputState(String input) {
		this.setInput(input);
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getInput() {
		return this.input;
	}
}