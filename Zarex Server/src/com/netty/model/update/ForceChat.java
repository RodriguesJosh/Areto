package com.netty.model.update;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:37:41 PM
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