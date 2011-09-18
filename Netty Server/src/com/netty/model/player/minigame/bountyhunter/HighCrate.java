package com.netty.model.player.minigame.bountyhunter;

import com.netty.model.player.Player;

public class HighCrate extends Crate {

	public HighCrate(Player player) {
		super(player);
	}

	@Override
	public boolean isLevelNeeded() {
		return this.getPlayer().getCombatLevel() >= 95;
	}
}