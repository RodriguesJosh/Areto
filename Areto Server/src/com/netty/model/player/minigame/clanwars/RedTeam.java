package com.netty.model.player.minigame.clanwars;

import com.netty.model.player.Player;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:29:55 PM
 */
public class RedTeam extends Team {

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public RedTeam(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.clanwars.Team#isDangerous()
	 */
	@Override
	public boolean isDangerous() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.clanwars.Team#getPortal()
	 */
	@Override
	public Object getPortal() {
		return World.getWorld().getObjectList().get(0);
	}
}