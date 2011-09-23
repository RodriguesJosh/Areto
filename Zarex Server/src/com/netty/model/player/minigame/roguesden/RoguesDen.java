package com.netty.model.player.minigame.roguesden;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:30:20 PM
 */
public class RoguesDen extends MiniGame {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public RoguesDen(Player player) {
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
}
