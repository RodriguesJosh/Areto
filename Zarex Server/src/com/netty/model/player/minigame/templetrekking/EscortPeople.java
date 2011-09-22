package com.netty.model.player.minigame.templetrekking;

public enum EscortPeople {

	FYIONA_FRAY(EscortPeopleType.EASY), DALCIAN_FANG(EscortPeopleType.EASY), MAGE(EscortPeopleType.EASY), ADVENTURER(EscortPeopleType.EASY),
	JAYENE_KLIYN(EscortPeopleType.MEDIUM), VALANTAY_EPPEL(EscortPeopleType.MEDIUM), RANGER(EscortPeopleType.MEDIUM), APPRENTICE(EscortPeopleType.MEDIUM),
	ROLAYNE_TWICKIT(EscortPeopleType.HARD), SMIDDI_RYAK(EscortPeopleType.HARD), WOMAN_AT_ARMS(EscortPeopleType.HARD), FORESTER(EscortPeopleType.HARD);

	private EscortPeopleType escortPeopleType;

	private EscortPeople(EscortPeopleType escortPeopleType) {
		this.setEscortPeopleType(escortPeopleType);
	}

	public void setEscortPeopleType(EscortPeopleType escortPeopleType) {
		this.escortPeopleType = escortPeopleType;
	}

	public EscortPeopleType getEscortPeopleType() {
		return this.escortPeopleType;
	}
}