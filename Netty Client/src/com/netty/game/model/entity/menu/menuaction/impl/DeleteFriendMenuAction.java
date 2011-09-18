package com.netty.game.model.entity.menu.menuaction.impl;

import com.netty.game.model.entity.menu.menuaction.MenuAction;
import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.player.Player;
import com.netty.game.model.entity.player.sociable.impl.Friend;
import com.netty.net.packet.Packet;

public class DeleteFriendMenuAction implements MenuActionHandler {

	@Override
	public void handleAction(MenuAction menuAction, Player player, Packet packet) {
		Friend friend = player.getFriendList().get(0);
		if (friend == null) {
			return;
		}
		if (friend.getName().equals("")) {
			return;
		}
		if (friend.getName() == null) {
			return;
		}
		for (Friend friendName : player.getFriendList()) {
			if (friendName == friend) {
				player.getFriendList().remove(friendName);
				// this.needDrawTabArea = true;
				@SuppressWarnings("unused")
				Friend[] friendArray = (Friend[]) player.getFriendList().toArray();
				@SuppressWarnings("unused")
				int position = player.getIgnoreList().indexOf(friendName);
				// System.arraycopy(friendArray, position + 1, friendArray, position, this.friendsCount - position);
				// packet.putOpcode(215);
				// packet.putString(friendName.getName());
				return;
			}
		}
	}
}