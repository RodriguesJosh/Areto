package com.netty.model.player.minigame.castlewars;

import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.world.Location;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:28:44 PM
 */
public class ZamorakTeam extends Team {

	/**
	 * 
	 */
	private Location startLocation;

	/**
	 * 
	 */
	private Location endLocation;

	/**
	 * 
	 */
	private Teleport teleportLocation;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public ZamorakTeam(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.castlewars.Team#setStartLocation(com.netty.world.Location)
	 */
	@Override
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.castlewars.Team#getStartLocation()
	 */
	@Override
	public Location getStartLocation() {
		return this.startLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.castlewars.Team#setEndLocation(com.netty.world.Location)
	 */
	@Override
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.castlewars.Team#getEndLocation()
	 */
	@Override
	public Location getEndLocation() {
		return this.endLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.castlewars.Team#getTeleportLocation()
	 */
	@Override
	public Teleport getTeleportLocation() {
		return this.teleportLocation;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.castlewars.Team#getEnterPortal()
	 */
	@Override
	public Object getEnterPortal() {
		this.getPlayerList().add(this.getPlayer());
		return World.getWorld().getObjectList().get(4388);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.castlewars.Team#getLeaveLobbyPortal()
	 */
	@Override
	public Object getLeaveLobbyPortal() {
		this.getPlayerList().remove(this.getPlayer());
		return World.getWorld().getObjectList().get(0);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.castlewars.Team#getLeaveGamePortal()
	 */
	@Override
	public Object getLeaveGamePortal() {
		this.getPlayerList().remove(this.getPlayer());
		return World.getWorld().getObjectList().get(0);
	}
}