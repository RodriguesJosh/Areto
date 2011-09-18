package com.netty.model.player.quest.aclockworksyringe;

import com.netty.model.npc.NPC;
import com.netty.model.update.ForceChat;
import com.netty.world.World;

public class ZombieHead {

	private NPC npc;
	private ForceChat firstForceChat;
	private ForceChat secondForceChat;
	private ForceChat thirdForceChat;

	public ZombieHead() {
		NPC npc = World.getWorld().getNPCList().get(0);
		this.setNPC(npc);
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

	public void setThirdForceChat(ForceChat thirdForceChat) {
		this.thirdForceChat = thirdForceChat;
	}

	public ForceChat getThirdForceChat() {
		return this.thirdForceChat;
	}
}