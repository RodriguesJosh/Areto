package com.netty.model.player.minigame.bountyhunter;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:11:29 PM
 */
public class MediumCrate extends Crate {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public MediumCrate(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.bountyhunter.Crate#isLevelNeeded()
	 */
	@Override
	public boolean isLevelNeeded() {
		return (this.getPlayer().getCombatLevel() >= 50) && (this.getPlayer().getCombatLevel() <= 100);
	}
}