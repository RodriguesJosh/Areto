package com.netty;

import java.util.concurrent.TimeUnit;

import com.netty.util.Constants;
import com.netty.util.Execution;
import com.netty.util.Timing;
import com.netty.world.GarbageCollector;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 6:54:16 PM
 */
public class Main {

	/**
	 * 
	 * @param args
	 * 			The program's arguments.
	 */
	public static void main(String[] args) {
		Timing time = new Timing();
		World.getWorld().getLogger().info("Starting the client emulation project...");

		Execution.getScheduledExecutorService().scheduleAtFixedRate(new GarbageCollector(), 0, Constants.GARBAGE_COLLECTOR_TIME, TimeUnit.MILLISECONDS);
		World.getWorld().getLogger().info("Client started in " + time + "...");
	}
}