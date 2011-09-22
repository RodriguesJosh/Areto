package com.netty.model.player.minigame.castlewars;

import com.netty.model.object.impl.Portal;
import com.netty.model.player.Player;
import com.netty.world.Location;
import com.netty.world.World;

public class GuthixPortal extends Portal {

	public GuthixPortal(Player player, Team team) {
		super(0, (byte) 1, (byte) 10, new Location((short) 0, (short) 0, (byte) 0));
		World.getWorld().getObjectList().get(4408);
		team.getPlayerList().add(player);
	}
}