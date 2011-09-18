package com.netty.model.player.dialogue;

public class DialogueChoice {

	private String[] options;

	public DialogueChoice(String[] options) {
		this.setOptions(options);
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String[] getOptions() {
		return this.options;
	}
}