package com.netty.net.packet.commands;

import com.netty.model.player.Rank;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:28:01 PM
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