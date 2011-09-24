package com.netty.model.player.minigame.pestcontrol;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.player.Player;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:33:50 PM
 */
public class Boat {

	/**
	 * 
	 */
	private Location startLocation;

	/**
	 * 
	 */
	private Location endLocation;

	/**
	 * 
	 */
	private List<Player> playerList;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public Boat(Player player) {
		this.setStartLocation(new Location((short) 2659, (short) 2637, (byte) 1));
		this.setEndLocation(new Location((short) 2664, (short) 2644, (byte) 1));
		this.setPlayerList(new ArrayList<Player>(PestControlConstants.MAX_BOAT_PLAYERS));
		if (this.getPlayerList().add(player) && (this.getPlayerList().size() <= 25) && (this.getPlayerList().size() >= 2)) {
			for (Player p : this.getPlayerList()) {
				p.setLocation(new Location((short) 2667, (short) 2594, (byte) 0));
			}
		}
	}

	/**
	 * 
	 * @param startLocation
	 * 			The id to set.
	 */
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getStartLocation() {
		return this.startLocation;
	}

	/**
	 * 
	 * @param endLocation
	 * 			The id to set.
	 */
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Location getEndLocation() {
		return this.endLocation;
	}

	/**
	 * 
	 * @param playerList
	 * 			The id to set.
	 */
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Player> getPlayerList() {
		return this.playerList;
	}
}