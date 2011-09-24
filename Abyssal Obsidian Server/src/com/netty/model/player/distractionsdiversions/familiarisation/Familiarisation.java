package com.netty.model.player.distractionsdiversions.familiarisation;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 6:27:05 PM
 */
public class Familiarisation {

	/**
	 * 
	 */
	private Pikkupstix pikkupstix;

	/**
	 * 
	 */
	private Pikkenmix pikkenmix;

	/**
	 * 
	 */
	private SpiritPlane spiritPlane;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param pikkupstix
	 * 			The pikkupstix to set.
	 */
	public void setPikkupstix(Pikkupstix pikkupstix) {
		this.pikkupstix = pikkupstix;
	}

	/**
	 * 
	 * @return pikkupstix
	 * 			Returns the pikkupstix to get.
	 */
	public Pikkupstix getPikkupstix() {
		return this.pikkupstix;
	}

	/**
	 * 
	 * @param pikkenmix
	 * 			The pikkenmix to set.
	 */
	public void setPikkenmix(Pikkenmix pikkenmix) {
		this.pikkenmix = pikkenmix;
	}

	/**
	 * 
	 * @return pikkenmix
	 * 			Returns the pikkenmix to get.
	 */
	public Pikkenmix getPikkenmix() {
		return this.pikkenmix;
	}

	/**
	 * 
	 * @param spiritPlane
	 * 			The spiritPlane to set.
	 */
	public void setSpiritPlane(SpiritPlane spiritPlane) {
		this.spiritPlane = spiritPlane;
	}

	/**
	 * 
	 * @return spiritPlane
	 * 			Returns the spiritPlane to get.
	 */
	public SpiritPlane getSpiritPlane() {
		return this.spiritPlane;
	}

	/**
	 * 
	 * @param reward
	 * 			The reward to set.
	 */
	public void setReward(Reward reward) {
		this.reward = reward;
	}

	/**
	 * 
	 * @return reward
	 * 			Returns the reward to get.
	 */
	public Reward getReward() {
		return this.reward;
	}
}