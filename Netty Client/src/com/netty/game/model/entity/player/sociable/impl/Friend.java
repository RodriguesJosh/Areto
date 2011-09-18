package com.netty.game.model.entity.player.sociable.impl;

import com.netty.game.model.entity.player.sociable.Sociable;
import com.netty.game.model.entity.player.sociable.Socialist;
import com.netty.game.model.update.Chat;

public class Friend extends Socialist implements Sociable {

	private boolean isOnline;

	public Friend(String name, boolean isOnline) {
		super(name);
		this.setOnline(isOnline);
	}

	@Override
	public boolean addConversation(Chat chat) {
		return false;
	}

	@Override
	public boolean removeConversation(Chat chat) {
		return false;
	}

	@Override
	public boolean addSocialist(Socialist socialist) {
		if (socialist == null) {
			return false;
		}
		// int size = World.getWorld().getFriendList().size();
		// if (size >= 100) {

		// }
		// if (size >= 200) {

		// }
		return false;
	}

	@Override
	public boolean removeSocialist(Socialist socialist) {
		return false;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public boolean isOnline() {
		return this.isOnline;
	}
}