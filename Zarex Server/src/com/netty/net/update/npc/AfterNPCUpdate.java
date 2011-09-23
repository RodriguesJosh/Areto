package com.netty.net.update.npc;

import com.netty.model.npc.NPC;
import com.netty.net.update.EntityUpdate;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:15:43 PM
 */
public class AfterNPCUpdate implements Runnable {

	/**
	 * 
	 */
	private EntityUpdate entityUpdate;

	/**
	 * 
	 */
	private NPC npc;

	/**
	 * 
	 * @param entityUpdate
	 * 			The id to set.
	 * @param npc
	 * 			The id to set.
	 */
	public AfterNPCUpdate(EntityUpdate entityUpdate, NPC npc) {
		this.setEntityUpdate(entityUpdate);
		this.setNPC(npc);
	}

	/**
	 * 
	 * @param entityUpdate
	 * 			The id to set.
	 */
	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
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

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.getNPC().getUpdateFlags().resetUpdateFlags();
		this.getEntityUpdate().getCountDownLatch().countDown();
	}
}