package com.netty.model.player.randomevent.mime;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

public class Mime extends RandomEvent {

	public Mime(Player player) {
		super(player);
	}

	@Override
	public void start() {}

	@Override
	public void end() {}

	@Override
	public boolean isMembers() {
		return false;
	}

	@Override
	public Teleport getTeleportingLocation() {
		return null;
	}
}