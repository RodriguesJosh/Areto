package com.netty.game.model.entity.menu.impl;

import com.netty.game.model.entity.menu.Menu;

public class ThreeDMenu extends Menu {

	public void process() {
		/** if ((this.itemSelected == 0) && (this.spellSelected == 0)) {
			this.menuActionName[this.menuActionRow] = "Walk here";
			this.menuActionID[this.menuActionRow] = 516;
			this.menuActionCmd2[this.menuActionRow] = super.mouseX;
			this.menuActionCmd3[this.menuActionRow] = super.mouseY;
			this.menuActionRow++;
		}
		int j = -1;
		for (int k = 0; k < Model.resourceCount; k++) {
			int l = Model.resourceIDTAG[k];
			int i1 = l & 0x7f;
			int j1 = (l >> 7) & 0x7f;
			int k1 = (l >> 29) & 3;
			int l1 = (l >> 14) & 0x7fff;
			if (l == j) {
				continue;
			}
			j = l;
			if ((k1 == 2) && (this.sceneGraph.method304(this.plane, i1, j1, l) >= 0)) {
				ObjectDef objectDef = ObjectDef.forID(l1);
				if (objectDef.childrenIDs != null) {
					objectDef = objectDef.method580();
				}
				if (objectDef == null) {
					continue;
				}
				if (this.itemSelected == 1) {
					this.menuActionName[this.menuActionRow] = "Use " + this.selectedItemName + " with @cya@" + objectDef.name;
					this.menuActionID[this.menuActionRow] = 62;
					this.menuActionCmd1[this.menuActionRow] = l;
					this.menuActionCmd2[this.menuActionRow] = i1;
					this.menuActionCmd3[this.menuActionRow] = j1;
					this.menuActionRow++;
				} else if (this.spellSelected == 1) {
					if ((this.spellUsableOn & 4) == 4) {
						this.menuActionName[this.menuActionRow] = this.spellTooltip + " @cya@" + objectDef.name;
						this.menuActionID[this.menuActionRow] = 956;
						this.menuActionCmd1[this.menuActionRow] = l;
						this.menuActionCmd2[this.menuActionRow] = i1;
						this.menuActionCmd3[this.menuActionRow] = j1;
						this.menuActionRow++;
					}
				} else {
					if (objectDef.actions != null) {
						for (int i2 = 4; i2 >= 0; i2--) {
							if (objectDef.actions[i2] != null) {
								this.menuActionName[this.menuActionRow] = objectDef.actions[i2] + " @cya@" + objectDef.name;
								if (i2 == 0) {
									this.menuActionID[this.menuActionRow] = 502;
								}
								if (i2 == 1) {
									this.menuActionID[this.menuActionRow] = 900;
								}
								if (i2 == 2) {
									this.menuActionID[this.menuActionRow] = 113;
								}
								if (i2 == 3) {
									this.menuActionID[this.menuActionRow] = 872;
								}
								if (i2 == 4) {
									this.menuActionID[this.menuActionRow] = 1062;
								}
								this.menuActionCmd1[this.menuActionRow] = l;
								this.menuActionCmd2[this.menuActionRow] = i1;
								this.menuActionCmd3[this.menuActionRow] = j1;
								this.menuActionRow++;
							}
						}
					}
					this.menuActionName[this.menuActionRow] = "Examine @cya@" + objectDef.name + " @gre@(@whi@" + l1 + "@gre@) (@whi@" + (i1 + this.baseX) + "," + (j1 + this.baseY) + "@gre@)";
					this.menuActionID[this.menuActionRow] = 1226;
					this.menuActionCmd1[this.menuActionRow] = objectDef.type << 14;
					this.menuActionCmd2[this.menuActionRow] = i1;
					this.menuActionCmd3[this.menuActionRow] = j1;
					this.menuActionRow++;
				}
			}
			if (k1 == 1) {
				NPC npc = this.npcArray[l1];
				if ((npc.desc.boundDim == 1) && ((npc.x & 0x7f) == 64) && ((npc.y & 0x7f) == 64)) {
					for (int j2 = 0; j2 < this.npcCount; j2++) {
						NPC npc2 = this.npcArray[this.npcIndices[j2]];
						if ((npc2 != null) && (npc2 != npc) && (npc2.desc.boundDim == 1) && (npc2.x == npc.x) && (npc2.y == npc.y)) {
							this.buildAtNPCMenu(npc2.desc, this.npcIndices[j2], j1, i1);
						}
					}
					for (Player player : World.getWorld().getPlayerList()) {
						if ((player != null) && (player.x == npc.x) && (player.y == npc.y)) {
							this.buildAtPlayerMenu(i1, World.getWorld().getPlayerList().indexOf(player), player, j1);
						}
					}
				}
				this.buildAtNPCMenu(npc.desc, l1, j1, i1);
			}
			if (k1 == 0) {
				Player player = World.getWorld().getPlayerList().get(l1);
				if (((player.x & 0x7f) == 64) && ((player.y & 0x7f) == 64)) {
					for (int k2 = 0; k2 < this.npcCount; k2++) {
						NPC class30_sub2_sub4_sub1_sub1_2 = this.npcArray[this.npcIndices[k2]];
						if ((class30_sub2_sub4_sub1_sub1_2 != null) && (class30_sub2_sub4_sub1_sub1_2.desc.boundDim == 1) && (class30_sub2_sub4_sub1_sub1_2.x == player.x) && (class30_sub2_sub4_sub1_sub1_2.y == player.y)) {
							this.buildAtNPCMenu(class30_sub2_sub4_sub1_sub1_2.desc, this.npcIndices[k2], j1, i1);
						}
					}
					for (Player otherPlayer : World.getWorld().getPlayerList()) {
						if ((otherPlayer != null) && (otherPlayer != player) && (otherPlayer.x == player.x) && (otherPlayer.y == player.y)) {
							int position = World.getWorld().getPlayerList().indexOf(otherPlayer);
							this.buildAtPlayerMenu(i1, position, otherPlayer, j1);
						}
					}
				}
				this.buildAtPlayerMenu(i1, l1, player, j1);
			}
			if (k1 == 3) {
				Deque deque = this.groundArray[this.plane][i1][j1];
				if (deque != null) {
					for (Item item = (Item) deque.getFirst(); item != null; item = (Item) deque.getNext()) {
						ItemDef itemDef = ItemDef.forID(item.id);
						if (this.itemSelected == 1) {
							this.menuActionName[this.menuActionRow] = "Use " + this.selectedItemName + " with @lre@" + itemDef.name;
							this.menuActionID[this.menuActionRow] = 511;
							this.menuActionCmd1[this.menuActionRow] = item.id;
							this.menuActionCmd2[this.menuActionRow] = i1;
							this.menuActionCmd3[this.menuActionRow] = j1;
							this.menuActionRow++;
						} else if (this.spellSelected == 1) {
							if ((this.spellUsableOn & 1) == 1) {
								this.menuActionName[this.menuActionRow] = this.spellTooltip + " @lre@" + itemDef.name;
								this.menuActionID[this.menuActionRow] = 94;
								this.menuActionCmd1[this.menuActionRow] = item.id;
								this.menuActionCmd2[this.menuActionRow] = i1;
								this.menuActionCmd3[this.menuActionRow] = j1;
								this.menuActionRow++;
							}
						} else {
							for (int j3 = 4; j3 >= 0; j3--) {
								if ((itemDef.groundActions != null) && (itemDef.groundActions[j3] != null)) {
									this.menuActionName[this.menuActionRow] = itemDef.groundActions[j3] + " @lre@" + itemDef.name;
									if (j3 == 0) {
										this.menuActionID[this.menuActionRow] = 652;
									}
									if (j3 == 1) {
										this.menuActionID[this.menuActionRow] = 567;
									}
									if (j3 == 2) {
										this.menuActionID[this.menuActionRow] = 234;
									}
									if (j3 == 3) {
										this.menuActionID[this.menuActionRow] = 244;
									}
									if (j3 == 4) {
										this.menuActionID[this.menuActionRow] = 213;
									}
									this.menuActionCmd1[this.menuActionRow] = item.id;
									this.menuActionCmd2[this.menuActionRow] = i1;
									this.menuActionCmd3[this.menuActionRow] = j1;
									this.menuActionRow++;
								} else if (j3 == 2) {
									this.menuActionName[this.menuActionRow] = "Take @lre@" + itemDef.name;
									this.menuActionID[this.menuActionRow] = 234;
									this.menuActionCmd1[this.menuActionRow] = item.id;
									this.menuActionCmd2[this.menuActionRow] = i1;
									this.menuActionCmd3[this.menuActionRow] = j1;
									this.menuActionRow++;
								}
							}
							this.menuActionName[this.menuActionRow] = "Examine @lre@" + itemDef.name + " @gre@(@whi@" + item.id + "@gre@)";
							this.menuActionID[this.menuActionRow] = 1448;
							this.menuActionCmd1[this.menuActionRow] = item.id;
							this.menuActionCmd2[this.menuActionRow] = i1;
							this.menuActionCmd3[this.menuActionRow] = j1;
							this.menuActionRow++;
						}
					}
				}
			}
		} */
	}
}