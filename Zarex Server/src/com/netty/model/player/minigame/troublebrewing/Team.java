package com.netty.model.player.minigame.troublebrewing;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:24:37 PM
 */
public abstract class Team {

	/**
	 * 
	 */
	private WaitingRoom waitingRoom;

	/**
	 * 
	 */
	public Team() {
		this.setWaitingRoom(new WaitingRoom());
	}

	/**
	 * 
	 * @param waitingRoom
	 * 			The id to set.
	 */
	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public WaitingRoom getWaitingRoom() {
		return this.waitingRoom;
	}
}