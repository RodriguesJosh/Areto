package com.netty.model.player.minigame.allfiredup;

import java.util.LinkedList;
import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.SkillType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:57:29 PM
 */
public class AllFiredUp extends MiniGame {

	/**
	 * 
	 */
	private List<Beacon> beaconList;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public AllFiredUp(Player player) {
		super(player);
		this.setBeaconList(new LinkedList<Beacon>());
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		if (this.getPlayer().getSkills()[SkillType.AGILITY.getID()].getLevel() < 64) {
			return;
		}
		if (this.getPlayer().getSkills()[SkillType.CONSTRUCTION.getID()].getLevel() < 59) {
			return;
		}
		if (this.getPlayer().getSkills()[SkillType.SMITHING.getID()].getLevel() < 70) {
			return;
		}
		if (this.getPlayer().getSkills()[SkillType.CRAFTING.getID()].getLevel() < 60) {
			return;
		}
		if (this.getPlayer().getSkills()[SkillType.PRAYER.getID()].getLevel() < 31) {
			return;
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
	 * @param beaconList
	 * 			The id to set.
	 */
	public void setBeaconList(List<Beacon> beaconList) {
		this.beaconList = beaconList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Beacon> getBeaconList() {
		return this.beaconList;
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