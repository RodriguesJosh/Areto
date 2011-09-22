package com.netty.game.model.entity.player.commads;

import com.netty.game.model.entity.player.Rank;

public class Command {

	private String command;
	private Rank rank;

	public Command(String command, Rank rank) {
		this.setCommand(command);
		this.setRank(rank);
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getCommand() {
		return this.command;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Rank getRank() {
		return this.rank;
	}
}