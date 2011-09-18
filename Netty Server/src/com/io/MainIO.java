package com.io;

import java.util.concurrent.TimeUnit;

import com.io.net.BootIO;
import com.netty.net.NetworkConstants;
import com.netty.net.update.EntityUpdate;
import com.netty.util.Execution;
import com.netty.util.Timing;
import com.netty.world.GarbageCollector;
import com.netty.world.World;
import com.netty.world.WorldConstants;

/**
 * The main class to start up the Grizzly
 * implementation of this server.
 * @author Josh Rodrigues
 * @since September 18, 2011
 */
public class MainIO {

	/**
	 * The main method to execute upon startup
	 * of this application/program.
	 * @param args
	 * 			The program's arguments.
	 */
	public static void main(String[] args) {
		Timing time = new Timing();
		World.getWorld().getLogger().info("Starting the IO Server emulation project...");
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new EntityUpdate(), 0, NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		BootIO bootIO = new BootIO();
		bootIO.bindPort(NetworkConstants.PORT);
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new GarbageCollector(), 0, WorldConstants.GARBAGE_COLLECTOR_TIME, TimeUnit.MILLISECONDS);
		World.getWorld().getLogger().info("IO Server started in " + time + "...");
	}
}