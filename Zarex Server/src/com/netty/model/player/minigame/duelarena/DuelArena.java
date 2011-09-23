package com.netty.model.player.minigame.duelarena;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:38:37 PM
 */
public class DuelArena extends MiniGame {

	/**
	 * 
	 */
	private Staking staking;

	/**
	 * 
	 */
	private Tournament tournament;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public DuelArena(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		this.getPlayer().setTeleport(Teleport.DUEL_ARENA);
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
	 * @param staking
	 *			The id to set.
	 */
	public void setStaking(Staking staking) {
		this.staking = staking;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Staking getStaking() {
		return this.staking;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public boolean isStaking() {
		return this.getStaking() != null;
	}

	/**
	 * 
	 * @param tournament
	 *			The id to set.
	 */
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Tournament getTournament() {
		return this.tournament;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public boolean isTournament() {
		return this.getTournament() != null;
	}
}
