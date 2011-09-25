package com.netty.game.model.entity.menu.impl;

import com.netty.game.model.entity.menu.Menu;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:23:31 PM
 */
public class ChatAreaMenu extends Menu {

	/**
	 * 
	 */
	public void process() {
		/** int l = 0;
		for (int i1 = 0; i1 < 100; i1++) {
			if (this.chatMessages[i1] == null) {
				continue;
			}
			int j1 = this.chatTypes[i1];
			int k1 = (70 - (l * 14)) + this.anInt1089 + 4;
			if (k1 < -20) {
				break;
			}
			String s = this.chatNames[i1];
			if ((s != null) && s.startsWith("@cr1@")) {
				s = s.substring(5);
			}
			if ((s != null) && s.startsWith("@cr2@")) {
				s = s.substring(5);
			}
			if (j1 == 0) {
				l++;
			}
			if (((j1 == 1) || (j1 == 2)) && ((j1 == 1) || (this.publicChatMode == 0) || ((this.publicChatMode == 1) && this.isFriendOrSelf(s)))) {
				if ((j > (k1 - 14)) && (j <= k1) && !s.equals(Client.myPlayer.name)) {
					if (this.myPrivilege >= 1) {
						this.menuActionName[this.menuActionRow] = "Report abuse @whi@" + s;
						this.menuActionID[this.menuActionRow] = 606;
						this.menuActionRow++;
					}
					this.menuActionName[this.menuActionRow] = "Add ignore @whi@" + s;
					this.menuActionID[this.menuActionRow] = 42;
					this.menuActionRow++;
					this.menuActionName[this.menuActionRow] = "Add friend @whi@" + s;
					this.menuActionID[this.menuActionRow] = 337;
					this.menuActionRow++;
				}
				l++;
			}
			if (((j1 == 3) || (j1 == 7)) && (this.splitPrivateChat == 0) && ((j1 == 7) || (this.privateChatMode == 0) || ((this.privateChatMode == 1) && this.isFriendOrSelf(s)))) {
				if ((j > (k1 - 14)) && (j <= k1)) {
					if (this.myPrivilege >= 1) {
						this.menuActionName[this.menuActionRow] = "Report abuse @whi@" + s;
						this.menuActionID[this.menuActionRow] = 606;
						this.menuActionRow++;
					}
					this.menuActionName[this.menuActionRow] = "Add ignore @whi@" + s;
					this.menuActionID[this.menuActionRow] = 42;
					this.menuActionRow++;
					this.menuActionName[this.menuActionRow] = "Add friend @whi@" + s;
					this.menuActionID[this.menuActionRow] = 337;
					this.menuActionRow++;
				}
				l++;
			}
			if ((j1 == 4) && ((this.tradeMode == 0) || ((this.tradeMode == 1) && this.isFriendOrSelf(s)))) {
				if ((j > (k1 - 14)) && (j <= k1)) {
					this.menuActionName[this.menuActionRow] = "Accept trade @whi@" + s;
					this.menuActionID[this.menuActionRow] = 484;
					this.menuActionRow++;
				}
				l++;
			}
			if (((j1 == 5) || (j1 == 6)) && (this.splitPrivateChat == 0) && (this.privateChatMode < 2)) {
				l++;
			}
			if ((j1 == 8) && ((this.tradeMode == 0) || ((this.tradeMode == 1) && this.isFriendOrSelf(s)))) {
				if ((j > (k1 - 14)) && (j <= k1)) {
					this.menuActionName[this.menuActionRow] = "Accept challenge @whi@" + s;
					this.menuActionID[this.menuActionRow] = 6;
					this.menuActionRow++;
				}
				l++;
			}
		} */
	}
}