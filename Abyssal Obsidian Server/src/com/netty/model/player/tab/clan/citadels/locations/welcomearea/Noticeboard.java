package com.netty.model.player.tab.clan.citadels.locations.welcomearea;

import java.util.Deque;
import java.util.Queue;

import com.netty.model.player.tab.clan.citadels.interfaces.resource.ResourceType;
import com.netty.model.player.tab.clan.citadels.locations.welcomearea.event.ClanEvent;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 10:07:56 AM
 */
public class Noticeboard {

	/**
	 * 
	 */
	private Deque<ResourceType> resourceList; // ArrayDeque

	/**
	 * 
	 */
	private Queue<ClanEvent> clanEventList; // PriorityBlockingQueue

	/**
	 * 
	 * @param resourceList
	 * 			The resourceList to set.
	 */
	public void setResourceList(Deque<ResourceType> resourceList) {
		this.resourceList = resourceList;
	}

	/**
	 * 
	 * @return resourceList
	 * 			Returns the resourceList to get.
	 */
	public Deque<ResourceType> getResourceList() {
		return this.resourceList;
	}

	/**
	 * 
	 * @param clanEventList
	 * 			The clanEventList to set.
	 */
	public void setClanEventList(Queue<ClanEvent> clanEventList) {
		this.clanEventList = clanEventList;
	}

	/**
	 * 
	 * @return clanEventList
	 * 			Returns the clanEventList to get.
	 */
	public Queue<ClanEvent> getClanEventList() {
		return this.clanEventList;
	}
}