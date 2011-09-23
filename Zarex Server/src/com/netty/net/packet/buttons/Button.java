package com.netty.net.packet.buttons;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:38:17 PM
 */
public class Button {

	/**
	 * 
	 */
	private short id;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public Button(short id) {
		this.setID(id);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(short id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public short getID() {
		return this.id;
	}
}