package com.netty.net.codec;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.timeout.ReadTimeoutHandler;
import org.jboss.netty.util.HashedWheelTimer;

import com.netty.world.World;

public class Timeout extends ReadTimeoutHandler {

	public Timeout() {
		super(new HashedWheelTimer(), 5);
	}

	@Override
	public void readTimedOut(ChannelHandlerContext chc) {
		if (chc == null) {
			return;
		}
		chc.getChannel().close();
		World.getWorld().getLogger().info("Channel from " + chc.getChannel().getRemoteAddress() + " has timed out....");
	}
}