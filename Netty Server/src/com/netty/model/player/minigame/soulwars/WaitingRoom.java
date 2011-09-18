package com.netty.model.player.minigame.soulwars;

public class WaitingRoom {

	private Nomad nomad;
	private Zimberfizz zimberfizz;

	public WaitingRoom(Nomad nomad, Zimberfizz zimberfizz) {
		this.setNomad(nomad);
		this.setZimberfizz(zimberfizz);
	}

	public void setNomad(Nomad nomad) {
		this.nomad = nomad;
	}

	public Nomad getNomad() {
		return this.nomad;
	}

	public void setZimberfizz(Zimberfizz zimberfizz) {
		this.zimberfizz = zimberfizz;
	}

	public Zimberfizz getZimberfizz() {
		return this.zimberfizz;
	}
}