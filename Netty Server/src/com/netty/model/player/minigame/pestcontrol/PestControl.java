package com.netty.model.player.minigame.pestcontrol;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.world.World;

public class PestControl extends MiniGame {

	private Boat boat;
	private Portal[] portals;

	public PestControl(Player player) {
		super(player);
	}

	@Override
	public void start() {
		this.setBoat(new Boat(this.getPlayer()));
		this.setPortals(new Portal[] {
				new Portal(this.getPlayer()), new Portal(this.getPlayer()), new Portal(this.getPlayer()),
				new Portal(this.getPlayer())
		});
	}

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

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public Boat getBoat() {
		return this.boat;
	}

	public void setPortals(Portal[] portals) {
		this.portals = portals;
	}

	public Portal[] getPortals() {
		return this.portals;
	}
}
