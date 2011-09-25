package com.netty.game.model.entity.menu.impl;

import com.netty.game.model.entity.menu.Menu;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:24:06 PM
 */
public class InterfaceMenu extends Menu {

	/**
	 * 
	 */
	public void process() {
		/** if ((class9.type != 0) || (class9.children == null) || class9.hiddenUntilMouseover) {
			return;
		}
		if ((k < i) || (i1 < l) || (k > (i + class9.width)) || (i1 > (l + class9.height))) {
			return;
		}
		int k1 = class9.children.length;
		for (int l1 = 0; l1 < k1; l1++) {
			int i2 = class9.childX[l1] + i;
			int j2 = (class9.childY[l1] + l) - j1;
			RSInterface class9_1 = RSInterface.interfaceCache[class9.children[l1]];
			i2 += class9_1.xOffset;
			j2 += class9_1.yOffset;
			if (((class9_1.mouseOverPopupInterface >= 0) || (class9_1.colourConditionFalseMouseover != 0)) && (k >= i2) && (i1 >= j2) && (k < (i2 + class9_1.width)) && (i1 < (j2 + class9_1.height))) {
				if (class9_1.mouseOverPopupInterface >= 0) {
					this.anInt886 = class9_1.mouseOverPopupInterface;
				} else {
					this.anInt886 = class9_1.id;
				}
			}
			if (class9_1.type == 0) {
				this.buildInterfaceMenu(i2, class9_1, k, j2, i1, class9_1.scrollPosition);
				if (class9_1.scrollMax > class9_1.height) {
					this.method65(i2 + class9_1.width, class9_1.height, k, i1, class9_1, j2, true, class9_1.scrollMax);
				}
			} else {
				if ((class9_1.atActionType == 1) && (k >= i2) && (i1 >= j2) && (k < (i2 + class9_1.width)) && (i1 < (j2 + class9_1.height))) {
					boolean flag = false;
					if (class9_1.contentType != 0) {
						flag = this.buildFriendsListMenu(class9_1);
					}
					if (!flag) {
						this.menuActionName[this.menuActionRow] = class9_1.tooltip + ", " + class9_1.id;
						this.menuActionID[this.menuActionRow] = 315;
						this.menuActionCmd3[this.menuActionRow] = class9_1.id;
						this.menuActionRow++;
					}
				}
				if ((class9_1.atActionType == 2) && (this.spellSelected == 0) && (k >= i2) && (i1 >= j2) && (k < (i2 + class9_1.width)) && (i1 < (j2 + class9_1.height))) {
					String s = class9_1.selectedActionName;
					if (s.indexOf(" ") != -1) {
						s = s.substring(0, s.indexOf(" "));
					}
					this.menuActionName[this.menuActionRow] = s + " @gre@" + class9_1.spellName;
					this.menuActionID[this.menuActionRow] = 626;
					this.menuActionCmd3[this.menuActionRow] = class9_1.id;
					this.menuActionRow++;
				}
				if ((class9_1.atActionType == 3) && (k >= i2) && (i1 >= j2) && (k < (i2 + class9_1.width)) && (i1 < (j2 + class9_1.height))) {
					this.menuActionName[this.menuActionRow] = "Close";
					this.menuActionID[this.menuActionRow] = 200;
					this.menuActionCmd3[this.menuActionRow] = class9_1.id;
					this.menuActionRow++;
				}
				if ((class9_1.atActionType == 4) && (k >= i2) && (i1 >= j2) && (k < (i2 + class9_1.width)) && (i1 < (j2 + class9_1.height))) {
					this.menuActionName[this.menuActionRow] = class9_1.tooltip + ", " + class9_1.id;
					this.menuActionID[this.menuActionRow] = 169;
					this.menuActionCmd3[this.menuActionRow] = class9_1.id;
					this.menuActionRow++;
				}
				if ((class9_1.atActionType == 5) && (k >= i2) && (i1 >= j2) && (k < (i2 + class9_1.width)) && (i1 < (j2 + class9_1.height))) {
					this.menuActionName[this.menuActionRow] = class9_1.tooltip + ", " + class9_1.id;
					this.menuActionID[this.menuActionRow] = 646;
					this.menuActionCmd3[this.menuActionRow] = class9_1.id;
					this.menuActionRow++;
				}
				if ((class9_1.atActionType == 6) && !this.aBoolean1149 && (k >= i2) && (i1 >= j2) && (k < (i2 + class9_1.width)) && (i1 < (j2 + class9_1.height))) {
					this.menuActionName[this.menuActionRow] = class9_1.tooltip + ", " + class9_1.id;
					this.menuActionID[this.menuActionRow] = 679;
					this.menuActionCmd3[this.menuActionRow] = class9_1.id;
					this.menuActionRow++;
				}
				if (class9_1.type == 2) {
					int k2 = 0;
					for (int l2 = 0; l2 < class9_1.height; l2++) {
						for (int i3 = 0; i3 < class9_1.width; i3++) {
							int j3 = i2 + (i3 * (32 + class9_1.invSpritePadX));
							int k3 = j2 + (l2 * (32 + class9_1.invSpritePadY));
							if (k2 < 20) {
								j3 += class9_1.spritesX[k2];
								k3 += class9_1.spritesY[k2];
							}
							if ((k >= j3) && (i1 >= k3) && (k < (j3 + 32)) && (i1 < (k3 + 32))) {
								this.mouseInvInterfaceIndex = k2;
								this.lastActiveInvInterface = class9_1.id;
								if (class9_1.inv[k2] > 0) {
									ItemDef itemDef = ItemDef.forID(class9_1.inv[k2] - 1);
									if ((this.itemSelected == 1) && class9_1.isInventoryInterface) {
										if ((class9_1.id != this.anInt1284) || (k2 != this.anInt1283)) {
											this.menuActionName[this.menuActionRow] = "Use " + this.selectedItemName + " with @lre@" + itemDef.name;
											this.menuActionID[this.menuActionRow] = 870;
											this.menuActionCmd1[this.menuActionRow] = itemDef.id;
											this.menuActionCmd2[this.menuActionRow] = k2;
											this.menuActionCmd3[this.menuActionRow] = class9_1.id;
											this.menuActionRow++;
										}
									} else if ((this.spellSelected == 1) && class9_1.isInventoryInterface) {
										if ((this.spellUsableOn & 0x10) == 16) {
											this.menuActionName[this.menuActionRow] = this.spellTooltip + " @lre@" + itemDef.name;
											this.menuActionID[this.menuActionRow] = 543;
											this.menuActionCmd1[this.menuActionRow] = itemDef.id;
											this.menuActionCmd2[this.menuActionRow] = k2;
											this.menuActionCmd3[this.menuActionRow] = class9_1.id;
											this.menuActionRow++;
										}
									} else {
										if (class9_1.isInventoryInterface) {
											for (int l3 = 4; l3 >= 3; l3--) {
												if ((itemDef.actions != null) && (itemDef.actions[l3] != null)) {
													this.menuActionName[this.menuActionRow] = itemDef.actions[l3] + " @lre@" + itemDef.name;
													if (l3 == 3) {
														this.menuActionID[this.menuActionRow] = 493;
													}
													if (l3 == 4) {
														this.menuActionID[this.menuActionRow] = 847;
													}
													this.menuActionCmd1[this.menuActionRow] = itemDef.id;
													this.menuActionCmd2[this.menuActionRow] = k2;
													this.menuActionCmd3[this.menuActionRow] = class9_1.id;
													this.menuActionRow++;
												} else if (l3 == 4) {
													this.menuActionName[this.menuActionRow] = "Drop @lre@" + itemDef.name;
													this.menuActionID[this.menuActionRow] = 847;
													this.menuActionCmd1[this.menuActionRow] = itemDef.id;
													this.menuActionCmd2[this.menuActionRow] = k2;
													this.menuActionCmd3[this.menuActionRow] = class9_1.id;
													this.menuActionRow++;
												}
											}
										}
										if (class9_1.usableItemInterface) {
											this.menuActionName[this.menuActionRow] = "Use @lre@" + itemDef.name;
											this.menuActionID[this.menuActionRow] = 447;
											this.menuActionCmd1[this.menuActionRow] = itemDef.id;
											this.menuActionCmd2[this.menuActionRow] = k2;
											this.menuActionCmd3[this.menuActionRow] = class9_1.id;
											this.menuActionRow++;
										}
										if (class9_1.isInventoryInterface && (itemDef.actions != null)) {
											for (int i4 = 2; i4 >= 0; i4--) {
												if (itemDef.actions[i4] != null) {
													this.menuActionName[this.menuActionRow] = itemDef.actions[i4] + " @lre@" + itemDef.name;
													if (i4 == 0) {
														this.menuActionID[this.menuActionRow] = 74;
													}
													if (i4 == 1) {
														this.menuActionID[this.menuActionRow] = 454;
													}
													if (i4 == 2) {
														this.menuActionID[this.menuActionRow] = 539;
													}
													this.menuActionCmd1[this.menuActionRow] = itemDef.id;
													this.menuActionCmd2[this.menuActionRow] = k2;
													this.menuActionCmd3[this.menuActionRow] = class9_1.id;
													this.menuActionRow++;
												}
											}
										}
										if (class9_1.actions != null) {
											for (int j4 = 4; j4 >= 0; j4--) {
												if (class9_1.actions[j4] != null) {
													this.menuActionName[this.menuActionRow] = class9_1.actions[j4] + " @lre@" + itemDef.name;
													if (j4 == 0) {
														this.menuActionID[this.menuActionRow] = 632;
													}
													if (j4 == 1) {
														this.menuActionID[this.menuActionRow] = 78;
													}
													if (j4 == 2) {
														this.menuActionID[this.menuActionRow] = 867;
													}
													if (j4 == 3) {
														this.menuActionID[this.menuActionRow] = 431;
													}
													if (j4 == 4) {
														this.menuActionID[this.menuActionRow] = 53;
													}
													this.menuActionCmd1[this.menuActionRow] = itemDef.id;
													this.menuActionCmd2[this.menuActionRow] = k2;
													this.menuActionCmd3[this.menuActionRow] = class9_1.id;
													this.menuActionRow++;
												}
											}
										}
										this.menuActionName[this.menuActionRow] = "Examine @lre@" + itemDef.name + " @gre@(@whi@" + (class9_1.inv[k2] - 1) + "@gre@)";
										this.menuActionID[this.menuActionRow] = 1125;
										this.menuActionCmd1[this.menuActionRow] = itemDef.id;
										this.menuActionCmd2[this.menuActionRow] = k2;
										this.menuActionCmd3[this.menuActionRow] = class9_1.id;
										this.menuActionRow++;
									}
								}
							}
							k2++;
						}
					}
				}
			}
		} */
	}
}