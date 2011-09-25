package com.netty.lobby;

import java.util.List;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;
import com.netty.model.player.tab.Friend;
import com.netty.model.player.tab.Ignore;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 5:40:26 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public class Friends {

	/**
	 * A list of friends from in-game.
	 */
	private List<Friend> friendsList;

	/**
	 * A list of ignored users from in-game.
	 */
	private List<Ignore> ignoreList;

	/**
	 * 
	 * 
	 * @param friendsList
	 * 			The friends list to set.
	 */
	public void setFriendsList(List<Friend> friendsList) {
		this.friendsList = friendsList;
	}

	/**
	 * 
	 * 
	 * @return friendsList
	 * 
	 */
	public List<Friend> getFriendsList() {
		return this.friendsList;
	}

	/**
	 * 
	 * 
	 * @param ignoreList
	 * 			The ignore list to set.
	 */
	public void setIgnoreList(List<Ignore> ignoreList) {
		this.ignoreList = ignoreList;
	}

	/**
	 * 
	 * 
	 * @return ignoreList
	 */
	public List<Ignore> getIgnoreList() {
		return this.ignoreList;
	}
}