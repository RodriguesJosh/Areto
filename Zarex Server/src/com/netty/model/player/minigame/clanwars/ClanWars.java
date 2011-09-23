package com.netty.model.player.minigame.clanwars;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:29:12 PM
 */
public class ClanWars extends MiniGame {

	/**
	 * 
	 */
	private Team team;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 * @param team
	 *			The id to set.
	 */
	public ClanWars(Player player, Team team) {
		super(player);
		this.setTeam(team);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getMembershipState()
	 */
	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getThreateningState()
	 */
	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	/**
	 * 
	 * @param team
	 *			The id to set.
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Team getTeam() {
		return this.team;
	}
}