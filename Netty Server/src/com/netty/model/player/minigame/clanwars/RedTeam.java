package com.netty.model.player.minigame.clanwars;

import com.netty.model.player.Player;
import com.netty.world.World;

public class RedTeam extends Team {

	public RedTeam(Player player) {
		super(player);
	}

	@Override
	public boolean isDangerous() {
		return true;
	}

	@Override
	public Object getPortal() {
		return World.getWorld().getObjectList().get(0);
	}
}