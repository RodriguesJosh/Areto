package com.netty.model.player;

import java.util.ArrayList;
import java.util.List;

public class Status {

	private List<Player> bannedList;
	private List<Player> mutedList;

	public Status() {
		this.setBannedList(new ArrayList<Player>());
		this.setMutedList(new ArrayList<Player>());
	}

	public boolean isBanningPlayer(Player player) {
		return this.getBannedList().add(player);
	}

	public boolean isUnbanningPlayer(Player player) {
		return this.getBannedList().remove(player);
	}

	public boolean isMutingPlayer(Player player) {
		return this.getMutedList().add(player);
	}

	public boolean isUnmutePlayer(Player player) {
		return this.getMutedList().remove(player);
	}

	public boolean isBanned(Player player) {
		return this.getBannedList().contains(player);
	}

	public boolean isMuted(Player player) {
		return this.getMutedList().contains(player);
	}

	public void setBannedList(List<Player> bannedList) {
		this.bannedList = bannedList;
	}

	public List<Player> getBannedList() {
		return this.bannedList;
	}

	public void setMutedList(List<Player> mutedList) {
		this.mutedList = mutedList;
	}

	public List<Player> getMutedList() {
		return this.mutedList;
	}
}