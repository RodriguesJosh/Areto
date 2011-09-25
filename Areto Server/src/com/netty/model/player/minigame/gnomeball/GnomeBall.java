package com.netty.model.player.minigame.gnomeball;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:46:06 PM
 */
public class GnomeBall extends MiniGame {

	/**
	 * 
	 */
	private Ball ball;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public GnomeBall(Player player) {
		super(player);
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
		return ThreateningState.DANGEROUS;
	}

	/**
	 * 
	 * @param ball
	 *			The id to set.
	 */
	public void setBall(Ball ball) {
		this.ball = ball;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Ball getBall() {
		return this.ball;
	}
}
