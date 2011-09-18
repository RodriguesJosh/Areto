package com.netty.model.player.randomevent.axehandleaxehead;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.randomevent.RandomEvent;

public class AxeHandleAxeHead extends RandomEvent {

	private AxeHandle axeHandle;
	private AxeHead axeHead;

	public AxeHandleAxeHead(Player player) {
		super(player);
	}

	@Override
	public void start() {
		// If the player is woodcutting or mining, make the handle and head fly off.
	}

	@Override
	public void end() {
		return;
	}

	@Override
	public Teleport getTeleportingLocation() {
		return null;
	}

	@Override
	public boolean isMembers() {
		return false;
	}

	public void setAxeHandle(AxeHandle axeHandle) {
		this.axeHandle = axeHandle;
	}

	public AxeHandle getAxeHandle() {
		return this.axeHandle;
	}

	public void setAxeHead(AxeHead axeHead) {
		this.axeHead = axeHead;
	}

	public AxeHead getAxeHead() {
		return this.axeHead;
	}
}