package com.netty.model.player.cluescroll;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:25:14 AM
 */
public abstract class ClueScroll {

	/**
	 * 
	 */
	private ClueScrollLevel clueScrollLevel;

	/**
	 * 
	 * @param clueScrollLevel
	 * 			The id to set.
	 */
	public ClueScroll(ClueScrollLevel clueScrollLevel) {
		this.setClueScrollLevel(clueScrollLevel);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract String getClueMessage();

	/**
	 * 
	 * @param clueScrollLevel
	 * 			The id to set.
	 */
	public void setClueScrollLevel(ClueScrollLevel clueScrollLevel) {
		this.clueScrollLevel = clueScrollLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ClueScrollLevel getClueScrollLevel() {
		return this.clueScrollLevel;
	}
}