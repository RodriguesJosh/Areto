package com.netty.model.player.tab.clan;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:08:16 AM
 */
public class Clan {

	/**
	 * 
	 */
	private String owner;

	/**
	 * 
	 */
	private ConcurrentMap<String, ClanRank> rankMap;

	/**
	 * 
	 * @param owner
	 * 			The id to set.
	 */
	public Clan(String owner) {
		this.setOwner(owner);
		this.setRankMap(new ConcurrentHashMap<String, ClanRank>(ClanConstants.MAX_CLAN_NAMES));
	}

	/**
	 * 
	 * @param owner
	 * 			The id to set.
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getOwner() {
		return this.owner;
	}

	/**
	 * 
	 * @param rankMap
	 * 			The id to set.
	 */
	public void setRankMap(ConcurrentMap<String, ClanRank> rankMap) {
		this.rankMap = rankMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ConcurrentMap<String, ClanRank> getRankMap() {
		return this.rankMap;
	}
}