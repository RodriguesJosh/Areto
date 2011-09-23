package com.netty.model.player.minigame.conquest;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:38:10 PM
 */
public class InviteRoom extends WaitingRoom {

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.conquest.WaitingRoom#addPlayer(com.netty.model.player.Player)
	 */
	@Override
	public boolean addPlayer(Player player) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.conquest.WaitingRoom#removePlayer(com.netty.model.player.Player)
	 */
	@Override
	public boolean removePlayer(Player player) {
		return false;
	}
}