package com.grizzly;

import java.util.concurrent.TimeUnit;

import com.grizzly.net.BootGrizzly;
import com.netty.net.NetworkConstants;
import com.netty.net.update.EntityUpdate;
import com.netty.util.Execution;
import com.netty.util.Timing;
import com.netty.world.GarbageCollector;
import com.netty.world.World;
import com.netty.world.WorldConstants;

/**
 * The starting class to start up the
 * Grizzly Server implementation on
 * the Netty Server.
 * @author Josh Rodrigues
 * @since September 18, 2011
 */
public class MainGrizzly {

	/**
	 * Executed upon startup of this application.
	 * @param args
	 * 			The program's arguments.
	 */
	public static void main(String[] args) {
		Timing time = new Timing();
		World.getWorld().getLogger().info("Starting the Grizzly Server emulation project...");
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new EntityUpdate(), 0, NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		BootGrizzly bootGrizzly = new BootGrizzly();
		bootGrizzly.bindPort(NetworkConstants.PORT);
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new GarbageCollector(), 0, WorldConstants.GARBAGE_COLLECTOR_TIME, TimeUnit.MILLISECONDS);
		World.getWorld().getLogger().info("Grizzly Server started in " + time + "...");
	}
}