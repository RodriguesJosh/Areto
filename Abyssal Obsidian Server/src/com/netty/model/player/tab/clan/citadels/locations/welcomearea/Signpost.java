package com.netty.model.player.tab.clan.citadels.locations.welcomearea;

import java.util.Queue;

import com.netty.model.player.tab.clan.Clan;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 10:07:47 AM
 */
public class Signpost {

	/**
	 * 
	 */
	private Queue<Clan> clanRelationshipList;

	/**
	 * 
	 * @param clanRelationshipList
	 * 			The clanRelationshipList to set.
	 */
	public void setClanRelationshipList(Queue<Clan> clanRelationshipList) {
		this.clanRelationshipList = clanRelationshipList;
	}

	/**
	 * 
	 * @return clanRelationshipList
	 * 			Returns the clanRelationshipList to get.
	 */
	public Queue<Clan> getClanRelationshipList() {
		return this.clanRelationshipList;
	}
}