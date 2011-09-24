package com.netty.model.player.dialogue;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:33:37 AM
 */
public class DialogueChoice {

	/**
	 * 
	 */
	private String[] options;

	/**
	 * 
	 * @param options
	 * 			The id to set.
	 */
	public DialogueChoice(String[] options) {
		this.setOptions(options);
	}

	/**
	 * 
	 * @param options
	 * 			The id to set.
	 */
	public void setOptions(String[] options) {
		this.options = options;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String[] getOptions() {
		return this.options;
	}
}