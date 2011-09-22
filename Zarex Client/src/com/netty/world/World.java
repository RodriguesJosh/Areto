package com.netty.world;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.netty.game.model.entity.npc.NPC;
import com.netty.game.model.entity.player.Player;

public class World {

	private static World world;
	private List<Player> playerList;
	private List<NPC> npcList;
	private Logger logger;

	public World() {
		this.setPlayerList(new ArrayList<Player>(2000));
		this.setNPCList(new ArrayList<NPC>(2000));
		this.setLogger(Logger.getLogger(this.getClass().getName()));
	}

	public static void setWorld(World world) {
		World.world = world;
	}

	public static World getWorld() {
		if (World.world == null) {
			World.setWorld(new World());
		}
		return World.world;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public List<Player> getPlayerList() {
		return this.playerList;
	}

	public void setNPCList(List<NPC> npcList) {
		this.npcList = npcList;
	}

	public List<NPC> getNPCList() {
		return this.npcList;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Logger getLogger() {
		return this.logger;
	}
}
