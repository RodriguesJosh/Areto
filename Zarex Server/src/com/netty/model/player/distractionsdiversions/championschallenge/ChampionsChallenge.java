package com.netty.model.player.distractionsdiversions.championschallenge;

import com.netty.model.player.distractionsdiversions.DistractionsAndDiversions;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 2:59:54 PM
 */
public class ChampionsChallenge extends DistractionsAndDiversions {

	/**
	 * 
	 */
	private Larxus larxus;

	/**
	 * 
	 */
	private LowerChampionRace lowerChampionRace;

	/**
	 * 
	 */
	private HigherChampionRace higherChampionRace;

	/* (non-Javadoc)
	 * @see com.netty.model.player.distractionsdiversions.DistractionsAndDiversions#end()
	 */
	@Override
	public void end() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.distractionsdiversions.DistractionsAndDiversions#start()
	 */
	@Override
	public void start() {
		//
	}

	/**
	 * 
	 * @param larxus
	 * 			The larxus to set.
	 */
	public void setLarxus(Larxus larxus) {
		this.larxus = larxus;
	}

	/**
	 * 
	 * @return larxus
	 * 			Returns the larxus to get.
	 */
	public Larxus getLarxus() {
		return this.larxus;
	}

	/**
	 * 
	 * @param lowerChampionRace
	 * 			The lowerChampionRace to set.
	 */
	public void setLowerChampionRace(LowerChampionRace lowerChampionRace) {
		this.lowerChampionRace = lowerChampionRace;
	}

	/**
	 * 
	 * @return lowerChampionRace
	 * 			Returns the lowerChampionRace to get.
	 */
	public LowerChampionRace getLowerChampionRace() {
		return this.lowerChampionRace;
	}

	/**
	 * 
	 * @param higherChampionRace
	 * 			The higherChampionRace to set.
	 */
	public void setHigherChampionRace(HigherChampionRace higherChampionRace) {
		this.higherChampionRace = higherChampionRace;
	}

	/**
	 * 
	 * @return higherChampionRace
	 * 			Returns the higherChampionRace to get.
	 */
	public HigherChampionRace getHigherChampionRace() {
		return this.higherChampionRace;
	}
}