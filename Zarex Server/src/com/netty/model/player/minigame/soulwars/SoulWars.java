package com.netty.model.player.minigame.soulwars;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:28:08 PM
 */
public class SoulWars extends MiniGame {

	/**
	 * 
	 */
	private WaitingRoom waitingRoom;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public SoulWars(Player player) {
		super(player);
		this.setWaitingRoom(new WaitingRoom(new Nomad(), new Zimberfizz()));
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
	 * @param waitingRoom
	 * 			The id to set.
	 */
	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public WaitingRoom getWaitingRoom() {
		return this.waitingRoom;
	}
}
