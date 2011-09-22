package com.netty.game.model.entity.player;

import java.util.ArrayList;
import java.util.List;

import com.netty.game.Membership;
import com.netty.game.Memory;
import com.netty.game.model.Model;
import com.netty.game.model.entity.Entity;
import com.netty.game.model.entity.EntityDef;
import com.netty.game.model.entity.item.ItemDef;
import com.netty.game.model.entity.menu.Menu;
import com.netty.game.model.entity.player.chat.Chat;
import com.netty.game.model.entity.player.interfaces.InterfaceManager;
import com.netty.game.model.entity.player.skills.Skill;
import com.netty.game.model.entity.player.sociable.impl.Friend;
import com.netty.game.model.entity.player.sociable.impl.Ignore;
import com.netty.net.cache.MemoryCache;
import com.netty.net.packet.Packet;
import com.netty.stuff.Animation;
import com.netty.stuff.Sequence;
import com.netty.stuff.SpotAnim;
import com.netty.util.text.TextClass;

public class Player extends Entity {

	private Rank rank;
	private Skill[] skills;
	private Chat chat;
	private Memory memory;
	private Membership membership;
	private Menu menu;
	private List<Ignore> ignoreList;
	private List<Friend> friendList;
	private InterfaceManager interfaceManager;

	public Player() {
		this.setIgnoreList(new ArrayList<Ignore>(100));
		this.setFriendList(new ArrayList<Friend>(200));
	}

	public Rank getRank() {
		return this.rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public void setSkillList(Skill[] skills) {
		this.skills = skills;
	}

	public Skill[] getSkills() {
		return this.skills;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Chat getChat() {
		return this.chat;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public Memory getMemory() {
		return this.memory;
	}

	public void setMemberShip(Membership membership) {
		this.membership = membership;
	}

	public Membership getMembership() {
		return this.membership;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setIgnoreList(List<Ignore> ignoreList) {
		this.ignoreList = ignoreList;
	}

	public List<Ignore> getIgnoreList() {
		return this.ignoreList;
	}

	public void setFriendList(List<Friend> friendList) {
		this.friendList = friendList;
	}

	public List<Friend> getFriendList() {
		return this.friendList;
	}

	public void setInterfaceManager(InterfaceManager interfaceManager) {
		this.interfaceManager = interfaceManager;
	}

	public InterfaceManager getInterfaceManager() {
		return this.interfaceManager;
	}

	@Override
	public Model getRotatedModel() {
		if (!this.visible) {
			return null;
		}
		Model model = this.method452();
		if (model == null) {
			return null;
		}
		super.height = model.modelHeight;
		model.oneSquareModel = true;
		if (this.aBoolean1699) {
			return model;
		}
		if ((super.gfxID != -1) && (super.currentAnim != -1)) {
			SpotAnim spotAnim = SpotAnim.cache[super.gfxID];
			Model model_2 = spotAnim.getModel();
			if (model_2 != null) {
				Model model_3 = new Model(true, Animation.method532(super.currentAnim), false, model_2);
				model_3.method475(0, -super.graphicHeight, 0);
				model_3.method469();
				model_3.method470(spotAnim.animationSequence.frame2IDS[super.currentAnim]);
				model_3.triangleSkin = null;
				model_3.vertexSkin = null;
				if ((spotAnim.resizeXY != 128) || (spotAnim.resizeZ != 128)) {
					model_3.method478(spotAnim.resizeXY, spotAnim.resizeXY, spotAnim.resizeZ);
				}
				model_3.method479(64 + spotAnim.modelBrightness, 850 + spotAnim.modelShadow, -30, -50, -30, true);
				Model aclass30_sub2_sub4_sub6_1s[] = {
						model, model_3
				};
				model = new Model(aclass30_sub2_sub4_sub6_1s);
			}
		}
		if (this.aModel_1714 != null) {
			// if (Client.loopCycle >= this.anInt1708) {
			// 	this.aModel_1714 = null;
			// }
			/** if ((Client.loopCycle >= this.anInt1707) && (Client.loopCycle < this.anInt1708)) {
				Model model_1 = this.aModel_1714;
				model_1.method475(this.anInt1711 - super.x, this.anInt1712 - this.drawHeight, this.anInt1713 - super.y);
				if (super.turnDirection == 512) {
					model_1.method473();
					model_1.method473();
					model_1.method473();
				} else if (super.turnDirection == 1024) {
					model_1.method473();
					model_1.method473();
				} else if (super.turnDirection == 1536) {
					model_1.method473();
				}
				Model aclass30_sub2_sub4_sub6s[] = {
						model, model_1
				};
				model = new Model(aclass30_sub2_sub4_sub6s);
				if (super.turnDirection == 512) {
					model_1.method473();
				} else if (super.turnDirection == 1024) {
					model_1.method473();
					model_1.method473();
				} else if (super.turnDirection == 1536) {
					model_1.method473();
					model_1.method473();
					model_1.method473();
				}
				model_1.method475(super.x - this.anInt1711, this.drawHeight - this.anInt1712, super.y - this.anInt1713);
			} */
		}
		model.oneSquareModel = true;
		return model;
	}

	public void updatePlayer(Packet packet) {
		packet.setPosition(0);
		this.playerGender = packet.getUnsignedByte();
		this.headIcon = packet.getUnsignedByte();
		this.desc = null;
		this.team = 0;
		for (int j = 0; j < 12; j++) {
			int k = packet.getUnsignedByte();
			if (k == 0) {
				this.equipment[j] = 0;
				continue;
			}
			int i1 = packet.getUnsignedByte();
			this.equipment[j] = (k << 8) + i1;
			if ((j == 0) && (this.equipment[0] == 65535)) {
				this.desc = EntityDef.forID(packet.getUnsignedShort());
				break;
			}
			if ((this.equipment[j] >= 512) && ((this.equipment[j] - 512) < ItemDef.totalItems)) {
				int l1 = ItemDef.forID(this.equipment[j] - 512).team;
				if (l1 != 0) {
					this.team = l1;
				}
			}
		}
		for (int l = 0; l < 5; l++) {
			int j1 = packet.getUnsignedByte();
			// if ((j1 < 0) || (j1 >= Client.anIntArrayArray1003[l].length)) {
			// 	j1 = 0;
			// }
			this.appearanceColours[l] = j1;
		}
		super.standAnimIndex = packet.getUnsignedShort();
		if (super.standAnimIndex == 65535) {
			super.standAnimIndex = -1;
		}
		super.standTurnAnimIndex = packet.getUnsignedShort();
		if (super.standTurnAnimIndex == 65535) {
			super.standTurnAnimIndex = -1;
		}
		super.walkAnimIndex = packet.getUnsignedShort();
		if (super.walkAnimIndex == 65535) {
			super.walkAnimIndex = -1;
		}
		super.turn180AnimIndex = packet.getUnsignedShort();
		if (super.turn180AnimIndex == 65535) {
			super.turn180AnimIndex = -1;
		}
		super.turn90CWAnimIndex = packet.getUnsignedShort();
		if (super.turn90CWAnimIndex == 65535) {
			super.turn90CWAnimIndex = -1;
		}
		super.turn90CCWAnimIndex = packet.getUnsignedShort();
		if (super.turn90CCWAnimIndex == 65535) {
			super.turn90CCWAnimIndex = -1;
		}
		super.runAnimIndex = packet.getUnsignedShort();
		if (super.runAnimIndex == 65535) {
			super.runAnimIndex = -1;
		}
		this.name = TextClass.fixName(TextClass.nameForLong(packet.getLong()));
		this.combatLevel = packet.getUnsignedByte();
		this.skill = packet.getUnsignedShort();
		this.visible = true;
		this.aLong1718 = 0L;
		for (int k1 = 0; k1 < 12; k1++) {
			this.aLong1718 <<= 4;
			if (this.equipment[k1] >= 256) {
				this.aLong1718 += this.equipment[k1] - 256;
			}
		}
		if (this.equipment[0] >= 256) {
			this.aLong1718 += (this.equipment[0] - 256) >> 4;
		}
		if (this.equipment[1] >= 256) {
			this.aLong1718 += (this.equipment[1] - 256) >> 8;
		}
		for (int i2 = 0; i2 < 5; i2++) {
			this.aLong1718 <<= 3;
			this.aLong1718 += this.appearanceColours[i2];
		}
		this.aLong1718 <<= 1;
		this.aLong1718 += this.playerGender;
	}

	private Model method452() {
		if (this.desc != null) {
			int j = -1;
			if ((super.anim >= 0) && (super.animationDelay == 0)) {
				j = Sequence.anims[super.anim].frame2IDS[super.anInt1527];
			} else if (super.anInt1517 >= 0) {
				j = Sequence.anims[super.anInt1517].frame2IDS[super.anInt1518];
			}
			Model model = this.desc.method164(-1, j, null);
			return model;
		}
		long l = this.aLong1718;
		int k = -1;
		int i1 = -1;
		int j1 = -1;
		int k1 = -1;
		if ((super.anim >= 0) && (super.animationDelay == 0)) {
			Sequence sequence = Sequence.anims[super.anim];
			k = sequence.frame2IDS[super.anInt1527];
			if ((super.anInt1517 >= 0) && (super.anInt1517 != super.standAnimIndex)) {
				i1 = Sequence.anims[super.anInt1517].frame2IDS[super.anInt1518];
			}
			if (sequence.anInt360 >= 0) {
				j1 = sequence.anInt360;
				l += (j1 - this.equipment[5]) << 40;
			}
			if (sequence.anInt361 >= 0) {
				k1 = sequence.anInt361;
				l += (k1 - this.equipment[3]) << 48;
			}
		} else if (super.anInt1517 >= 0) {
			k = Sequence.anims[super.anInt1517].frame2IDS[super.anInt1518];
		}
		Model model_1 = (Model) Player.modelCache.insertFromCache(l);
		if (model_1 == null) {
			boolean flag = false;
			for (int i2 = 0; i2 < 12; i2++) {
				int k2 = this.equipment[i2];
				if ((k1 >= 0) && (i2 == 3)) {
					k2 = k1;
				}
				if ((j1 >= 0) && (i2 == 5)) {
					k2 = j1;
				}
				if ((k2 >= 256) && (k2 < 512) && !IdentityKit.cache[k2 - 256].isBodyDownloaded()) {
					flag = true;
				}
				if ((k2 >= 512) && !ItemDef.forID(k2 - 512).method195(this.playerGender)) {
					flag = true;
				}
			}
			if (flag) {
				if(this.aLong1697 != -1L) {
					model_1 = (Model) Player.modelCache.insertFromCache(this.aLong1697);
				}
				if(model_1 == null) {
					return null;
				}
			}
		}
		if (model_1 == null) {
			Model aclass30_sub2_sub4_sub6s[] = new Model[12];
			int j2 = 0;
			for (int l2 = 0; l2 < 12; l2++) {
				int i3 = this.equipment[l2];
				if ((k1 >= 0) && (l2 == 3)) {
					i3 = k1;
				}
				if ((j1 >= 0) && (l2 == 5)) {
					i3 = j1;
				}
				if ((i3 >= 256) && (i3 < 512)) {
					Model model_3 = IdentityKit.cache[i3 - 256].getBodyModel();
					if (model_3 != null) {
						aclass30_sub2_sub4_sub6s[j2++] = model_3;
					}
				}
				if (i3 >= 512) {
					Model model_4 = ItemDef.forID(i3 - 512).method196(this.playerGender);
					if (model_4 != null) {
						aclass30_sub2_sub4_sub6s[j2++] = model_4;
					}
				}
			}
			model_1 = new Model(j2, aclass30_sub2_sub4_sub6s);
			for (int j3 = 0; j3 < 5; j3++) {
				if (this.appearanceColours[j3] != 0) {
					// model_1.method476(Client.anIntArrayArray1003[j3][0], Client.anIntArrayArray1003[j3][this.appearanceColours[j3]]);
					// if (j3 == 1) {
					// 	model_1.method476(Client.anIntArray1204[0], Client.anIntArray1204[this.appearanceColours[j3]]);
					// }
				}
			}
			model_1.method469();
			model_1.method479(64, 850, -30, -50, -30, true);
			Player.modelCache.removeFromCache(model_1, l);
			this.aLong1697 = l;
		}
		if (this.aBoolean1699) {
			return model_1;
		}
		Model model_2 = Model.aModel_1621;
		model_2.method464(model_1, Animation.method532(k) & Animation.method532(i1));
		if ((k != -1) && (i1 != -1)) {
			model_2.method471(Sequence.anims[super.anim].animationFlowControl, i1, k);
		} else if (k != -1) {
			model_2.method470(k);
		}
		model_2.method466();
		model_2.triangleSkin = null;
		model_2.vertexSkin = null;
		return model_2;
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	public int privelage;

	public Model method453() {
		if (!this.visible) {
			return null;
		}
		if (this.desc != null) {
			return this.desc.getHeadModel();
		}
		boolean flag = false;
		for (int i = 0; i < 12; i++) {
			int j = this.equipment[i];
			if ((j >= 256) && (j < 512) && !IdentityKit.cache[j - 256].isHeadDownloaded()) {
				flag = true;
			}
			if ((j >= 512) && !ItemDef.forID(j - 512).method192(this.playerGender)) {
				flag = true;
			}
		}
		if (flag) {
			return null;
		}
		Model aclass30_sub2_sub4_sub6s[] = new Model[12];
		int k = 0;
		for(int l = 0; l < 12; l++) {
			int i1 = this.equipment[l];
			if ((i1 >= 256) && (i1 < 512)) {
				Model model_1 = IdentityKit.cache[i1 - 256].getHeadModel();
				if(model_1 != null) {
					aclass30_sub2_sub4_sub6s[k++] = model_1;
				}
			}
			if (i1 >= 512) {
				Model model_2 = ItemDef.forID(i1 - 512).method194(this.playerGender);
				if (model_2 != null) {
					aclass30_sub2_sub4_sub6s[k++] = model_2;
				}
			}
		}
		Model model = new Model(k, aclass30_sub2_sub4_sub6s);
		for (int j1 = 0; j1 < 5; j1++) {
			if (this.appearanceColours[j1] != 0) {
				// model.method476(Client.anIntArrayArray1003[j1][0], Client.anIntArrayArray1003[j1][this.appearanceColours[j1]]);
				// if (j1 == 1) {
				// 	model.method476(Client.anIntArray1204[0], Client.anIntArray1204[this.appearanceColours[j1]]);
				// }
			}
		}
		return model;
	}

	/** public Player() {
		this.aLong1697 = -1L;
		this.aBoolean1699 = false;
		this.appearanceColours = new int[5];
		this.visible = false;
		this.equipment = new int[12];
	} */

	private long aLong1697;
	public EntityDef desc;
	public boolean aBoolean1699;
	public int[] appearanceColours;
	public int team;
	private int playerGender;
	public String name;
	public static MemoryCache modelCache = new MemoryCache(260);
	public int combatLevel;
	public int headIcon;
	public int anInt1707;
	public int anInt1708;
	public int drawHeight;
	public boolean visible;
	public int anInt1711;
	public int anInt1712;
	public int anInt1713;
	public Model aModel_1714;
	public int[] equipment;
	private long aLong1718;
	public int anInt1719;
	public int anInt1720;
	public int anInt1721;
	public int anInt1722;
	public int skill;
}
