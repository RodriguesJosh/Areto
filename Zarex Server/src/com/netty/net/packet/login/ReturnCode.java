package com.netty.net.packet.login;

public enum ReturnCode {

	INVALID_USER_PASS((byte) 3), LOGIN((byte) 2), ALREADY_LOGGED_IN((byte) 5), NO_ACCOUNT((byte) 12);

	private byte returnID;

	private ReturnCode(byte returnID) {
		this.setReturnID(returnID);
	}

	public void setReturnID(byte returnID) {
		this.returnID = returnID;
	}

	public byte getReturnID() {
		return this.returnID;
	}
}