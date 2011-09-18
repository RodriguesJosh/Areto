package com.netty.model.player.minigame.greatorbproject;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.SkillType;
import com.netty.world.Location;

public class GreatOrbProject extends MiniGame {

	private Round round;
	private Orb[] orb;
	private Team team;
	private Barrier barrier;
	private Reward reward;

	public GreatOrbProject(Player player, Team team) {
		super(player);
		this.setOrb(new Orb[20]);
		this.setTeam(team);
	}

	@Override
	public void start() {
		if (!(this.getOrb()[0].getTeam().equals(this.getTeam()))) {
			return;
		}
		this.getPlayer().setTeleport(Teleport.GREAT_ORB_PROJECT);
		if (this.getPlayer().getSkills()[SkillType.RUNECRAFTING.getID()].getLevel() < 50) {
			return;
		}
		this.setRound(Round.AIR_ALTAR);
		if (this.getTeam().getBarrierGenerator().isActivated()) {
			this.setBarrier(new Barrier(this.getTeam(), this.getPlayer().getLocation()));
		}
		if (this.getTeam().getAttractorWand().isActivated()) {
			short x = (short) (this.getPlayer().getLocation().getX() + 1);
			short y = (short) (this.getPlayer().getLocation().getY() + 1);
			byte z = this.getPlayer().getLocation().getZ();
			this.getOrb()[0].setLocation(new Location(x, y, z));
		}
		if (this.getTeam().getRepellerWand().isActivated()) {
			short x = (short) (this.getPlayer().getLocation().getX() - 1);
			short y = (short) (this.getPlayer().getLocation().getY() - 1);
			byte z = this.getPlayer().getLocation().getZ();
			this.getOrb()[0].setLocation(new Location(x, y, z));
		}
	}

	@Override
	public void end() {
		this.setReward(Reward.NONE);
	}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public Round getRound() {
		return this.round;
	}

	public void setOrb(Orb[] orb) {
		this.orb = orb;
	}

	public Orb[] getOrb() {
		return this.orb;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setBarrier(Barrier barrier) {
		this.barrier = barrier;
	}

	public Barrier getBarrier() {
		return this.barrier;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
