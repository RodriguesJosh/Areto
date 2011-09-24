package com.netty.model.player.minigame.stealingcreation;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:26:28 PM
 */
public class StealingCreation extends MiniGame {

	/**
	 * 
	 */
	private Tutorial tutorial;

	/**
	 * 
	 */
	private Team redTeam;

	/**
	 * 
	 */
	private Team blueTeam;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public StealingCreation(Player player) {
		super(player);
		this.setRedTeam(new RedTeam());
		this.setBlueTeam(new BlueTeam());
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
		this.getRedTeam().setReward(Reward.NONE);
		this.getBlueTeam().setReward(Reward.NONE);
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
	 * @param tutorial
	 * 			The id to set.
	 */
	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Tutorial getTutorial() {
		return this.tutorial;
	}

	/**
	 * 
	 * @param redTeam
	 * 			The id to set.
	 */
	public void setRedTeam(Team redTeam) {
		this.redTeam = redTeam;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Team getRedTeam() {
		return this.redTeam;
	}

	/**
	 * 
	 * @param blueTeam
	 * 			The id to set.
	 */
	public void setBlueTeam(Team blueTeam) {
		this.blueTeam = blueTeam;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Team getBlueTeam() {
		return this.blueTeam;
	}
}
