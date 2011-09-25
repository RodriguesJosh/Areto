package com.netty.game.model.entity.menu.impl;

import com.netty.game.model.entity.menu.Menu;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:23:49 PM
 */
public class SplitPrivateChatMenu extends Menu {

	/**
	 * 
	 */
	public void process() {
		/** if (this.splitPrivateChat == 0) {
			return;
		}
		int i = 0;
		if (this.anInt1104 != 0) {
			i = 1;
		}
		for (int j = 0; j < 100; j++) {
			if (this.chatMessages[j] != null) {
				int k = this.chatTypes[j];
				String s = this.chatNames[j];
				if ((s != null) && s.startsWith("@cr1@")) {
					s = s.substring(5);
				}
				if ((s != null) && s.startsWith("@cr2@")) {
					s = s.substring(5);
				}
				if (((k == 3) || (k == 7)) && ((k == 7) || (this.privateChatMode == 0) || ((this.privateChatMode == 1) && this.isFriendOrSelf(s)))) {
					int l = 329 - (i * 13);
					if ((super.mouseX > 4) && ((super.mouseY - 4) > (l - 10)) && ((super.mouseY - 4) <= (l + 3))) {
						int i1 = this.aTextDrawingArea_1271.getTextWidth("From:  " + s + this.chatMessages[j]) + 25;
						if (i1 > 450) {
							i1 = 450;
						}
						if (super.mouseX < (4 + i1)) {
							if (this.myPrivilege >= 1) {
								this.menuActionName[this.menuActionRow] = "Report abuse @whi@" + s;
								this.menuActionID[this.menuActionRow] = 2606;
								this.menuActionRow++;
							}
							this.menuActionName[this.menuActionRow] = "Add ignore @whi@" + s;
							this.menuActionID[this.menuActionRow] = 2042;
							this.menuActionRow++;
							this.menuActionName[this.menuActionRow] = "Add friend @whi@" + s;
							this.menuActionID[this.menuActionRow] = 2337;
							this.menuActionRow++;
						}
					}
					if (++i >= 5) {
						return;
					}
				}
				if (((k == 5) || (k == 6)) && (this.privateChatMode < 2) && (++i >= 5)) {
					return;
				}
			}
		} */
	}
}