package com.netty;

import java.util.concurrent.TimeUnit;

import com.netty.net.Boot;
import com.netty.net.NetworkConstants;
import com.netty.net.fileserver.FileServer;
import com.netty.net.packet.PacketManagerXML;
import com.netty.net.update.EntityUpdate;
import com.netty.util.Execution;
import com.netty.util.Timing;
import com.netty.world.GarbageCollector;
import com.netty.world.World;
import com.netty.world.WorldConstants;

/**
 * The starting class to start up the
 * Netty Server.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 9:13:11 PM
 */
public class Main {

	/**
	 * Executed upon startup of this application.
	 * 
	 * @param args
	 * 			The program's arguments.
	 */
	public static void main(String[] args) {
		try {
			Timing time = new Timing();
			World.getWorld().getLogger().info("Starting the Netty Server emulation project...");
			PacketManagerXML.parsePackets();
			new FileServer();
			Execution.getScheduledExecutorService().scheduleAtFixedRate(new EntityUpdate(), 0, NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
			Boot boot = new Boot();
			boot.bindPort(NetworkConstants.PORT);
			Execution.getScheduledExecutorService().scheduleAtFixedRate(new GarbageCollector(), 0, WorldConstants.GARBAGE_COLLECTOR_TIME, TimeUnit.MILLISECONDS);
			// Runtime.getRuntime().exec("C:/Program Files/Java/jdk1.6.0_26/bin/jvisualvm.exe");
			World.getWorld().getLogger().info("Netty Server started in " + time + "...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}