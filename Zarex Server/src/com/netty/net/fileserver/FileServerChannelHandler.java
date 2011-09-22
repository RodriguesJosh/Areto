package com.netty.net.fileserver;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelLocal;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.netty.world.World;

public class FileServerChannelHandler extends SimpleChannelHandler {

	private ChannelLocal<UpdateSession> updateSessionLocal = new ChannelLocal<UpdateSession>();
	private UpdateType updateType;

	public FileServerChannelHandler(UpdateType updateType) {
		this.setUpdateType(updateType);
	}

	@Override
	public void channelConnected(ChannelHandlerContext chc, ChannelStateEvent cse) throws Exception {
		this.getUpdateSessionLocal().set(cse.getChannel(), new UpdateSession(this.getUpdateType(), cse.getChannel()));
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext chc, ChannelStateEvent cse) throws Exception {
		this.getUpdateSessionLocal().remove(cse.getChannel());
	}

	@Override
	public void messageReceived(ChannelHandlerContext chc, MessageEvent me) throws Exception {
		String message = (String) me.getMessage();
		this.getUpdateSessionLocal().get(me.getChannel()).readLine(message);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext chc, ExceptionEvent ee) throws Exception {
		World.getWorld().getLogger().severe("Error while handling request." + ee.getCause());
	}

	public void setUpdateSessionLocal(ChannelLocal<UpdateSession> updateSessionLocal) {
		this.updateSessionLocal = updateSessionLocal;
	}

	public ChannelLocal<UpdateSession> getUpdateSessionLocal() {
		return this.updateSessionLocal;
	}

	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}

	public UpdateType getUpdateType() {
		return this.updateType;
	}
}