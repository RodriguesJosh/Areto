package com.netty.world;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.netty.game.model.entity.npc.NPC;
import com.netty.game.model.entity.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:50:42 PM
 */
public class World {

	/**
	 * 
	 */
	private static World world;

	/**
	 * 
	 */
	private List<Player> playerList;

	/**
	 * 
	 */
	private List<NPC> npcList;

	/**
	 * 
	 */
	private Logger logger;

	/**
	 * 
	 */
	public World() {
		this.setPlayerList(new ArrayList<Player>(2000));
		this.setNPCList(new ArrayList<NPC>(2000));
		this.setLogger(Logger.getLogger(this.getClass().getName()));
	}

	/**
	 * 
	 * @param world
	 * 			The id to set.
	 */
	public static void setWorld(World world) {
		World.world = world;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static World getWorld() {
		if (World.world == null) {
			World.setWorld(new World());
		}
		return World.world;
	}

	/**
	 * 
	 * @param playerList
	 * 			The id to set.
	 */
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Player> getPlayerList() {
		return this.playerList;
	}

	/**
	 * 
	 * @param npcList
	 * 			The id to set.
	 */
	public void setNPCList(List<NPC> npcList) {
		this.npcList = npcList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<NPC> getNPCList() {
		return this.npcList;
	}

	/**
	 * 
	 * @param logger
	 * 			The id to set.
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Logger getLogger() {
		return this.logger;
	}
}