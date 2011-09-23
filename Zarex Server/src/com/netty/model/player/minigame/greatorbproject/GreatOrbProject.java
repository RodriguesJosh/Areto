package com.netty.model.player.minigame.greatorbproject;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.SkillType;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:54:47 PM
 */
public class GreatOrbProject extends MiniGame {

	/**
	 * 
	 */
	private Round round;

	/**
	 * 
	 */
	private Orb[] orb;

	/**
	 * 
	 */
	private Team team;

	/**
	 * 
	 */
	private Barrier barrier;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 * @param team
	 *			The id to set.
	 */
	public GreatOrbProject(Player player, Team team) {
		super(player);
		this.setOrb(new Orb[20]);
		this.setTeam(team);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
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
	 * @param round
	 *			The id to set.
	 */
	public void setRound(Round round) {
		this.round = round;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Round getRound() {
		return this.round;
	}

	/**
	 * 
	 * @param orb
	 *			The id to set.
	 */
	public void setOrb(Orb[] orb) {
		this.orb = orb;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Orb[] getOrb() {
		return this.orb;
	}

	/**
	 * 
	 * @param team
	 *			The id to set.
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Team getTeam() {
		return this.team;
	}

	/**
	 * 
	 * @param barrier
	 *			The id to set.
	 */
	public void setBarrier(Barrier barrier) {
		this.barrier = barrier;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Barrier getBarrier() {
		return this.barrier;
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
