package com.netty.model.player.minigame.castlewars;

import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:22:51 PM
 */
public class CastleWars extends MiniGame {

	/**
	 * 
	 */
	private Lobby lobby;

	/**
	 * 
	 */
	private Team team;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 * @param location
	 *			The id to set.
	 * @param object
	 *			The id to set.
	 */
	public CastleWars(Player player, Location location, Object object) {
		super(player);
		this.setLobby(new Lobby(player, location, object));
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
		return MembershipState.MEMBER;
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
	 * @param lobby
	 *			The id to set.
	 */
	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Lobby getLobby() {
		return this.lobby;
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