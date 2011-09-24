package com.netty.model.player.tab.clan.citadels.locations.welcomearea;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 10:05:53 AM
 */
public class WelcomeArea {

	/**
	 * 
	 */
	private Signpost signpost;

	/**
	 * 
	 */
	private Noticeboard noticeboard;

	/**
	 * 
	 * @param signpost
	 * 			The signpost to set.
	 */
	public void setSignpost(Signpost signpost) {
		this.signpost = signpost;
	}

	/**
	 * 
	 * @return signpost
	 * 			Returns the signpost to get.
	 */
	public Signpost getSignpost() {
		return this.signpost;
	}

	/**
	 * 
	 * @param noticeboard
	 * 			The noticeboard to set.
	 */
	public void setNoticeboard(Noticeboard noticeboard) {
		this.noticeboard = noticeboard;
	}

	/**
	 * 
	 * @return noticeboard
	 * 			Returns the noticeboard to get.
	 */
	public Noticeboard getNoticeboard() {
		return this.noticeboard;
	}
}