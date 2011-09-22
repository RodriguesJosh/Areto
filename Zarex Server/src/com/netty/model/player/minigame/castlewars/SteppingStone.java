package com.netty.model.player.minigame.castlewars;

import com.netty.model.object.Object;
import com.netty.world.Location;

public class SteppingStone extends Object {

	private Location playerLocation;

	public SteppingStone(int id, byte direction, byte type) {
		super(id, direction, type);
		@SuppressWarnings("unused")
		int x = this.getLocation().getX() - this.getPlayerLocation().getX();
		@SuppressWarnings("unused")
		int y = this.getLocation().getY() - this.getPlayerLocation().getY();
		// if(Misc.getDistance(playerPosition, objectPosition) <= 1) {
		//	player.walkToPoint(i, j);
		// }
	}

	public void setPlayerLocation(Location playerLocation) {
		this.playerLocation = playerLocation;
	}

	public Location getPlayerLocation() {
		return this.playerLocation;
	}
}