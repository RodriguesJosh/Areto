package com.netty.model.player.minigame.castlewars;

import com.netty.model.object.Object;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:25:33 PM
 */
public class SteppingStone extends Object {

	/**
	 * 
	 */
	private Location playerLocation;

	/**
	 * 
	 * @param id
	 *			The id to set.
	 * @param direction
	 *			The id to set.
	 * @param type
	 *			The id to set.
	 */
	public SteppingStone(int id, byte direction, byte type) {
		super(id, direction, type);
		int x = this.getLocation().getX() - this.getPlayerLocation().getX();
		int y = this.getLocation().getY() - this.getPlayerLocation().getY();
		if ((x == -1) || (y == -1)) {
			return;
		}
		// if(Misc.getDistance(playerPosition, objectPosition) <= 1) {
		//	player.walkToPoint(i, j);
		// }
	}

	/**
	 * 
	 * @param playerLocation
	 *			The id to set.
	 */
	public void setPlayerLocation(Location playerLocation) {
		this.playerLocation = playerLocation;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public Location getPlayerLocation() {
		return this.playerLocation;
	}
}