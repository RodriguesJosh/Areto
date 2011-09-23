package com.netty.model.player.minigame.troublebrewing;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:24:59 PM
 */
public class TroubleBrewing extends MiniGame {

	/**
	 * 
	 */
	private Team team;

	/**
	 * 
	 */
	private Task task;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param team
	 * 			The id to set.
	 * @param task
	 * 			The id to set.
	 */
	public TroubleBrewing(Player player, Team team, Task task) {
		super(player);
		this.setTeam(team);
		this.setTask(task);
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
	 * @param team
	 * 			The id to set.
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Team getTeam() {
		return this.team;
	}

	/**
	 * 
	 * @param task
	 * 			The id to set.
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Task getTask() {
		return this.task;
	}
}
