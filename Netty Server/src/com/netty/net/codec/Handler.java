package com.netty.net.codec;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.netty.model.player.Player;
import com.netty.net.packet.Packet;
import com.netty.net.packet.PacketManagerXML;
import com.netty.world.World;

public class Handler extends SimpleChannelHandler {

	@Override
	public void channelConnected(ChannelHandlerContext chc, ChannelStateEvent cse) {
		if (chc.getChannel() == null) {
			return;
		}
		Player player = new Player(chc.getChannel());
		World.getWorld().getChannelLocal().set(player.getChannel(), player);
		// new JavaScriptXML().parseJavaScripts();
		// new PythonScriptXML().parsePythonScripts();
		// new RubyScriptXML().parseRubyScripts();
		// new ItemSpawn().parseItemsSpawned();
		// new ItemDrop().parseItemDrops();
		// new NPCSpawn().parseNPCSSpawned();
		// new NPCDrop().parseNPCDrops();
		// new ObjectSpawn().parseObjectsSpawned(player);
		World.getWorld().getLogger().info("Channel connected from " + chc.getChannel().getRemoteAddress() + "...");
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext chc, ChannelStateEvent cse) {
		Player player = World.getWorld().getChannelLocal().get(chc.getChannel());
		if (player == null) {
			return;
		}
		player.getPacketSender().getLogout();
		World.getWorld().getLogger().info("Channel disconnected from " + chc.getChannel().getRemoteAddress() + "...");
	}

	@Override
	public void messageReceived(ChannelHandlerContext chc, MessageEvent me) {
		Player player = World.getWorld().getChannelLocal().get(chc.getChannel());
		if (player == null) {
			return;
		}
		Packet packet = (Packet) me.getMessage();
		if (packet == null) {
			return;
		}
		PacketManagerXML.execute(player, packet);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext chc, ExceptionEvent ee) {}
}