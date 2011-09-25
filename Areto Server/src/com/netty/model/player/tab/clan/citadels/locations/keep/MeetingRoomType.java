package com.netty.model.player.tab.clan.citadels.locations.keep;

import java.util.Deque;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 10:09:18 AM
 */
public enum MeetingRoomType {

	/**
	 * 
	 */
	LARGE_TENT,

	/**
	 * 
	 */
	FIRST_SMALL_ROOM,

	/**
	 * 
	 */
	SECOND_SMALL_ROOM,

	/**
	 * 
	 */
	SENATE;

	/**
	 * 
	 */
	private Deque<Player> playerList;

	/**
	 * 
	 */
	private MeetingAccess meetingAccess;

	/**
	 * 
	 * @param playerList
	 * 			The playerList to set.
	 */
	public void setPlayerList(Deque<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * 
	 * @return playerList
	 * 			Returns the playerList to get.
	 */
	public Deque<Player> getPlayerList() {
		return this.playerList;
	}

	/**
	 * 
	 * @param meetingAccess
	 * 			The meetingAccess to set.
	 */
	public void setMeetingAccess(MeetingAccess meetingAccess) {
		this.meetingAccess = meetingAccess;
	}

	/**
	 * 
	 * @return meetingAccess
	 * 			Returns the meetingAccess to get.
	 */
	public MeetingAccess getMeetingAccess() {
		return this.meetingAccess;
	}
}