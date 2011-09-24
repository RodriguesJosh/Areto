package com.netty.model.player.randomevent.bigfish;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:45:50 PM
 */
public class BigFish extends RandomEvent {

	/**
	 * 
	 */
	private BigFishNPC bigFishNPC;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public BigFish(Player player) {
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

	/**
	 * 
	 * @param bigFishNPC
	 * 			The id to set.
	 */
	public void setBigFishNPC(BigFishNPC bigFishNPC) {
		this.bigFishNPC = bigFishNPC;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BigFishNPC getBigFishNPC() {
		return this.bigFishNPC;
	}
}