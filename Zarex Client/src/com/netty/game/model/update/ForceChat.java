package com.netty.game.model.update;

public class ForceChat {

	private String forceText;

	public ForceChat(String forceText) {
		this.setForceText(forceText);
	}

	public void setForceText(String forceText) {
		this.forceText = forceText;
	}

	public String getForceText() {
		return this.forceText;
	}
}