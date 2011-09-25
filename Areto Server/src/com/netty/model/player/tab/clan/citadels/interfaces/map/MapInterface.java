package com.netty.model.player.tab.clan.citadels.interfaces.map;

import com.netty.model.player.tab.clan.citadels.interfaces.CitadelsInterface;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:06:54 PM
 */
public class MapInterface extends CitadelsInterface {

	/**
	 * 
	 * @param daysLeft
	 * 			The days left.
	 * @param hoursLeft
	 * 			The hours left.
	 * @param minutesLeft
	 * 			The minutes left.
	 * @param clanMembers
	 * 			The clan's members.
	 */
	public MapInterface(byte daysLeft, byte hoursLeft, byte minutesLeft, byte clanMembers) {
		super(daysLeft, hoursLeft, minutesLeft, clanMembers);
	}
}