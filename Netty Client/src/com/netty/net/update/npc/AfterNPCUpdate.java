package com.netty.net.update.npc;

import com.netty.game.model.entity.npc.NPC;
import com.netty.net.update.EntityUpdate;

public class AfterNPCUpdate implements Runnable {

	private EntityUpdate entityUpdate;
	private NPC npc;

	public AfterNPCUpdate(EntityUpdate entityUpdate, NPC npc) {
		this.setEntityUpdate(entityUpdate);
		this.setNPC(npc);
	}

	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	public void setNPC(NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}

	@Override
	public void run() {
		// this.getNPC().getUpdateFlags().resetUpdateFlags();
		this.getEntityUpdate().getCountDownLatch().countDown();
	}
}