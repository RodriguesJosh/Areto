package com.netty.model.player.minigame.allfiredup;

import java.util.LinkedList;
import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.model.player.skill.SkillType;

public class AllFiredUp extends MiniGame {

	private List<Beacon> beaconList;
	private Reward reward;

	public AllFiredUp(Player player) {
		super(player);
		this.setBeaconList(new LinkedList<Beacon>());
	}

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

	@Override
	public void end() {
		this.setReward(Reward.NONE);
	}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.DANGEROUS;
	}

	public void setBeaconList(List<Beacon> beaconList) {
		this.beaconList = beaconList;
	}

	public List<Beacon> getBeaconList() {
		return this.beaconList;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
