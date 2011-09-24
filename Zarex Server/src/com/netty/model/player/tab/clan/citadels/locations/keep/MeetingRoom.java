package com.netty.model.player.tab.clan.citadels.locations.keep;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 10:09:07 AM
 */
public class MeetingRoom {

	/**
	 * 
	 */
	private MeetingRoomType meetingRoomType;

	/**
	 * 
	 */
	private InvitationType invitationType;

	/**
	 * 
	 * @param meetingRoomType
	 * 			The meetingRoomType to set.
	 */
	public void setMeetingRoomType(MeetingRoomType meetingRoomType) {
		this.meetingRoomType = meetingRoomType;
	}

	/**
	 * 
	 * @return meetingRoomType
	 * 			Returns the meetingRoomType to get.
	 */
	public MeetingRoomType getMeetingRoomType() {
		return this.meetingRoomType;
	}

	/**
	 * 
	 * @param invitationType
	 * 			The invitationType to set.
	 */
	public void setInvitationType(InvitationType invitationType) {
		this.invitationType = invitationType;
	}

	/**
	 * 
	 * @return invitationType
	 * 			Returns the invitationType to get.
	 */
	public InvitationType getInvitationType() {
		return this.invitationType;
	}
}