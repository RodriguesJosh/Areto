package com.netty.model.player.distractionsdiversions.balthazarbeauregardsbonanza.range;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 1:57:00 PM
 */
public class RangeChest {

	/**
	 * 
	 */
	private RangedEquipment rangedEquipment;

	/**
	 * 
	 */
	private short[][] targetExperience = {

			/** Gotta change this to something else or maybe not - not sure. */

			{ 10, (short) 687.5 },
			{ 20, 1455 },
			{ 30, (short) 1458.5 },
			{ 40, (short) 1510.5 },
			{ 50, (short) 1562.5 },
			{ 60, 1875 },
			{ 70, 1979 },
			{ 80, (short) 2187.5 },
			{ 90, 2495 },
			{ 99, 2500 },
	};

	/**
	 * 
	 * @param rangedEquipment
	 * 			The rangedEquipment to set.
	 */
	public void setRangedEquipment(RangedEquipment rangedEquipment) {
		this.rangedEquipment = rangedEquipment;
	}

	/**
	 * 
	 * @return rangedEquipment
	 * 			Returns the rangedEquipment to get.
	 */
	public RangedEquipment getRangedEquipment() {
		return this.rangedEquipment;
	}

	/**
	 * 
	 * @param targetExperience
	 * 			The targetExperience to set.
	 */
	public void setTargetExperience(short[][] targetExperience) {
		this.targetExperience = targetExperience;
	}

	/**
	 * 
	 * @return targetExperience
	 * 			Returns the targetExperience to get.
	 */
	public short[][] getTargetExperience() {
		return this.targetExperience;
	}
}