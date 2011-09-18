package com.netty.model.player.minigame.bountyhunter;

import com.netty.model.player.Player;

public class MediumCrate extends Crate {

	public MediumCrate(Player player) {
		super(player);
	}

	@Override
	public boolean isLevelNeeded() {
		return (this.getPlayer().getCombatLevel() >= 50) && (this.getPlayer().getCombatLevel() <= 100);
	}
}