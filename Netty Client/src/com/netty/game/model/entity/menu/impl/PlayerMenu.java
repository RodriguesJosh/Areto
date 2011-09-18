package com.netty.game.model.entity.menu.impl;

import com.netty.game.model.entity.menu.Menu;

public class PlayerMenu extends Menu {

	public void process() {
		/** if (player == Client.myPlayer) {
			return;
		}
		if (this.menuActionRow >= 400) {
			return;
		}
		String s;
		if (player.skill == 0) {
			s = player.name + Client.combatDiffColor(Client.myPlayer.combatLevel, player.combatLevel) + " (level-" + player.combatLevel + ")";
		} else {
			s = player.name + " (skill-" + player.skill + ")";
		}
		if (this.itemSelected == 1) {
			this.menuActionName[this.menuActionRow] = "Use " + this.selectedItemName + " with @whi@" + s;
			this.menuActionID[this.menuActionRow] = 491;
			this.menuActionCmd1[this.menuActionRow] = j;
			this.menuActionCmd2[this.menuActionRow] = i;
			this.menuActionCmd3[this.menuActionRow] = k;
			this.menuActionRow++;
		} else if (this.spellSelected == 1) {
			if ((this.spellUsableOn & 8) == 8) {
				this.menuActionName[this.menuActionRow] = this.spellTooltip + " @whi@" + s;
				this.menuActionID[this.menuActionRow] = 365;
				this.menuActionCmd1[this.menuActionRow] = j;
				this.menuActionCmd2[this.menuActionRow] = i;
				this.menuActionCmd3[this.menuActionRow] = k;
				this.menuActionRow++;
			}
		} else {
			for (int l = 4; l >= 0; l--) {
				if (this.atPlayerActions[l] != null) {
					this.menuActionName[this.menuActionRow] = this.atPlayerActions[l] + " @whi@" + s;
					char c = '\0';
					if (this.atPlayerActions[l].equalsIgnoreCase("attack")) {
						if (player.combatLevel > Client.myPlayer.combatLevel) {
							c = '\u07D0';
						}
						if ((Client.myPlayer.team != 0) && (player.team != 0)) {
							if (Client.myPlayer.team == player.team) {
								c = '\u07D0';
							} else {
								c = '\0';
							}
						}
					} else if (this.atPlayerArray[l]) {
						c = '\u07D0';
					}
					if (l == 0) {
						this.menuActionID[this.menuActionRow] = 561 + c;
					}
					if (l == 1) {
						this.menuActionID[this.menuActionRow] = 779 + c;
					}
					if (l == 2) {
						this.menuActionID[this.menuActionRow] = 27 + c;
					}
					if (l == 3) {
						this.menuActionID[this.menuActionRow] = 577 + c;
					}
					if (l == 4) {
						this.menuActionID[this.menuActionRow] = 729 + c;
					}
					this.menuActionCmd1[this.menuActionRow] = j;
					this.menuActionCmd2[this.menuActionRow] = i;
					this.menuActionCmd3[this.menuActionRow] = k;
					this.menuActionRow++;
				}
			}
		}
		for (int i1 = 0; i1 < this.menuActionRow; i1++) {
			if (this.menuActionID[i1] == 516) {
				this.menuActionName[i1] = "Walk here @whi@" + s;
				return;
			}
		} */
	}
}