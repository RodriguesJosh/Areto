package com.mina.net;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;

import com.mina.net.codec.CodecFactoryMINA;
import com.netty.world.World;

public class HandlerMINA extends IoHandlerAdapter {

	@Override
	public void sessionOpened(IoSession ioSession) throws Exception {
		ioSession.setAttribute("remote", ioSession.getRemoteAddress());
		ioSession.getFilterChain().addFirst("codec", new ProtocolCodecFilter(CodecFactoryMINA.getLoginFactory()));
		World.getWorld().getLogger().info("Connected from " + ioSession.getRemoteAddress() + "...");
	}

	@Override
	public void sessionClosed(IoSession ioSession) throws Exception {
		ioSession.close(false);
		World.getWorld().getLogger().info("Disconnected from " + ioSession.getRemoteAddress() + "...");
	}

	@Override
	public void messageReceived(IoSession ioSession, Object object) throws Exception {
		// Packet packet = (Packet) object;
		// Player player = (Player) ioSession.getAttribute("player");
	}

	@Override
	public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {
		throwable.printStackTrace();
		ioSession.close(false);
	}
}