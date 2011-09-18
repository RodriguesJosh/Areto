package com.netty.game.model.entity.menu.menuaction.impl;

import com.netty.game.model.entity.menu.menuaction.MenuAction;
import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.player.Player;
import com.netty.game.model.entity.player.interfaces.chat.EnterNameInterfaceHandler;
import com.netty.game.model.entity.player.sociable.Sociable;
import com.netty.game.model.entity.player.sociable.impl.Friend;
import com.netty.net.packet.Packet;

public class AddFriendMenuAction implements MenuActionHandler {

	@Override
	public void handleAction(MenuAction menuAction, Player player, Packet packet) {
		EnterNameInterfaceHandler enterNameInterface = new EnterNameInterfaceHandler();
		player.getInterfaceManager().handleInterface(enterNameInterface);
		Friend friend = new Friend(enterNameInterface.getName(), true); // Change the boolean for "isOnline".
		if (friend.getName() == null) {
			return;
		}
		if (friend.getName().equals("")) {
			return;
		}
		if (friend.getName().equals(null)) {
			return;
		}
		int friendListSize = player.getFriendList().size();
		int ignoreListSize = player.getIgnoreList().size();
		// if ((friendListSize > 100) && (this.anInt1046 != 1)) {
		// player.getPacketSender().getMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "");
		// return;
		// }
		if (friendListSize > 200) {
			// player.getPacketSender().getMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", 0, "");
			return;
		}
		@SuppressWarnings("unused")
		String name = friend.getName();
		for (Friend friendName : player.getFriendList()) {
			if (friendListSize > 0) {
				if (friendName == friend) {
					// player.getPacketSender().getMessage(name + " is already on your friend list", 0, "");
					return;
				}
			}
		}
		for (Sociable ignoreSociable : player.getIgnoreList()) {
			if (ignoreListSize > 0) {
				if (ignoreSociable == friend) {
					// player.getPacketSender().getMessage("Please remove " + name + " from your ignore list first", 0, "");
					return;
				}
			}
		}
		player.getFriendList().add(friend);
		// this.needDrawTabArea = true;
		// packet.putOpcode(PacketConstants.ADD_FRIEND_PACKET); Change these to the "PacketBuilder" class.
		// packet.putString(name);
		return;
	}
}