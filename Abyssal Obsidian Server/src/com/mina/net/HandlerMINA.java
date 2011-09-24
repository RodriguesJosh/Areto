package com.mina.net;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;

import com.mina.net.codec.CodecFactoryMINA;
import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.world.World;

/**
 * Handles incoming connections from
 * the client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:41:42 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class HandlerMINA extends IoHandlerAdapter {

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.core.service.IoHandlerAdapter#sessionOpened(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public void sessionOpened(IoSession ioSession) {
		ioSession.setAttribute("remote", ioSession.getRemoteAddress());
		ioSession.getFilterChain().addFirst("codec", new ProtocolCodecFilter(CodecFactoryMINA.getLoginFactory()));
		World.getWorld().getLogger().info("Connected from " + ioSession.getRemoteAddress() + "...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.core.service.IoHandlerAdapter#sessionClosed(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public void sessionClosed(IoSession ioSession) {
		ioSession.close(false);
		World.getWorld().getLogger().info("Disconnected from " + ioSession.getRemoteAddress() + "...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.core.service.IoHandlerAdapter#messageReceived(org.apache.mina.core.session.IoSession, java.lang.Object)
	 */
	@Override
	public void messageReceived(IoSession ioSession, Object object) {
		// Packet packet = (Packet) object;
		// Player player = (Player) ioSession.getAttribute("player");
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.core.service.IoHandlerAdapter#exceptionCaught(org.apache.mina.core.session.IoSession, java.lang.Throwable)
	 */
	@Override
	public void exceptionCaught(IoSession ioSession, Throwable throwable) {
		throwable.printStackTrace();
		ioSession.close(false);
	}
}