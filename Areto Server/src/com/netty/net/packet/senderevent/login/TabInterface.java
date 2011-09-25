package com.netty.net.packet.senderevent.login;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:22:39 PM
 */
public class TabInterface {

	/**
	 * 
	 */
	private short interfaceID;

	/**
	 * 
	 * @param interfaceID
	 * 			The interface ID to set.
	 */
	public TabInterface(short interfaceID) {
		this.setInterfaceID(interfaceID);
	}

	/**
	 * 
	 * @param interfaceID
	 * 			The interfaceID to set.
	 */
	public void setInterfaceID(short interfaceID) {
		this.interfaceID = interfaceID;
	}

	/**
	 * 
	 * @return interfaceID
	 * 			Returns the interfaceID to get.
	 */
	public short getInterfaceID() {
		return this.interfaceID;
	}
}