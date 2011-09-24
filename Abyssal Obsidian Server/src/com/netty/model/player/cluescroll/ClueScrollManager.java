package com.netty.model.player.cluescroll;

import java.util.List;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:25:45 AM
 */
public class ClueScrollManager {

	/**
	 * 
	 */
	private List<ClueScroll> clueScrollList;

	/**
	 * 
	 * @param clueScrollList
	 * 			The clueScrollList to set.
	 */
	public void setClueScrollList(List<ClueScroll> clueScrollList) {
		this.clueScrollList = clueScrollList;
	}

	/**
	 * 
	 * @return clueScrollList
	 * 			Returns the clueScrollList to get.
	 */
	public List<ClueScroll> getClueScrollList() {
		return this.clueScrollList;
	}
}