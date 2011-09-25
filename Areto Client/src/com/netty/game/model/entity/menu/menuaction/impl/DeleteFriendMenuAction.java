package com.netty.game.model.entity.menu.menuaction.impl;

import com.netty.game.model.entity.menu.menuaction.MenuAction;
import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.player.Player;
import com.netty.game.model.entity.player.sociable.impl.Friend;
import com.netty.net.packet.Packet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:30:51 PM
 */
public class DeleteFriendMenuAction implements MenuActionHandler {

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.menu.menuaction.MenuActionHandler#handleAction(com.netty.game.model.entity.menu.menuaction.MenuAction, com.netty.game.model.entity.player.Player, com.netty.net.packet.Packet)
	 */
	@Override
	public void handleAction(MenuAction menuAction, Player player, Packet packet) {
		if (menuAction == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		if (packet == null) {
			throw new NullPointerException();
		}
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
				// Friend[] friendArray = (Friend[]) player.getFriendList().toArray();
				// int position = player.getIgnoreList().indexOf(friendName);
				// System.arraycopy(friendArray, position + 1, friendArray, position, this.friendsCount - position);
				// packet.putOpcode(215);
				// packet.putString(friendName.getName());
				return;
			}
		}
	}
}