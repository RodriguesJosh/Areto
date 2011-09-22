package com.netty.world;

public enum Revision {

	THREE_ONE_SEVEN((short) 317), FOUR_SEVEN_FOUR((short) 474), FIVE_OH_EIGHT((short) 508),
	FIVE_SIXTY_TWO((short) 562), SIX_OH_ONE((short) 601), SIX_FOURTEEN((short) 614),
	SIX_THIRTY_FOUR((short) 634);

	private short revisionID;

	private Revision(short revisionID) {
		this.setRevisionID(revisionID);
	}

	public void setRevisionID(short revisionID) {
		this.revisionID = revisionID;
	}

	public short getRevisionID() {
		return this.revisionID;
	}
}