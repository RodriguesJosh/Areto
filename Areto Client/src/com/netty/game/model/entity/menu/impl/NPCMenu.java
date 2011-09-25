package com.netty.game.model.entity.menu.impl;

import com.netty.game.model.entity.menu.Menu;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:23:59 PM
 */
public class NPCMenu extends Menu {

	/**
	 * 
	 */
	public void process() {
		/** if (this.menuActionRow >= 400) {
			return;
		}
		if (entityDef.childrenIDs != null) {
			entityDef = entityDef.method161();
		}
		if (entityDef == null) {
			return;
		}
		if (!entityDef.clickable) {
			return;
		}
		String s = entityDef.name;
		if (entityDef.combatLevel != 0) {
			s = s + Client.combatDiffColor(Client.myPlayer.combatLevel, entityDef.combatLevel) + " (level-" + entityDef.combatLevel + ")";
		}
		if (this.itemSelected == 1) {
			this.menuActionName[this.menuActionRow] = "Use " + this.selectedItemName + " with @yel@" + s;
			this.menuActionID[this.menuActionRow] = 582;
			this.menuActionCmd1[this.menuActionRow] = i;
			this.menuActionCmd2[this.menuActionRow] = k;
			this.menuActionCmd3[this.menuActionRow] = j;
			this.menuActionRow++;
			return;
		}
		if (this.spellSelected == 1) {
			if ((this.spellUsableOn & 2) == 2) {
				this.menuActionName[this.menuActionRow] = this.spellTooltip + " @yel@" + s;
				this.menuActionID[this.menuActionRow] = 413;
				this.menuActionCmd1[this.menuActionRow] = i;
				this.menuActionCmd2[this.menuActionRow] = k;
				this.menuActionCmd3[this.menuActionRow] = j;
				this.menuActionRow++;
			}
		} else {
			if (entityDef.actions != null) {
				for (int l = 4; l >= 0; l--) {
					if ((entityDef.actions[l] != null) && !entityDef.actions[l].equalsIgnoreCase("attack")) {
						this.menuActionName[this.menuActionRow] = entityDef.actions[l] + " @yel@" + s;
						if (l == 0) {
							this.menuActionID[this.menuActionRow] = 20;
						}
						if (l == 1) {
							this.menuActionID[this.menuActionRow] = 412;
						}
						if (l == 2) {
							this.menuActionID[this.menuActionRow] = 225;
						}
						if (l == 3) {
							this.menuActionID[this.menuActionRow] = 965;
						}
						if (l == 4) {
							this.menuActionID[this.menuActionRow] = 478;
						}
						this.menuActionCmd1[this.menuActionRow] = i;
						this.menuActionCmd2[this.menuActionRow] = k;
						this.menuActionCmd3[this.menuActionRow] = j;
						this.menuActionRow++;
					}
				}
			}
			if (entityDef.actions != null) {
				for (int i1 = 4; i1 >= 0; i1--) {
					if ((entityDef.actions[i1] != null) && entityDef.actions[i1].equalsIgnoreCase("attack")) {
						char c = '\0';
						if (entityDef.combatLevel > Client.myPlayer.combatLevel) {
							c = '\u07D0';
						}
						this.menuActionName[this.menuActionRow] = entityDef.actions[i1] + " @yel@" + s;
						if (i1 == 0) {
							this.menuActionID[this.menuActionRow] = 20 + c;
						}
						if (i1 == 1) {
							this.menuActionID[this.menuActionRow] = 412 + c;
						}
						if (i1 == 2) {
							this.menuActionID[this.menuActionRow] = 225 + c;
						}
						if (i1 == 3) {
							this.menuActionID[this.menuActionRow] = 965 + c;
						}
						if (i1 == 4) {
							this.menuActionID[this.menuActionRow] = 478 + c;
						}
						this.menuActionCmd1[this.menuActionRow] = i;
						this.menuActionCmd2[this.menuActionRow] = k;
						this.menuActionCmd3[this.menuActionRow] = j;
						this.menuActionRow++;
					}
				}
			}
			this.menuActionName[this.menuActionRow] = "Examine @yel@" + s + " @gre@(@whi@" + entityDef.type + "@gre@)";
			this.menuActionID[this.menuActionRow] = 1025;
			this.menuActionCmd1[this.menuActionRow] = i;
			this.menuActionCmd2[this.menuActionRow] = k;
			this.menuActionCmd3[this.menuActionRow] = j;
			this.menuActionRow++;
		} */
	}
}