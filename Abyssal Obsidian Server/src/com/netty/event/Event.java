package com.netty.event;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 1:17:00 PM
 */
public class Event {

	/**
	 * 
	 */
	private long time;

	/**
	 * 
	 * @param time
	 * 			The time to set.
	 */
	public void setTime(long time) {
		this.time = time;
	}

	/**
	 * 
	 * @return time
	 * 			Returns the time to get.
	 */
	public long getTime() {
		return this.time;
	}
}
