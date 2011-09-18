package com.netty.model.player.tab.clan;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Clan {

	private String owner;
	private ConcurrentMap<String, ClanRank> rankMap;

	public Clan(String owner) {
		this.setOwner(owner);
		this.setRankMap(new ConcurrentHashMap<String, ClanRank>(ClanConstants.MAX_CLAN_NAMES));
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setRankMap(ConcurrentMap<String, ClanRank> rankMap) {
		this.rankMap = rankMap;
	}

	public ConcurrentMap<String, ClanRank> getRankMap() {
		return this.rankMap;
	}
}