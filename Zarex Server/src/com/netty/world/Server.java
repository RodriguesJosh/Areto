package com.netty.world;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:59:07 AM
 */
public class Server {

	/**
	 * 
	 */
	private byte updateSeconds;

	/**
	 * 
	 * @param updateSeconds
	 * 			The id to set.
	 */
	public Server(byte updateSeconds) {
		this.setUpdateSeconds(updateSeconds);
	}

	/**
	 * 
	 * @param updateSeconds
	 * 			The id to set.
	 */
	public void setUpdateSeconds(byte updateSeconds) {
		if (updateSeconds > 60) {
			return;
		}
		this.updateSeconds = updateSeconds;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getUpdateSeconds() {
		return this.updateSeconds;
	}
}