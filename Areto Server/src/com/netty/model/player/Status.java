package com.netty.model.player;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:21:04 AM
 */
public class Status {

	/**
	 * 
	 */
	private List<Player> bannedList;

	/**
	 * 
	 */
	private List<Player> mutedList;

	/**
	 * 
	 */
	public Status() {
		this.setBannedList(new ArrayList<Player>());
		this.setMutedList(new ArrayList<Player>());
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean isBanningPlayer(Player player) {
		return this.getBannedList().add(player);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean isUnbanningPlayer(Player player) {
		return this.getBannedList().remove(player);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean isMutingPlayer(Player player) {
		return this.getMutedList().add(player);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean isUnmutePlayer(Player player) {
		return this.getMutedList().remove(player);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean isBanned(Player player) {
		return this.getBannedList().contains(player);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean isMuted(Player player) {
		return this.getMutedList().contains(player);
	}

	/**
	 * 
	 * @param bannedList
	 * 			The id to set.
	 */
	public void setBannedList(List<Player> bannedList) {
		this.bannedList = bannedList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Player> getBannedList() {
		return this.bannedList;
	}

	/**
	 * 
	 * @param mutedList
	 * 			The id to set.
	 */
	public void setMutedList(List<Player> mutedList) {
		this.mutedList = mutedList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Player> getMutedList() {
		return this.mutedList;
	}
}