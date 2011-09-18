package com.netty.model.player.tab.clan;

public enum ClanRank {

	FRIEND(false, null), RECRUIT(false, null), CORPORAL(false, null), SERGEANT(true, null), LIEUTENANT(true, null), CAPTAIN(true, null),
	GENERAL(true, null), LEADER(true, null), OWNER(true, null);

	private boolean isKicking;
	private ClanAction clanAction;

	private ClanRank(boolean isKicking, ClanAction clanAction) {
		this.setKicking(isKicking);
		this.setClanAction(clanAction);
	}

	public void setKicking(boolean isKicking) {
		this.isKicking = isKicking;
	}

	public boolean isKicking() {
		return this.isKicking;
	}

	public void setClanAction(ClanAction clanAction) {
		this.clanAction = clanAction;
	}

	public ClanAction getClanAction() {
		return this.clanAction;
	}
}