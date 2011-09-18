package com.netty.model.player.randomevent.beekeeper;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

public class BeeKeeper extends RandomEvent {

	private BeeKeeperNPC beeKeeperNPC;
	private Reward reward;

	public BeeKeeper(Player player) {
		super(player);
	}

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

	@Override
	public void end() {}

	@Override
	public Teleport getTeleportingLocation() {
		return null;
	}

	@Override
	public boolean isMembers() {
		return false;
	}

	public void setBeeKeeperNPC(BeeKeeperNPC beeKeeperNPC) {
		this.beeKeeperNPC = beeKeeperNPC;
	}

	public BeeKeeperNPC getBeeKeeperNPC() {
		return this.beeKeeperNPC;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public Reward getReward() {
		return this.reward;
	}
}