package com.netty.model.player.minigame.bountyhunter;

import com.netty.model.player.Player;

public class LowCrate extends Crate {

	public LowCrate(Player player) {
		super(player);
	}

	@Override
	public boolean isLevelNeeded() {
		return (this.getPlayer().getCombatLevel() >= 3) && (this.getPlayer().getCombatLevel() <= 55);
	}
}