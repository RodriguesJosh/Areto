package com.netty.model.player.minigame.troublebrewing;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class TroubleBrewing extends MiniGame {

	private Team team;
	private Task task;

	public TroubleBrewing(Player player, Team team, Task task) {
		super(player);
		this.setTeam(team);
		this.setTask(task);
	}

	@Override
	public void start() {}

	@Override
	public void end() {}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Task getTask() {
		return this.task;
	}
}
