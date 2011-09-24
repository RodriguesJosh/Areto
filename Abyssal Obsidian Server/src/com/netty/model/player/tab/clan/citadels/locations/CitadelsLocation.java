package com.netty.model.player.tab.clan.citadels.locations;

import com.netty.model.player.tab.clan.citadels.locations.battlefield.Battlefield;
import com.netty.model.player.tab.clan.citadels.locations.keep.Keep;
import com.netty.model.player.tab.clan.citadels.locations.welcomearea.WelcomeArea;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:43:43 PM
 */
public class CitadelsLocation {

	/**
	 * 
	 */
	private WelcomeArea welcomeArea;

	/**
	 * 
	 */
	private Keep keep;

	/**
	 * 
	 */
	private Battlefield battlefield;

	/**
	 * 
	 * @param welcomeArea
	 * 			The welcomeArea to set.
	 */
	public void setWelcomeArea(WelcomeArea welcomeArea) {
		this.welcomeArea = welcomeArea;
	}

	/**
	 * 
	 * @return welcomeArea
	 * 			Returns the welcomeArea to get.
	 */
	public WelcomeArea getWelcomeArea() {
		return this.welcomeArea;
	}

	/**
	 * 
	 * @param keep
	 * 			The keep to set.
	 */
	public void setKeep(Keep keep) {
		this.keep = keep;
	}

	/**
	 * 
	 * @return keep
	 * 			Returns the keep to get.
	 */
	public Keep getKeep() {
		return this.keep;
	}

	/**
	 * 
	 * @param battlefield
	 * 			The battlefield to set.
	 */
	public void setBattlefield(Battlefield battlefield) {
		this.battlefield = battlefield;
	}

	/**
	 * 
	 * @return battlefield
	 * 			Returns the battlefield to get.
	 */
	public Battlefield getBattlefield() {
		return this.battlefield;
	}
}