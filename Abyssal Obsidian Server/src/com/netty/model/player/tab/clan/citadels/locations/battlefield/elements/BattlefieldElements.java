package com.netty.model.player.tab.clan.citadels.locations.battlefield.elements;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 9:08:21 PM
 */
public class BattlefieldElements {

	/**
	 * 
	 */
	private Architecture architecture;

	/**
	 * 
	 */
	private Toys toys;

	/**
	 * 
	 */
	private Targets targets;

	/**
	 * 
	 */
	private Hazards hazards;

	/**
	 * 
	 * @param architecture
	 * 			The architecture to set.
	 */
	public void setArchitecture(Architecture architecture) {
		this.architecture = architecture;
	}

	/**
	 * 
	 * @return architecture
	 * 			Returns the architecture to get.
	 */
	public Architecture getArchitecture() {
		return this.architecture;
	}

	/**
	 * 
	 * @param toys
	 * 			The toys to set.
	 */
	public void setToys(Toys toys) {
		this.toys = toys;
	}

	/**
	 * 
	 * @return toys
	 * 			Returns the toys to get.
	 */
	public Toys getToys() {
		return this.toys;
	}

	/**
	 * 
	 * @param targets
	 * 			The targets to set.
	 */
	public void setTargets(Targets targets) {
		this.targets = targets;
	}

	/**
	 * 
	 * @return targets
	 * 			Returns the targets to get.
	 */
	public Targets getTargets() {
		return this.targets;
	}

	/**
	 * 
	 * @param hazards
	 * 			The hazards to set.
	 */
	public void setHazards(Hazards hazards) {
		this.hazards = hazards;
	}

	/**
	 * 
	 * @return hazards
	 * 			Returns the hazards to get.
	 */
	public Hazards getHazards() {
		return this.hazards;
	}
}