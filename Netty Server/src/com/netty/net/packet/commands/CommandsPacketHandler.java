package com.netty.net.packet.commands;

import com.netty.model.player.Player;
import com.netty.model.player.Rank;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class CommandsPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		String commandString = (String) packetAttribute.getAttribute("COMMAND");// getString();
		World.getWorld().getLogger().info("Command : " + commandString);
		String[] splitCommand = commandString.split(" ");
		String commandStringLower = splitCommand[0].toLowerCase();
		Command command = new Command(commandStringLower, Rank.ADMINISTRATOR);
		CommandManager.execute(command, player);
	}
}