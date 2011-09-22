package com.netty.model.player.minigame.barbarianassault;

import com.netty.model.npc.NPC;

public enum PenanceCreature {

	PENANCE_RANGER, PENANCE_FIGHTER, PENANCE_RUNNER, PENANCE_HEALER;

	private NPC npc;

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}
}