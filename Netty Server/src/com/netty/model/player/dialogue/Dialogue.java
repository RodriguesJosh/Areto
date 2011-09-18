package com.netty.model.player.dialogue;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;

public class Dialogue {

	private Player player;
	private NPC npc;
	private String[] text;

	public Dialogue(Player player, NPC npc, String[] text) {
		this.setPlayer(player);
		this.setNPC(npc);
		this.setText(text);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	public void setText(String[] text) {
		this.text = text;
	}

	public String[] getText() {
		return this.text;
	}
}