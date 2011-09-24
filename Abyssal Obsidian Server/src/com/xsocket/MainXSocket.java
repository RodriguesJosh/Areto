package com.xsocket;

import java.util.concurrent.TimeUnit;

import com.netty.net.NetworkConstants;
import com.netty.net.update.EntityUpdate;
import com.netty.util.Execution;
import com.netty.util.Timing;
import com.netty.world.GarbageCollector;
import com.netty.world.World;
import com.netty.world.WorldConstants;
import com.xsocket.net.BootXSocket;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:52:36 AM
 */
public class MainXSocket {

	/**
	 * 
	 * @param args
	 * 			The id to set.
	 */
	public static void main(String[] args) {
		Timing time = new Timing();
		World.getWorld().getLogger().info("Starting the XSocket Server emulation project...");
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new EntityUpdate(), 0, NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		BootXSocket bootXSocket = new BootXSocket();
		bootXSocket.bindPort(NetworkConstants.PORT);
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new GarbageCollector(), 0, WorldConstants.GARBAGE_COLLECTOR_TIME, TimeUnit.MILLISECONDS);
		World.getWorld().getLogger().info("XSocket Server started in " + time + "...");
	}
}