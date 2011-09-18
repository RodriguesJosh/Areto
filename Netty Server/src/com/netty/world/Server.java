package com.netty.world;

public class Server {

	private byte updateSeconds;

	public Server(byte updateSeconds) {
		this.setUpdateSeconds(updateSeconds);
	}

	public void setUpdateSeconds(byte updateSeconds) {
		if (updateSeconds > 60) {
			return;
		}
		this.updateSeconds = updateSeconds;
	}

	public byte getUpdateSeconds() {
		return this.updateSeconds;
	}
}