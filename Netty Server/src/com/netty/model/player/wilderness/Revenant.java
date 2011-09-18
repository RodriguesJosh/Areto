package com.netty.model.player.wilderness;

import com.netty.model.npc.NPC;

public class Revenant {

	private NPC npc;

	public Revenant(NPC npc) {
		this.setNPC(npc);
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}
}