package com.netty.model.player.minigame.conquest;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:36:38 PM
 */
public class Conquest extends MiniGame {

	/**
	 * 
	 */
	private WaitingRoom waitingRoom;

	/**
	 * 
	 */
	private Unit unit;

	/**
	 * 
	 */
	private Command command;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 * @param waitingRoom
	 *			The id to set.
	 */
	public Conquest(Player player, WaitingRoom waitingRoom) {
		super(player);
		this.setWaitingRoom(waitingRoom);
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
		this.setReward(Reward.NONE);
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
	 *			The id to set.
	 */
	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public WaitingRoom getWaitingRoom() {
		return this.waitingRoom;
	}

	/**
	 * 
	 * @param unit
	 *			The id to set.
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Unit getUnit() {
		return this.unit;
	}

	/**
	 * 
	 * @param command
	 *			The id to set.
	 */
	public void setCommand(Command command) {
		this.command = command;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Command getCommand() {
		return this.command;
	}

	/**
	 * 
	 * @param reward
	 *			The id to set.
	 */
	public void setReward(Reward reward) {
		this.reward = reward;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Reward getReward() {
		return this.reward;
	}
}