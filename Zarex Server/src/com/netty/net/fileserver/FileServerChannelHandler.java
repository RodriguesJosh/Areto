package com.netty.net.fileserver;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelLocal;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:22:00 PM
 */
public class FileServerChannelHandler extends SimpleChannelHandler {

	/**
	 * 
	 */
	private ChannelLocal<UpdateSession> updateSessionLocal = new ChannelLocal<UpdateSession>();

	/**
	 * 
	 */
	private UpdateType updateType;

	/**
	 * 
	 * @param updateType
	 * 			The id to set.
	 */
	public FileServerChannelHandler(UpdateType updateType) {
		this.setUpdateType(updateType);
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#channelConnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
	@Override
	public void channelConnected(ChannelHandlerContext chc, ChannelStateEvent cse) {
		this.getUpdateSessionLocal().set(cse.getChannel(), new UpdateSession(this.getUpdateType(), cse.getChannel()));
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#channelDisconnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
	@Override
	public void channelDisconnected(ChannelHandlerContext chc, ChannelStateEvent cse) {
		this.getUpdateSessionLocal().remove(cse.getChannel());
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#messageReceived(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.MessageEvent)
	 */
	@Override
	public void messageReceived(ChannelHandlerContext chc, MessageEvent me) {
		String message = (String) me.getMessage();
		this.getUpdateSessionLocal().get(me.getChannel()).readLine(message);
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext chc, ExceptionEvent ee) {
		World.getWorld().getLogger().severe("Error while handling request." + ee.getCause());
	}

	/**
	 * 
	 * @param updateSessionLocal
	 * 			The id to set.
	 */
	public void setUpdateSessionLocal(ChannelLocal<UpdateSession> updateSessionLocal) {
		this.updateSessionLocal = updateSessionLocal;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ChannelLocal<UpdateSession> getUpdateSessionLocal() {
		return this.updateSessionLocal;
	}

	/**
	 * 
	 * @param updateType
	 * 			The id to set.
	 */
	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public UpdateType getUpdateType() {
		return this.updateType;
	}
}