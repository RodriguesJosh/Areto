package com.netty.game.model.entity.item;

import com.netty.game.graphics.DrawingArea;
import com.netty.game.graphics.image.RGBImage;
import com.netty.game.graphics.texture.Rasterizer;
import com.netty.game.model.Model;
import com.netty.net.cache.MemoryCache;
import com.netty.net.packet.JagexArchive;
import com.netty.net.packet.Packet;

public class ItemDef {

	public static void nullLoader() {
		ItemDef.modelCache = null;
		ItemDef.rgbImageCache = null;
		ItemDef.streamIndices = null;
		ItemDef.cache = null;
		ItemDef.packet = null;
	}

	public boolean method192(int j) {
		int k = this.maleDialogue;
		int l = this.maleDialogueHat;
		if (j == 1) {
			k = this.femaleDialogue;
			l = this.femaleDialogueHat;
		}
		if (k == -1) {
			return true;
		}
		boolean flag = true;
		if (!Model.method463(k)) {
			flag = false;
		}
		if ((l != -1) && !Model.method463(l)) {
			flag = false;
		}
		return flag;
	}

	public static void unpackConfig(JagexArchive jagexArchive) {
		ItemDef.packet = new Packet(jagexArchive.getDataForName("obj.dat"));
		Packet packet = new Packet(jagexArchive.getDataForName("obj.idx"));
		ItemDef.totalItems = packet.getUnsignedShort();
		ItemDef.streamIndices = new int[ItemDef.totalItems];
		int i = 2;
		for (int j = 0; j < ItemDef.totalItems; j++) {
			ItemDef.streamIndices[j] = i;
			i += packet.getUnsignedShort();
		}
		ItemDef.cache = new ItemDef[10];
		for (int k = 0; k < 10; k++) {
			ItemDef.cache[k] = new ItemDef();
		}
	}

	public Model method194(int j) {
		int k = this.maleDialogue;
		int l = this.maleDialogueHat;
		if (j == 1) {
			k = this.femaleDialogue;
			l = this.femaleDialogueHat;
		}
		if (k == -1) {
			return null;
		}
		Model model = Model.method462(k);
		if (l != -1) {
			Model model_1 = Model.method462(l);
			Model aclass30_sub2_sub4_sub6s[] = {
					model, model_1
			};
			model = new Model(2, aclass30_sub2_sub4_sub6s);
		}
		if (this.modifiedModelColors != null) {
			for (int i1 = 0; i1 < this.modifiedModelColors.length; i1++) {
				model.method476(this.modifiedModelColors[i1], this.originalModelColors[i1]);
			}
		}
		return model;
	}

	public boolean method195(int j) {
		int k = this.maleEquip1;
		int l = this.maleEquip2;
		int i1 = this.maleEmblem;
		if (j == 1) {
			k = this.femaleEquip1;
			l = this.femaleEquip2;
			i1 = this.femaleEmblem;
		}
		if (k == -1) {
			return true;
		}
		boolean flag = true;
		if (!Model.method463(k)) {
			flag = false;
		}
		if ((l != -1) && !Model.method463(l)) {
			flag = false;
		}
		if ((i1 != -1) && !Model.method463(i1)) {
			flag = false;
		}
		return flag;
	}

	public Model method196(int i) {
		int j = this.maleEquip1;
		int k = this.maleEquip2;
		int l = this.maleEmblem;
		if (i == 1) {
			j = this.femaleEquip1;
			k = this.femaleEquip2;
			l = this.femaleEmblem;
		}
		if (j == -1) {
			return null;
		}
		Model model = Model.method462(j);
		if (k != -1) {
			if (l != -1) {
				Model model_1 = Model.method462(k);
				Model model_3 = Model.method462(l);
				Model aclass30_sub2_sub4_sub6_1s[] = {
						model, model_1, model_3
				};
				model = new Model(3, aclass30_sub2_sub4_sub6_1s);
			} else {
				Model model_2 = Model.method462(k);
				Model aclass30_sub2_sub4_sub6s[] = {
						model, model_2
				};
				model = new Model(2, aclass30_sub2_sub4_sub6s);
			}
		}
		if ((i == 0) && (this.maleYOffset != 0)) {
			model.method475(0, this.maleYOffset, 0);
		}
		if ((i == 1) && (this.femaleYOffset != 0)) {
			model.method475(0, this.femaleYOffset, 0);
		}
		if (this.modifiedModelColors != null) {
			for (int i1 = 0; i1 < this.modifiedModelColors.length; i1++) {
				model.method476(this.modifiedModelColors[i1], this.originalModelColors[i1]);
			}
		}
		return model;
	}

	private void setDefaults() {
		this.modelID = 0;
		this.name = null;
		this.description = null;
		this.modifiedModelColors = null;
		this.originalModelColors = null;
		this.modelZoom = 2000;
		this.rotationY = 0;
		this.rotationX = 0;
		this.diagionalRotation = 0;
		this.modelOffset1 = 0;
		this.modelOffset2 = 0;
		this.stackable = false;
		this.value = 1;
		this.membersObject = false;
		this.groundActions = null;
		this.actions = null;
		this.maleEquip1 = -1;
		this.maleEquip2 = -1;
		this.maleYOffset = 0;
		this.femaleEquip1 = -1;
		this.femaleEquip2 = -1;
		this.femaleYOffset = 0;
		this.maleEmblem = -1;
		this.femaleEmblem = -1;
		this.maleDialogue = -1;
		this.maleDialogueHat = -1;
		this.femaleDialogue = -1;
		this.femaleDialogueHat = -1;
		this.stackIDs = null;
		this.stackAmounts = null;
		this.certID = -1;
		this.certTemplateID = -1;
		this.modelSizeX = 128;
		this.modelSizeY = 128;
		this.modelSizeZ = 128;
		this.lightModifier = 0;
		this.shadowModifier = 0;
		this.team = 0;
	}

	public static ItemDef forID(int i) {
		for (int j = 0; j < 10; j++) {
			if (ItemDef.cache[j].id == i) {
				return ItemDef.cache[j];
			}
		}
		ItemDef.cacheIndex = (ItemDef.cacheIndex + 1) % 10;
		ItemDef itemDef = ItemDef.cache[ItemDef.cacheIndex];
		ItemDef.packet.setPosition(ItemDef.streamIndices[i]);
		itemDef.id = i;
		itemDef.setDefaults();
		itemDef.readValues(ItemDef.packet);
		if (itemDef.certTemplateID != -1) {
			itemDef.toNote();
		}
		if (!ItemDef.isMembers && itemDef.membersObject) {
			itemDef.name = "Members Object";
			itemDef.description = "Login to a members' server to use this object.".getBytes();
			itemDef.groundActions = null;
			itemDef.actions = null;
			itemDef.team = 0;
		}
		return itemDef;
	}

	private void toNote() {
		ItemDef itemDef = ItemDef.forID(this.certTemplateID);
		this.modelID = itemDef.modelID;
		this.modelZoom = itemDef.modelZoom;
		this.rotationY = itemDef.rotationY;
		this.rotationX = itemDef.rotationX;
		this.diagionalRotation = itemDef.diagionalRotation;
		this.modelOffset1 = itemDef.modelOffset1;
		this.modelOffset2 = itemDef.modelOffset2;
		this.modifiedModelColors = itemDef.modifiedModelColors;
		this.originalModelColors = itemDef.originalModelColors;
		ItemDef itemDef_1 = ItemDef.forID(this.certID);
		this.name = itemDef_1.name;
		this.membersObject = itemDef_1.membersObject;
		this.value = itemDef_1.value;
		String s = "a";
		char c = itemDef_1.name.charAt(0);
		if ((c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U')) {
			s = "an";
		}
		this.description = ("Swap this note at any bank for " + s + " " + itemDef_1.name + ".").getBytes();
		this.stackable = true;
	}

	public static RGBImage getSprite(int i, int j, int k) {
		if (k == 0) {
			RGBImage rGBImage = (RGBImage) ItemDef.rgbImageCache.insertFromCache(i);
			if ((rGBImage != null) && (rGBImage.secondHeight != j) && (rGBImage.secondHeight != -1)) {
				rGBImage.unlink();
				rGBImage = null;
			}
			if (rGBImage != null) {
				return rGBImage;
			}
		}
		ItemDef itemDef = ItemDef.forID(i);
		if (itemDef.stackIDs == null) {
			j = -1;
		}
		if (j > 1) {
			int i1 = -1;
			for (int j1 = 0; j1 < 10; j1++) {
				if ((j >= itemDef.stackAmounts[j1]) && (itemDef.stackAmounts[j1] != 0)) {
					i1 = itemDef.stackIDs[j1];
				}
			}
			if (i1 != -1) {
				itemDef = ItemDef.forID(i1);
			}
		}
		Model model = itemDef.method201(1);
		if (model == null) {
			return null;
		}
		RGBImage rGBImage = null;
		if (itemDef.certTemplateID != -1) {
			rGBImage = ItemDef.getSprite(itemDef.certID, 10, -1);
			if (rGBImage == null) {
				return null;
			}
		}
		RGBImage sprite2 = new RGBImage(32, 32);
		int k1 = Rasterizer.textureInt1;
		int l1 = Rasterizer.textureInt2;
		int ai[] = Rasterizer.anIntArray1472;
		int ai1[] = DrawingArea.pixels;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.viewportWidth;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.viewportHeight;
		Rasterizer.aBoolean1464 = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels);
		DrawingArea.method336(32, 0, 0, 0, 32);
		Rasterizer.method364();
		int k3 = itemDef.modelZoom;
		if (k == -1) {
			k3 = (int)(k3 * 1.5D);
		}
		if (k > 0) {
			k3 = (int)(k3 * 1.04D);
		}
		int l3 = (Rasterizer.anIntArray1470[itemDef.rotationY] * k3) >> 16;
			int i4 = (Rasterizer.anIntArray1471[itemDef.rotationY] * k3) >> 16;
		model.method482(itemDef.rotationX, itemDef.diagionalRotation, itemDef.rotationY, itemDef.modelOffset1, l3 + (model.modelHeight / 2) + itemDef.modelOffset2, i4 + itemDef.modelOffset2);
		for (int i5 = 31; i5 >= 0; i5--) {
			for (int j4 = 31; j4 >= 0; j4--) {
				if (sprite2.myPixels[i5 + (j4 * 32)] == 0) {
					if ((i5 > 0) && (sprite2.myPixels[(i5 - 1) + (j4 * 32)] > 1)) {
						sprite2.myPixels[i5 + (j4 * 32)] = 1;
					} else if ((j4 > 0) && (sprite2.myPixels[i5 + ((j4 - 1) * 32)] > 1)) {
						sprite2.myPixels[i5 + (j4 * 32)] = 1;
					} else if ((i5 < 31) && (sprite2.myPixels[i5 + 1 + (j4 * 32)] > 1)) {
						sprite2.myPixels[i5 + (j4 * 32)] = 1;
					} else if ((j4 < 31) && (sprite2.myPixels[i5 + ((j4 + 1) * 32)] > 1)) {
						sprite2.myPixels[i5 + (j4 * 32)] = 1;
					}
				}
			}
		}
		if (k > 0) {
			for (int j5 = 31; j5 >= 0; j5--) {
				for (int k4 = 31; k4 >= 0; k4--) {
					if (sprite2.myPixels[j5 + (k4 * 32)] == 0) {
						if ((j5 > 0) && (sprite2.myPixels[(j5 - 1) + (k4 * 32)] == 1)) {
							sprite2.myPixels[j5 + (k4 * 32)] = k;
						} else if ((k4 > 0) && (sprite2.myPixels[j5 + ((k4 - 1) * 32)] == 1)) {
							sprite2.myPixels[j5 + (k4 * 32)] = k;
						} else if ((j5 < 31) && (sprite2.myPixels[j5 + 1 + (k4 * 32)] == 1)) {
							sprite2.myPixels[j5 + (k4 * 32)] = k;
						} else if ((k4 < 31) && (sprite2.myPixels[j5 + ((k4 + 1) * 32)] == 1)) {
							sprite2.myPixels[j5 + (k4 * 32)] = k;
						}
					}
				}
			}
		} else if (k == 0) {
			for (int k5 = 31; k5 >= 0; k5--) {
				for (int l4 = 31; l4 >= 0; l4--) {
					if ((sprite2.myPixels[k5 + (l4 * 32)] == 0) && (k5 > 0) && (l4 > 0) && (sprite2.myPixels[(k5 - 1) + ((l4 - 1) * 32)] > 0)) {
						sprite2.myPixels[k5 + (l4 * 32)] = 0x302020;
					}
				}
			}
		}
		if (itemDef.certTemplateID != -1) {
			int l5 = rGBImage.secondWidth;
			int j6 = rGBImage.secondHeight;
			rGBImage.secondWidth = 32;
			rGBImage.secondHeight = 32;
			rGBImage.drawSprite(0, 0);
			rGBImage.secondWidth = l5;
			rGBImage.secondHeight = j6;
		}
		if (k == 0) {
			ItemDef.rgbImageCache.removeFromCache(sprite2, i);
		}
		DrawingArea.initDrawingArea(j2, i2, ai1);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Rasterizer.textureInt1 = k1;
		Rasterizer.textureInt2 = l1;
		Rasterizer.anIntArray1472 = ai;
		Rasterizer.aBoolean1464 = true;
		if (itemDef.stackable) {
			sprite2.secondWidth = 33;
		} else {
			sprite2.secondWidth = 32;
		}
		sprite2.secondHeight = j;
		return sprite2;
	}

	public Model method201(int i) {
		if ((this.stackIDs != null) && (i > 1)) {
			int j = -1;
			for (int k = 0; k < 10; k++) {
				if ((i >= this.stackAmounts[k]) && (this.stackAmounts[k] != 0)) {
					j = this.stackIDs[k];
				}
			}
			if (j != -1) {
				return ItemDef.forID(j).method201(1);
			}
		}
		Model model = (Model) ItemDef.modelCache.insertFromCache(this.id);
		if (model != null) {
			return model;
		}
		model = Model.method462(this.modelID);
		if (model == null) {
			return null;
		}
		if ((this.modelSizeX != 128) || (this.modelSizeY != 128) || (this.modelSizeZ != 128)) {
			model.method478(this.modelSizeX, this.modelSizeZ, this.modelSizeY);
		}
		if (this.modifiedModelColors != null) {
			for (int l = 0; l < this.modifiedModelColors.length; l++) {
				model.method476(this.modifiedModelColors[l], this.originalModelColors[l]);
			}
		}
		model.method479(64 + this.lightModifier, 768 + this.shadowModifier, -50, -10, -50, true);
		model.oneSquareModel = true;
		ItemDef.modelCache.removeFromCache(model, this.id);
		return model;
	}

	public Model method202(int i) {
		if ((this.stackIDs != null) && (i > 1)) {
			int j = -1;
			for (int k = 0; k < 10; k++) {
				if ((i >= this.stackAmounts[k]) && (this.stackAmounts[k] != 0)) {
					j = this.stackIDs[k];
				}
			}
			if (j != -1) {
				return ItemDef.forID(j).method202(1);
			}
		}
		Model model = Model.method462(this.modelID);
		if (model == null) {
			return null;
		}
		if (this.modifiedModelColors != null) {
			for (int l = 0; l < this.modifiedModelColors.length; l++) {
				model.method476(this.modifiedModelColors[l], this.originalModelColors[l]);
			}
		}
		return model;
	}

	private void readValues(Packet packet) {
		do {
			int i = packet.getUnsignedByte();
			if (i == 0) {
				return;
			}
			if (i == 1) {
				this.modelID = packet.getUnsignedShort();
			} else if (i == 2) {
				this.name = packet.getString();
			} else if (i == 3) {
				this.description = packet.getBytes();
			} else if (i == 4) {
				this.modelZoom = packet.getUnsignedShort();
			} else if (i == 5) {
				this.rotationY = packet.getUnsignedShort();
			} else if (i == 6) {
				this.rotationX = packet.getUnsignedShort();
			} else if (i == 7) {
				this.modelOffset1 = packet.getUnsignedShort();
				if (this.modelOffset1 > 32767) {
					this.modelOffset1 -= 0x10000;
				}
			} else if (i == 8) {
				this.modelOffset2 = packet.getUnsignedShort();
				if (this.modelOffset2 > 32767) {
					this.modelOffset2 -= 0x10000;
				}
			} else if (i == 10) {
				packet.getUnsignedShort();
			} else if (i == 11) {
				this.stackable = true;
			} else if (i == 12) {
				this.value = packet.getInt();
			} else if (i == 16) {
				this.membersObject = true;
			} else if (i == 23) {
				this.maleEquip1 = packet.getUnsignedShort();
				this.maleYOffset = packet.getByte();
			} else if (i == 24) {
				this.maleEquip2 = packet.getUnsignedShort();
			} else if (i == 25) {
				this.femaleEquip1 = packet.getUnsignedShort();
				this.femaleYOffset = packet.getByte();
			} else if (i == 26) {
				this.femaleEquip2 = packet.getUnsignedShort();
			} else if ((i >= 30) && (i < 35)) {
				if (this.groundActions == null) {
					this.groundActions = new String[5];
				}
				this.groundActions[i - 30] = packet.getString();
				if (this.groundActions[i - 30].equalsIgnoreCase("hidden")) {
					this.groundActions[i - 30] = null;
				}
			} else if ((i >= 35) && (i < 40)) {
				if (this.actions == null) {
					this.actions = new String[5];
				}
				this.actions[i - 35] = packet.getString();
			} else if (i == 40) {
				int j = packet.getUnsignedByte();
				this.modifiedModelColors = new int[j];
				this.originalModelColors = new int[j];
				for (int k = 0; k < j; k++) {
					this.modifiedModelColors[k] = packet.getUnsignedShort();
					this.originalModelColors[k] = packet.getUnsignedShort();
				}
			} else if (i == 78) {
				this.maleEmblem = packet.getUnsignedShort();
			} else if (i == 79) {
				this.femaleEmblem = packet.getUnsignedShort();
			} else if (i == 90) {
				this.maleDialogue = packet.getUnsignedShort();
			} else if (i == 91) {
				this.femaleDialogue = packet.getUnsignedShort();
			} else if (i == 92) {
				this.maleDialogueHat = packet.getUnsignedShort();
			} else if (i == 93) {
				this.femaleDialogueHat = packet.getUnsignedShort();
			} else if (i == 95) {
				this.diagionalRotation = packet.getUnsignedShort();
			} else if (i == 97) {
				this.certID = packet.getUnsignedShort();
			} else if (i == 98) {
				this.certTemplateID = packet.getUnsignedShort();
			} else if ((i >= 100) && (i < 110)) {
				if (this.stackIDs == null) {
					this.stackIDs = new int[10];
					this.stackAmounts = new int[10];
				}
				this.stackIDs[i - 100] = packet.getUnsignedShort();
				this.stackAmounts[i - 100] = packet.getUnsignedShort();
			} else if (i == 110) {
				this.modelSizeX = packet.getUnsignedShort();
			} else if (i == 111) {
				this.modelSizeY = packet.getUnsignedShort();
			} else if (i == 112) {
				this.modelSizeZ = packet.getUnsignedShort();
			} else if (i == 113) {
				this.lightModifier = packet.getByte();
			} else if (i == 114) {
				this.shadowModifier = packet.getByte() * 5;
			} else if (i == 115) {
				this.team = packet.getUnsignedByte();
			}
		} while (true);
	}

	private ItemDef() {
		this.id = -1;
	}

	private byte femaleYOffset;
	public int value;
	private int[] modifiedModelColors;
	public int id;
	public static MemoryCache rgbImageCache = new MemoryCache(100);
	public static MemoryCache modelCache = new MemoryCache(50);
	private int[] originalModelColors;
	public boolean membersObject;
	private int femaleEmblem;
	private int certTemplateID;
	private int femaleEquip2;
	private int maleEquip1;
	private int maleDialogueHat;
	private int modelSizeX;
	public String groundActions[];
	private int modelOffset1;
	public String name;
	private static ItemDef[] cache;
	private int femaleDialogueHat;
	private int modelID;
	private int maleDialogue;
	public boolean stackable;
	public byte description[];
	private int certID;
	private static int cacheIndex;
	public int modelZoom;
	public static boolean isMembers = true;
	private static Packet packet;
	private int shadowModifier;
	private int maleEmblem;
	private int maleEquip2;
	public String actions[];
	public int rotationY;
	private int modelSizeZ;
	private int modelSizeY;
	private int[] stackIDs;
	private int modelOffset2;
	private static int[] streamIndices;
	private int lightModifier;
	private int femaleDialogue;
	public int rotationX;
	private int femaleEquip1;
	private int[] stackAmounts;
	public int team;
	public static int totalItems;
	private int diagionalRotation;
	private byte maleYOffset;
}