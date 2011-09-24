package com.netty.model.player.tab.clan.citadels.interfaces.build;

import com.netty.model.player.tab.clan.citadels.interfaces.CitadelsInterface;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:07:05 PM
 */
public class BuildingInterface extends CitadelsInterface {

	/**
	 * 
	 */
	private Permission permission;

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
	public BuildingInterface(byte daysLeft, byte hoursLeft, byte minutesLeft, byte clanMembers) {
		super(daysLeft, hoursLeft, minutesLeft, clanMembers);
	}

	/**
	 * 
	 * @param permission
	 * 			The permission to set.
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	/**
	 * 
	 * @return permission
	 * 			Returns the permission to get.
	 */
	public Permission getPermission() {
		return this.permission;
	}
}