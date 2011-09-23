package com.netty.model.player.minigame.godwars;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:48:57 PM
 */
public class GodWars extends MiniGame {

	/**
	 * 
	 */
	private Boss boss;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 * @param boss
	 *			The id to set.
	 */
	public GodWars(Player player, Boss boss) {
		super(player);
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
	 * @param boss
	 *			The id to set.
	 */
	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Boss getBoss() {
		return this.boss;
	}
}
