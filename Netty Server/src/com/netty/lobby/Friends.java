package com.netty.lobby;

import java.util.List;

import com.netty.model.player.tab.Friend;
import com.netty.model.player.tab.Ignore;

public class Friends {

	private List<Friend> friendsList;
	private List<Ignore> ignoreList;

	public void setFriendsList(List<Friend> friendsList) {
		this.friendsList = friendsList;
	}

	public List<Friend> getFriendsList() {
		return this.friendsList;
	}

	public void setIgnoreList(List<Ignore> ignoreList) {
		this.ignoreList = ignoreList;
	}

	public List<Ignore> getIgnoreList() {
		return this.ignoreList;
	}
}