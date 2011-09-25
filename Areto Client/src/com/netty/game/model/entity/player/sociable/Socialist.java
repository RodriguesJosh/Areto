package com.netty.game.model.entity.player.sociable;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:56:15 PM
 */
public class Socialist {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private SocialStatus socialStatus;

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public Socialist(String name) {
		this.setName(name);
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param socialStatus
	 * 			The socialStatus to set.
	 */
	public void setSocialStatus(SocialStatus socialStatus) {
		this.socialStatus = socialStatus;
	}

	/**
	 * 
	 * @return socialStatus
	 * 			Returns the socialStatus to get.
	 */
	public SocialStatus getSocialStatus() {
		return this.socialStatus;
	}
}