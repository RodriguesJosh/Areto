package com.netty.model.player.minigame.pestcontrol;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:33:31 PM
 */
public class PestControl extends MiniGame {

	/**
	 * 
	 */
	private Boat boat;

	/**
	 * 
	 */
	private Portal[] portals;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public PestControl(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		this.setBoat(new Boat(this.getPlayer()));
		this.setPortals(new Portal[] {
				new Portal(this.getPlayer()), new Portal(this.getPlayer()), new Portal(this.getPlayer()),
				new Portal(this.getPlayer())
		});
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		NPC npc = World.getWorld().getNPCList().get(0); /** Needs the knight's ID. */
		if (npc.isDead()) {
			/** End the game here. */
		}
		NPC firstPortal = this.getPortals()[0].getNPC();
		NPC secondPortal = this.getPortals()[1].getNPC();
		NPC thirdPortal = this.getPortals()[2].getNPC();
		NPC fourthPortal = this.getPortals()[3].getNPC();
		if (firstPortal.isDead() && secondPortal.isDead() && thirdPortal.isDead() && fourthPortal.isDead()) {
			/** End the game here. */
		}
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getMembershipState()
	 */
	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getThreateningState()
	 */
	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	/**
	 * 
	 * @param boat
	 * 			The id to set.
	 */
	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Boat getBoat() {
		return this.boat;
	}

	/**
	 * 
	 * @param portals
	 * 			The id to set.
	 */
	public void setPortals(Portal[] portals) {
		this.portals = portals;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Portal[] getPortals() {
		return this.portals;
	}
}
