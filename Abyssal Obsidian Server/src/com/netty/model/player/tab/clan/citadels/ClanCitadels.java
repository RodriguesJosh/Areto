package com.netty.model.player.tab.clan.citadels;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:36:04 PM
 */
public class ClanCitadels {

	/**
	 * 
	 */
	private ClanRing clanRing;

	/**
	 * 
	 */
	private DragonType dragonType;

	/** Add more later - too bored to do this. */

	/**
	 * 
	 * @param clanRing
	 * 			The clanRing to set.
	 */
	public void setClanRing(ClanRing clanRing) {
		this.clanRing = clanRing;
	}

	/**
	 * 
	 * @return clanRing
	 * 			Returns the clanRing to get.
	 */
	public ClanRing getClanRing() {
		return this.clanRing;
	}

	/**
	 * 
	 * @param dragonType
	 * 			The dragonType to set.
	 */
	public void setDragonType(DragonType dragonType) {
		this.dragonType = dragonType;
	}

	/**
	 * 
	 * @return dragonType
	 * 			Returns the dragonType to get.
	 */
	public DragonType getDragonType() {
		return this.dragonType;
	}
}