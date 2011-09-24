package com.netty.model.player.tab.clan.citadels.interfaces;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:37:45 PM
 */
public abstract class CitadelsInterface {

	/**
	 * 
	 */
	private byte daysLeft;

	/**
	 * 
	 */
	private byte hoursLeft;

	/**
	 * 
	 */
	private byte minutesLeft;

	/**
	 * 
	 */
	private byte clanMembers;

	/**
	 * 
	 * 
	 * @param daysLeft
	 * 			The days left.
	 * @param hoursLeft
	 * 			The hours left.
	 * @param minutesLeft
	 * 			The minutes left.
	 * @param clanMembers
	 * 			The clan members in the citadel.
	 */
	public CitadelsInterface(byte daysLeft, byte hoursLeft, byte minutesLeft, byte clanMembers) {
		this.setDaysLeft(daysLeft);
		this.setHoursLeft(hoursLeft);
		this.setMinutesLeft(minutesLeft);
		this.setClanMembers(clanMembers);
	}

	/**
	 * 
	 * @param daysLeft
	 * 			The daysLeft to set.
	 */
	public void setDaysLeft(byte daysLeft) {
		this.daysLeft = daysLeft;
	}

	/**
	 * 
	 * @return daysLeft
	 * 			Returns the daysLeft to get.
	 */
	public byte getDaysLeft() {
		return this.daysLeft;
	}

	/**
	 * 
	 * @param hoursLeft
	 * 			The hoursLeft to set.
	 */
	public void setHoursLeft(byte hoursLeft) {
		this.hoursLeft = hoursLeft;
	}

	/**
	 * 
	 * @return hoursLeft
	 * 			Returns the hoursLeft to get.
	 */
	public byte getHoursLeft() {
		return this.hoursLeft;
	}

	/**
	 * 
	 * @param minutesLeft
	 * 			The minutesLeft to set.
	 */
	public void setMinutesLeft(byte minutesLeft) {
		this.minutesLeft = minutesLeft;
	}

	/**
	 * 
	 * @return minutesLeft
	 * 			Returns the minutesLeft to get.
	 */
	public byte getMinutesLeft() {
		return this.minutesLeft;
	}

	/**
	 * 
	 * @param clanMembers
	 * 			The clanMembers to set.
	 */
	public void setClanMembers(byte clanMembers) {
		this.clanMembers = clanMembers;
	}

	/**
	 * 
	 * @return clanMembers
	 * 			Returns the clanMembers to get.
	 */
	public byte getClanMembers() {
		return this.clanMembers;
	}
}