package com.netty.model.player.tab.clan.citadels.locations.keep;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 10:05:59 AM
 */
public class Keep {

	/**
	 * 
	 */
	private MeetingRoom meetingRoom;

	/**
	 * 
	 */
	private CitadelsPartyRoom citadelsPartyRoom;

	/**
	 * 
	 */
	private Costs costs;

	/**
	 * 
	 * @param meetingRoom
	 * 			The meetingRoom to set.
	 */
	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	/**
	 * 
	 * @return meetingRoom
	 * 			Returns the meetingRoom to get.
	 */
	public MeetingRoom getMeetingRoom() {
		return this.meetingRoom;
	}

	/**
	 * 
	 * @param citadelsPartyRoom
	 * 			The citadelsPartyRoom to set.
	 */
	public void setCitadelsPartyRoom(CitadelsPartyRoom citadelsPartyRoom) {
		this.citadelsPartyRoom = citadelsPartyRoom;
	}

	/**
	 * 
	 * @return citadelsPartyRoom
	 * 			Returns the citadelsPartyRoom to get.
	 */
	public CitadelsPartyRoom getCitadelsPartyRoom() {
		return this.citadelsPartyRoom;
	}

	/**
	 * 
	 * @param costs
	 * 			The costs to set.
	 */
	public void setCosts(Costs costs) {
		this.costs = costs;
	}

	/**
	 * 
	 * @return costs
	 * 			Returns the costs to get.
	 */
	public Costs getCosts() {
		return this.costs;
	}
}