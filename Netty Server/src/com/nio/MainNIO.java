package com.nio;

import java.util.concurrent.TimeUnit;

import com.netty.net.NetworkConstants;
import com.netty.net.update.EntityUpdate;
import com.netty.util.Execution;
import com.netty.util.Timing;
import com.netty.world.GarbageCollector;
import com.netty.world.World;
import com.netty.world.WorldConstants;
import com.nio.net.BootNIO;

public class MainNIO {

	public static void main(String[] args) {
		Timing time = new Timing();
		World.getWorld().getLogger().info("Starting the MINA Server emulation project...");
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new EntityUpdate(), 0, NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		BootNIO bootNIO = new BootNIO();
		bootNIO.bindPort(NetworkConstants.PORT);
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new GarbageCollector(), 0, WorldConstants.GARBAGE_COLLECTOR_TIME, TimeUnit.MILLISECONDS);
		World.getWorld().getLogger().info("NIO Server started in " + time + "...");
	}
}