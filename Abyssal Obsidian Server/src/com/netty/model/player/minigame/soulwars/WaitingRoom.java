package com.netty.model.player.minigame.soulwars;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:29:01 PM
 */
public class WaitingRoom {

	/**
	 * 
	 */
	private Nomad nomad;

	/**
	 * 
	 */
	private Zimberfizz zimberfizz;

	/**
	 * 
	 * @param nomad
	 * 			The id to set.
	 * @param zimberfizz
	 * 			The id to set.
	 */
	public WaitingRoom(Nomad nomad, Zimberfizz zimberfizz) {
		this.setNomad(nomad);
		this.setZimberfizz(zimberfizz);
	}

	/**
	 * 
	 * @param nomad
	 * 			The id to set.
	 */
	public void setNomad(Nomad nomad) {
		this.nomad = nomad;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Nomad getNomad() {
		return this.nomad;
	}

	/**
	 * 
	 * @param zimberfizz
	 * 			The id to set.
	 */
	public void setZimberfizz(Zimberfizz zimberfizz) {
		this.zimberfizz = zimberfizz;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Zimberfizz getZimberfizz() {
		return this.zimberfizz;
	}
}