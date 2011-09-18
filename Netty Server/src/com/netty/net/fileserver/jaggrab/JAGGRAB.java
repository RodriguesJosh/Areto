package com.netty.net.fileserver.jaggrab;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.netty.net.fileserver.FileServerConstants;

public class JAGGRAB {

	private ServerBootstrap serverBootstrap;

	public JAGGRAB() {
		this.setServerBootstrap(new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newSingleThreadExecutor(), Executors.newSingleThreadExecutor())));
		this.getServerBootstrap().bind(new InetSocketAddress(FileServerConstants.JAGGRAB_PORT));
	}

	public void setServerBootstrap(ServerBootstrap serverBootstrap) {
		this.serverBootstrap = serverBootstrap;
	}

	public ServerBootstrap getServerBootstrap() {
		return this.serverBootstrap;
	}
}