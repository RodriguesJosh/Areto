package com.netty.model.player.minigame.fistguthix;

import com.netty.model.combat.AttackType;
import com.netty.model.combat.CombatType;
import com.netty.model.combat.RangeCombat;
import com.netty.model.combat.magic.MagicCombat;
import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class FistOfGuthix extends MiniGame {

	private Hunter hunter;
	private Hunted hunted;
	private Reward reward;

	public FistOfGuthix(Player player, Hunter hunter, Hunted hunted) {
		super(player);
		this.setHunter(hunter);
		this.setHunted(hunted);
	}

	@Override
	public void start() {
		Item[] items = {
				new Item(0, 5), new Item(0, 300), new Item(0, 1000), new Item(0, 1), new Item(0, 5), new Item(0, 300), new Item(0, 1000),
				new Item(0, 1)
		};
		for (Item item : items) {
			this.getHunter().getPlayer().getInventory().registerItem(item);
		}
		Player hunter = this.getHunter().getPlayer();
		Player hunted = this.getHunted().getPlayer();
		if (hunter.isMaging()) {
			hunter.setCombat(new MagicCombat(hunter, hunted, CombatType.MAGIC, AttackType.ACCURATE));
		} else if (hunter.isMeleeing()) {
			hunter.setCombat(new MeleeCombat(hunter, hunted, CombatType.MELEE, AttackType.ACCURATE));
		} else if (hunter.isRanging()) {
			hunter.setCombat(new RangeCombat(hunter, hunted, CombatType.RANGE, AttackType.ACCURATE));
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

	public void setHunter(Hunter hunter) {
		this.hunter = hunter;
	}

	public Hunter getHunter() {
		return this.hunter;
	}

	public void setHunted(Hunted hunted) {
		this.hunted = hunted;
	}

	public Hunted getHunted() {
		return this.hunted;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}
