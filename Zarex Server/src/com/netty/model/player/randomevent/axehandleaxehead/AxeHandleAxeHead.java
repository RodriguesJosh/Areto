package com.netty.model.player.randomevent.axehandleaxehead;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:47:06 PM
 */
public class AxeHandleAxeHead extends RandomEvent {

	/**
	 * 
	 */
	private AxeHandle axeHandle;

	/**
	 * 
	 */
	private AxeHead axeHead;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public AxeHandleAxeHead(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.randomevent.RandomEvent#start()
	 */
	@Override
	public void start() {
		// If the player is woodcutting or mining, make the handle and head fly off.
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.randomevent.RandomEvent#end()
	 */
	@Override
	public void end() {
		return;
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
	 * @param axeHandle
	 * 			The id to set.
	 */
	public void setAxeHandle(AxeHandle axeHandle) {
		this.axeHandle = axeHandle;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public AxeHandle getAxeHandle() {
		return this.axeHandle;
	}

	/**
	 * 
	 * @param axeHead
	 * 			The id to set.
	 */
	public void setAxeHead(AxeHead axeHead) {
		this.axeHead = axeHead;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public AxeHead getAxeHead() {
		return this.axeHead;
	}
}