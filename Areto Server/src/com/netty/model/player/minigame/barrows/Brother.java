package com.netty.model.player.minigame.barrows;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:03:42 PM
 */
public abstract class Brother {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Brother(Player player) {
		this.setPlayer(player);
	}

	/**
	 * 
	 * @param startLocation
	 * 			The id to set.
	 */
	public abstract void setStartLocation(Location startLocation);

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract Location getStartLocation();

	/**
	 * 
	 * @param endLocation
	 * 			The id to set.
	 */
	public abstract void setEndLocation(Location endLocation);

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract Location getEndLocation();

	/**
	 * 
	 * @param npc
	 * 			The id to set.
	 */
	public abstract void setNPC(NPC npc);

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract NPC getNPC();

	/**
	 * 
	 * @param teleport
	 * 			The id to set.
	 */
	public abstract void setTeleportLocation(Teleport teleport);

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract Teleport getTeleportLocation();

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
	}
}