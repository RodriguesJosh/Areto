package com.netty.model.player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:10:52 AM
 */
public class Energy {

	/**
	 * 
	 */
	private double energyAmount;

	/**
	 * 
	 * @param energyAmount
	 * 			The id to set.
	 */
	public Energy(double energyAmount) {
		this.setEnergyAmount(energyAmount);
	}

	/**
	 * 
	 * @param energyAmount
	 * 			The id to set.
	 */
	public void setEnergyAmount(double energyAmount) {
		this.energyAmount = energyAmount;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public double getEnergyAmount() {
		return this.energyAmount;
	}
}