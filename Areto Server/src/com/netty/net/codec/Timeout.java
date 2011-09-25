package com.netty.net.codec;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.timeout.ReadTimeoutHandler;
import org.jboss.netty.util.HashedWheelTimer;

import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:28:32 PM
 */
public class Timeout extends ReadTimeoutHandler {

	/**
	 * 
	 */
	public Timeout() {
		super(new HashedWheelTimer(), 5);
	}

	/* (non-Javadoc)
	 * @see org.jboss.netty.handler.timeout.ReadTimeoutHandler#readTimedOut(org.jboss.netty.channel.ChannelHandlerContext)
	 */
	@Override
	public void readTimedOut(ChannelHandlerContext chc) {
		if (chc == null) {
			return;
		}
		chc.getChannel().close();
		World.getWorld().getLogger().info("Channel from " + chc.getChannel().getRemoteAddress() + " has timed out....");
	}
}