package com.netty.model.player.minigame.impetuousimpulses;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:40:06 PM
 */
public class ImpetuousImpulses extends MiniGame {

	/**
	 * 
	 */
	private PuroPuro puroPuro;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public ImpetuousImpulses(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		//
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
	 * @param puroPuro
	 * 			The id to set.
	 */
	public void setPuroPuro(PuroPuro puroPuro) {
		this.puroPuro = puroPuro;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PuroPuro getPuroPuro() {
		return this.puroPuro;
	}

	/**
	 * 
	 * @param reward
	 * 			The id to set.
	 */
	public void setReward(Reward reward) {
		this.reward = reward;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Reward getReward() {
		return this.reward;
	}
}
