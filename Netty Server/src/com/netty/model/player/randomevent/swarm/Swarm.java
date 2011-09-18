package com.netty.model.player.randomevent.swarm;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

public class Swarm extends RandomEvent {

	public Swarm(Player player) {
		super(player);
	}

	@Override
	public Teleport getTeleportingLocation() {
		return null;
	}

	@Override
	public void start() {}

	@Override
	public void end() {}

	@Override
	public boolean isMembers() {
		return false;
	}
}