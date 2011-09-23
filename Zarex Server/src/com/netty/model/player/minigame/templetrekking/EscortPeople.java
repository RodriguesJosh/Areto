package com.netty.model.player.minigame.templetrekking;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:21:35 PM
 */
public enum EscortPeople {

	/**
	 * 
	 */
	FYIONA_FRAY(EscortPeopleType.EASY),

	/**
	 * 
	 */
	DALCIAN_FANG(EscortPeopleType.EASY),

	/**
	 * 
	 */
	MAGE(EscortPeopleType.EASY),

	/**
	 * 
	 */
	ADVENTURER(EscortPeopleType.EASY),

	/**
	 * 
	 */
	JAYENE_KLIYN(EscortPeopleType.MEDIUM),

	/**
	 * 
	 */
	VALANTAY_EPPEL(EscortPeopleType.MEDIUM),

	/**
	 * 
	 */
	RANGER(EscortPeopleType.MEDIUM),

	/**
	 * 
	 */
	APPRENTICE(EscortPeopleType.MEDIUM),
	/**
	 * 
	 */
	ROLAYNE_TWICKIT(EscortPeopleType.HARD),

	/**
	 * 
	 */
	SMIDDI_RYAK(EscortPeopleType.HARD),

	/**
	 * 
	 */
	WOMAN_AT_ARMS(EscortPeopleType.HARD),

	/**
	 * 
	 */
	FORESTER(EscortPeopleType.HARD);

	/**
	 * 
	 */
	private EscortPeopleType escortPeopleType;

	/**
	 * 
	 * @param escortPeopleType
	 * 			The id to set.
	 */
	private EscortPeople(EscortPeopleType escortPeopleType) {
		this.setEscortPeopleType(escortPeopleType);
	}

	/**
	 * 
	 * @param escortPeopleType
	 * 			The id to set.
	 */
	public void setEscortPeopleType(EscortPeopleType escortPeopleType) {
		this.escortPeopleType = escortPeopleType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public EscortPeopleType getEscortPeopleType() {
		return this.escortPeopleType;
	}
}