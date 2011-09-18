package com.netty.model.player.minigame.mobilisingarmies;

public class Squad {

	private SquadControllment squadControllment;
	private SquadType squadType;
	private SquadRace squadRace;

	public Squad(SquadControllment squadControllment, SquadType squadType, SquadRace squadRace) {
		this.setSquadControllment(squadControllment);
		this.setSquadType(squadType);
		this.setSquadRace(squadRace);
	}

	public void setSquadControllment(SquadControllment squadControllment) {
		this.squadControllment = squadControllment;
	}

	public SquadControllment getSquadControllment() {
		return this.squadControllment;
	}

	public void setSquadType(SquadType squadType) {
		this.squadType = squadType;
	}

	public SquadType getSquadType() {
		return this.squadType;
	}

	public void setSquadRace(SquadRace squadRace) {
		this.squadRace = squadRace;
	}

	public SquadRace getSquadRace() {
		return this.squadRace;
	}
}