package com.netty.model.player.minigame.magearena;

import com.netty.model.npc.NPC;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:38:44 PM
 */
public class Kolodion {

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 */
	private Form form;

	/**
	 * 
	 */
	public Kolodion() {
		this.setNPC(World.getWorld().getNPCList().get(0));
		this.setForm(Form.FIRST);
	}

	/**
	 * 
	 * @param npc
	 * 			The id to set.
	 */
	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public NPC getNPC() {
		return this.npc;
	}

	/**
	 * 
	 * @param form
	 * 			The id to set.
	 */
	public void setForm(Form form) {
		this.form = form;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Form getForm() {
		return this.form;
	}
}