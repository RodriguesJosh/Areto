package com.netty.model.player.minigame.godwars;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class GodWars extends MiniGame {

	private Boss boss;

	public GodWars(Player player, Boss boss) {
		super(player);
	}

	@Override
	public void start() {}

	@Override
	public void end() {
		if (this.getBoss() instanceof Bandos) {
			if (this.getBoss().getNPC().isDead()) {
				Item[] items = {

				};
				this.getBoss().getNPC().setItemDrops(items);
			}
		} else if (this.getBoss() instanceof Zamorak) {
			if (this.getBoss().getNPC().isDead()) {
				Item[] items = {

				};
				this.getBoss().getNPC().setItemDrops(items);
			}
		} else if (this.getBoss() instanceof Saradomin) {
			if (this.getBoss().getNPC().isDead()) {
				Item[] items = {

				};
				this.getBoss().getNPC().setItemDrops(items);
			}
		} else if (this.getBoss() instanceof Armadyl) {
			if (this.getBoss().getNPC().isDead()) {
				Item[] items = {

				};
				this.getBoss().getNPC().setItemDrops(items);
			}
		}
	}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public Boss getBoss() {
		return this.boss;
	}
}
