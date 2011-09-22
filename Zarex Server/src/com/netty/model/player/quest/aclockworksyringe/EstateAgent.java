package com.netty.model.player.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.update.ForceChat;
import com.netty.world.World;

public class EstateAgent {

	private NPC npc;
	private ForceChat forceChat;

	public EstateAgent() {
		NPC npc = World.getWorld().getNPCList().get(0);
		this.setNPC(npc);
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	public void setForceChat(ForceChat forceChat) {
		this.forceChat = forceChat;
	}

	public ForceChat getForceChat() {
		return this.forceChat;
	}
}