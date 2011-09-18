package com.netty.model.player.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.update.ForceChat;
import com.netty.world.World;

public class BarrelchestMkII {

	private NPC npc;
	private ForceChat firstForceChat;
	private ForceChat secondForceChat;

	public BarrelchestMkII() {
		NPC npc = World.getWorld().getNPCList().get(0);
		this.setNPC(npc);
		ForceChat firstForceChat = new ForceChat("Heh heh heh");
		this.setFirstForceChat(firstForceChat);
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	public void setFirstForceChat(ForceChat firstForceChat) {
		this.firstForceChat = firstForceChat;
	}

	public ForceChat getFirstForceChat() {
		return this.firstForceChat;
	}

	public void setSecondForceChat(ForceChat secondForceChat) {
		this.secondForceChat = secondForceChat;
	}

	public ForceChat getSecondForceChat() {
		return this.secondForceChat;
	}
}