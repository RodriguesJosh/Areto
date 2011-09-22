package com.netty.world;

import com.netty.game.graphics.DrawingArea;
import com.netty.game.graphics.texture.Rasterizer;
import com.netty.game.model.Model;
import com.netty.game.model.entity.object.GroundDecoration;
import com.netty.game.model.entity.object.GroundItemTile;
import com.netty.game.model.entity.object.InteractableObject;
import com.netty.game.model.entity.object.WallDecoration;
import com.netty.game.model.entity.object.WallObject;
import com.netty.net.cache.Deque;
import com.netty.stuff.Animable;
import com.netty.stuff.CullingCluster;
import com.netty.stuff.PlainTile;
import com.netty.stuff.ShapedTile;
import com.netty.stuff.Tile;
import com.netty.stuff.VertexNormal;

public class SceneGraph {

	public SceneGraph(int[][][] ai) {
		int i = 104;
		int j = 104;
		int k = 4;
		this.aBoolean434 = true;
		this.obj5Cache = new InteractableObject[5000];
		this.anIntArray486 = new int[10000];
		this.anIntArray487 = new int[10000];
		this.anInt437 = k;
		this.anInt438 = j;
		this.anInt439 = i;
		this.groundArray = new Tile[k][j][i];
		this.anIntArrayArrayArray445 = new int[k][j + 1][i + 1];
		this.anIntArrayArrayArray440 = ai;
		this.initToNull();
	}

	public static void nullLoader() {
		SceneGraph.aClass28Array462 = null;
		SceneGraph.anIntArray473 = null;
		SceneGraph.aClass47ArrayArray474 = null;
		SceneGraph.aClass19_477 = null;
		SceneGraph.aBooleanArrayArrayArrayArray491 = null;
		SceneGraph.aBooleanArrayArray492 = null;
	}

	public void initToNull() {
		for (int j = 0; j < this.anInt437; j++) {
			for (int k = 0; k < this.anInt438; k++) {
				for (int i1 = 0; i1 < this.anInt439; i1++) {
					this.groundArray[j][k][i1] = null;
				}
			}
		}
		for (int l = 0; l < SceneGraph.anInt472; l++)  {
			for (int j1 = 0; j1 < SceneGraph.anIntArray473[l]; j1++) {
				SceneGraph.aClass47ArrayArray474[l][j1] = null;
			}
			SceneGraph.anIntArray473[l] = 0;
		}
		for (int k1 = 0; k1 < this.obj5CacheCurrPos; k1++) {
			this.obj5Cache[k1] = null;
		}
		this.obj5CacheCurrPos = 0;
		for (int l1 = 0; l1 < SceneGraph.aClass28Array462.length; l1++) {
			SceneGraph.aClass28Array462[l1] = null;
		}
	}

	public void method275(int i) {
		this.anInt442 = i;
		for (int k = 0; k < this.anInt438; k++) {
			for (int l = 0; l < this.anInt439; l++) {
				if (this.groundArray[i][k][l] == null) {
					this.groundArray[i][k][l] = new Tile(i, k, l);
				}
			}
		}
	}

	public void method276(int i, int j) {
		Tile class30_sub3 = this.groundArray[0][j][i];
		for (int l = 0; l < 3; l++) {
			Tile class30_sub3_1 = this.groundArray[l][j][i] = this.groundArray[l + 1][j][i];
			if (class30_sub3_1 != null) {
				class30_sub3_1.tileZ--;
				for (int j1 = 0; j1 < class30_sub3_1.entityCount; j1++) {
					InteractableObject class28 = class30_sub3_1.interactableObjects[j1];
					if ((((class28.uid >> 29) & 3) == 2) && (class28.tileLeft == j) && (class28.tileTop == i)) {
						class28.zPos--;
					}
				}
			}
		}
		if (this.groundArray[0][j][i] == null) {
			this.groundArray[0][j][i] = new Tile(0, j, i);
		}
		this.groundArray[0][j][i].tileBelowZero = class30_sub3;
		this.groundArray[3][j][i] = null;
	}

	public static void method277(int i, int j, int k, int l, int i1, int j1, int l1, int i2) {
		CullingCluster cullingCluster = new CullingCluster();
		cullingCluster.tileStartX = j / 128;
		cullingCluster.tileEndX = l / 128;
		cullingCluster.tileStartY = l1 / 128;
		cullingCluster.tileEndY = i1 / 128;
		cullingCluster.searchMask = i2;
		cullingCluster.worldStartX = j;
		cullingCluster.worldEndX = l;
		cullingCluster.worldStartY = l1;
		cullingCluster.worldEndY = i1;
		cullingCluster.worldStartZ = j1;
		cullingCluster.tileDistanceEnum = k;
		SceneGraph.aClass47ArrayArray474[i][SceneGraph.anIntArray473[i]++] = cullingCluster;
	}

	public void method278(int i, int j, int k, int l) {
		Tile class30_sub3 = this.groundArray[i][j][k];
		if (class30_sub3 != null) {
			this.groundArray[i][j][k].logicHeight = l;
		}
	}

	public void method279(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2, int i3, int j3, int k3, int l3, int i4, int j4, int k4, int l4) {
		if (l == 0) {
			PlainTile plainTile = new PlainTile(k2, l2, i3, j3, -1, k4, false);
			for (int i5 = i; i5 >= 0; i5--) {
				if (this.groundArray[i5][j][k] == null) {
					this.groundArray[i5][j][k] = new Tile(i5, j, k);
				}
			}
			this.groundArray[i][j][k].myPlainTile = plainTile;
			return;
		}
		if (l == 1) {
			PlainTile class43_1 = new PlainTile(k3, l3, i4, j4, j1, l4, (k1 == l1) && (k1 == i2) && (k1 == j2));
			for (int j5 = i; j5 >= 0; j5--) {
				if (this.groundArray[j5][j][k] == null) {
					this.groundArray[j5][j][k] = new Tile(j5, j, k);
				}
			}
			this.groundArray[i][j][k].myPlainTile = class43_1;
			return;
		}
		ShapedTile shapedTile = new ShapedTile(k, k3, j3, i2, j1, i4, i1, k2, k4, i3, j2, l1, k1, l, j4, l3, l2, j, l4);
		for (int k5 = i; k5 >= 0; k5--) {
			if (this.groundArray[k5][j][k] == null) {
				this.groundArray[k5][j][k] = new Tile(k5, j, k);
			}
		}
		this.groundArray[i][j][k].shapedTile = shapedTile;
	}

	public void method280(int i, int j, int k, Animable class30_sub2_sub4, byte byte0, int i1, int j1) {
		if (class30_sub2_sub4 == null) {
			return;
		}
		GroundDecoration class49 = new GroundDecoration();
		class49.aClass30_Sub2_Sub4_814 = class30_sub2_sub4;
		class49.xPos = (j1 * 128) + 64;
		class49.yPos = (k * 128) + 64;
		class49.zPos = j;
		class49.uid = i1;
		class49.objConf = byte0;
		if (this.groundArray[i][j1][k] == null) {
			this.groundArray[i][j1][k] = new Tile(i, j1, k);
		}
		this.groundArray[i][j1][k].groundDecoration = class49;
	}

	public void method281(int i, int j, Animable class30_sub2_sub4, int k, Animable class30_sub2_sub4_1, Animable class30_sub2_sub4_2, int l, int i1) {
		GroundItemTile groundItemTile = new GroundItemTile();
		groundItemTile.firstGroundItem = class30_sub2_sub4_2;
		groundItemTile.xPos = (i * 128) + 64;
		groundItemTile.yPos = (i1 * 128) + 64;
		groundItemTile.zPos = k;
		groundItemTile.uid = j;
		groundItemTile.secondGroundItem = class30_sub2_sub4;
		groundItemTile.thirdGroundItem = class30_sub2_sub4_1;
		int j1 = 0;
		Tile class30_sub3 = this.groundArray[l][i][i1];
		if (class30_sub3 != null) {
			for (int k1 = 0; k1 < class30_sub3.entityCount; k1++) {
				if (class30_sub3.interactableObjects[k1].jagexNode instanceof Model) {
					int l1 = ((Model)class30_sub3.interactableObjects[k1].jagexNode).anInt1654;
					if (l1 > j1) {
						j1 = l1;
					}
				}
			}
		}
		groundItemTile.anInt52 = j1;
		if (this.groundArray[l][i][i1] == null) {
			this.groundArray[l][i][i1] = new Tile(l, i, i1);
		}
		this.groundArray[l][i][i1].groundItemTile = groundItemTile;
	}

	public void method282(int i, Animable class30_sub2_sub4, int j, int k, byte byte0, int l, Animable class30_sub2_sub4_1, int i1, int j1, int k1) {
		if ((class30_sub2_sub4 == null) && (class30_sub2_sub4_1 == null)) {
			return;
		}
		WallObject wallObject = new WallObject();
		wallObject.uid = j;
		wallObject.aByte281 = byte0;
		wallObject.xPos = (l * 128) + 64;
		wallObject.yPos = (k * 128) + 64;
		wallObject.zPos = i1;
		wallObject.entity1 = class30_sub2_sub4;
		wallObject.entity2 = class30_sub2_sub4_1;
		wallObject.orientation = i;
		wallObject.orientation1 = j1;
		for (int l1 = k1; l1 >= 0; l1--) {
			if (this.groundArray[l1][l][k] == null) {
				this.groundArray[l1][l][k] = new Tile(l1, l, k);
			}
		}
		this.groundArray[k1][l][k].wallObject = wallObject;
	}

	public void method283(int i, int j, int k, int i1, int j1, int k1, Animable class30_sub2_sub4, int l1, byte byte0, int i2, int j2) {
		if (class30_sub2_sub4 == null) {
			return;
		}
		WallDecoration class26 = new WallDecoration();
		class26.uid = i;
		class26.objConf = byte0;
		class26.xPos = (l1 * 128) + 64 + j1;
		class26.yPos = (j * 128) + 64 + i2;
		class26.zPos = k1;
		class26.entity = class30_sub2_sub4;
		class26.configBits = j2;
		class26.face = k;
		for (int k2 = i1; k2 >= 0; k2--) {
			if (this.groundArray[k2][l1][j] == null) {
				this.groundArray[k2][l1][j] = new Tile(k2, l1, j);
			}
		}
		this.groundArray[i1][l1][j].wallDecoration = class26;
	}

	public boolean method284(int i, byte byte0, int j, int k, Animable class30_sub2_sub4, int l, int i1, int j1, int k1, int l1) {
		if (class30_sub2_sub4 == null) {
			return true;
		}
		int i2 = (l1 * 128) + (64 * l);
		int j2 = (k1 * 128) + (64 * k);
		return this.method287(i1, l1, k1, l, k, i2, j2, j, class30_sub2_sub4, j1, false, i, byte0);
	}

	public boolean method285(int i, int j, int k, int l, int i1, int j1, int k1, Animable class30_sub2_sub4, boolean flag) {
		if (class30_sub2_sub4 == null) {
			return true;
		}
		int l1 = k1 - j1;
		int i2 = i1 - j1;
		int j2 = k1 + j1;
		int k2 = i1 + j1;
		if (flag) {
			if ((j > 640) && (j < 1408)) {
				k2 += 128;
			}
			if ((j > 1152) && (j < 1920)) {
				j2 += 128;
			}
			if ((j > 1664) || (j < 384)) {
				i2 -= 128;
			}
			if ((j > 128) && (j < 896)) {
				l1 -= 128;
			}
		}
		l1 /= 128;
		i2 /= 128;
		j2 /= 128;
		k2 /= 128;
		return this.method287(i, l1, i2, (j2 - l1) + 1, (k2 - i2) + 1, k1, i1, k, class30_sub2_sub4, j, true, l, (byte)0);
	}

	public boolean method286(int j, int k, Animable class30_sub2_sub4, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2) {
		return (class30_sub2_sub4 == null) || this.method287(j, l1, k2, (i2 - l1) + 1, (i1 - k2) + 1, j1, k, k1, class30_sub2_sub4, l, true, j2, (byte) 0);
	}

	private boolean method287(int i, int j, int k, int l, int i1, int j1, int k1, int l1, Animable class30_sub2_sub4, int i2, boolean flag, int j2, byte byte0) {
		for (int k2 = j; k2 < (j + l); k2++) {
			for (int l2 = k; l2 < (k + i1); l2++) {
				if ((k2 < 0) || (l2 < 0) || (k2 >= this.anInt438) || (l2 >= this.anInt439)) {
					return false;
				}
				Tile class30_sub3 = this.groundArray[i][k2][l2];
				if ((class30_sub3 != null) && (class30_sub3.entityCount >= 5)) {
					return false;
				}
			}
		}
		InteractableObject class28 = new InteractableObject();
		class28.uid = j2;
		class28.aByte530 = byte0;
		class28.zPos = i;
		class28.worldX = j1;
		class28.worldY = k1;
		class28.worldZ = l1;
		class28.jagexNode = class30_sub2_sub4;
		class28.rotation = i2;
		class28.tileLeft = j;
		class28.tileTop = k;
		class28.tileRight = (j + l) - 1;
		class28.tileBottom = (k + i1) - 1;
		for (int i3 = j; i3 < (j + l); i3++) {
			for (int j3 = k; j3 < (k + i1); j3++) {
				int k3 = 0;
				if (i3 > j) {
					k3++;
				}
				if (i3 < ((j + l) - 1)) {
					k3 += 4;
				}
				if (j3 > k) {
					k3 += 8;
				}
				if (j3 < ((k + i1) - 1)) {
					k3 += 2;
				}
				for (int l3 = i; l3 >= 0; l3--) {
					if (this.groundArray[l3][i3][j3] == null) {
						this.groundArray[l3][i3][j3] = new Tile(l3, i3, j3);
					}
				}
				Tile tile = this.groundArray[i][i3][j3];
				tile.interactableObjects[tile.entityCount] = class28;
				tile.anIntArray1319[tile.entityCount] = k3;
				tile.anInt1320 |= k3;
				tile.entityCount++;
			}
		}
		if (flag) {
			this.obj5Cache[this.obj5CacheCurrPos++] = class28;
		}
		return true;
	}

	public void clearObj5Cache() {
		for (int i = 0; i < this.obj5CacheCurrPos; i++) {
			InteractableObject interactableObject = this.obj5Cache[i];
			this.method289(interactableObject);
			this.obj5Cache[i] = null;
		}
		this.obj5CacheCurrPos = 0;
	}

	private void method289(InteractableObject class28) {
		for (int j = class28.tileLeft; j <= class28.tileRight; j++) {
			for (int k = class28.tileTop; k <= class28.tileBottom; k++) {
				Tile tile = this.groundArray[class28.zPos][j][k];
				if (tile != null) {
					for (int l = 0; l < tile.entityCount; l++) {
						if (tile.interactableObjects[l] != class28) {
							continue;
						}
						tile.entityCount--;
						for (int i1 = l; i1 < tile.entityCount; i1++) {
							tile.interactableObjects[i1] = tile.interactableObjects[i1 + 1];
							tile.anIntArray1319[i1] = tile.anIntArray1319[i1 + 1];
						}
						tile.interactableObjects[tile.entityCount] = null;
						break;
					}
					tile.anInt1320 = 0;
					for (int j1 = 0; j1 < tile.entityCount; j1++) {
						tile.anInt1320 |= tile.anIntArray1319[j1];
					}
				}
			}
		}
	}

	public void method290(int i, int k, int l, int i1) {
		Tile tile = this.groundArray[i1][l][i];
		if (tile == null) {
			return;
		}
		WallDecoration class26 = tile.wallDecoration;
		if (class26 != null) {
			int j1 = (l * 128) + 64;
			int k1 = (i * 128) + 64;
			class26.xPos = j1 + (((class26.xPos - j1) * k) / 16);
			class26.yPos = k1 + (((class26.yPos - k1) * k) / 16);
		}
	}

	public void method291(int i, int j, int k, byte byte0) {
		Tile tile = this.groundArray[j][i][k];
		if (byte0 != -119) {
			this.aBoolean434 = !this.aBoolean434;
		}
		if (tile != null) {
			tile.wallObject = null;
		}
	}

	public void method292(int j, int k, int l) {
		Tile tile = this.groundArray[k][l][j];
		if (tile != null) {
			tile.wallDecoration = null;
		}
	}

	public void method293(int i, int k, int l) {
		Tile tile = this.groundArray[i][k][l];
		if (tile == null) {
			return;
		}
		for (int j1 = 0; j1 < tile.entityCount; j1++) {
			InteractableObject class28 = tile.interactableObjects[j1];
			if ((((class28.uid >> 29) & 3) == 2) && (class28.tileLeft == k) && (class28.tileTop == l)) {
				this.method289(class28);
				return;
			}
		}
	}

	public void method294(int i, int j, int k) {
		Tile tile = this.groundArray[i][k][j];
		if (tile == null) {
			return;
		}
		tile.groundDecoration = null;
	}

	public void method295(int i, int j, int k) {
		Tile tile = this.groundArray[i][j][k];
		if (tile != null) {
			tile.groundItemTile = null;
		}
	}

	public WallObject method296(int i, int j, int k) {
		Tile tile = this.groundArray[i][j][k];
		if (tile == null) {
			return null;
		}
		return tile.wallObject;
	}

	public WallDecoration method297(int i, int k, int l) {
		Tile tile = this.groundArray[l][i][k];
		if (tile == null) {
			return null;
		}
		return tile.wallDecoration;
	}

	public InteractableObject method298(int i, int j, int k) {
		Tile tile = this.groundArray[k][i][j];
		if (tile == null) {
			return null;
		}
		for (int l = 0; l < tile.entityCount; l++) {
			InteractableObject class28 = tile.interactableObjects[l];
			if ((((class28.uid >> 29) & 3) == 2) && (class28.tileLeft == i) && (class28.tileTop == j)) {
				return class28;
			}
		}
		return null;
	}

	public GroundDecoration method299(int i, int j, int k) {
		Tile class30_sub3 = this.groundArray[k][j][i];
		if ((class30_sub3 == null) || (class30_sub3.groundDecoration == null)) {
			return null;
		}
		return class30_sub3.groundDecoration;
	}

	public int method300(int i, int j, int k) {
		Tile class30_sub3 = this.groundArray[i][j][k];
		if ((class30_sub3 == null) || (class30_sub3.wallObject == null)) {
			return 0;
		}
		return class30_sub3.wallObject.uid;

	}

	public int method301(int i, int j, int l) {
		Tile class30_sub3 = this.groundArray[i][j][l];
		if ((class30_sub3 == null) || (class30_sub3.wallDecoration == null)) {
			return 0;
		}
		return class30_sub3.wallDecoration.uid;
	}

	public int method302(int i, int j, int k) {
		Tile class30_sub3 = this.groundArray[i][j][k];
		if (class30_sub3 == null) {
			return 0;
		}
		for (int l = 0; l < class30_sub3.entityCount; l++) {
			InteractableObject class28 = class30_sub3.interactableObjects[l];
			if ((((class28.uid >> 29) & 3) == 2) && (class28.tileLeft == j) && (class28.tileTop == k)) {
				return class28.uid;
			}
		}

		return 0;
	}

	public int method303(int i, int j, int k) {
		Tile class30_sub3 = this.groundArray[i][j][k];
		if ((class30_sub3 == null) || (class30_sub3.groundDecoration == null)) {
			return 0;
		}
		return class30_sub3.groundDecoration.uid;
	}

	public int method304(int i, int j, int k, int l) {
		Tile tile = this.groundArray[i][j][k];
		if (tile == null) {
			return -1;
		}
		if ((tile.wallObject != null) && (tile.wallObject.uid == l)) {
			return tile.wallObject.aByte281 & 0xff;
		}
		if ((tile.wallDecoration != null) && (tile.wallDecoration.uid == l)) {
			return tile.wallDecoration.objConf & 0xff;
		}
		if ((tile.groundDecoration != null) && (tile.groundDecoration.uid == l)) {
			return tile.groundDecoration.objConf & 0xff;
		}
		for (int i1 = 0; i1 < tile.entityCount; i1++) {
			if (tile.interactableObjects[i1].uid == l) {
				return tile.interactableObjects[i1].aByte530 & 0xff;
			}
		}
		return -1;
	}

	public void method305(int i, int k, int i1) {
		int j = 64;
		int l = 768;
		int j1 = (int)Math.sqrt((k * k) + (i * i) + (i1 * i1));
		int k1 = (l * j1) >> 8;
		for (int l1 = 0; l1 < this.anInt437; l1++) {
			for (int i2 = 0; i2 < this.anInt438; i2++) {
				for (int j2 = 0; j2 < this.anInt439; j2++) {
					Tile class30_sub3 = this.groundArray[l1][i2][j2];
					if (class30_sub3 != null) {
						WallObject class10 = class30_sub3.wallObject;
						if ((class10 != null) && (class10.entity1 != null) && (class10.entity1.vertexNormals != null)) {
							this.method307(l1, 1, 1, i2, j2, (Model)class10.entity1);
							if ((class10.entity2 != null) && (class10.entity2.vertexNormals != null)) {
								this.method307(l1, 1, 1, i2, j2, (Model)class10.entity2);
								this.method308((Model)class10.entity1, (Model)class10.entity2, 0, 0, 0, false);
								((Model) class10.entity2).method480(j, k1, k, i, i1);
							}
							((Model) class10.entity1).method480(j, k1, k, i, i1);
						}
						for (int k2 = 0; k2 < class30_sub3.entityCount; k2++) {
							InteractableObject class28 = class30_sub3.interactableObjects[k2];
							if ((class28 != null) && (class28.jagexNode != null) && (class28.jagexNode.vertexNormals != null)) {
								this.method307(l1, (class28.tileRight - class28.tileLeft) + 1, (class28.tileBottom - class28.tileTop) + 1, i2, j2, (Model)class28.jagexNode);
								((Model) class28.jagexNode).method480(j, k1, k, i, i1);
							}
						}
						GroundDecoration class49 = class30_sub3.groundDecoration;
						if ((class49 != null) && (class49.aClass30_Sub2_Sub4_814.vertexNormals != null)) {
							this.method306(i2, l1, (Model)class49.aClass30_Sub2_Sub4_814, j2);
							((Model) class49.aClass30_Sub2_Sub4_814).method480(j, k1, k, i, i1);
						}
					}
				}
			}
		}
	}

	private void method306(int i, int j, Model model, int k) {
		if (i < this.anInt438) {
			Tile class30_sub3 = this.groundArray[j][i + 1][k];
			if ((class30_sub3 != null) && (class30_sub3.groundDecoration != null) && (class30_sub3.groundDecoration.aClass30_Sub2_Sub4_814.vertexNormals != null)) {
				this.method308(model, (Model) class30_sub3.groundDecoration.aClass30_Sub2_Sub4_814, 128, 0, 0, true);
			}
		}
		if (k < this.anInt438) {
			Tile class30_sub3_1 = this.groundArray[j][i][k + 1];
			if ((class30_sub3_1 != null) && (class30_sub3_1.groundDecoration != null) && (class30_sub3_1.groundDecoration.aClass30_Sub2_Sub4_814.vertexNormals != null)) {
				this.method308(model, (Model) class30_sub3_1.groundDecoration.aClass30_Sub2_Sub4_814, 0, 0, 128, true);
			}
		}
		if ((i < this.anInt438) && (k < this.anInt439)) {
			Tile class30_sub3_2 = this.groundArray[j][i + 1][k + 1];
			if ((class30_sub3_2 != null) && (class30_sub3_2.groundDecoration != null) && (class30_sub3_2.groundDecoration.aClass30_Sub2_Sub4_814.vertexNormals != null)) {
				this.method308(model, (Model) class30_sub3_2.groundDecoration.aClass30_Sub2_Sub4_814, 128, 0, 128, true);
			}
		}
		if ((i < this.anInt438) && (k > 0)) {
			Tile class30_sub3_3 = this.groundArray[j][i + 1][k - 1];
			if ((class30_sub3_3 != null) && (class30_sub3_3.groundDecoration != null) && (class30_sub3_3.groundDecoration.aClass30_Sub2_Sub4_814.vertexNormals != null)) {
				this.method308(model, (Model)class30_sub3_3.groundDecoration.aClass30_Sub2_Sub4_814, 128, 0, -128, true);
			}
		}
	}

	private void method307(int i, int j, int k, int l, int i1, Model model) {
		boolean flag = true;
		int j1 = l;
		int k1 = l + j;
		int l1 = i1 - 1;
		int i2 = i1 + k;
		for (int j2 = i; j2 <= (i + 1); j2++) {
			if (j2 != this.anInt437) {
				for (int k2 = j1; k2 <= k1; k2++) {
					if ((k2 >= 0) && (k2 < this.anInt438)) {
						for (int l2 = l1; l2 <= i2; l2++) {
							if ((l2 >= 0) && (l2 < this.anInt439) && (!flag || (k2 >= k1) || (l2 >= i2) || ((l2 < i1) && (k2 != l)))) {
								Tile class30_sub3 = this.groundArray[j2][k2][l2];
								if (class30_sub3 != null) {
									int i3 = ((this.anIntArrayArrayArray440[j2][k2][l2] + this.anIntArrayArrayArray440[j2][k2 + 1][l2] + this.anIntArrayArrayArray440[j2][k2][l2 + 1] + this.anIntArrayArrayArray440[j2][k2 + 1][l2 + 1]) / 4) - ((this.anIntArrayArrayArray440[i][l][i1] + this.anIntArrayArrayArray440[i][l + 1][i1] + this.anIntArrayArrayArray440[i][l][i1 + 1] + this.anIntArrayArrayArray440[i][l + 1][i1 + 1]) / 4);
									WallObject class10 = class30_sub3.wallObject;
									if ((class10 != null) && (class10.entity1 != null) && (class10.entity1.vertexNormals != null)) {
										this.method308(model, (Model)class10.entity1, ((k2 - l) * 128) + ((1 - j) * 64), i3, ((l2 - i1) * 128) + ((1 - k) * 64), flag);
									}
									if ((class10 != null) && (class10.entity2 != null) && (class10.entity2.vertexNormals != null)) {
										this.method308(model, (Model)class10.entity2, ((k2 - l) * 128) + ((1 - j) * 64), i3, ((l2 - i1) * 128) + ((1 - k) * 64), flag);
									}
									for (int j3 = 0; j3 < class30_sub3.entityCount; j3++) {
										InteractableObject class28 = class30_sub3.interactableObjects[j3];
										if ((class28 != null) && (class28.jagexNode != null) && (class28.jagexNode.vertexNormals != null)) {
											int k3 = (class28.tileRight - class28.tileLeft) + 1;
											int l3 = (class28.tileBottom - class28.tileTop) + 1;
											this.method308(model, (Model)class28.jagexNode, ((class28.tileLeft - l) * 128) + ((k3 - j) * 64), i3, ((class28.tileTop - i1) * 128) + ((l3 - k) * 64), flag);
										}
									}
								}
							}
						}
					}
				}
				j1--;
				flag = false;
			}
		}
	}

	private void method308(Model model, Model model_1, int i, int j, int k, boolean flag) {
		this.anInt488++;
		int l = 0;
		int ai[] = model_1.vertexX;
		int i1 = model_1.vertexCount;
		for (int j1 = 0; j1 < model.vertexCount; j1++) {
			VertexNormal vertexNormal = model.vertexNormals[j1];
			VertexNormal class33_1 = model.vertexNormalOffset[j1];
			if (class33_1.magnitude != 0) {
				int i2 = model.vertexY[j1] - j;
				if (i2 <= model_1.maxY) {
					int j2 = model.vertexX[j1] - i;
					if ((j2 >= model_1.minX) && (j2 <= model_1.maxX)) {
						int k2 = model.vertexZ[j1] - k;
						if ((k2 >= model_1.minZ) && (k2 <= model_1.maxZ)) {
							for (int l2 = 0; l2 < i1; l2++) {
								VertexNormal class33_2 = model_1.vertexNormals[l2];
								VertexNormal class33_3 = model_1.vertexNormalOffset[l2];
								if ((j2 == ai[l2]) && (k2 == model_1.vertexZ[l2]) && (i2 == model_1.vertexY[l2]) && (class33_3.magnitude != 0)) {
									vertexNormal.x += class33_3.x;
									vertexNormal.y += class33_3.y;
									vertexNormal.z += class33_3.z;
									vertexNormal.magnitude += class33_3.magnitude;
									class33_2.x += class33_1.x;
									class33_2.y += class33_1.y;
									class33_2.z += class33_1.z;
									class33_2.magnitude += class33_1.magnitude;
									l++;
									this.anIntArray486[j1] = this.anInt488;
									this.anIntArray487[l2] = this.anInt488;
								}
							}
						}
					}
				}
			}
		}
		if ((l < 3) || !flag) {
			return;
		}
		for (int k1 = 0; k1 < model.triangleCount; k1++) {
			if ((this.anIntArray486[model.triangleA[k1]] == this.anInt488) && (this.anIntArray486[model.triangleB[k1]] == this.anInt488) && (this.anIntArray486[model.triangleC[k1]] == this.anInt488)) {
				model.triangleDrawType[k1] = -1;
			}
		}
		for (int l1 = 0; l1 < model_1.triangleCount; l1++) {
			if ((this.anIntArray487[model_1.triangleA[l1]] == this.anInt488) && (this.anIntArray487[model_1.triangleB[l1]] == this.anInt488) && (this.anIntArray487[model_1.triangleC[l1]] == this.anInt488)) {
				model_1.triangleDrawType[l1] = -1;
			}
		}
	}

	public void method309(int ai[], int i, int k, int l, int i1) {
		int j = 512;
		Tile class30_sub3 = this.groundArray[k][l][i1];
		if (class30_sub3 == null) {
			return;
		}
		PlainTile plainTile = class30_sub3.myPlainTile;
		if (plainTile != null) {
			int j1 = plainTile.colourRGB;
			if (j1 == 0) {
				return;
			}
			for (int k1 = 0; k1 < 4; k1++) {
				ai[i] = j1;
				ai[i + 1] = j1;
				ai[i + 2] = j1;
				ai[i + 3] = j1;
				i += j;
			}
			return;
		}
		ShapedTile shapedTile = class30_sub3.shapedTile;
		if (shapedTile == null) {
			return;
		}
		int l1 = shapedTile.shape;
		int i2 = shapedTile.rotation;
		int j2 = shapedTile.colourRGB;
		int k2 = shapedTile.colourRGBA;
		int ai1[] = this.anIntArrayArray489[l1];
		int ai2[] = this.anIntArrayArray490[i2];
		int l2 = 0;
		if (j2 != 0) {
			for (int i3 = 0; i3 < 4; i3++) {
				ai[i] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 1] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 2] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 3] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				i += j;
			}
			return;
		}
		for (int j3 = 0; j3 < 4; j3++) {
			if (ai1[ai2[l2++]] != 0) {
				ai[i] = k2;
			}
			if (ai1[ai2[l2++]] != 0) {
				ai[i + 1] = k2;
			}
			if (ai1[ai2[l2++]] != 0) {
				ai[i + 2] = k2;
			}
			if (ai1[ai2[l2++]] != 0) {
				ai[i + 3] = k2;
			}
			i += j;
		}
	}

	public static void method310(int i, int j, int k, int l, int ai[]) {
		SceneGraph.anInt495 = 0;
		SceneGraph.anInt496 = 0;
		SceneGraph.anInt497 = k;
		SceneGraph.anInt498 = l;
		SceneGraph.anInt493 = k / 2;
		SceneGraph.anInt494 = l / 2;
		boolean aflag[][][][] = new boolean[9][32][53][53];
		for (int i1 = 128; i1 <= 384; i1 += 32) {
			for (int j1 = 0; j1 < 2048; j1 += 64) {
				SceneGraph.anInt458 = Model.sine[i1];
				SceneGraph.anInt459 = Model.cosine[i1];
				SceneGraph.anInt460 = Model.sine[j1];
				SceneGraph.anInt461 = Model.cosine[j1];
				int l1 = (i1 - 128) / 32;
				int j2 = j1 / 64;
				for (int l2 = -26; l2 <= 26; l2++) {
					for (int j3 = -26; j3 <= 26; j3++) {
						int k3 = l2 * 128;
						int i4 = j3 * 128;
						boolean flag2 = false;
						for (int k4 = -i; k4 <= j; k4 += 128) {
							if (!SceneGraph.method311(ai[l1] + k4, i4, k3)) {
								continue;
							}
							flag2 = true;
							break;
						}
						aflag[l1][j2][l2 + 25 + 1][j3 + 25 + 1] = flag2;
					}
				}
			}
		}
		for (int k1 = 0; k1 < 8; k1++) {
			for (int i2 = 0; i2 < 32; i2++) {
				for (int k2 = -25; k2 < 25; k2++) {
					for (int i3 = -25; i3 < 25; i3++) {
						boolean flag1 = false;
						label0:
							for (int l3 = -1; l3 <= 1; l3++) {
								for (int j4 = -1; j4 <= 1; j4++) {
									if (aflag[k1][i2][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1]) {
										flag1 = true;
									} else
										if (aflag[k1][(i2 + 1) % 31][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1]) {
											flag1 = true;
										} else if (aflag[k1 + 1][i2][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1]) {
											flag1 = true;
										} else {
											if (!aflag[k1 + 1][(i2 + 1) % 31][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1]) {
												continue;
											}
											flag1 = true;
										}
									break label0;
								}
							}
						SceneGraph.aBooleanArrayArrayArrayArray491[k1][i2][k2 + 25][i3 + 25] = flag1;
					}
				}
			}
		}
	}

	private static boolean method311(int i, int j, int k) {
		int l = ((j * SceneGraph.anInt460) + (k * SceneGraph.anInt461)) >> 16;
								int i1 = ((j * SceneGraph.anInt461) - (k * SceneGraph.anInt460)) >> 16;
					int j1 = ((i * SceneGraph.anInt458) + (i1 * SceneGraph.anInt459)) >> 16;
			int k1 = ((i * SceneGraph.anInt459) - (i1 * SceneGraph.anInt458)) >> 16;
						if ((j1 < 50) || (j1 > 3500)) {
							return false;
						}
						int l1 = SceneGraph.anInt493 + ((l << 9) / j1);
						int i2 = SceneGraph.anInt494 + ((k1 << 9) / j1);
						return (l1 >= SceneGraph.anInt495) && (l1 <= SceneGraph.anInt497) && (i2 >= SceneGraph.anInt496) && (i2 <= SceneGraph.anInt498);
	}

	public void method312(int i, int j) {
		SceneGraph.aBoolean467 = true;
		SceneGraph.anInt468 = j;
		SceneGraph.anInt469 = i;
		SceneGraph.anInt470 = -1;
		SceneGraph.anInt471 = -1;
	}

	public void method313(int i, int j, int k, int l, int i1, int j1) {
		if (i < 0) {
			i = 0;
		} else if (i >= (this.anInt438 * 128)) {
			i = (this.anInt438 * 128) - 1;
		}
		if (j < 0) {
			j = 0;
		} else if (j >= (this.anInt439 * 128)) {
			j = (this.anInt439 * 128) - 1;
		}
		SceneGraph.anInt448++;
		SceneGraph.anInt458 = Model.sine[j1];
		SceneGraph.anInt459 = Model.cosine[j1];
		SceneGraph.anInt460 = Model.sine[k];
		SceneGraph.anInt461 = Model.cosine[k];
		SceneGraph.aBooleanArrayArray492 = SceneGraph.aBooleanArrayArrayArrayArray491[(j1 - 128) / 32][k / 64];
		SceneGraph.anInt455 = i;
		SceneGraph.anInt456 = l;
		SceneGraph.anInt457 = j;
		SceneGraph.anInt453 = i / 128;
		SceneGraph.anInt454 = j / 128;
		SceneGraph.anInt447 = i1;
		SceneGraph.anInt449 = SceneGraph.anInt453 - 25;
		if (SceneGraph.anInt449 < 0) {
			SceneGraph.anInt449 = 0;
		}
		SceneGraph.anInt451 = SceneGraph.anInt454 - 25;
		if (SceneGraph.anInt451 < 0) {
			SceneGraph.anInt451 = 0;
		}
		SceneGraph.anInt450 = SceneGraph.anInt453 + 25;
		if (SceneGraph.anInt450 > this.anInt438) {
			SceneGraph.anInt450 = this.anInt438;
		}
		SceneGraph.anInt452 = SceneGraph.anInt454 + 25;
		if (SceneGraph.anInt452 > this.anInt439) {
			SceneGraph.anInt452 = this.anInt439;
		}
		this.method319();
		SceneGraph.anInt446 = 0;
		for (int k1 = this.anInt442; k1 < this.anInt437; k1++) {
			Tile aclass30_sub3[][] = this.groundArray[k1];
			for (int i2 = SceneGraph.anInt449; i2 < SceneGraph.anInt450; i2++) {
				for (int k2 = SceneGraph.anInt451; k2 < SceneGraph.anInt452; k2++) {
					Tile class30_sub3 = aclass30_sub3[i2][k2];
					if (class30_sub3 != null) {
						if ((class30_sub3.logicHeight > i1) || (!SceneGraph.aBooleanArrayArray492[(i2 - SceneGraph.anInt453) + 25][(k2 - SceneGraph.anInt454) + 25] && ((this.anIntArrayArrayArray440[k1][i2][k2] - l) < 2000))) {
							class30_sub3.aBoolean1322 = false;
							class30_sub3.aBoolean1323 = false;
							class30_sub3.anInt1325 = 0;
						} else {
							class30_sub3.aBoolean1322 = true;
							class30_sub3.aBoolean1323 = true;
							class30_sub3.aBoolean1324 = class30_sub3.entityCount > 0;
							SceneGraph.anInt446++;
						}
					}
				}
			}
		}
		for (int l1 = this.anInt442; l1 < this.anInt437; l1++) {
			Tile aclass30_sub3_1[][] = this.groundArray[l1];
			for (int l2 = -25; l2 <= 0; l2++) {
				int i3 = SceneGraph.anInt453 + l2;
				int k3 = SceneGraph.anInt453 - l2;
				if ((i3 >= SceneGraph.anInt449) || (k3 < SceneGraph.anInt450)) {
					for (int i4 = -25; i4 <= 0; i4++) {
						int k4 = SceneGraph.anInt454 + i4;
						int i5 = SceneGraph.anInt454 - i4;
						if (i3 >= SceneGraph.anInt449) {
							if (k4 >= SceneGraph.anInt451) {
								Tile class30_sub3_1 = aclass30_sub3_1[i3][k4];
								if ((class30_sub3_1 != null) && class30_sub3_1.aBoolean1322) {
									this.method314(class30_sub3_1, true);
								}
							}
							if (i5 < SceneGraph.anInt452) {
								Tile class30_sub3_2 = aclass30_sub3_1[i3][i5];
								if ((class30_sub3_2 != null) && class30_sub3_2.aBoolean1322) {
									this.method314(class30_sub3_2, true);
								}
							}
						}
						if (k3 < SceneGraph.anInt450) {
							if (k4 >= SceneGraph.anInt451) {
								Tile class30_sub3_3 = aclass30_sub3_1[k3][k4];
								if ((class30_sub3_3 != null) && class30_sub3_3.aBoolean1322) {
									this.method314(class30_sub3_3, true);
								}
							}
							if (i5 < SceneGraph.anInt452) {
								Tile class30_sub3_4 = aclass30_sub3_1[k3][i5];
								if ((class30_sub3_4 != null) && class30_sub3_4.aBoolean1322) {
									this.method314(class30_sub3_4, true);
								}
							}
						}
						if (SceneGraph.anInt446 == 0) {
							SceneGraph.aBoolean467 = false;
							return;
						}
					}
				}
			}
		}
		for (int j2 = this.anInt442; j2 < this.anInt437; j2++) {
			Tile aclass30_sub3_2[][] = this.groundArray[j2];
			for (int j3 = -25; j3 <= 0; j3++) {
				int l3 = SceneGraph.anInt453 + j3;
				int j4 = SceneGraph.anInt453 - j3;
				if ((l3 >= SceneGraph.anInt449) || (j4 < SceneGraph.anInt450))
				{
					for (int l4 = -25; l4 <= 0; l4++) {
						int j5 = SceneGraph.anInt454 + l4;
						int k5 = SceneGraph.anInt454 - l4;
						if (l3 >= SceneGraph.anInt449) {
							if (j5 >= SceneGraph.anInt451) {
								Tile class30_sub3_5 = aclass30_sub3_2[l3][j5];
								if ((class30_sub3_5 != null) && class30_sub3_5.aBoolean1322) {
									this.method314(class30_sub3_5, false);
								}
							}
							if (k5 < SceneGraph.anInt452) {
								Tile class30_sub3_6 = aclass30_sub3_2[l3][k5];
								if ((class30_sub3_6 != null) && class30_sub3_6.aBoolean1322) {
									this.method314(class30_sub3_6, false);
								}
							}
						}
						if (j4 < SceneGraph.anInt450) {
							if (j5 >= SceneGraph.anInt451) {
								Tile class30_sub3_7 = aclass30_sub3_2[j4][j5];
								if ((class30_sub3_7 != null) && class30_sub3_7.aBoolean1322) {
									this.method314(class30_sub3_7, false);
								}
							}
							if (k5 < SceneGraph.anInt452) {
								Tile class30_sub3_8 = aclass30_sub3_2[j4][k5];
								if ((class30_sub3_8 != null) && class30_sub3_8.aBoolean1322) {
									this.method314(class30_sub3_8, false);
								}
							}
						}
						if (SceneGraph.anInt446 == 0) {
							SceneGraph.aBoolean467 = false;
							return;
						}
					}
				}
			}
		}
		SceneGraph.aBoolean467 = false;
	}

	private void method314(Tile class30_sub3, boolean flag) {
		SceneGraph.aClass19_477.insertHead(class30_sub3);
		do {
			Tile class30_sub3_1;
			do {
				class30_sub3_1 = (Tile)SceneGraph.aClass19_477.popHead();
				if (class30_sub3_1 == null) {
					return;
				}
			} while (!class30_sub3_1.aBoolean1323);
			int i = class30_sub3_1.anInt1308;
			int j = class30_sub3_1.anInt1309;
			int k = class30_sub3_1.tileZ;
			int l = class30_sub3_1.anInt1310;
			Tile aclass30_sub3[][] = this.groundArray[k];
			if (class30_sub3_1.aBoolean1322) {
				if (flag) {
					if (k > 0) {
						Tile class30_sub3_2 = this.groundArray[k - 1][i][j];
						if ((class30_sub3_2 != null) && class30_sub3_2.aBoolean1323) {
							continue;
						}
					}
					if ((i <= SceneGraph.anInt453) && (i > SceneGraph.anInt449)) {
						Tile class30_sub3_3 = aclass30_sub3[i - 1][j];
						if ((class30_sub3_3 != null) && class30_sub3_3.aBoolean1323 && (class30_sub3_3.aBoolean1322 || ((class30_sub3_1.anInt1320 & 1) == 0))) {
							continue;
						}
					}
					if ((i >= SceneGraph.anInt453) && (i < (SceneGraph.anInt450 - 1)))
					{
						Tile class30_sub3_4 = aclass30_sub3[i + 1][j];
						if ((class30_sub3_4 != null) && class30_sub3_4.aBoolean1323 && (class30_sub3_4.aBoolean1322 || ((class30_sub3_1.anInt1320 & 4) == 0))) {
							continue;
						}
					}
					if ((j <= SceneGraph.anInt454) && (j > SceneGraph.anInt451)) {
						Tile class30_sub3_5 = aclass30_sub3[i][j - 1];
						if ((class30_sub3_5 != null) && class30_sub3_5.aBoolean1323 && (class30_sub3_5.aBoolean1322 || ((class30_sub3_1.anInt1320 & 8) == 0))) {
							continue;
						}
					}
					if ((j >= SceneGraph.anInt454) && (j < (SceneGraph.anInt452 - 1))) {
						Tile class30_sub3_6 = aclass30_sub3[i][j + 1];
						if ((class30_sub3_6 != null) && class30_sub3_6.aBoolean1323 && (class30_sub3_6.aBoolean1322 || ((class30_sub3_1.anInt1320 & 2) == 0))) {
							continue;
						}
					}
				} else {
					flag = true;
				}
				class30_sub3_1.aBoolean1322 = false;
				if (class30_sub3_1.tileBelowZero != null) {
					Tile class30_sub3_7 = class30_sub3_1.tileBelowZero;
					if (class30_sub3_7.myPlainTile != null) {
						if (!this.method320(0, i, j)) {
							this.method315(class30_sub3_7.myPlainTile, 0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, i, j);
						}
					} else if ((class30_sub3_7.shapedTile != null) && !this.method320(0, i, j)) {
						this.method316(i, SceneGraph.anInt458, SceneGraph.anInt460, class30_sub3_7.shapedTile, SceneGraph.anInt459, j, SceneGraph.anInt461);
					}
					WallObject class10 = class30_sub3_7.wallObject;
					if (class10 != null) {
						class10.entity1.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class10.xPos - SceneGraph.anInt455, class10.zPos - SceneGraph.anInt456, class10.yPos - SceneGraph.anInt457, class10.uid);
					}
					for (int i2 = 0; i2 < class30_sub3_7.entityCount; i2++) {
						InteractableObject class28 = class30_sub3_7.interactableObjects[i2];
						if (class28 != null) {
							class28.jagexNode.method443(class28.rotation, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class28.worldX - SceneGraph.anInt455, class28.worldZ - SceneGraph.anInt456, class28.worldY - SceneGraph.anInt457, class28.uid);
						}
					}
				}
				boolean flag1 = false;
				if (class30_sub3_1.myPlainTile != null) {
					if (!this.method320(l, i, j)) {
						flag1 = true;
						this.method315(class30_sub3_1.myPlainTile, l, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, i, j);
					}
				} else if ((class30_sub3_1.shapedTile != null) && !this.method320(l, i, j)) {
					flag1 = true;
					this.method316(i, SceneGraph.anInt458, SceneGraph.anInt460, class30_sub3_1.shapedTile, SceneGraph.anInt459, j, SceneGraph.anInt461);
				}
				int j1 = 0;
				int j2 = 0;
				WallObject class10_3 = class30_sub3_1.wallObject;
				WallDecoration class26_1 = class30_sub3_1.wallDecoration;
				if ((class10_3 != null) || (class26_1 != null)) {
					if (SceneGraph.anInt453 == i) {
						j1++;
					} else if (SceneGraph.anInt453 < i) {
						j1 += 2;
					}
					if (SceneGraph.anInt454 == j) {
						j1 += 3;
					} else if (SceneGraph.anInt454 > j) {
						j1 += 6;
					}
					j2 = SceneGraph.anIntArray478[j1];
					class30_sub3_1.anInt1328 = SceneGraph.anIntArray480[j1];
				}
				if (class10_3 != null) {
					if ((class10_3.orientation & SceneGraph.anIntArray479[j1]) != 0) {
						if (class10_3.orientation == 16) {
							class30_sub3_1.anInt1325 = 3;
							class30_sub3_1.anInt1326 = SceneGraph.anIntArray481[j1];
							class30_sub3_1.anInt1327 = 3 - class30_sub3_1.anInt1326;
						} else if (class10_3.orientation == 32) {
							class30_sub3_1.anInt1325 = 6;
							class30_sub3_1.anInt1326 = SceneGraph.anIntArray482[j1];
							class30_sub3_1.anInt1327 = 6 - class30_sub3_1.anInt1326;
						} else if (class10_3.orientation == 64) {
							class30_sub3_1.anInt1325 = 12;
							class30_sub3_1.anInt1326 = SceneGraph.anIntArray483[j1];
							class30_sub3_1.anInt1327 = 12 - class30_sub3_1.anInt1326;
						} else {
							class30_sub3_1.anInt1325 = 9;
							class30_sub3_1.anInt1326 = SceneGraph.anIntArray484[j1];
							class30_sub3_1.anInt1327 = 9 - class30_sub3_1.anInt1326;
						}
					} else {
						class30_sub3_1.anInt1325 = 0;
					}
					if (((class10_3.orientation & j2) != 0) && !this.method321(l, i, j, class10_3.orientation)) {
						class10_3.entity1.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class10_3.xPos - SceneGraph.anInt455, class10_3.zPos - SceneGraph.anInt456, class10_3.yPos - SceneGraph.anInt457, class10_3.uid);
					}
					if (((class10_3.orientation1 & j2) != 0) && !this.method321(l, i, j, class10_3.orientation1)) {
						class10_3.entity2.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class10_3.xPos - SceneGraph.anInt455, class10_3.zPos - SceneGraph.anInt456, class10_3.yPos - SceneGraph.anInt457, class10_3.uid);
					}
				}
				if ((class26_1 != null) && !this.method322(l, i, j, class26_1.entity.modelHeight)) {
					if ((class26_1.configBits & j2) != 0) {
						class26_1.entity.method443(class26_1.face, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class26_1.xPos - SceneGraph.anInt455, class26_1.zPos - SceneGraph.anInt456, class26_1.yPos - SceneGraph.anInt457, class26_1.uid);
					} else if ((class26_1.configBits & 0x300) != 0) {
						int j4 = class26_1.xPos - SceneGraph.anInt455;
						int l5 = class26_1.zPos - SceneGraph.anInt456;
						int k6 = class26_1.yPos - SceneGraph.anInt457;
						int i8 = class26_1.face;
						int k9;
						if ((i8 == 1) || (i8 == 2)) {
							k9 = -j4;
						} else {
							k9 = j4;
						}
						int k10;
						if ((i8 == 2) || (i8 == 3)) {
							k10 = -k6;
						} else {
							k10 = k6;
						}
						if (((class26_1.configBits & 0x100) != 0) && (k10 < k9)) {
							int i11 = j4 + SceneGraph.anIntArray463[i8];
							int k11 = k6 + SceneGraph.anIntArray464[i8];
							class26_1.entity.method443((i8 * 512) + 256, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, i11, l5, k11, class26_1.uid);
						}
						if (((class26_1.configBits & 0x200) != 0) && (k10 > k9)) {
							int j11 = j4 + SceneGraph.anIntArray465[i8];
							int l11 = k6 + SceneGraph.anIntArray466[i8];
							class26_1.entity.method443(((i8 * 512) + 1280) & 0x7ff, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, j11, l5, l11, class26_1.uid);
						}
					}
				}
				if (flag1) {
					GroundDecoration class49 = class30_sub3_1.groundDecoration;
					if (class49 != null) {
						class49.aClass30_Sub2_Sub4_814.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class49.xPos - SceneGraph.anInt455, class49.zPos - SceneGraph.anInt456, class49.yPos - SceneGraph.anInt457, class49.uid);
					}
					GroundItemTile object4_1 = class30_sub3_1.groundItemTile;
					if ((object4_1 != null) && (object4_1.anInt52 == 0)) {
						if (object4_1.secondGroundItem != null) {
							object4_1.secondGroundItem.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, object4_1.xPos - SceneGraph.anInt455, object4_1.zPos - SceneGraph.anInt456, object4_1.yPos - SceneGraph.anInt457, object4_1.uid);
						}
						if (object4_1.thirdGroundItem != null) {
							object4_1.thirdGroundItem.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, object4_1.xPos - SceneGraph.anInt455, object4_1.zPos - SceneGraph.anInt456, object4_1.yPos - SceneGraph.anInt457, object4_1.uid);
						}
						if (object4_1.firstGroundItem != null) {
							object4_1.firstGroundItem.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, object4_1.xPos - SceneGraph.anInt455, object4_1.zPos - SceneGraph.anInt456, object4_1.yPos - SceneGraph.anInt457, object4_1.uid);
						}
					}
				}
				int k4 = class30_sub3_1.anInt1320;
				if (k4 != 0) {
					if ((i < SceneGraph.anInt453) && ((k4 & 4) != 0)) {
						Tile class30_sub3_17 = aclass30_sub3[i + 1][j];
						if ((class30_sub3_17 != null) && class30_sub3_17.aBoolean1323) {
							SceneGraph.aClass19_477.insertHead(class30_sub3_17);
						}
					}
					if ((j < SceneGraph.anInt454) && ((k4 & 2) != 0)) {
						Tile class30_sub3_18 = aclass30_sub3[i][j + 1];
						if ((class30_sub3_18 != null) && class30_sub3_18.aBoolean1323) {
							SceneGraph.aClass19_477.insertHead(class30_sub3_18);
						}
					}
					if ((i > SceneGraph.anInt453) && ((k4 & 1) != 0)) {
						Tile class30_sub3_19 = aclass30_sub3[i - 1][j];
						if ((class30_sub3_19 != null) && class30_sub3_19.aBoolean1323) {
							SceneGraph.aClass19_477.insertHead(class30_sub3_19);
						}
					}
					if ((j > SceneGraph.anInt454) && ((k4 & 8) != 0)) {
						Tile class30_sub3_20 = aclass30_sub3[i][j - 1];
						if ((class30_sub3_20 != null) && class30_sub3_20.aBoolean1323) {
							SceneGraph.aClass19_477.insertHead(class30_sub3_20);
						}
					}
				}
			}
			if (class30_sub3_1.anInt1325 != 0) {
				boolean flag2 = true;
				for (int k1 = 0; k1 < class30_sub3_1.entityCount; k1++) {
					if ((class30_sub3_1.interactableObjects[k1].anInt528 == SceneGraph.anInt448) || ((class30_sub3_1.anIntArray1319[k1] & class30_sub3_1.anInt1325) != class30_sub3_1.anInt1326)) {
						continue;
					}
					flag2 = false;
					break;
				}
				if (flag2) {
					WallObject class10_1 = class30_sub3_1.wallObject;
					if (!this.method321(l, i, j, class10_1.orientation)) {
						class10_1.entity1.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class10_1.xPos - SceneGraph.anInt455, class10_1.zPos - SceneGraph.anInt456, class10_1.yPos - SceneGraph.anInt457, class10_1.uid);
					}
					class30_sub3_1.anInt1325 = 0;
				}
			}
			if (class30_sub3_1.aBoolean1324) {
				try {
					int i1 = class30_sub3_1.entityCount;
					class30_sub3_1.aBoolean1324 = false;
					int l1 = 0;
					label0:
						for (int k2 = 0; k2 < i1; k2++) {
							InteractableObject interactableObject = class30_sub3_1.interactableObjects[k2];
							if (interactableObject.anInt528 == SceneGraph.anInt448) {
								continue;
							}
							for (int k3 = interactableObject.tileLeft; k3 <= interactableObject.tileRight; k3++) {
								for (int l4 = interactableObject.tileTop; l4 <= interactableObject.tileBottom; l4++) {
									Tile tile = aclass30_sub3[k3][l4];
									if (tile.aBoolean1322) {
										class30_sub3_1.aBoolean1324 = true;
									} else {
										if (tile.anInt1325 == 0) {
											continue;
										}
										int l6 = 0;
										if (k3 > interactableObject.tileLeft) {
											l6++;
										}
										if (k3 < interactableObject.tileRight) {
											l6 += 4;
										}
										if (l4 > interactableObject.tileTop) {
											l6 += 8;
										}
										if (l4 < interactableObject.tileBottom) {
											l6 += 2;
										}
										if ((l6 & tile.anInt1325) != class30_sub3_1.anInt1327) {
											continue;
										}
										class30_sub3_1.aBoolean1324 = true;
									}
									continue label0;
								}
							}
							SceneGraph.aClass28Array462[l1++] = interactableObject;
							int i5 = SceneGraph.anInt453 - interactableObject.tileLeft;
							int i6 = interactableObject.tileRight - SceneGraph.anInt453;
							if (i6 > i5) {
								i5 = i6;
							}
							int i7 = SceneGraph.anInt454 - interactableObject.tileTop;
							int j8 = interactableObject.tileBottom - SceneGraph.anInt454;
							if (j8 > i7) {
								interactableObject.anInt527 = i5 + j8;
							} else {
								interactableObject.anInt527 = i5 + i7;
							}
						}
					while (l1 > 0) {
						int i3 = -50;
						int l3 = -1;
						for (int j5 = 0; j5 < l1; j5++) {
							InteractableObject class28_2 = SceneGraph.aClass28Array462[j5];
							if (class28_2.anInt528 != SceneGraph.anInt448) {
								if (class28_2.anInt527 > i3) {
									i3 = class28_2.anInt527;
									l3 = j5;
								} else if (class28_2.anInt527 == i3) {
									int j7 = class28_2.worldX - SceneGraph.anInt455;
									int k8 = class28_2.worldY - SceneGraph.anInt457;
									int l9 = SceneGraph.aClass28Array462[l3].worldX - SceneGraph.anInt455;
									int l10 = SceneGraph.aClass28Array462[l3].worldY - SceneGraph.anInt457;
									if (((j7 * j7) + (k8 * k8)) > ((l9 * l9) + (l10 * l10))) {
										l3 = j5;
									}
								}
							}
						}
						if (l3 == -1) {
							break;
						}
						InteractableObject class28_3 = SceneGraph.aClass28Array462[l3];
						class28_3.anInt528 = SceneGraph.anInt448;
						if (!this.method323(l, class28_3.tileLeft, class28_3.tileRight, class28_3.tileTop, class28_3.tileBottom, class28_3.jagexNode.modelHeight)) {
							class28_3.jagexNode.method443(class28_3.rotation, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class28_3.worldX - SceneGraph.anInt455, class28_3.worldZ - SceneGraph.anInt456, class28_3.worldY - SceneGraph.anInt457, class28_3.uid);
						}
						for (int k7 = class28_3.tileLeft; k7 <= class28_3.tileRight; k7++) {
							for (int l8 = class28_3.tileTop; l8 <= class28_3.tileBottom; l8++) {
								Tile class30_sub3_22 = aclass30_sub3[k7][l8];
								if (class30_sub3_22.anInt1325 != 0) {
									SceneGraph.aClass19_477.insertHead(class30_sub3_22);
								} else if (((k7 != i) || (l8 != j)) && class30_sub3_22.aBoolean1323) {
									SceneGraph.aClass19_477.insertHead(class30_sub3_22);
								}
							}
						}
					}
					if (class30_sub3_1.aBoolean1324) {
						continue;
					}
				} catch (Exception _ex) {
					class30_sub3_1.aBoolean1324 = false;
				}
			}
			if (!class30_sub3_1.aBoolean1323 || (class30_sub3_1.anInt1325 != 0)) {
				continue;
			}
			if ((i <= SceneGraph.anInt453) && (i > SceneGraph.anInt449)) {
				Tile class30_sub3_8 = aclass30_sub3[i - 1][j];
				if ((class30_sub3_8 != null) && class30_sub3_8.aBoolean1323) {
					continue;
				}
			}
			if ((i >= SceneGraph.anInt453) && (i < (SceneGraph.anInt450 - 1))) {
				Tile class30_sub3_9 = aclass30_sub3[i + 1][j];
				if ((class30_sub3_9 != null) && class30_sub3_9.aBoolean1323) {
					continue;
				}
			}
			if ((j <= SceneGraph.anInt454) && (j > SceneGraph.anInt451)) {
				Tile class30_sub3_10 = aclass30_sub3[i][j - 1];
				if ((class30_sub3_10 != null) && class30_sub3_10.aBoolean1323) {
					continue;
				}
			}
			if ((j >= SceneGraph.anInt454) && (j < (SceneGraph.anInt452 - 1))) {
				Tile class30_sub3_11 = aclass30_sub3[i][j + 1];
				if ((class30_sub3_11 != null) && class30_sub3_11.aBoolean1323) {
					continue;
				}
			}
			class30_sub3_1.aBoolean1323 = false;
			SceneGraph.anInt446--;
			GroundItemTile groundItemTile = class30_sub3_1.groundItemTile;
			if ((groundItemTile != null) && (groundItemTile.anInt52 != 0)) {
				if (groundItemTile.secondGroundItem != null) {
					groundItemTile.secondGroundItem.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, groundItemTile.xPos - SceneGraph.anInt455, groundItemTile.zPos - SceneGraph.anInt456 - groundItemTile.anInt52, groundItemTile.yPos - SceneGraph.anInt457, groundItemTile.uid);
				}
				if (groundItemTile.thirdGroundItem != null) {
					groundItemTile.thirdGroundItem.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, groundItemTile.xPos - SceneGraph.anInt455, groundItemTile.zPos - SceneGraph.anInt456 - groundItemTile.anInt52, groundItemTile.yPos - SceneGraph.anInt457, groundItemTile.uid);
				}
				if (groundItemTile.firstGroundItem != null) {
					groundItemTile.firstGroundItem.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, groundItemTile.xPos - SceneGraph.anInt455, groundItemTile.zPos - SceneGraph.anInt456 - groundItemTile.anInt52, groundItemTile.yPos - SceneGraph.anInt457, groundItemTile.uid);
				}
			}
			if (class30_sub3_1.anInt1328 != 0) {
				WallDecoration class26 = class30_sub3_1.wallDecoration;
				if ((class26 != null) && !this.method322(l, i, j, class26.entity.modelHeight)) {
					if ((class26.configBits & class30_sub3_1.anInt1328) != 0) {
						class26.entity.method443(class26.face, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class26.xPos - SceneGraph.anInt455, class26.zPos - SceneGraph.anInt456, class26.yPos - SceneGraph.anInt457, class26.uid);
					} else if ((class26.configBits & 0x300) != 0) {
						int l2 = class26.xPos - SceneGraph.anInt455;
						int j3 = class26.zPos - SceneGraph.anInt456;
						int i4 = class26.yPos - SceneGraph.anInt457;
						int k5 = class26.face;
						int j6;
						if ((k5 == 1) || (k5 == 2)) {
							j6 = -l2;
						} else {
							j6 = l2;
						}
						int l7;
						if ((k5 == 2) || (k5 == 3)) {
							l7 = -i4;
						} else {
							l7 = i4;
						}
						if (((class26.configBits & 0x100) != 0) && (l7 >= j6)) {
							int i9 = l2 + SceneGraph.anIntArray463[k5];
							int i10 = i4 + SceneGraph.anIntArray464[k5];
							class26.entity.method443((k5 * 512) + 256, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, i9, j3, i10, class26.uid);
						}
						if (((class26.configBits & 0x200) != 0) && (l7 <= j6)) {
							int j9 = l2 + SceneGraph.anIntArray465[k5];
							int j10 = i4 + SceneGraph.anIntArray466[k5];
							class26.entity.method443(((k5 * 512) + 1280) & 0x7ff, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, j9, j3, j10, class26.uid);
						}
					}
				}
				WallObject class10_2 = class30_sub3_1.wallObject;
				if (class10_2 != null) {
					if (((class10_2.orientation1 & class30_sub3_1.anInt1328) != 0) && !this.method321(l, i, j, class10_2.orientation1)) {
						class10_2.entity2.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class10_2.xPos - SceneGraph.anInt455, class10_2.zPos - SceneGraph.anInt456, class10_2.yPos - SceneGraph.anInt457, class10_2.uid);
					}
					if (((class10_2.orientation & class30_sub3_1.anInt1328) != 0) && !this.method321(l, i, j, class10_2.orientation)) {
						class10_2.entity1.method443(0, SceneGraph.anInt458, SceneGraph.anInt459, SceneGraph.anInt460, SceneGraph.anInt461, class10_2.xPos - SceneGraph.anInt455, class10_2.zPos - SceneGraph.anInt456, class10_2.yPos - SceneGraph.anInt457, class10_2.uid);
					}
				}
			}
			if (k < (this.anInt437 - 1)) {
				Tile class30_sub3_12 = this.groundArray[k + 1][i][j];
				if ((class30_sub3_12 != null) && class30_sub3_12.aBoolean1323) {
					SceneGraph.aClass19_477.insertHead(class30_sub3_12);
				}
			}
			if (i < SceneGraph.anInt453)
			{
				Tile class30_sub3_13 = aclass30_sub3[i + 1][j];
				if ((class30_sub3_13 != null) && class30_sub3_13.aBoolean1323) {
					SceneGraph.aClass19_477.insertHead(class30_sub3_13);
				}
			}
			if (j < SceneGraph.anInt454) {
				Tile class30_sub3_14 = aclass30_sub3[i][j + 1];
				if ((class30_sub3_14 != null) && class30_sub3_14.aBoolean1323) {
					SceneGraph.aClass19_477.insertHead(class30_sub3_14);
				}
			}
			if (i > SceneGraph.anInt453) {
				Tile class30_sub3_15 = aclass30_sub3[i - 1][j];
				if ((class30_sub3_15 != null) && class30_sub3_15.aBoolean1323) {
					SceneGraph.aClass19_477.insertHead(class30_sub3_15);
				}
			}
			if (j > SceneGraph.anInt454) {
				Tile class30_sub3_16 = aclass30_sub3[i][j - 1];
				if ((class30_sub3_16 != null) && class30_sub3_16.aBoolean1323) {
					SceneGraph.aClass19_477.insertHead(class30_sub3_16);
				}
			}
		} while (true);
	}

	private void method315(PlainTile plainTile, int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1;
		int i2 = l1 = (j1 << 7) - SceneGraph.anInt455;
		int j2;
		int k2 = j2 = (k1 << 7) - SceneGraph.anInt457;
		int l2;
		int i3 = l2 = i2 + 128;
		int j3;
		int k3 = j3 = k2 + 128;
		int l3 = this.anIntArrayArrayArray440[i][j1][k1] - SceneGraph.anInt456;
		int i4 = this.anIntArrayArrayArray440[i][j1 + 1][k1] - SceneGraph.anInt456;
		int j4 = this.anIntArrayArrayArray440[i][j1 + 1][k1 + 1] - SceneGraph.anInt456;
		int k4 = this.anIntArrayArrayArray440[i][j1][k1 + 1] - SceneGraph.anInt456;
		int l4 = ((k2 * l) + (i2 * i1)) >> 16;
		k2 = ((k2 * i1) - (i2 * l)) >> 16;
		i2 = l4;
		l4 = ((l3 * k) - (k2 * j)) >> 16;
			k2 = ((l3 * j) + (k2 * k)) >> 16;
						l3 = l4;
						if (k2 < 50) {
							return;
						}
						l4 = ((j2 * l) + (i3 * i1)) >> 16;
						j2 = ((j2 * i1) - (i3 * l)) >> 16;
		i3 = l4;
		l4 = ((i4 * k) - (j2 * j)) >> 16;
							j2 = ((i4 * j) + (j2 * k)) >> 16;
			i4 = l4;
			if (j2 < 50) {
				return;
			}
			l4 = ((k3 * l) + (l2 * i1)) >> 16;
			k3 = ((k3 * i1) - (l2 * l)) >> 16;
						l2 = l4;
						l4 = ((j4 * k) - (k3 * j)) >> 16;
						k3 = ((j4 * j) + (k3 * k)) >> 16;
			j4 = l4;
			if (k3 < 50) {
				return;
			}
			l4 = ((j3 * l) + (l1 * i1)) >> 16;
			j3 = ((j3 * i1) - (l1 * l)) >> 16;
			l1 = l4;
			l4 = ((k4 * k) - (j3 * j)) >> 16;
		j3 = ((k4 * j) + (j3 * k)) >> 16;
		k4 = l4;
		if (j3 < 50) {
			return;
		}
		int i5 = Rasterizer.textureInt1 + ((i2 << 9) / k2);
		int j5 = Rasterizer.textureInt2 + ((l3 << 9) / k2);
		int k5 = Rasterizer.textureInt1 + ((i3 << 9) / j2);
		int l5 = Rasterizer.textureInt2 + ((i4 << 9) / j2);
		int i6 = Rasterizer.textureInt1 + ((l2 << 9) / k3);
		int j6 = Rasterizer.textureInt2 + ((j4 << 9) / k3);
		int k6 = Rasterizer.textureInt1 + ((l1 << 9) / j3);
		int l6 = Rasterizer.textureInt2 + ((k4 << 9) / j3);
		Rasterizer.anInt1465 = 0;
		if ((((i6 - k6) * (l5 - l6)) - ((j6 - l6) * (k5 - k6))) > 0) {
			Rasterizer.aBoolean1462 = (i6 < 0) || (k6 < 0) || (k5 < 0) || (i6 > DrawingArea.viewportRX) || (k6 > DrawingArea.viewportRX) || (k5 > DrawingArea.viewportRX);
			if (SceneGraph.aBoolean467 && this.method318(SceneGraph.anInt468, SceneGraph.anInt469, j6, l6, l5, i6, k6, k5)) {
				SceneGraph.anInt470 = j1;
				SceneGraph.anInt471 = k1;
			}
			if (plainTile.texture == -1) {
				if (plainTile.colourD != 0xbc614e) {
					Rasterizer.method374(j6, l6, l5, i6, k6, k5, plainTile.colourD, plainTile.colourC, plainTile.colourB);
				}
			} else if (!SceneGraph.lowMem) {
				if (plainTile.flat) {
					Rasterizer.method378(j6, l6, l5, i6, k6, k5, plainTile.colourD, plainTile.colourC, plainTile.colourB, i2, i3, l1, l3, i4, k4, k2, j2, j3, plainTile.texture);
				} else {
					Rasterizer.method378(j6, l6, l5, i6, k6, k5, plainTile.colourD, plainTile.colourC, plainTile.colourB, l2, l1, i3, j4, k4, i4, k3, j3, j2, plainTile.texture);
				}
			} else {
				int i7 = SceneGraph.anIntArray485[plainTile.texture];
				Rasterizer.method374(j6, l6, l5, i6, k6, k5, this.method317(i7, plainTile.colourD), this.method317(i7, plainTile.colourC), this.method317(i7, plainTile.colourB));
			}
		}
		if ((((i5 - k5) * (l6 - l5)) - ((j5 - l5) * (k6 - k5))) > 0) {
			Rasterizer.aBoolean1462 = (i5 < 0) || (k5 < 0) || (k6 < 0) || (i5 > DrawingArea.viewportRX) || (k5 > DrawingArea.viewportRX) || (k6 > DrawingArea.viewportRX);
			if (SceneGraph.aBoolean467 && this.method318(SceneGraph.anInt468, SceneGraph.anInt469, j5, l5, l6, i5, k5, k6)) {
				SceneGraph.anInt470 = j1;
				SceneGraph.anInt471 = k1;
			}
			if (plainTile.texture == -1) {
				if (plainTile.colourA != 0xbc614e) {
					Rasterizer.method374(j5, l5, l6, i5, k5, k6, plainTile.colourA, plainTile.colourB, plainTile.colourC);
				}
			} else {
				if (!SceneGraph.lowMem) {
					Rasterizer.method378(j5, l5, l6, i5, k5, k6, plainTile.colourA, plainTile.colourB, plainTile.colourC, i2, i3, l1, l3, i4, k4, k2, j2, j3, plainTile.texture);
					return;
				}
				int j7 = SceneGraph.anIntArray485[plainTile.texture];
				Rasterizer.method374(j5, l5, l6, i5, k5, k6, this.method317(j7, plainTile.colourA), this.method317(j7, plainTile.colourB), this.method317(j7, plainTile.colourC));
			}
		}
	}

	private void method316(int i, int j, int k, ShapedTile shapedTile, int l, int i1, int j1) {
		int k1 = shapedTile.origVertexX.length;
		for (int l1 = 0; l1 < k1; l1++) {
			int i2 = shapedTile.origVertexX[l1] - SceneGraph.anInt455;
			int k2 = shapedTile.origVertexY[l1] - SceneGraph.anInt456;
			int i3 = shapedTile.origVertexZ[l1] - SceneGraph.anInt457;
			int k3 = ((i3 * k) + (i2 * j1)) >> 16;
		i3 = ((i3 * j1) - (i2 * k)) >> 16;
		i2 = k3;
		k3 = ((k2 * l) - (i3 * j)) >> 16;
		i3 = ((k2 * j) + (i3 * l)) >> 16;
		k2 = k3;
		if (i3 < 50) {
			return;
		}
		if (shapedTile.triangleTexture != null) {
			ShapedTile.viewSpaceX[l1] = i2;
			ShapedTile.viewSpaceY[l1] = k2;
			ShapedTile.viewSpaceZ[l1] = i3;
		}
		ShapedTile.screenX[l1] = Rasterizer.textureInt1 + ((i2 << 9) / i3);
		ShapedTile.screenY[l1] = Rasterizer.textureInt2 + ((k2 << 9) / i3);
		}
		Rasterizer.anInt1465 = 0;
		k1 = shapedTile.triangleA.length;
		for (int j2 = 0; j2 < k1; j2++) {
			int l2 = shapedTile.triangleA[j2];
			int j3 = shapedTile.triangleB[j2];
			int l3 = shapedTile.triangleC[j2];
			int i4 = ShapedTile.screenX[l2];
			int j4 = ShapedTile.screenX[j3];
			int k4 = ShapedTile.screenX[l3];
			int l4 = ShapedTile.screenY[l2];
			int i5 = ShapedTile.screenY[j3];
			int j5 = ShapedTile.screenY[l3];
			if ((((i4 - j4) * (j5 - i5)) - ((l4 - i5) * (k4 - j4))) > 0) {
				Rasterizer.aBoolean1462 = (i4 < 0) || (j4 < 0) || (k4 < 0) || (i4 > DrawingArea.viewportRX) || (j4 > DrawingArea.viewportRX) || (k4 > DrawingArea.viewportRX);
				if (SceneGraph.aBoolean467 && this.method318(SceneGraph.anInt468, SceneGraph.anInt469, l4, i5, j5, i4, j4, k4)) {
					SceneGraph.anInt470 = i;
					SceneGraph.anInt471 = i1;
				}
				if ((shapedTile.triangleTexture == null) || (shapedTile.triangleTexture[j2] == -1)) {
					if (shapedTile.triangleHSLA[j2] != 0xbc614e) {
						Rasterizer.method374(l4, i5, j5, i4, j4, k4, shapedTile.triangleHSLA[j2], shapedTile.triangleHSLB[j2], shapedTile.triangleHSLC[j2]);
					}
				} else if (!SceneGraph.lowMem) {
					if (shapedTile.flat) {
						Rasterizer.method378(l4, i5, j5, i4, j4, k4, shapedTile.triangleHSLA[j2], shapedTile.triangleHSLB[j2], shapedTile.triangleHSLC[j2], ShapedTile.viewSpaceX[0], ShapedTile.viewSpaceX[1], ShapedTile.viewSpaceX[3], ShapedTile.viewSpaceY[0], ShapedTile.viewSpaceY[1], ShapedTile.viewSpaceY[3], ShapedTile.viewSpaceZ[0], ShapedTile.viewSpaceZ[1], ShapedTile.viewSpaceZ[3], shapedTile.triangleTexture[j2]);
					} else {
						Rasterizer.method378(l4, i5, j5, i4, j4, k4, shapedTile.triangleHSLA[j2], shapedTile.triangleHSLB[j2], shapedTile.triangleHSLC[j2], ShapedTile.viewSpaceX[l2], ShapedTile.viewSpaceX[j3], ShapedTile.viewSpaceX[l3], ShapedTile.viewSpaceY[l2], ShapedTile.viewSpaceY[j3], ShapedTile.viewSpaceY[l3], ShapedTile.viewSpaceZ[l2], ShapedTile.viewSpaceZ[j3], ShapedTile.viewSpaceZ[l3], shapedTile.triangleTexture[j2]);
					}
				} else {
					int k5 = SceneGraph.anIntArray485[shapedTile.triangleTexture[j2]];
					Rasterizer.method374(l4, i5, j5, i4, j4, k4, this.method317(k5, shapedTile.triangleHSLA[j2]), this.method317(k5, shapedTile.triangleHSLB[j2]), this.method317(k5, shapedTile.triangleHSLC[j2]));
				}
			}
		}
	}

	private int method317(int j, int k) {
		k = 127 - k;
		k = (k * (j & 0x7f)) / 160;
		if (k < 2) {
			k = 2;
		} else if (k > 126) {
			k = 126;
		}
		return (j & 0xff80) + k;
	}

	private boolean method318(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
		if ((j < k) && (j < l) && (j < i1)) {
			return false;
		}
		if ((j > k) && (j > l) && (j > i1)) {
			return false;
		}
		if ((i < j1) && (i < k1) && (i < l1)) {
			return false;
		}
		if ((i > j1) && (i > k1) && (i > l1)) {
			return false;
		}
		int i2 = ((j - k) * (k1 - j1)) - ((i - j1) * (l - k));
		int j2 = ((j - i1) * (j1 - l1)) - ((i - l1) * (k - i1));
		int k2 = ((j - l) * (l1 - k1)) - ((i - k1) * (i1 - l));
		return ((i2 * k2) > 0) && ((k2 * j2) > 0);
	}

	private void method319() {
		int j = SceneGraph.anIntArray473[SceneGraph.anInt447];
		CullingCluster aclass47[] = SceneGraph.aClass47ArrayArray474[SceneGraph.anInt447];
		SceneGraph.anInt475 = 0;
		for (int k = 0; k < j; k++) {
			CullingCluster cullingCluster = aclass47[k];
			if (cullingCluster.searchMask == 1) {
				int l = (cullingCluster.tileStartX - SceneGraph.anInt453) + 25;
				if ((l < 0) || (l > 50)) {
					continue;
				}
				int k1 = (cullingCluster.tileStartY - SceneGraph.anInt454) + 25;
				if (k1 < 0) {
					k1 = 0;
				}
				int j2 = (cullingCluster.tileEndY - SceneGraph.anInt454) + 25;
				if (j2 > 50) {
					j2 = 50;
				}
				boolean flag = false;
				while (k1 <= j2) {
					if (SceneGraph.aBooleanArrayArray492[l][k1++]) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					continue;
				}
				int j3 = SceneGraph.anInt455 - cullingCluster.worldStartX;
				if (j3 > 32) {
					cullingCluster.tileDistanceEnum = 1;
				} else {
					if (j3 >= -32) {
						continue;
					}
					cullingCluster.tileDistanceEnum = 2;
					j3 = -j3;
				}
				cullingCluster.worldDistanceFromCameraStartY = ((cullingCluster.worldStartY - SceneGraph.anInt457) << 8) / j3;
				cullingCluster.worldDistanceFromCameraEndY = ((cullingCluster.worldEndY - SceneGraph.anInt457) << 8) / j3;
				cullingCluster.worldDistanceFromCameraStartZ = ((cullingCluster.worldStartZ - SceneGraph.anInt456) << 8) / j3;
				cullingCluster.worldDistanceFromCameraEndZ = ((cullingCluster.worldEndZ - SceneGraph.anInt456) << 8) / j3;
				SceneGraph.aClass47Array476[SceneGraph.anInt475++] = cullingCluster;
				continue;
			}
			if (cullingCluster.searchMask == 2) {
				int i1 = (cullingCluster.tileStartY - SceneGraph.anInt454) + 25;
				if ((i1 < 0) || (i1 > 50)) {
					continue;
				}
				int l1 = (cullingCluster.tileStartX - SceneGraph.anInt453) + 25;
				if (l1 < 0) {
					l1 = 0;
				}
				int k2 = (cullingCluster.tileEndX - SceneGraph.anInt453) + 25;
				if (k2 > 50) {
					k2 = 50;
				}
				boolean flag1 = false;
				while (l1 <= k2) {
					if (SceneGraph.aBooleanArrayArray492[l1++][i1]) {
						flag1 = true;
						break;
					}
				}
				if (!flag1) {
					continue;
				}
				int k3 = SceneGraph.anInt457 - cullingCluster.worldStartY;
				if (k3 > 32) {
					cullingCluster.tileDistanceEnum = 3;
				} else {
					if (k3 >= -32) {
						continue;
					}
					cullingCluster.tileDistanceEnum = 4;
					k3 = -k3;
				}
				cullingCluster.worldDistanceFromCameraStartX = ((cullingCluster.worldStartX - SceneGraph.anInt455) << 8) / k3;
				cullingCluster.worldDistanceFromCameraEndX = ((cullingCluster.worldEndX - SceneGraph.anInt455) << 8) / k3;
				cullingCluster.worldDistanceFromCameraStartZ = ((cullingCluster.worldStartZ - SceneGraph.anInt456) << 8) / k3;
				cullingCluster.worldDistanceFromCameraEndZ = ((cullingCluster.worldEndZ - SceneGraph.anInt456) << 8) / k3;
				SceneGraph.aClass47Array476[SceneGraph.anInt475++] = cullingCluster;
			} else if (cullingCluster.searchMask == 4) {
				int j1 = cullingCluster.worldStartZ - SceneGraph.anInt456;
				if (j1 > 128) {
					int i2 = (cullingCluster.tileStartY - SceneGraph.anInt454) + 25;
					if (i2 < 0) {
						i2 = 0;
					}
					int l2 = (cullingCluster.tileEndY - SceneGraph.anInt454) + 25;
					if (l2 > 50) {
						l2 = 50;
					}
					if (i2 <= l2) {
						int i3 = (cullingCluster.tileStartX - SceneGraph.anInt453) + 25;
						if (i3 < 0) {
							i3 = 0;
						}
						int l3 = (cullingCluster.tileEndX - SceneGraph.anInt453) + 25;
						if (l3 > 50) {
							l3 = 50;
						}
						boolean flag2 = false;
						label0:
							for (int i4 = i3; i4 <= l3; i4++) {
								for (int j4 = i2; j4 <= l2; j4++) {
									if (!SceneGraph.aBooleanArrayArray492[i4][j4]) {
										continue;
									}
									flag2 = true;
									break label0;
								}
							}
						if (flag2) {
							cullingCluster.tileDistanceEnum = 5;
							cullingCluster.worldDistanceFromCameraStartX = ((cullingCluster.worldStartX - SceneGraph.anInt455) << 8) / j1;
							cullingCluster.worldDistanceFromCameraEndX = ((cullingCluster.worldEndX - SceneGraph.anInt455) << 8) / j1;
							cullingCluster.worldDistanceFromCameraStartY = ((cullingCluster.worldStartY - SceneGraph.anInt457) << 8) / j1;
							cullingCluster.worldDistanceFromCameraEndY = ((cullingCluster.worldEndY - SceneGraph.anInt457) << 8) / j1;
							SceneGraph.aClass47Array476[SceneGraph.anInt475++] = cullingCluster;
						}
					}
				}
			}
		}
	}

	private boolean method320(int i, int j, int k) {
		int l = this.anIntArrayArrayArray445[i][j][k];
		if (l == -SceneGraph.anInt448) {
			return false;
		}
		if (l == SceneGraph.anInt448) {
			return true;
		}
		int i1 = j << 7;
		int j1 = k << 7;
		if (this.method324(i1 + 1, this.anIntArrayArrayArray440[i][j][k], j1 + 1) && this.method324((i1 + 128) - 1, this.anIntArrayArrayArray440[i][j + 1][k], j1 + 1) && this.method324((i1 + 128) - 1, this.anIntArrayArrayArray440[i][j + 1][k + 1], (j1 + 128) - 1) && this.method324(i1 + 1, this.anIntArrayArrayArray440[i][j][k + 1], (j1 + 128) - 1)) {
			this.anIntArrayArrayArray445[i][j][k] = SceneGraph.anInt448;
			return true;
		}
		this.anIntArrayArrayArray445[i][j][k] = -SceneGraph.anInt448;
		return false;
	}

	private boolean method321(int i, int j, int k, int l) {
		if (!this.method320(i, j, k)) {
			return false;
		}
		int i1 = j << 7;
		int j1 = k << 7;
		int k1 = this.anIntArrayArrayArray440[i][j][k] - 1;
		int l1 = k1 - 120;
		int i2 = k1 - 230;
		int j2 = k1 - 238;
		if (l < 16) {
			if (l == 1) {
				if (i1 > SceneGraph.anInt455) {
					if (!this.method324(i1, k1, j1)) {
						return false;
					}
					if (!this.method324(i1, k1, j1 + 128)) {
						return false;
					}
				}
				if (i > 0) {
					if (!this.method324(i1, l1, j1)) {
						return false;
					}
					if (!this.method324(i1, l1, j1 + 128)) {
						return false;
					}
				}
				return this.method324(i1, i2, j1) && this.method324(i1, i2, j1 + 128);
			}
			if (l == 2) {
				if (j1 < SceneGraph.anInt457) {
					if (!this.method324(i1, k1, j1 + 128)) {
						return false;
					}
					if (!this.method324(i1 + 128, k1, j1 + 128)) {
						return false;
					}
				}
				if (i > 0) {
					if (!this.method324(i1, l1, j1 + 128)) {
						return false;
					}
					if (!this.method324(i1 + 128, l1, j1 + 128)) {
						return false;
					}
				}
				return this.method324(i1, i2, j1 + 128) && this.method324(i1 + 128, i2, j1 + 128);
			}
			if (l == 4) {
				if (i1 < SceneGraph.anInt455) {
					if (!this.method324(i1 + 128, k1, j1)) {
						return false;
					}
					if (!this.method324(i1 + 128, k1, j1 + 128)) {
						return false;
					}
				}
				if (i > 0) {
					if (!this.method324(i1 + 128, l1, j1)) {
						return false;
					}
					if (!this.method324(i1 + 128, l1, j1 + 128)) {
						return false;
					}
				}
				return this.method324(i1 + 128, i2, j1) && this.method324(i1 + 128, i2, j1 + 128);
			}
			if (l == 8) {
				if (j1 > SceneGraph.anInt457) {
					if (!this.method324(i1, k1, j1)) {
						return false;
					}
					if (!this.method324(i1 + 128, k1, j1)) {
						return false;
					}
				}
				if (i > 0) {
					if (!this.method324(i1, l1, j1)) {
						return false;
					}
					if (!this.method324(i1 + 128, l1, j1)) {
						return false;
					}
				}
				return this.method324(i1, i2, j1) && this.method324(i1 + 128, i2, j1);
			}
		}
		if (!this.method324(i1 + 64, j2, j1 + 64)) {
			return false;
		}
		if (l == 16) {
			return this.method324(i1, i2, j1 + 128);
		}
		if (l == 32) {
			return this.method324(i1 + 128, i2, j1 + 128);
		}
		if (l == 64) {
			return this.method324(i1 + 128, i2, j1);
		}
		if (l == 128) {
			return this.method324(i1, i2, j1);
		}
		System.out.println("Warning unsupported wall type");
		return true;
	}

	private boolean method322(int i, int j, int k, int l) {
		if (!this.method320(i, j, k)) {
			return false;
		}
		int i1 = j << 7;
		int j1 = k << 7;
		return this.method324(i1 + 1, this.anIntArrayArrayArray440[i][j][k] - l, j1 + 1) && this.method324((i1 + 128) - 1, this.anIntArrayArrayArray440[i][j + 1][k] - l, j1 + 1) && this.method324((i1 + 128) - 1, this.anIntArrayArrayArray440[i][j + 1][k + 1] - l, (j1 + 128) - 1) && this.method324(i1 + 1, this.anIntArrayArrayArray440[i][j][k + 1] - l, (j1 + 128) - 1);
	}

	private boolean method323(int i, int j, int k, int l, int i1, int j1) {
		if ((j == k) && (l == i1)) {
			if (!this.method320(i, j, l)) {
				return false;
			}
			int k1 = j << 7;
			int i2 = l << 7;
			return this.method324(k1 + 1, this.anIntArrayArrayArray440[i][j][l] - j1, i2 + 1) && this.method324((k1 + 128) - 1, this.anIntArrayArrayArray440[i][j + 1][l] - j1, i2 + 1) && this.method324((k1 + 128) - 1, this.anIntArrayArrayArray440[i][j + 1][l + 1] - j1, (i2 + 128) - 1) && this.method324(k1 + 1, this.anIntArrayArrayArray440[i][j][l + 1] - j1, (i2 + 128) - 1);
		}
		for (int l1 = j; l1 <= k; l1++) {
			for (int j2 = l; j2 <= i1; j2++) {
				if (this.anIntArrayArrayArray445[i][l1][j2] == -SceneGraph.anInt448) {
					return false;
				}
			}
		}
		int k2 = (j << 7) + 1;
		int l2 = (l << 7) + 2;
		int i3 = this.anIntArrayArrayArray440[i][j][l] - j1;
		if (!this.method324(k2, i3, l2)) {
			return false;
		}
		int j3 = (k << 7) - 1;
		if (!this.method324(j3, i3, l2)) {
			return false;
		}
		int k3 = (i1 << 7) - 1;
		return this.method324(k2, i3, k3) && this.method324(j3, i3, k3);
	}

	private boolean method324(int i, int j, int k) {
		for (int l = 0; l < SceneGraph.anInt475; l++) {
			CullingCluster cullingCluster = SceneGraph.aClass47Array476[l];
			if (cullingCluster.tileDistanceEnum == 1) {
				int i1 = cullingCluster.worldStartX - i;
				if (i1 > 0) {
					int j2 = cullingCluster.worldStartY + ((cullingCluster.worldDistanceFromCameraStartY * i1) >> 8);
					int k3 = cullingCluster.worldEndY + ((cullingCluster.worldDistanceFromCameraEndY * i1) >> 8);
					int l4 = cullingCluster.worldStartZ + ((cullingCluster.worldDistanceFromCameraStartZ * i1) >> 8);
					int i6 = cullingCluster.worldEndZ + ((cullingCluster.worldDistanceFromCameraEndZ * i1) >> 8);
					if ((k >= j2) && (k <= k3) && (j >= l4) && (j <= i6)) {
						return true;
					}
				}
			} else if (cullingCluster.tileDistanceEnum == 2) {
				int j1 = i - cullingCluster.worldStartX;
				if (j1 > 0) {
					int k2 = cullingCluster.worldStartY + ((cullingCluster.worldDistanceFromCameraStartY * j1) >> 8);
					int l3 = cullingCluster.worldEndY + ((cullingCluster.worldDistanceFromCameraEndY * j1) >> 8);
					int i5 = cullingCluster.worldStartZ + ((cullingCluster.worldDistanceFromCameraStartZ * j1) >> 8);
					int j6 = cullingCluster.worldEndZ + ((cullingCluster.worldDistanceFromCameraEndZ * j1) >> 8);
					if ((k >= k2) && (k <= l3) && (j >= i5) && (j <= j6)) {
						return true;
					}
				}
			} else if (cullingCluster.tileDistanceEnum == 3) {
				int k1 = cullingCluster.worldStartY - k;
				if (k1 > 0) {
					int l2 = cullingCluster.worldStartX + ((cullingCluster.worldDistanceFromCameraStartX * k1) >> 8);
					int i4 = cullingCluster.worldEndX + ((cullingCluster.worldDistanceFromCameraEndX * k1) >> 8);
					int j5 = cullingCluster.worldStartZ + ((cullingCluster.worldDistanceFromCameraStartZ * k1) >> 8);
					int k6 = cullingCluster.worldEndZ + ((cullingCluster.worldDistanceFromCameraEndZ * k1) >> 8);
					if ((i >= l2) && (i <= i4) && (j >= j5) && (j <= k6)) {
						return true;
					}
				}
			} else if (cullingCluster.tileDistanceEnum == 4) {
				int l1 = k - cullingCluster.worldStartY;
				if (l1 > 0) {
					int i3 = cullingCluster.worldStartX + ((cullingCluster.worldDistanceFromCameraStartX * l1) >> 8);
					int j4 = cullingCluster.worldEndX + ((cullingCluster.worldDistanceFromCameraEndX * l1) >> 8);
					int k5 = cullingCluster.worldStartZ + ((cullingCluster.worldDistanceFromCameraStartZ * l1) >> 8);
					int l6 = cullingCluster.worldEndZ + ((cullingCluster.worldDistanceFromCameraEndZ * l1) >> 8);
					if ((i >= i3) && (i <= j4) && (j >= k5) && (j <= l6)) {
						return true;
					}
				}
			} else if (cullingCluster.tileDistanceEnum == 5) {
				int i2 = j - cullingCluster.worldStartZ;
				if (i2 > 0) {
					int j3 = cullingCluster.worldStartX + ((cullingCluster.worldDistanceFromCameraStartX * i2) >> 8);
					int k4 = cullingCluster.worldEndX + ((cullingCluster.worldDistanceFromCameraEndX * i2) >> 8);
					int l5 = cullingCluster.worldStartY + ((cullingCluster.worldDistanceFromCameraStartY * i2) >> 8);
					int i7 = cullingCluster.worldEndY + ((cullingCluster.worldDistanceFromCameraEndY * i2) >> 8);
					if ((i >= j3) && (i <= k4) && (k >= l5) && (k <= i7)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean aBoolean434;
	public static boolean lowMem = true;
	private int anInt437;
	private int anInt438;
	private int anInt439;
	private int[][][] anIntArrayArrayArray440;
	private Tile[][][] groundArray;
	private int anInt442;
	private int obj5CacheCurrPos;
	private InteractableObject[] obj5Cache;
	private int[][][] anIntArrayArrayArray445;
	private static int anInt446;
	private static int anInt447;
	private static int anInt448;
	private static int anInt449;
	private static int anInt450;
	private static int anInt451;
	private static int anInt452;
	private static int anInt453;
	private static int anInt454;
	private static int anInt455;
	private static int anInt456;
	private static int anInt457;
	private static int anInt458;
	private static int anInt459;
	private static int anInt460;
	private static int anInt461;
	private static InteractableObject[] aClass28Array462 = new InteractableObject[100];
	private static int[] anIntArray463 = {
		53, -53, -53, 53
	};
	private static int[] anIntArray464 = {
		-53, -53, 53, 53
	};
	private static int[] anIntArray465 = {
		-45, 45, 45, -45
	};
	private static int[] anIntArray466 = {
		45, 45, -45, -45
	};
	private static boolean aBoolean467;
	private static int anInt468;
	private static int anInt469;
	public static int anInt470 = -1;
	public static int anInt471 = -1;
	private static int anInt472;
	private static int[] anIntArray473;
	private static CullingCluster[][] aClass47ArrayArray474;
	private static int anInt475;
	private static CullingCluster[] aClass47Array476 = new CullingCluster[500];
	private static Deque aClass19_477 = new Deque();
	private static int[] anIntArray478 = {
		19, 55, 38, 155, 255, 110, 137, 205, 76
	};
	private static int[] anIntArray479 = {
		160, 192, 80, 96, 0, 144, 80, 48, 160
	};
	private static int[] anIntArray480 = {
		76, 8, 137, 4, 0, 1, 38, 2, 19
	};
	private static int[] anIntArray481 = {
		0, 0, 2, 0, 0, 2, 1, 1, 0
	};
	private static int[] anIntArray482 = {
		2, 0, 0, 2, 0, 0, 0, 4, 4
	};
	private static int[] anIntArray483 = {
		0, 4, 4, 8, 0, 0, 8, 0, 0
	};
	private static int[] anIntArray484 = {
		1, 1, 0, 0, 0, 8, 0, 0, 8
	};
	private static int[] anIntArray485 = {
		41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41,
		41, 41, 41, 41, 41, 43086, 41, 41, 41, 41,
		41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41,
		41, 5056, 41, 41, 41, 7079, 41, 41, 41, 41,
		41, 41, 41, 41, 41, 41, 3131, 41, 41, 41
	};
	private int[] anIntArray486;
	private int[] anIntArray487;
	private int anInt488;
	private int[][] anIntArrayArray489 = {
			new int[16],
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1 },
			{ 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 }
	};
	private final int[][] anIntArrayArray490 = {
			{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
			{ 12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3 },
			{ 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 },
			{ 3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12 }
	};
	private static boolean[][][][] aBooleanArrayArrayArrayArray491 = new boolean[8][32][51][51];
	private static boolean[][] aBooleanArrayArray492;
	private static int anInt493;
	private static int anInt494;
	private static int anInt495;
	private static int anInt496;
	private static int anInt497;
	private static int anInt498;

	static {
		SceneGraph.anInt472 = 4;
		SceneGraph.anIntArray473 = new int[SceneGraph.anInt472];
		SceneGraph.aClass47ArrayArray474 = new CullingCluster[SceneGraph.anInt472][500];
	}
}