package com.mina;

import java.util.concurrent.TimeUnit;

import com.mina.net.BootMINA;
import com.netty.net.NetworkConstants;
import com.netty.net.update.EntityUpdate;
import com.netty.util.Execution;
import com.netty.util.Timing;
import com.netty.world.GarbageCollector;
import com.netty.world.World;
import com.netty.world.WorldConstants;

public class MainMINA {

	public static void main(String[] args) {
		Timing time = new Timing();
		World.getWorld().getLogger().info("Starting the MINA Server emulation project...");
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new EntityUpdate(), 0, NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		BootMINA bootMINA = new BootMINA();
		bootMINA.bindPort(NetworkConstants.PORT);
		Execution.getScheduledExecutorService().scheduleAtFixedRate(new GarbageCollector(), 0, WorldConstants.GARBAGE_COLLECTOR_TIME, TimeUnit.MILLISECONDS);
		World.getWorld().getLogger().info("MINA Server started in " + time + "...");
	}
}