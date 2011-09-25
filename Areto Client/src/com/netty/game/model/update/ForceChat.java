package com.netty.game.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:03:43 PM
 */
public class ForceChat {

	/**
	 * 
	 */
	private String forceText;

	/**
	 * 
	 * @param forceText
	 * 			The id to set.
	 */
	public ForceChat(String forceText) {
		this.setForceText(forceText);
	}

	/**
	 * 
	 * @param forceText
	 * 			The id to set.
	 */
	public void setForceText(String forceText) {
		this.forceText = forceText;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getForceText() {
		return this.forceText;
	}
}