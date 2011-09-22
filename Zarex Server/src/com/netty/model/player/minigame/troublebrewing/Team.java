package com.netty.model.player.minigame.troublebrewing;

public abstract class Team {

	private WaitingRoom waitingRoom;

	public Team() {
		this.setWaitingRoom(new WaitingRoom());
	}

	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	public WaitingRoom getWaitingRoom() {
		return this.waitingRoom;
	}
}