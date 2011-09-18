package com.netty.model.player.minigame.castlewars;

import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.world.Location;
import com.netty.world.World;

public class SaradominTeam extends Team {

	private Location startLocation;
	private Location endLocation;
	private Teleport teleportLocation;

	public SaradominTeam(Player player) {
		super(player);
	}

	@Override
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	@Override
	public Location getStartLocation() {
		return this.startLocation;
	}

	@Override
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	@Override
	public Location getEndLocation() {
		return this.endLocation;
	}

	@Override
	public Teleport getTeleportLocation() {
		return this.teleportLocation;
	}

	@Override
	public Object getEnterPortal() {
		this.getPlayerList().add(this.getPlayer());
		return World.getWorld().getObjectList().get(4387);
	}

	@Override
	public Object getLeaveLobbyPortal() {
		this.getPlayerList().remove(this.getPlayer());
		return World.getWorld().getObjectList().get(0);
	}

	@Override
	public Object getLeaveGamePortal() {
		this.getPlayerList().remove(this.getPlayer());
		return World.getWorld().getObjectList().get(0);
	}
}