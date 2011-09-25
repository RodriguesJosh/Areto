package com.netty.net.packet.player;

import com.netty.model.Walking;
import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:16:32 PM
 */
/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:55:56 PM
 */
public class WalkingPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		if (player == null) {
			return;
		}
		if (packetAttribute == null) {
			return;
		}
		Integer lengthInteger = (Integer) packetAttribute.getAttribute("LENGTH");
		int length = lengthInteger.intValue();// getPosition();
		if (player.getPacket().getOpcode() == 248) {
			length -= 14;
		}
		Walking walking = player.getWalking();
		walking.resetWalking();
		int steps = (length - 5) / 2;
		short[][] path = new short[steps][2];
		Short firstXShort = (Short) packetAttribute.getAttribute("FIRST_X");// getLEShortA();
		short firstX = firstXShort.shortValue();
		for (int i = 0; i < steps; i++) {
			Byte firstPath = (Byte) packetAttribute.getAttribute("PATH_ONE");// getByte();
			path[i][0] = firstPath.byteValue();
			Byte secondPath = (Byte) packetAttribute.getAttribute("PATH_TWO");// getByte();
			path[i][1] = secondPath.byteValue();
		}
		Short firstShort = (Short) packetAttribute.getAttribute("FIRST_Y");
		short firstY = firstShort.shortValue();// getLEShort();
		Boolean runStepsBoolean = (Boolean) packetAttribute.getAttribute("RUN_STEPS");
		boolean runSteps = runStepsBoolean.booleanValue();// getByteC() == 1;
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