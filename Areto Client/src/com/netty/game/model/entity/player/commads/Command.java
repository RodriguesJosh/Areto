package com.netty.game.model.entity.player.commads;

import com.netty.game.model.entity.player.Rank;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:46:54 PM
 */
public class Command {

	/**
	 * 
	 */
	private String command;

	/**
	 * 
	 */
	private Rank rank;

	/**
	 * 
	 * @param command
	 * 			The id to set.
	 * @param rank
	 * 			The id to set.
	 */
	public Command(String command, Rank rank) {
		this.setCommand(command);
		this.setRank(rank);
	}

	/**
	 * 
	 * @param command
	 * 			The id to set.
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getCommand() {
		return this.command;
	}

	/**
	 * 
	 * @param rank
	 * 			The id to set.
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Rank getRank() {
		return this.rank;
	}
}