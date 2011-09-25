package com.netty.model.player.minigame.mobilisingarmies;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:34:44 PM
 */
public class Squad {

	/**
	 * 
	 */
	private SquadControllment squadControllment;

	/**
	 * 
	 */
	private SquadType squadType;

	/**
	 * 
	 */
	private SquadRace squadRace;

	/**
	 * 
	 * @param squadControllment
	 * 			The id to set.
	 * @param squadType
	 * 			The id to set.
	 * @param squadRace
	 * 			The id to set.
	 */
	public Squad(SquadControllment squadControllment, SquadType squadType, SquadRace squadRace) {
		this.setSquadControllment(squadControllment);
		this.setSquadType(squadType);
		this.setSquadRace(squadRace);
	}

	/**
	 * 
	 * @param squadControllment
	 * 			The id to set.
	 */
	public void setSquadControllment(SquadControllment squadControllment) {
		this.squadControllment = squadControllment;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public SquadControllment getSquadControllment() {
		return this.squadControllment;
	}

	/**
	 * 
	 * @param squadType
	 * 			The id to set.
	 */
	public void setSquadType(SquadType squadType) {
		this.squadType = squadType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public SquadType getSquadType() {
		return this.squadType;
	}

	/**
	 * 
	 * @param squadRace
	 * 			The id to set.
	 */
	public void setSquadRace(SquadRace squadRace) {
		this.squadRace = squadRace;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public SquadRace getSquadRace() {
		return this.squadRace;
	}
}