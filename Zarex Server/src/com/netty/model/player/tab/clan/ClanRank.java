package com.netty.model.player.tab.clan;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:07:24 AM
 */
public enum ClanRank {

	/**
	 * 
	 */
	FRIEND(false, null),

	/**
	 * 
	 */
	RECRUIT(false, null),

	/**
	 * 
	 */
	CORPORAL(false, null),

	/**
	 * 
	 */
	SERGEANT(true, null),

	/**
	 * 
	 */
	LIEUTENANT(true, null),

	/**
	 * 
	 */
	CAPTAIN(true, null),
	/**
	 * 
	 */
	GENERAL(true, null),

	/**
	 * 
	 */
	LEADER(true, null),

	/**
	 * 
	 */
	OWNER(true, null);

	/**
	 * 
	 */
	private boolean isKicking;

	/**
	 * 
	 */
	private ClanAction clanAction;

	/**
	 * 
	 * @param isKicking
	 * 			The id to set.
	 * @param clanAction
	 * 			The id to set.
	 */
	private ClanRank(boolean isKicking, ClanAction clanAction) {
		this.setKicking(isKicking);
		this.setClanAction(clanAction);
	}

	/**
	 * 
	 * @param isKicking
	 * 			The id to set.
	 */
	public void setKicking(boolean isKicking) {
		this.isKicking = isKicking;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isKicking() {
		return this.isKicking;
	}

	/**
	 * 
	 * @param clanAction
	 * 			The id to set.
	 */
	public void setClanAction(ClanAction clanAction) {
		this.clanAction = clanAction;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ClanAction getClanAction() {
		return this.clanAction;
	}
}