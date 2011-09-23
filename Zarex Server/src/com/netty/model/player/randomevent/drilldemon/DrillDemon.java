package com.netty.model.player.randomevent.drilldemon;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:44:27 PM
 */
public class DrillDemon extends RandomEvent {

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public DrillDemon(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.randomevent.RandomEvent#start()
	 */
	@Override
	public void start() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.randomevent.RandomEvent#end()
	 */
	@Override
	public void end() {
		//
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.randomevent.RandomEvent#getTeleportingLocation()
	 */
	@Override
	public Teleport getTeleportingLocation() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.randomevent.RandomEvent#isMembers()
	 */
	@Override
	public boolean isMembers() {
		return false;
	}
}