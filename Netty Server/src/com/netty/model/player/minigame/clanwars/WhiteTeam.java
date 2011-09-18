package com.netty.model.player.minigame.clanwars;

import com.netty.model.player.Player;
import com.netty.world.World;

public class WhiteTeam extends Team {

	public WhiteTeam(Player player) {
		super(player);
	}

	@Override
	public boolean isDangerous() {
		return false;
	}

	@Override
	public Object getPortal() {
		return World.getWorld().getObjectList().get(0);
	}
}