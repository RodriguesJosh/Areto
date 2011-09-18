package com.netty.game.model.entity.player.sociable;

import com.netty.game.model.update.Chat;

public interface Sociable {

	public boolean addConversation(Chat chat);
	public boolean removeConversation(Chat chat);
	public boolean addSocialist(Socialist socialist);
	public boolean removeSocialist(Socialist socialist);
}