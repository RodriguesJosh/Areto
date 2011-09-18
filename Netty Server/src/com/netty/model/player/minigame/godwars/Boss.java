package com.netty.model.player.minigame.godwars;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.world.World;

public abstract class Boss {

	private NPC npc;

	public Boss(Player player) {
		if (this instanceof Bandos) {
			this.setNPC(World.getWorld().getNPCList().get(1));
		} else if (this instanceof Zamorak) {
			this.setNPC(World.getWorld().getNPCList().get(2));
		} else if (this instanceof Saradomin) {
			this.setNPC(World.getWorld().getNPCList().get(3));
		} else if (this instanceof Armadyl) {
			this.setNPC(World.getWorld().getNPCList().get(4));
		}
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}
}