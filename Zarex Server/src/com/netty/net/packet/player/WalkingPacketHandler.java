package com.netty.net.packet.player;

import com.netty.model.Walking;
import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.Location;

public class WalkingPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		if (player == null) {
			return;
		}
		if (packetAttribute == null) {
			return;
		}
		int length = (Integer) packetAttribute.getAttribute("LENGTH");// getPosition();
		if (player.getPacket().getOpcode() == 248) {
			length -= 14;
		}
		Walking walking = player.getWalking();
		walking.resetWalking();
		int steps = (length - 5) / 2;
		short[][] path = new short[steps][2];
		short firstX = (Short) packetAttribute.getAttribute("FIRST_X");// getLEShortA();
		for (int i = 0; i < steps; i++) {
			path[i][0] = (Byte) packetAttribute.getAttribute("PATH_ONE");// getByte();
			path[i][1] = (Byte) packetAttribute.getAttribute("PATH_TWO");// getByte();
		}
		short firstY = (Short) packetAttribute.getAttribute("FIRST_Y");// getLEShort();
		boolean runSteps = (Boolean) packetAttribute.getAttribute("RUN_STEPS");// getByteC() == 1;
		player.getWalking().setRunningQueue(runSteps);
		Location location = new Location(firstX, firstY, player.getLocation().getZ());
		walking.addStep(location);
		for (int i = 0; i < steps; i++) {
			path[i][0] += location.getX();
			path[i][1] += location.getY();
			Location stepLocation = new Location(path[i][0], path[i][1], player.getLocation().getZ());
			walking.addStep(stepLocation);
		}
		walking.finish();
	}
}