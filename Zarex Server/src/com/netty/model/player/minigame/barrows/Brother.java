package com.netty.model.player.minigame.barrows;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.world.Location;

public abstract class Brother {

	private Player player;

	public Brother(Player player) {
		this.setPlayer(player);
	}

	public abstract void setStartLocation(Location startLocation);
	public abstract Location getStartLocation();
	public abstract void setEndLocation(Location endLocation);
	public abstract Location getEndLocation();
	public abstract void setNPC(NPC npc);
	public abstract NPC getNPC();
	public abstract void setTeleportLocation(Teleport teleport);
	public abstract Teleport getTeleportLocation();

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}