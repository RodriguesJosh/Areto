package com.netty.model.player.minigame.magearena;

import com.netty.model.npc.NPC;
import com.netty.world.World;

public class Kolodion {

	private NPC npc;
	private Form form;

	public Kolodion() {
		this.setNPC(World.getWorld().getNPCList().get(0));
		this.setForm(Form.FIRST);
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Form getForm() {
		return this.form;
	}
}