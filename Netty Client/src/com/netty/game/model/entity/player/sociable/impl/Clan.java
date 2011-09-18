package com.netty.game.model.entity.player.sociable.impl;

import com.netty.game.model.entity.player.sociable.Sociable;
import com.netty.game.model.entity.player.sociable.Socialist;
import com.netty.game.model.update.Chat;

public class Clan extends Socialist implements Sociable {

	public Clan(String name) {
		super(name);
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
		return false;
	}

	@Override
	public boolean removeSocialist(Socialist socialist) {
		return false;
	}
}