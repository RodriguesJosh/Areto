package com.netty.model.player.minigame.pestcontrol;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;

public class Portal {

	private NPC npc;

	public Portal(Player player) {
		this.setNPC(new NPC(0));
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}
}