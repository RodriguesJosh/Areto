package com.netty.game.model.entity.player.chat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:44:03 PM
 */
public enum ChatInputState {

	/**
	 * 
	 */
	NONE(null),

	/**
	 * 
	 */
	AMOUNT(""),

	/**
	 * 
	 */
	NAME("");

	/**
	 * 
	 */
	private String input;

	/**
	 * 
	 * @param input
	 * 			The id to set.
	 */
	private ChatInputState(String input) {
		this.setInput(input);
	}

	/**
	 * 
	 * @param input
	 * 			The id to set.
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getInput() {
		return this.input;
	}
}