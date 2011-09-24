package com.netty.world;

import com.netty.util.Timing;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:54:57 AM
 */
public class GarbageCollector implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Timing time = new Timing();
		long beforeCollector = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
		System.gc();
		System.runFinalization();
		long afterCollector = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
		int memory = (int) (beforeCollector - afterCollector) / 1024;
		World.getWorld().getLogger().info("Cleaned out " + memory + " KB of memory in " + time + "...");
	}
}