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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:30:22 PM
 */
public class Handler extends SimpleChannelHandler {

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#channelConnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
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

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#channelDisconnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
	@Override
	public void channelDisconnected(ChannelHandlerContext chc, ChannelStateEvent cse) {
		Player player = World.getWorld().getChannelLocal().get(chc.getChannel());
		if (player == null) {
			return;
		}
		player.getPacketSender().getLogout();
		World.getWorld().getLogger().info("Channel disconnected from " + chc.getChannel().getRemoteAddress() + "...");
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#messageReceived(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.MessageEvent)
	 */
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

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext chc, ExceptionEvent ee) {
		return;
	}
}