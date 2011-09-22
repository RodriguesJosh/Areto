package com.netty.model.player.randomevent.kissfrog;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

public class KissTheFrog extends RandomEvent {

	public KissTheFrog(Player player) {
		super(player);
	}

	@Override
	public void start() {}

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
}