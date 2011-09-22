package com.netty.game.model.entity.player.interfaces;

import com.netty.game.graphics.image.RGBImage;
import com.netty.game.model.Model;
import com.netty.game.model.entity.EntityDef;
import com.netty.game.model.entity.item.ItemDef;
import com.netty.net.cache.MemoryCache;
import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;
import com.netty.stuff.Animation;
import com.netty.util.text.RSFont;
import com.netty.util.text.TextClass;

public class RSInterface {

	public void swapInventoryItems(int i, int j) {
		int k = this.inv[i];
		this.inv[i] = this.inv[j];
		this.inv[j] = k;
		k = this.invStackSizes[i];
		this.invStackSizes[i] = this.invStackSizes[j];
		this.invStackSizes[j] = k;
	}

	public static void unpack(JagexArchive jagexArchive, RSFont textDrawingAreas[], JagexArchive streamLoader_1) {
		RSInterface.spriteCache = new MemoryCache(50000);
		Packet packet = new Packet(jagexArchive.getDataForName("data"));
		int i = -1;
		int j = packet.getUnsignedShort();
		RSInterface.interfaceCache = new RSInterface[j];
		while (packet.getPosition() < packet.buffer.length) {
			int k = packet.getUnsignedShort();
			if (k == 65535) {
				i = packet.getUnsignedShort();
				k = packet.getUnsignedShort();
			}
			RSInterface rsInterface = RSInterface.interfaceCache[k] = new RSInterface();
			rsInterface.id = k;
			rsInterface.parentID = i;
			rsInterface.type = packet.getUnsignedByte();
			rsInterface.atActionType = packet.getUnsignedByte();
			rsInterface.contentType = packet.getUnsignedShort();
			rsInterface.width = packet.getUnsignedShort();
			rsInterface.height = packet.getUnsignedShort();
			rsInterface.alpha = (byte) packet.getUnsignedByte();
			rsInterface.mouseOverPopupInterface = packet.getUnsignedByte();
			if (rsInterface.mouseOverPopupInterface != 0) {
				rsInterface.mouseOverPopupInterface = ((rsInterface.mouseOverPopupInterface - 1) << 8) + packet.getUnsignedByte();
			} else {
				rsInterface.mouseOverPopupInterface = -1;
			}
			int i1 = packet.getUnsignedByte();
			if (i1 > 0) {
				rsInterface.conditionType = new int[i1];
				rsInterface.conditionValueToCompare = new int[i1];
				for (int j1 = 0; j1 < i1; j1++) {
					rsInterface.conditionType[j1] = packet.getUnsignedByte();
					rsInterface.conditionValueToCompare[j1] = packet.getUnsignedShort();
				}
			}
			int k1 = packet.getUnsignedByte();
			if (k1 > 0) {
				rsInterface.dynamicValueFormulas = new int[k1][];
				for (int l1 = 0; l1 < k1; l1++) {
					int i3 = packet.getUnsignedShort();
					rsInterface.dynamicValueFormulas[l1] = new int[i3];
					for (int l4 = 0; l4 < i3; l4++) {
						rsInterface.dynamicValueFormulas[l1][l4] = packet.getUnsignedShort();
					}
				}
			}
			if (rsInterface.type == 0) {
				rsInterface.scrollMax = packet.getUnsignedShort();
				rsInterface.hiddenUntilMouseover = packet.getUnsignedByte() == 1;
				int i2 = packet.getUnsignedShort();
				rsInterface.children = new int[i2];
				rsInterface.childX = new int[i2];
				rsInterface.childY = new int[i2];
				for (int j3 = 0; j3 < i2; j3++) {
					rsInterface.children[j3] = packet.getUnsignedShort();
					rsInterface.childX[j3] = packet.getShort();
					rsInterface.childY[j3] = packet.getShort();
				}
			}
			if (rsInterface.type == 1) {
				packet.getUnsignedShort();
				packet.getUnsignedByte();
			}
			if (rsInterface.type == 2) {
				rsInterface.inv = new int[rsInterface.width * rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
				rsInterface.aBoolean259 = packet.getUnsignedByte() == 1;
				rsInterface.isInventoryInterface = packet.getUnsignedByte() == 1;
				rsInterface.usableItemInterface = packet.getUnsignedByte() == 1;
				rsInterface.dragDeletes = packet.getUnsignedByte() == 1;
				rsInterface.invSpritePadX = packet.getUnsignedByte();
				rsInterface.invSpritePadY = packet.getUnsignedByte();
				rsInterface.spritesX = new int[20];
				rsInterface.spritesY = new int[20];
				rsInterface.rGBImages = new RGBImage[20];
				for (int j2 = 0; j2 < 20; j2++) {
					int k3 = packet.getUnsignedByte();
					if (k3 == 1) {
						rsInterface.spritesX[j2] = packet.getShort();
						rsInterface.spritesY[j2] = packet.getShort();
						String s1 = packet.getString();
						if ((streamLoader_1 != null) && (s1.length() > 0)) {
							int i5 = s1.lastIndexOf(",");
							rsInterface.rGBImages[j2] = RSInterface.getSprite(Integer.parseInt(s1.substring(i5 + 1)), streamLoader_1, s1.substring(0, i5));
						}
					}
				}
				rsInterface.actions = new String[5];
				for (int l3 = 0; l3 < 5; l3++) {
					rsInterface.actions[l3] = packet.getString();
					if (rsInterface.actions[l3].length() == 0) {
						rsInterface.actions[l3] = null;
					}
				}
			}
			if (rsInterface.type == 3) {
				rsInterface.filled = packet.getUnsignedByte() == 1;
			}
			if ((rsInterface.type == 4) || (rsInterface.type == 1)) {
				rsInterface.textCentered = packet.getUnsignedByte() == 1;
				int k2 = packet.getUnsignedByte();
				if (textDrawingAreas != null) {
					rsInterface.rSFonts = textDrawingAreas[k2];
				}
				rsInterface.textShadow = packet.getUnsignedByte() == 1;
			}
			if (rsInterface.type == 4) {
				rsInterface.message = packet.getString();
				rsInterface.textConditionTrue = packet.getString();
			}
			if ((rsInterface.type == 1) || (rsInterface.type == 3) || (rsInterface.type == 4)) {
				rsInterface.textColor = packet.getInt();
			}
			if ((rsInterface.type == 3) || (rsInterface.type == 4)) {
				rsInterface.colourConditionTrue = packet.getInt();
				rsInterface.colourConditionFalseMouseover = packet.getInt();
				rsInterface.colourConditionTrueMouseover = packet.getInt();
			}
			if (rsInterface.type == 5) {
				String s = packet.getString();
				if ((streamLoader_1 != null) && (s.length() > 0)) {
					int i4 = s.lastIndexOf(",");
					rsInterface.imageConditionFalse = RSInterface.getSprite(Integer.parseInt(s.substring(i4 + 1)), streamLoader_1, s.substring(0, i4));
				}
				s = packet.getString();
				if ((streamLoader_1 != null) && (s.length() > 0)) {
					int j4 = s.lastIndexOf(",");
					rsInterface.sprite2 = RSInterface.getSprite(Integer.parseInt(s.substring(j4 + 1)), streamLoader_1, s.substring(0, j4));
				}
			}
			if (rsInterface.type == 6) {
				int l = packet.getUnsignedByte();
				if (l != 0) {
					rsInterface.mediaType = 1;
					rsInterface.mediaID = ((l - 1) << 8) + packet.getUnsignedByte();
				}
				l = packet.getUnsignedByte();
				if (l != 0) {
					rsInterface.enabledMediaType = 1;
					rsInterface.enabledMediaID = ((l - 1) << 8) + packet.getUnsignedByte();
				}
				l = packet.getUnsignedByte();
				if (l != 0) {
					rsInterface.animationConditionFalse = ((l - 1) << 8) + packet.getUnsignedByte();
				} else {
					rsInterface.animationConditionFalse = -1;
				}
				l = packet.getUnsignedByte();
				if (l != 0) {
					rsInterface.animationConditionTrue = ((l - 1) << 8) + packet.getUnsignedByte();
				} else {
					rsInterface.animationConditionTrue = -1;
				}
				rsInterface.zoom = packet.getUnsignedShort();
				rsInterface.rotation1 = packet.getUnsignedShort();
				rsInterface.rotation2 = packet.getUnsignedShort();
			}
			if (rsInterface.type == 7) {
				rsInterface.inv = new int[rsInterface.width * rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
				rsInterface.textCentered = packet.getUnsignedByte() == 1;
				int l2 = packet.getUnsignedByte();
				if (textDrawingAreas != null) {
					rsInterface.rSFonts = textDrawingAreas[l2];
				}
				rsInterface.textShadow = packet.getUnsignedByte() == 1;
				rsInterface.textColor = packet.getInt();
				rsInterface.invSpritePadX = packet.getShort();
				rsInterface.invSpritePadY = packet.getShort();
				rsInterface.isInventoryInterface = packet.getUnsignedByte() == 1;
				rsInterface.actions = new String[5];
				for (int k4 = 0; k4 < 5; k4++) {
					rsInterface.actions[k4] = packet.getString();
					if (rsInterface.actions[k4].length() == 0) {
						rsInterface.actions[k4] = null;
					}
				}
			}
			if ((rsInterface.atActionType == 2) || (rsInterface.type == 2)) {
				rsInterface.selectedActionName = packet.getString();
				rsInterface.spellName = packet.getString();
				rsInterface.spellUsableOn = packet.getUnsignedShort();
			}
			if (rsInterface.type == 8) {
				rsInterface.message = packet.getString();
			}
			if ((rsInterface.atActionType == 1) || (rsInterface.atActionType == 4) || (rsInterface.atActionType == 5) || (rsInterface.atActionType == 6)) {
				rsInterface.tooltip = packet.getString();
				if (rsInterface.tooltip.length() == 0) {
					if (rsInterface.atActionType == 1) {
						rsInterface.tooltip = "Ok";
					}
					if (rsInterface.atActionType == 4) {
						rsInterface.tooltip = "Select";
					}
					if (rsInterface.atActionType == 5) {
						rsInterface.tooltip = "Select";
					}
					if (rsInterface.atActionType == 6) {
						rsInterface.tooltip = "Continue";
					}
				}
			}
		}
		RSInterface.spriteCache = null;
	}

	private Model getModel(int i, int j) {
		Model model = (Model) RSInterface.modelCache.insertFromCache((i << 16) + j);
		if (model != null) {
			return model;
		}
		if (i == 1) {
			model = Model.method462(j);
		}
		if (i == 2) {
			model = EntityDef.forID(j).getHeadModel();
		}
		if (i == 3) {
			// model = Client.myPlayer.method453();
		}
		if (i == 4) {
			model = ItemDef.forID(j).method202(50);
		}
		if (i == 5) {
			model = null;
		}
		if (model != null) {
			RSInterface.modelCache.removeFromCache(model, (i << 16) + j);
		}
		return model;
	}

	private static RGBImage getSprite(int i, JagexArchive jagexArchive, String s) {
		long l = (TextClass.method585(s) << 8) + i;
		RGBImage rGBImage = (RGBImage) RSInterface.spriteCache.insertFromCache(l);
		if (rGBImage != null) {
			return rGBImage;
		}
		try {
			rGBImage = new RGBImage(jagexArchive, s, i);
			RSInterface.spriteCache.removeFromCache(rGBImage, l);
		} catch (Exception _ex) {
			return null;
		}
		return rGBImage;
	}

	public static void setCustomModel(Model model) {
		int i = 0;
		int j = 5;
		RSInterface.modelCache.unlinkAll();
		if ((model != null) && (j != 4)) {
			RSInterface.modelCache.removeFromCache(model, (j << 16) + i);
		}
	}

	public Model getAnimatedModel(int j, int k, boolean flag) {
		Model model;
		if (flag) {
			model = this.getModel(this.enabledMediaType, this.enabledMediaID);
		} else {
			model = this.getModel(this.mediaType, this.mediaID);
		}
		if (model == null) {
			return null;
		}
		if ((k == -1) && (j == -1) && (model.triangleColour == null)) {
			return model;
		}
		Model model_1 = new Model(true, Animation.method532(k) & Animation.method532(j), false, model);
		if ((k != -1) || (j != -1)) {
			model_1.method469();
		}
		if (k != -1) {
			model_1.method470(k);
		}
		if (j != -1) {
			model_1.method470(j);
		}
		model_1.method479(64, 768, -50, -10, -50, true);
		return model_1;
	}

	public RSInterface() {}

	public RGBImage imageConditionFalse;
	public int duration;
	public RGBImage rGBImages[];
	public static RSInterface interfaceCache[];
	public int conditionValueToCompare[];
	public int contentType;
	public int spritesX[];
	public int colourConditionFalseMouseover;
	public int atActionType;
	public String spellName;
	public int colourConditionTrue;
	public int width;
	public String tooltip;
	public String selectedActionName;
	public boolean textCentered;
	public int scrollPosition;
	public String actions[];
	public int dynamicValueFormulas[][];
	public boolean filled;
	public String textConditionTrue;
	public int mouseOverPopupInterface;
	public int invSpritePadX;
	public int textColor;
	public int mediaType;
	public int mediaID;
	public boolean dragDeletes;
	public int parentID;
	public int spellUsableOn;
	private static MemoryCache spriteCache;
	public int colourConditionTrueMouseover;
	public int children[];
	public int childX[];
	public boolean usableItemInterface;
	public RSFont rSFonts;
	public int invSpritePadY;
	public int conditionType[];
	public int animFrame;
	public int spritesY[];
	public String message;
	public boolean isInventoryInterface;
	public int id;
	public int invStackSizes[];
	public int inv[];
	public byte alpha;
	private int enabledMediaType;
	private int enabledMediaID;
	public int animationConditionFalse;
	public int animationConditionTrue;
	public boolean aBoolean259;
	public RGBImage sprite2;
	public int scrollMax;
	public int type;
	public int xOffset;
	private static MemoryCache modelCache = new MemoryCache(30);
	public int yOffset;
	public boolean hiddenUntilMouseover;
	public int height;
	public boolean textShadow;
	public int zoom;
	public int rotation1;
	public int rotation2;
	public int childY[];
}