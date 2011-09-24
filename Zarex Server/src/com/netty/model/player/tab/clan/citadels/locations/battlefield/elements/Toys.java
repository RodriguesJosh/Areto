package com.netty.model.player.tab.clan.citadels.locations.battlefield.elements;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 9:19:10 PM
 */
public enum Toys {

	/**
	 * 
	 */
	ITEM_SPAWN,

	/**
	 * 
	 */
	BALL_SPAWN,

	/**
	 * 
	 */
	FLAG_SPAWN;

	/**
	 * 
	 */
	private boolean itemRespawn;

	/**
	 * 
	 */
	private boolean timeMovement;

	/**
	 * 
	 */
	private boolean restricted;

	/**
	 * 
	 */
	private boolean agility;

	/**
	 * 
	 */
	private boolean obstacleActions;

	/**
	 * 
	 */
	private boolean allowedTeam;

	/**
	 * 
	 */
	private boolean pickup;

	/**
	 * 
	 * @param itemRespawn
	 * 			The itemRespawn to set.
	 */
	public void setItemRespawn(boolean itemRespawn) {
		this.itemRespawn = itemRespawn;
	}

	/**
	 * 
	 * @return itemRespawn
	 * 			Returns the itemRespawn to get.
	 */
	public boolean isItemRespawn() {
		return this.itemRespawn;
	}

	/**
	 * 
	 * @param timeMovement
	 * 			The timeMovement to set.
	 */
	public void setTimeMovement(boolean timeMovement) {
		this.timeMovement = timeMovement;
	}

	/**
	 * 
	 * @return timeMovement
	 * 			Returns the timeMovement to get.
	 */
	public boolean isTimeMovement() {
		return this.timeMovement;
	}

	/**
	 * 
	 * @param restricted
	 * 			The restricted to set.
	 */
	public void setRestricted(boolean restricted) {
		this.restricted = restricted;
	}

	/**
	 * 
	 * @return restricted
	 * 			Returns the restricted to get.
	 */
	public boolean isRestricted() {
		return this.restricted;
	}

	/**
	 * 
	 * @param agility
	 * 			The agility to set.
	 */
	public void setAgility(boolean agility) {
		this.agility = agility;
	}
	/**
	 * 
	 * @return agility
	 * 			Returns the agility to get.
	 */
	public boolean isAgility() {
		return this.agility;
	}

	/**
	 * 
	 * @param obstacleActions
	 * 			The obstacleActions to set.
	 */
	public void setObstacleActions(boolean obstacleActions) {
		this.obstacleActions = obstacleActions;
	}

	/**
	 * 
	 * @return obstacleActions
	 * 			Returns the obstacleActions to get.
	 */
	public boolean isObstacleActions() {
		return this.obstacleActions;
	}

	/**
	 * 
	 * @param allowedTeam
	 * 			The allowedTeam to set.
	 */
	public void setAllowedTeam(boolean allowedTeam) {
		this.allowedTeam = allowedTeam;
	}

	/**
	 * 
	 * @return allowedTeam
	 * 			Returns the allowedTeam to get.
	 */
	public boolean isAllowedTeam() {
		return this.allowedTeam;
	}

	/**
	 * 
	 * @param pickup
	 * 			The pickup to set.
	 */
	public void setPickup(boolean pickup) {
		this.pickup = pickup;
	}

	/**
	 * 
	 * @return pickup
	 * 			Returns the pickup to get.
	 */
	public boolean isPickup() {
		return this.pickup;
	}
}