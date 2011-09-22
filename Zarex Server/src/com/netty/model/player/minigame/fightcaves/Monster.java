package com.netty.model.player.minigame.fightcaves;

import com.netty.model.combat.CombatType;
import com.netty.model.npc.NPC;

public enum Monster {

	TZ_KIH, TZ_KEK, TZ_KEK_MINI, TOK_XIL, YT_MEJKOT, KET_ZEK, TZTOK_JAD, YT_HURKOT;

	private NPC npc;
	private CombatType combatType;
	private int maxHit;

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}

	public CombatType getCombatType() {
		return this.combatType;
	}

	public void setMaxHit(int maxHit) {
		this.maxHit = maxHit;
	}

	public int getMaxHit() {
		return this.maxHit;
	}
}