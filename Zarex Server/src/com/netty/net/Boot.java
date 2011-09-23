package com.netty.net;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:34:32 PM
 */
public class Boot {

	/**
	 * 
	 */
	private ServerBootstrap serverBootStrap;

	/**
	 * 
	 */
	public Boot() {
		this.setServerBootStrap(new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool())));
	}

	/**
	 * 
	 * @param port
	 * 			The id to set.
	 */
	public void bindPort(int port) {
		this.getServerBootStrap().setPipelineFactory(new Pipeline());
		this.getServerBootStrap().bind(new InetSocketAddress(port));
		World.getWorld().getLogger().info("Server bootstrap binded to port " + port + "...");
	}

	/**
	 * 
	 * @param serverBootStrap
	 * 			The id to set.
	 */
	public void setServerBootStrap(ServerBootstrap serverBootStrap) {
		this.serverBootStrap = serverBootStrap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ServerBootstrap getServerBootStrap() {
		return this.serverBootStrap;
	}
}