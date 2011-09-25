package com.netty.model.player.tab;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:05:26 AM
 */
public class OptionsSettings {

	/**
	 * 
	 */
	private boolean isChatting;

	/**
	 * 
	 */
	private boolean isSplitPrivateChat;

	/**
	 * 
	 */
	private boolean isMouseButtons;

	/**
	 * 
	 */
	private boolean isAiding;

	/**
	 * 
	 */
	public OptionsSettings() {
		this.setChatting(true);
		this.setSplitPrivateChat(false);
		this.setMouseButtons(true);
		this.setAiding(false);
	}

	/**
	 * 
	 * @param isChatting
	 * 			The id to set.
	 */
	public void setChatting(boolean isChatting) {
		this.isChatting = isChatting;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isChatting() {
		return this.isChatting;
	}

	/**
	 * 
	 * @param isSplitPrivateChat
	 * 			The id to set.
	 */
	public void setSplitPrivateChat(boolean isSplitPrivateChat) {
		this.isSplitPrivateChat = isSplitPrivateChat;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isSplitPrivateChat() {
		return this.isSplitPrivateChat;
	}

	/**
	 * 
	 * @param isMouseButtons
	 * 			The id to set.
	 */
	public void setMouseButtons(boolean isMouseButtons) {
		this.isMouseButtons = isMouseButtons;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isMouseButtons() {
		return this.isMouseButtons;
	}

	/**
	 * 
	 * @param isAiding
	 * 			The id to set.
	 */
	public void setAiding(boolean isAiding) {
		this.isAiding = isAiding;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isAiding() {
		return this.isAiding;
	}
}