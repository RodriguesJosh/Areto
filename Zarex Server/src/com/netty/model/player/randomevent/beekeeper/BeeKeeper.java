package com.netty.model.player.randomevent.beekeeper;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 6:46:29 PM
 */
public class BeeKeeper extends RandomEvent {

	/**
	 * 
	 */
	private BeeKeeperNPC beeKeeperNPC;

	/**
	 * 
	 */
	private Reward reward;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public BeeKeeper(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.randomevent.RandomEvent#start()
	 */
	@Override
	public void start() {
		// Teleport the user to the bee hive.
		// Show the NPC dialogue along with the player's.
		// Show the interface.
		// If did not drag components to center of the display panel, show message "You need
		// to move all 4 of the spinning components to the frame in the centre of the
		// display."
		// If correct, teleport the user to where he was.
		// Give him the magical box.
		// If not correct, show more dialogue until correct.
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
	 * @param beeKeeperNPC
	 * 			The id to set.
	 */
	public void setBeeKeeperNPC(BeeKeeperNPC beeKeeperNPC) {
		this.beeKeeperNPC = beeKeeperNPC;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BeeKeeperNPC getBeeKeeperNPC() {
		return this.beeKeeperNPC;
	}

	/**
	 * 
	 * @param reward
	 * 			The id to set.
	 */
	public void setReward(Reward reward) {
		this.reward = reward;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Reward getReward() {
		return this.reward;
	}
}