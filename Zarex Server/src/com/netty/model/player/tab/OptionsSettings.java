package com.netty.model.player.tab;

public class OptionsSettings {

	private boolean isChatting;
	private boolean isSplitPrivateChat;
	private boolean isMouseButtons;
	private boolean isAiding;

	public OptionsSettings() {
		this.setChatting(true);
		this.setSplitPrivateChat(false);
		this.setMouseButtons(true);
		this.setAiding(false);
	}

	public void setChatting(boolean isChatting) {
		this.isChatting = isChatting;
	}

	public boolean isChatting() {
		return this.isChatting;
	}

	public void setSplitPrivateChat(boolean isSplitPrivateChat) {
		this.isSplitPrivateChat = isSplitPrivateChat;
	}

	public boolean isSplitPrivateChat() {
		return this.isSplitPrivateChat;
	}

	public void setMouseButtons(boolean isMouseButtons) {
		this.isMouseButtons = isMouseButtons;
	}

	public boolean isMouseButtons() {
		return this.isMouseButtons;
	}

	public void setAiding(boolean isAiding) {
		this.isAiding = isAiding;
	}

	public boolean isAiding() {
		return this.isAiding;
	}
}