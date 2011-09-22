package com.netty.game.model.entity.object;

import com.netty.game.graphics.texture.Rasterizer;
import com.netty.game.model.Model;
import com.netty.net.cache.OnDemandFetcher;
import com.netty.net.packet.Packet;
import com.netty.stuff.Animable;
import com.netty.stuff.Floor;
import com.netty.stuff.MapUtility;
import com.netty.stuff.ObjectOnTile;
import com.netty.stuff.TileSetting;
import com.netty.world.SceneGraph;

public class MapRegion {

	public MapRegion(byte[][][] abyte0, int[][][] ai) {
		MapRegion.setZ = 99;
		this.xMapSize = 104;
		this.yMapSize = 104;
		this.heightMap = ai;
		this.tileSettings = abyte0;
		this.underLay = new byte[4][this.xMapSize][this.yMapSize];
		this.overLay = new byte[4][this.xMapSize][this.yMapSize];
		this.tileShape = new byte[4][this.xMapSize][this.yMapSize];
		this.tileShapeRotation = new byte[4][this.xMapSize][this.yMapSize];
		this.tileCullingBitmap = new int[4][this.xMapSize + 1][this.yMapSize + 1];
		this.objectShadowData = new byte[4][this.xMapSize + 1][this.yMapSize + 1];
		this.tileLightness = new int[this.xMapSize + 1][this.yMapSize + 1];
		this.hue = new int[this.yMapSize];
		this.saturation = new int[this.yMapSize];
		this.lightness = new int[this.yMapSize];
		this.hueDivider = new int[this.yMapSize];
		this.colourCount = new int[this.yMapSize];
	}

	private static int method170(int i, int j) {
		int k = i + (j * 57);
		k = (k << 13) ^ k;
		int l = ((k * ((k * k * 15731) + 0xc0ae5)) + 0x5208dd0d) & 0x7fffffff;
		return (l >> 19) & 0xff;
	}

	public final void method171(TileSetting aclass11[], SceneGraph sceneGraph) {
		for (int j = 0; j < 4; j++) {
			for (int k = 0; k < 104; k++) {
				for (int i1 = 0; i1 < 104; i1++) {
					if ((this.tileSettings[j][k][i1] & 1) == 1) {
						int k1 = j;
						if ((this.tileSettings[1][k][i1] & 2) == 2) {
							k1--;
						}
						if (k1 >= 0) {
							aclass11[k1].method213(i1, k);
						}
					}
				}
			}
		}
		MapRegion.hueOffset += (int) (Math.random() * 5D) - 2;
		if (MapRegion.hueOffset < -8) {
			MapRegion.hueOffset = -8;
		}
		if (MapRegion.hueOffset > 8) {
			MapRegion.hueOffset = 8;
		}
		MapRegion.lightnessOffset += (int) (Math.random() * 5D) - 2;
		if (MapRegion.lightnessOffset < -16) {
			MapRegion.lightnessOffset = -16;
		}
		if (MapRegion.lightnessOffset > 16) {
			MapRegion.lightnessOffset = 16;
		}
		for (int l = 0; l < 4; l++) {
			byte abyte0[][] = this.objectShadowData[l];
			byte byte0 = 96;
			char c = '\u0300';
			byte byte1 = -50;
			byte byte2 = -10;
			byte byte3 = -50;
			int j3 = (int)Math.sqrt((byte1 * byte1) + (byte2 * byte2) + (byte3 * byte3));
			int l3 = (c * j3) >> 8;
		for (int j4 = 1; j4 < (this.yMapSize - 1); j4++) {
			for (int j5 = 1; j5 < (this.xMapSize - 1); j5++) {
				int k6 = this.heightMap[l][j5 + 1][j4] - this.heightMap[l][j5 - 1][j4];
				int l7 = this.heightMap[l][j5][j4 + 1] - this.heightMap[l][j5][j4 - 1];
				int j9 = (int)Math.sqrt((k6 * k6) + 0x10000 + (l7 * l7));
				int k12 = (k6 << 8) / j9;
				int l13 = 0x10000 / j9;
				int j15 = (l7 << 8) / j9;
				int j16 = byte0 + (((byte1 * k12) + (byte2 * l13) + (byte3 * j15)) / l3);
				int j17 = (abyte0[j5 - 1][j4] >> 2) + (abyte0[j5 + 1][j4] >> 3) + (abyte0[j5][j4 - 1] >> 2) + (abyte0[j5][j4 + 1] >> 3) + (abyte0[j5][j4] >> 1);
				this.tileLightness[j5][j4] = j16 - j17;
			}
		}
		for (int k5 = 0; k5 < this.yMapSize; k5++) {
			this.hue[k5] = 0;
			this.saturation[k5] = 0;
			this.lightness[k5] = 0;
			this.hueDivider[k5] = 0;
			this.colourCount[k5] = 0;
		}
		for (int l6 = -5; l6 < (this.xMapSize + 5); l6++) {
			for (int i8 = 0; i8 < this.yMapSize; i8++) {
				int k9 = l6 + 5;
				if ((k9 >= 0) && (k9 < this.xMapSize)) {
					int l12 = this.underLay[l][k9][i8] & 0xff;
					if (l12 > 0) {
						Floor floor = Floor.cache[l12 - 1];
						this.hue[i8] += floor.hue2;
						this.saturation[i8] += floor.saturation;
						this.lightness[i8] += floor.lightness;
						this.hueDivider[i8] += floor.pCDivider;
						this.colourCount[i8]++;
					}
				}
				int i13 = l6 - 5;
				if ((i13 >= 0) && (i13 < this.xMapSize)) {
					int i14 = this.underLay[l][i13][i8] & 0xff;
					if (i14 > 0) {
						Floor flo_1 = Floor.cache[i14 - 1];
						this.hue[i8] -= flo_1.hue2;
						this.saturation[i8] -= flo_1.saturation;
						this.lightness[i8] -= flo_1.lightness;
						this.hueDivider[i8] -= flo_1.pCDivider;
						this.colourCount[i8]--;
					}
				}
			}
			if ((l6 >= 1) && (l6 < (this.xMapSize - 1))) {
				int l9 = 0;
				int j13 = 0;
				int j14 = 0;
				int k15 = 0;
				int k16 = 0;
				for (int k17 = -5; k17 < (this.yMapSize + 5); k17++) {
					int j18 = k17 + 5;
					if ((j18 >= 0) && (j18 < this.yMapSize)) {
						l9 += this.hue[j18];
						j13 += this.saturation[j18];
						j14 += this.lightness[j18];
						k15 += this.hueDivider[j18];
						k16 += this.colourCount[j18];
					}
					int k18 = k17 - 5;
					if ((k18 >= 0) && (k18 < this.yMapSize)) {
						l9 -= this.hue[k18];
						j13 -= this.saturation[k18];
						j14 -= this.lightness[k18];
						k15 -= this.hueDivider[k18];
						k16 -= this.colourCount[k18];
					}
					if ((k17 >= 1) && (k17 < (this.yMapSize - 1)) && (!MapRegion.lowMem || ((this.tileSettings[0][l6][k17] & 2) != 0) || (((this.tileSettings[l][l6][k17] & 0x10) == 0) && (this.method182(k17, l, l6) == MapRegion.anInt131)))) {
						if (l < MapRegion.setZ) {
							MapRegion.setZ = l;
						}
						int l18 = this.underLay[l][l6][k17] & 0xff;
						int i19 = this.overLay[l][l6][k17] & 0xff;
						if ((l18 > 0) || (i19 > 0)) {
							int j19 = this.heightMap[l][l6][k17];
							int k19 = this.heightMap[l][l6 + 1][k17];
							int l19 = this.heightMap[l][l6 + 1][k17 + 1];
							int i20 = this.heightMap[l][l6][k17 + 1];
							int j20 = this.tileLightness[l6][k17];
							int k20 = this.tileLightness[l6 + 1][k17];
							int l20 = this.tileLightness[l6 + 1][k17 + 1];
							int i21 = this.tileLightness[l6][k17 + 1];
							int j21 = -1;
							int k21 = -1;
							if (l18 > 0) {
								int l21 = (l9 * 256) / k15;
								int j22 = j13 / k16;
								int l22 = j14 / k16;
								j21 = this.method177(l21, j22, l22);
								l21 = (l21 + MapRegion.hueOffset) & 0xff;
								l22 += MapRegion.lightnessOffset;
								if (l22 < 0) {
									l22 = 0;
								} else if (l22 > 255) {
									l22 = 255;
								}
								k21 = this.method177(l21, j22, l22);
							}
							if (l > 0) {
								boolean flag = true;
								if ((l18 == 0) && (this.tileShape[l][l6][k17] != 0)) {
									flag = false;
								}
								if ((i19 > 0) && !Floor.cache[i19 - 1].occlude) {
									flag = false;
								}
								if (flag && (j19 == k19) && (j19 == l19) && (j19 == i20)) {
									this.tileCullingBitmap[l][l6][k17] |= 0x924;
								}
							}
							int i22 = 0;
							if (j21 != -1) {
								i22 = Rasterizer.anIntArray1482[MapRegion.method187(k21, 96)];
							}
							if (i19 == 0) {
								sceneGraph.method279(l, l6, k17, 0, 0, -1, j19, k19, l19, i20, MapRegion.method187(j21, j20), MapRegion.method187(j21, k20), MapRegion.method187(j21, l20), MapRegion.method187(j21, i21), 0, 0, 0, 0, i22, 0);
							} else {
								int k22 = this.tileShape[l][l6][k17] + 1;
								byte byte4 = this.tileShapeRotation[l][l6][k17];
								Floor flo_2 = Floor.cache[i19 - 1];
								int i23 = flo_2.texture;
								int j23;
								int k23;
								if (i23 >= 0) {
									k23 = Rasterizer.method369(i23);
									j23 = -1;
								} else if (flo_2.colourTwo == 0xff00ff) {
									k23 = 0;
									j23 = -2;
									i23 = -1;
								} else {
									j23 = this.method177(flo_2.hue, flo_2.saturation, flo_2.lightness);
									k23 = Rasterizer.anIntArray1482[this.method185(flo_2.anInt399, 96)];
								}
								sceneGraph.method279(l, l6, k17, k22, byte4, i23, j19, k19, l19, i20, MapRegion.method187(j21, j20), MapRegion.method187(j21, k20), MapRegion.method187(j21, l20), MapRegion.method187(j21, i21), this.method185(j23, j20), this.method185(j23, k20), this.method185(j23, l20), this.method185(j23, i21), i22, k23);
							}
						}
					}
				}
			}
		}
		for (int j8 = 1; j8 < (this.yMapSize - 1); j8++) {
			for (int i10 = 1; i10 < (this.xMapSize - 1); i10++) {
				sceneGraph.method278(l, i10, j8, this.method182(j8, l, i10));
			}
		}
		}
		sceneGraph.method305(-10, -50, -50);
		for (int j1 = 0; j1 < this.xMapSize; j1++) {
			for (int l1 = 0; l1 < this.yMapSize; l1++) {
				if ((this.tileSettings[1][j1][l1] & 2) == 2) {
					sceneGraph.method276(l1, j1);
				}
			}
		}
		int i2 = 1;
		int j2 = 2;
		int k2 = 4;
		for (int l2 = 0; l2 < 4; l2++) {
			if (l2 > 0) {
				i2 <<= 3;
				j2 <<= 3;
				k2 <<= 3;
			}
			for (int i3 = 0; i3 <= l2; i3++) {
				for (int k3 = 0; k3 <= this.yMapSize; k3++) {
					for (int i4 = 0; i4 <= this.xMapSize; i4++) {
						if ((this.tileCullingBitmap[i3][i4][k3] & i2) != 0) {
							int k4 = k3;
							int l5 = k3;
							int i7 = i3;
							int k8 = i3;
							for (; (k4 > 0) && ((this.tileCullingBitmap[i3][i4][k4 - 1] & i2) != 0); k4--) {
								;
							}
							for (; (l5 < this.yMapSize) && ((this.tileCullingBitmap[i3][i4][l5 + 1] & i2) != 0); l5++) {
								;
							}
							label0:
								for (; i7 > 0; i7--) {
									for (int j10 = k4; j10 <= l5; j10++) {
										if ((this.tileCullingBitmap[i7 - 1][i4][j10] & i2) == 0) {
											break label0;
										}
									}
								}
							label1:
								for (; k8 < l2; k8++) {
									for (int k10 = k4; k10 <= l5; k10++) {
										if ((this.tileCullingBitmap[k8 + 1][i4][k10] & i2) == 0) {
											break label1;
										}
									}
								}
								int l10 = ((k8 + 1) - i7) * ((l5 - k4) + 1);
								if (l10 >= 8) {
									char c1 = '\360';
									int k14 = this.heightMap[k8][i4][k4] - c1;
									int l15 = this.heightMap[i7][i4][k4];
									SceneGraph.method277(l2, i4 * 128, l15, i4 * 128, (l5 * 128) + 128, k14, k4 * 128, 1);
									for (int l16 = i7; l16 <= k8; l16++) {
										for (int l17 = k4; l17 <= l5; l17++) {
											this.tileCullingBitmap[l16][i4][l17] &= ~i2;
										}
									}
								}
						}
						if ((this.tileCullingBitmap[i3][i4][k3] & j2) != 0) {
							int l4 = i4;
							int i6 = i4;
							int j7 = i3;
							int l8 = i3;
							for (; (l4 > 0) && ((this.tileCullingBitmap[i3][l4 - 1][k3] & j2) != 0); l4--) {
								;
							}
							for (; (i6 < this.xMapSize) && ((this.tileCullingBitmap[i3][i6 + 1][k3] & j2) != 0); i6++) {
								;
							}
							label2:
								for (; j7 > 0; j7--) {
									for (int i11 = l4; i11 <= i6; i11++) {
										if ((this.tileCullingBitmap[j7 - 1][i11][k3] & j2) == 0) {
											break label2;
										}
									}
								}
							label3:
								for (; l8 < l2; l8++) {
									for (int j11 = l4; j11 <= i6; j11++) {
										if ((this.tileCullingBitmap[l8 + 1][j11][k3] & j2) == 0) {
											break label3;
										}
									}
								}
								int k11 = ((l8 + 1) - j7) * ((i6 - l4) + 1);
								if (k11 >= 8) {
									char c2 = '\360';
									int l14 = this.heightMap[l8][l4][k3] - c2;
									int i16 = this.heightMap[j7][l4][k3];
									SceneGraph.method277(l2, l4 * 128, i16, (i6 * 128) + 128, k3 * 128, l14, k3 * 128, 2);
									for (int i17 = j7; i17 <= l8; i17++) {
										for (int i18 = l4; i18 <= i6; i18++) {
											this.tileCullingBitmap[i17][i18][k3] &= ~j2;
										}
									}
								}
						}
						if ((this.tileCullingBitmap[i3][i4][k3] & k2) != 0) {
							int i5 = i4;
							int j6 = i4;
							int k7 = k3;
							int i9 = k3;
							for (; (k7 > 0) && ((this.tileCullingBitmap[i3][i4][k7 - 1] & k2) != 0); k7--) {
								;
							}
							for (; (i9 < this.yMapSize) && ((this.tileCullingBitmap[i3][i4][i9 + 1] & k2) != 0); i9++) {
								;
							}
							label4:
								for (; i5 > 0; i5--) {
									for (int l11 = k7; l11 <= i9; l11++) {
										if ((this.tileCullingBitmap[i3][i5 - 1][l11] & k2) == 0) {
											break label4;
										}
									}
								}
							label5:
								for (; j6 < this.xMapSize; j6++) {
									for (int i12 = k7; i12 <= i9; i12++) {
										if ((this.tileCullingBitmap[i3][j6 + 1][i12] & k2) == 0) {
											break label5;
										}
									}
								}
								if ((((j6 - i5) + 1) * ((i9 - k7) + 1)) >= 4) {
									int j12 = this.heightMap[i3][i5][k7];
									SceneGraph.method277(l2, i5 * 128, j12, (j6 * 128) + 128, (i9 * 128) + 128, j12, k7 * 128, 4);
									for (int k13 = i5; k13 <= j6; k13++) {
										for (int i15 = k7; i15 <= i9; i15++) {
											this.tileCullingBitmap[i3][k13][i15] &= ~k2;
										}
									}
								}
						}
					}
				}
			}
		}
	}

	private static int method172(int i, int j) {
		int k = (MapRegion.method176(i + 45365, j + 0x16713, 4) - 128) + ((MapRegion.method176(i + 10294, j + 37821, 2) - 128) >> 1) + ((MapRegion.method176(i, j, 1) - 128) >> 2);
		k = (int)(k * 0.29999999999999999D) + 35;
		if (k < 10) {
			k = 10;
		} else if (k > 60) {
			k = 60;
		}
		return k;
	}

	public static void method173(Packet packet, OnDemandFetcher class42_sub1) {
		label0:
		{
		int i = -1;
		do {
			int j = packet.method422();
			if (j == 0) {
				break label0;
			}
			i += j;
			ObjectDef class46 = ObjectDef.forID(i);
			class46.method574(class42_sub1);
			do {
				int k = packet.method422();
				if (k == 0) {
					break;
				}
				packet.getUnsignedByte();
			} while (true);
		} while (true);
		}
	}

	public final void method174(int i, int j, int l, int i1) {
		for (int j1 = i; j1 <= (i + j); j1++) {
			for (int k1 = i1; k1 <= (i1 + l); k1++) {
				if ((k1 >= 0) && (k1 < this.xMapSize) && (j1 >= 0) && (j1 < this.yMapSize)) {
					this.objectShadowData[0][k1][j1] = 127;
					if ((k1 == i1) && (k1 > 0)) {
						this.heightMap[0][k1][j1] = this.heightMap[0][k1 - 1][j1];
					}
					if ((k1 == (i1 + l)) && (k1 < (this.xMapSize - 1))) {
						this.heightMap[0][k1][j1] = this.heightMap[0][k1 + 1][j1];
					}
					if ((j1 == i) && (j1 > 0)) {
						this.heightMap[0][k1][j1] = this.heightMap[0][k1][j1 - 1];
					}
					if ((j1 == (i + j)) && (j1 < (this.yMapSize - 1))) {
						this.heightMap[0][k1][j1] = this.heightMap[0][k1][j1 + 1];
					}
				}
			}
		}
	}

	private void method175(int i, SceneGraph sceneGraph, TileSetting tileSetting, int j, int k, int l, int i1, int j1) {
		if (MapRegion.lowMem && ((this.tileSettings[0][l][i] & 2) == 0)) {
			if ((this.tileSettings[k][l][i] & 0x10) != 0) {
				return;
			}
			if (this.method182(i, k, l) != MapRegion.anInt131) {
				return;
			}
		}
		if (k < MapRegion.setZ) {
			MapRegion.setZ = k;
		}
		int k1 = this.heightMap[k][l][i];
		int l1 = this.heightMap[k][l + 1][i];
		int i2 = this.heightMap[k][l + 1][i + 1];
		int j2 = this.heightMap[k][l][i + 1];
		int k2 = (k1 + l1 + i2 + j2) >> 2;
		ObjectDef class46 = ObjectDef.forID(i1);
		int l2 = l + (i << 7) + (i1 << 14) + 0x40000000;
		if (!class46.hasActions) {
			l2 += 0x80000000;
		}
		byte byte0 = (byte)((j1 << 6) + j);
		if (j == 22) {
			if (MapRegion.lowMem && !class46.hasActions && !class46.aBoolean736) {
				return;
			}
			Object obj;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj = class46.method578(22, j1, k1, l1, i2, j2, -1);
			} else {
				obj = new ObjectOnTile(i1, j1, 22, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method280(k, k2, i, ((Animable) (obj)), byte0, l2, l);
			if (class46.isUnwalkable && class46.hasActions && (tileSetting != null)) {
				tileSetting.method213(i, l);
			}
			return;
		}
		if ((j == 10) || (j == 11)) {
			Object obj1;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj1 = class46.method578(10, j1, k1, l1, i2, j2, -1);
			} else {
				obj1 = new ObjectOnTile(i1, j1, 10, l1, i2, k1, j2, class46.animationID, true);
			}
			if (obj1 != null) {
				int i5 = 0;
				if (j == 11) {
					i5 += 256;
				}
				int j4;
				int l4;
				if ((j1 == 1) || (j1 == 3)) {
					j4 = class46.sizeY;
					l4 = class46.sizeX;
				} else {
					j4 = class46.sizeX;
					l4 = class46.sizeY;
				}
				if (sceneGraph.method284(l2, byte0, k2, l4, ((Animable) (obj1)), j4, k, i5, i, l) && class46.aBoolean779) {
					Model model;
					if (obj1 instanceof Model) {
						model = (Model)obj1;
					} else {
						model = class46.method578(10, j1, k1, l1, i2, j2, -1);
					}
					if (model != null) {
						for (int j5 = 0; j5 <= j4; j5++) {
							for (int k5 = 0; k5 <= l4; k5++) {
								int l5 = model.diagonal2DAboveorigin / 4;
								if (l5 > 30) {
									l5 = 30;
								}
								if (l5 > this.objectShadowData[k][l + j5][i + k5]) {
									this.objectShadowData[k][l + j5][i + k5] = (byte)l5;
								}
							}
						}
					}
				}
			}
			if (class46.isUnwalkable && (tileSetting != null)) {
				tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, l, i, j1);
			}
			return;
		}
		if (j >= 12) {
			Object obj2;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj2 = class46.method578(j, j1, k1, l1, i2, j2, -1);
			} else {
				obj2 = new ObjectOnTile(i1, j1, j, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method284(l2, byte0, k2, 1, ((Animable) (obj2)), 1, k, 0, i, l);
			if ((j >= 12) && (j <= 17) && (j != 13) && (k > 0)) {
				this.tileCullingBitmap[k][l][i] |= 0x924;
			}
			if (class46.isUnwalkable && (tileSetting != null)) {
				tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, l, i, j1);
			}
			return;
		}
		if (j == 0) {
			Object obj3;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj3 = class46.method578(0, j1, k1, l1, i2, j2, -1);
			} else {
				obj3 = new ObjectOnTile(i1, j1, 0, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method282(MapRegion.bitValues[j1], ((Animable) (obj3)), l2, i, byte0, l, null, k2, 0, k);
			if (j1 == 0) {
				if (class46.aBoolean779) {
					this.objectShadowData[k][l][i] = 50;
					this.objectShadowData[k][l][i + 1] = 50;
				}
				if (class46.aBoolean764) {
					this.tileCullingBitmap[k][l][i] |= 0x249;
				}
			} else if (j1 == 1) {
				if (class46.aBoolean779) {
					this.objectShadowData[k][l][i + 1] = 50;
					this.objectShadowData[k][l + 1][i + 1] = 50;
				}
				if (class46.aBoolean764) {
					this.tileCullingBitmap[k][l][i + 1] |= 0x492;
				}
			} else if (j1 == 2) {
				if (class46.aBoolean779) {
					this.objectShadowData[k][l + 1][i] = 50;
					this.objectShadowData[k][l + 1][i + 1] = 50;
				}
				if (class46.aBoolean764) {
					this.tileCullingBitmap[k][l + 1][i] |= 0x249;
				}
			} else if (j1 == 3) {
				if (class46.aBoolean779) {
					this.objectShadowData[k][l][i] = 50;
					this.objectShadowData[k][l + 1][i] = 50;
				}
				if (class46.aBoolean764) {
					this.tileCullingBitmap[k][l][i] |= 0x492;
				}
			}
			if (class46.isUnwalkable && (tileSetting != null)) {
				tileSetting.method211(i, j1, l, j, class46.aBoolean757);
			}
			if (class46.anInt775 != 16) {
				sceneGraph.method290(i, class46.anInt775, l, k);
			}
			return;
		}
		if (j == 1) {
			Object obj4;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj4 = class46.method578(1, j1, k1, l1, i2, j2, -1);
			} else {
				obj4 = new ObjectOnTile(i1, j1, 1, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method282(MapRegion.highNybbleBitValues[j1], ((Animable) (obj4)), l2, i, byte0, l, null, k2, 0, k);
			if (class46.aBoolean779) {
				if (j1 == 0) {
					this.objectShadowData[k][l][i + 1] = 50;
				} else if (j1 == 1) {
					this.objectShadowData[k][l + 1][i + 1] = 50;
				} else if (j1 == 2) {
					this.objectShadowData[k][l + 1][i] = 50;
				} else if (j1 == 3) {
					this.objectShadowData[k][l][i] = 50;
				}
			}
			if (class46.isUnwalkable && (tileSetting != null)) {
				tileSetting.method211(i, j1, l, j, class46.aBoolean757);
			}
			return;
		}
		if (j == 2) {
			int i3 = (j1 + 1) & 3;
			Object obj11;
			Object obj12;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj11 = class46.method578(2, 4 + j1, k1, l1, i2, j2, -1);
				obj12 = class46.method578(2, i3, k1, l1, i2, j2, -1);
			} else {
				obj11 = new ObjectOnTile(i1, 4 + j1, 2, l1, i2, k1, j2, class46.animationID, true);
				obj12 = new ObjectOnTile(i1, i3, 2, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method282(MapRegion.bitValues[j1], ((Animable) (obj11)), l2, i, byte0, l, ((Animable) (obj12)), k2, MapRegion.bitValues[i3], k);
			if (class46.aBoolean764) {
				if (j1 == 0) {
					this.tileCullingBitmap[k][l][i] |= 0x249;
					this.tileCullingBitmap[k][l][i + 1] |= 0x492;
				} else if (j1 == 1) {
					this.tileCullingBitmap[k][l][i + 1] |= 0x492;
					this.tileCullingBitmap[k][l + 1][i] |= 0x249;
				} else if (j1 == 2) {
					this.tileCullingBitmap[k][l + 1][i] |= 0x249;
					this.tileCullingBitmap[k][l][i] |= 0x492;
				} else if (j1 == 3) {
					this.tileCullingBitmap[k][l][i] |= 0x492;
					this.tileCullingBitmap[k][l][i] |= 0x249;
				}
			}
			if (class46.isUnwalkable && (tileSetting != null)) {
				tileSetting.method211(i, j1, l, j, class46.aBoolean757);
			}
			if (class46.anInt775 != 16) {
				sceneGraph.method290(i, class46.anInt775, l, k);
			}
			return;
		}
		if (j == 3) {
			Object obj5;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj5 = class46.method578(3, j1, k1, l1, i2, j2, -1);
			} else {
				obj5 = new ObjectOnTile(i1, j1, 3, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method282(MapRegion.highNybbleBitValues[j1], ((Animable) (obj5)), l2, i, byte0, l, null, k2, 0, k);
			if (class46.aBoolean779) {
				if (j1 == 0) {
					this.objectShadowData[k][l][i + 1] = 50;
				} else if (j1 == 1) {
					this.objectShadowData[k][l + 1][i + 1] = 50;
				} else if (j1 == 2) {
					this.objectShadowData[k][l + 1][i] = 50;
				} else if (j1 == 3) {
					this.objectShadowData[k][l][i] = 50;
				}
			}
			if (class46.isUnwalkable && (tileSetting != null)) {
				tileSetting.method211(i, j1, l, j, class46.aBoolean757);
			}
			return;
		}
		if (j == 9) {
			Object obj6;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj6 = class46.method578(j, j1, k1, l1, i2, j2, -1);
			} else {
				obj6 = new ObjectOnTile(i1, j1, j, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method284(l2, byte0, k2, 1, ((Animable) (obj6)), 1, k, 0, i, l);
			if (class46.isUnwalkable && (tileSetting != null)) {
				tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, l, i, j1);
			}
			return;
		}
		if (class46.isModelSolid) {
			if (j1 == 1) {
				int j3 = j2;
				j2 = i2;
				i2 = l1;
				l1 = k1;
				k1 = j3;
			} else if (j1 == 2) {
				int k3 = j2;
				j2 = l1;
				l1 = k3;
				k3 = i2;
				i2 = k1;
				k1 = k3;
			} else if (j1 == 3) {
				int l3 = j2;
				j2 = k1;
				k1 = l1;
				l1 = i2;
				i2 = l3;
			}
		}
		if (j == 4) {
			Object obj7;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj7 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			} else {
				obj7 = new ObjectOnTile(i1, 0, 4, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method283(l2, i, j1 * 512, k, 0, k2, ((Animable) (obj7)), l, byte0, 0, MapRegion.bitValues[j1]);
			return;
		}
		if (j == 5) {
			int i4 = 16;
			int k4 = sceneGraph.method300(k, l, i);
			if (k4 > 0) {
				i4 = ObjectDef.forID((k4 >> 14) & 0x7fff).anInt775;
			}
			Object obj13;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj13 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			} else {
				obj13 = new ObjectOnTile(i1, 0, 4, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method283(l2, i, j1 * 512, k, MapRegion.faceXOffset[j1] * i4, k2, ((Animable) (obj13)), l, byte0, MapRegion.faceYOffset[j1] * i4, MapRegion.bitValues[j1]);
			return;
		}
		if (j == 6) {
			Object obj8;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj8 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			} else {
				obj8 = new ObjectOnTile(i1, 0, 4, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method283(l2, i, j1, k, 0, k2, ((Animable) (obj8)), l, byte0, 0, 256);
			return;
		}
		if (j == 7) {
			Object obj9;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj9 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			} else {
				obj9 = new ObjectOnTile(i1, 0, 4, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method283(l2, i, j1, k, 0, k2, ((Animable) (obj9)), l, byte0, 0, 512);
			return;
		}
		if (j == 8) {
			Object obj10;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj10 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			} else {
				obj10 = new ObjectOnTile(i1, 0, 4, l1, i2, k1, j2, class46.animationID, true);
			}
			sceneGraph.method283(l2, i, j1, k, 0, k2, ((Animable) (obj10)), l, byte0, 0, 768);
		}
	}

	private static int method176(int i, int j, int k) {
		int l = i / k;
		int i1 = i & (k - 1);
		int j1 = j / k;
		int k1 = j & (k - 1);
		int l1 = MapRegion.method186(l, j1);
		int i2 = MapRegion.method186(l + 1, j1);
		int j2 = MapRegion.method186(l, j1 + 1);
		int k2 = MapRegion.method186(l + 1, j1 + 1);
		int l2 = MapRegion.method184(l1, i2, i1, k);
		int i3 = MapRegion.method184(j2, k2, i1, k);
		return MapRegion.method184(l2, i3, k1, k);
	}

	private int method177(int i, int j, int k) {
		if (k > 179) {
			j /= 2;
		}
		if (k > 192) {
			j /= 2;
		}
		if (k > 217) {
			j /= 2;
		}
		if (k > 243) {
			j /= 2;
		}
		return ((i / 4) << 10) + ((j / 32) << 7) + (k / 2);
	}

	public static boolean method178(int i, int j)
	{
		ObjectDef class46 = ObjectDef.forID(i);
		if (j == 11) {
			j = 10;
		}
		if ((j >= 5) && (j <= 8)) {
			j = 4;
		}
		return class46.method577(j);
	}

	public void method179(int i, int j, TileSetting aclass11[], int l, int i1, byte abyte0[],
			int j1, int k1, int l1)
	{
		for (int i2 = 0; i2 < 8; i2++)
		{
			for (int j2 = 0; j2 < 8; j2++) {
				if (((l + i2) > 0) && ((l + i2) < 103) && ((l1 + j2) > 0) && ((l1 + j2) < 103)) {
					aclass11[k1].clipData[l + i2][l1 + j2] &= 0xfeffffff;
				}
			}

		}
		Packet packet = new Packet(abyte0);
		for (int l2 = 0; l2 < 4; l2++)
		{
			for (int i3 = 0; i3 < 64; i3++)
			{
				for (int j3 = 0; j3 < 64; j3++) {
					if ((l2 == i) && (i3 >= i1) && (i3 < (i1 + 8)) && (j3 >= j1) && (j3 < (j1 + 8))) {
						this.method181(l1 + MapUtility.getRotatedMapY(j3 & 7, j, i3 & 7), 0, packet, l + MapUtility.getRotatedMapX(j, j3 & 7, i3 & 7), k1, j, 0);
					} else {
						this.method181(-1, 0, packet, -1, 0, 0, 0);
					}
				}

			}

		}

	}

	public void method180(byte abyte0[], int i, int j, int k, int l, TileSetting aclass11[])
	{
		for (int i1 = 0; i1 < 4; i1++)
		{
			for (int j1 = 0; j1 < 64; j1++)
			{
				for (int k1 = 0; k1 < 64; k1++) {
					if (((j + j1) > 0) && ((j + j1) < 103) && ((i + k1) > 0) && ((i + k1) < 103)) {
						aclass11[i1].clipData[j + j1][i + k1] &= 0xfeffffff;
					}
				}

			}

		}

		Packet packet = new Packet(abyte0);
		for (int l1 = 0; l1 < 4; l1++)
		{
			for (int i2 = 0; i2 < 64; i2++)
			{
				for (int j2 = 0; j2 < 64; j2++) {
					this.method181(j2 + i, l, packet, i2 + j, l1, 0, k);
				}

			}

		}
	}

	private void method181(int i, int j, Packet packet, int k, int l, int i1,
			int k1)
	{
		if ((k >= 0) && (k < 104) && (i >= 0) && (i < 104))
		{
			this.tileSettings[l][k][i] = 0;
			do
			{
				int l1 = packet.getUnsignedByte();
				if (l1 == 0) {
					if (l == 0)
					{
						this.heightMap[0][k][i] = -MapRegion.method172(0xe3b7b + k + k1, 0x87cce + i + j) * 8;
						return;
					} else
					{
						this.heightMap[l][k][i] = this.heightMap[l - 1][k][i] - 240;
						return;
					}
				}
				if (l1 == 1)
				{
					int j2 = packet.getUnsignedByte();
					if (j2 == 1) {
						j2 = 0;
					}
					if (l == 0)
					{
						this.heightMap[0][k][i] = -j2 * 8;
						return;
					} else
					{
						this.heightMap[l][k][i] = this.heightMap[l - 1][k][i] - (j2 * 8);
						return;
					}
				}
				if (l1 <= 49)
				{
					this.overLay[l][k][i] = packet.getByte();
					this.tileShape[l][k][i] = (byte)((l1 - 2) / 4);
					this.tileShapeRotation[l][k][i] = (byte)(((l1 - 2) + i1) & 3);
				} else
					if (l1 <= 81) {
						this.tileSettings[l][k][i] = (byte)(l1 - 49);
					} else {
						this.underLay[l][k][i] = (byte)(l1 - 81);
					}
			} while (true);
		}
		do
		{
			int i2 = packet.getUnsignedByte();
			if (i2 == 0) {
				break;
			}
			if (i2 == 1)
			{
				packet.getUnsignedByte();
				return;
			}
			if (i2 <= 49) {
				packet.getUnsignedByte();
			}
		} while (true);
	}

	private int method182(int i, int j, int k)
	{
		if ((this.tileSettings[j][k][i] & 8) != 0) {
			return 0;
		}
		if ((j > 0) && ((this.tileSettings[1][k][i] & 2) != 0)) {
			return j - 1;
		} else {
			return j;
		}
	}

	public final void method183(TileSetting aclass11[], SceneGraph sceneGraph, int i, int j, int k, int l,
			byte abyte0[], int i1, int j1, int k1)
	{
		label0:
		{
		Packet packet = new Packet(abyte0);
		int l1 = -1;
		do
		{
			int i2 = packet.method422();
			if (i2 == 0) {
				break label0;
			}
			l1 += i2;
			int j2 = 0;
			do
			{
				int k2 = packet.method422();
				if (k2 == 0) {
					break;
				}
				j2 += k2 - 1;
				int l2 = j2 & 0x3f;
				int i3 = (j2 >> 6) & 0x3f;
				int j3 = j2 >> 12;
		int k3 = packet.getUnsignedByte();
		int l3 = k3 >> 2;
		int i4 = k3 & 3;
		if ((j3 == i) && (i3 >= i1) && (i3 < (i1 + 8)) && (l2 >= k) && (l2 < (k + 8)))
		{
			ObjectDef class46 = ObjectDef.forID(l1);
			int j4 = j + MapUtility.getRotatedLandScapeX(j1, class46.sizeY, i3 & 7, l2 & 7, class46.sizeX);
			int k4 = k1 + MapUtility.getRotatedLandScapeY(l2 & 7, class46.sizeY, j1, class46.sizeX, i3 & 7);
			if ((j4 > 0) && (k4 > 0) && (j4 < 103) && (k4 < 103))
			{
				int l4 = j3;
				if ((this.tileSettings[1][j4][k4] & 2) == 2) {
					l4--;
				}
				TileSetting tileSetting = null;
				if (l4 >= 0) {
					tileSetting = aclass11[l4];
				}
				this.method175(k4, sceneGraph, tileSetting, l3, l, j4, l1, (i4 + j1) & 3);
			}
		}
			} while (true);
		} while (true);
		}
	}

	private static int method184(int i, int j, int k, int l)
	{
		int i1 = (0x10000 - Rasterizer.anIntArray1471[(k * 1024) / l]) >> 1;
			return ((i * (0x10000 - i1)) >> 16) + ((j * i1) >> 16);
	}

	private int method185(int i, int j)
	{
		if (i == -2) {
			return 0xbc614e;
		}
		if (i == -1)
		{
			if (j < 0) {
				j = 0;
			} else
				if (j > 127) {
					j = 127;
				}
			j = 127 - j;
			return j;
		}
		j = (j * (i & 0x7f)) / 128;
		if (j < 2) {
			j = 2;
		} else
			if (j > 126) {
				j = 126;
			}
		return (i & 0xff80) + j;
	}

	private static int method186(int i, int j)
	{
		int k = MapRegion.method170(i - 1, j - 1) + MapRegion.method170(i + 1, j - 1) + MapRegion.method170(i - 1, j + 1) + MapRegion.method170(i + 1, j + 1);
		int l = MapRegion.method170(i - 1, j) + MapRegion.method170(i + 1, j) + MapRegion.method170(i, j - 1) + MapRegion.method170(i, j + 1);
		int i1 = MapRegion.method170(i, j);
		return (k / 16) + (l / 8) + (i1 / 4);
	}

	private static int method187(int i, int j) {
		if (i == -1) {
			return 0xbc614e;
		}
		j = (j * (i & 0x7f)) / 128;
		if (j < 2) {
			j = 2;
		} else if (j > 126) {
			j = 126;
		}
		return (i & 0xff80) + j;
	}

	public static void method188(SceneGraph sceneGraph, int i, int j, int k, int l, TileSetting tileSetting, int ai[][][], int i1, int j1, int k1) {
		int l1 = ai[l][i1][j];
		int i2 = ai[l][i1 + 1][j];
		int j2 = ai[l][i1 + 1][j + 1];
		int k2 = ai[l][i1][j + 1];
		int l2 = (l1 + i2 + j2 + k2) >> 2;
		ObjectDef class46 = ObjectDef.forID(j1);
		int i3 = i1 + (j << 7) + (j1 << 14) + 0x40000000;
		if (!class46.hasActions) {
			i3 += 0x80000000;
		}
		byte byte1 = (byte)((i << 6) + k);
		if (k == 22) {
			Object obj;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj = class46.method578(22, i, l1, i2, j2, k2, -1);
			} else {
				obj = new ObjectOnTile(j1, i, 22, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method280(k1, l2, j, ((Animable) (obj)), byte1, i3, i1);
			if (class46.isUnwalkable && class46.hasActions) {
				tileSetting.method213(j, i1);
			}
			return;
		}
		if ((k == 10) || (k == 11)) {
			Object obj1;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj1 = class46.method578(10, i, l1, i2, j2, k2, -1);
			} else {
				obj1 = new ObjectOnTile(j1, i, 10, i2, j2, l1, k2, class46.animationID, true);
			}
			if (obj1 != null) {
				int j5 = 0;
				if (k == 11) {
					j5 += 256;
				}
				int k4;
				int i5;
				if ((i == 1) || (i == 3)) {
					k4 = class46.sizeY;
					i5 = class46.sizeX;
				} else {
					k4 = class46.sizeX;
					i5 = class46.sizeY;
				}
				sceneGraph.method284(i3, byte1, l2, i5, ((Animable) (obj1)), k4, k1, j5, j, i1);
			}
			if (class46.isUnwalkable) {
				tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, i1, j, i);
			}
			return;
		}
		if (k >= 12) {
			Object obj2;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj2 = class46.method578(k, i, l1, i2, j2, k2, -1);
			} else {
				obj2 = new ObjectOnTile(j1, i, k, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method284(i3, byte1, l2, 1, ((Animable) (obj2)), 1, k1, 0, j, i1);
			if (class46.isUnwalkable) {
				tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, i1, j, i);
			}
			return;
		}
		if (k == 0) {
			Object obj3;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj3 = class46.method578(0, i, l1, i2, j2, k2, -1);
			} else {
				obj3 = new ObjectOnTile(j1, i, 0, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method282(MapRegion.bitValues[i], ((Animable) (obj3)), i3, j, byte1, i1, null, l2, 0, k1);
			if (class46.isUnwalkable) {
				tileSetting.method211(j, i, i1, k, class46.aBoolean757);
			}
			return;
		}
		if (k == 1) {
			Object obj4;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj4 = class46.method578(1, i, l1, i2, j2, k2, -1);
			} else {
				obj4 = new ObjectOnTile(j1, i, 1, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method282(MapRegion.highNybbleBitValues[i], ((Animable) (obj4)), i3, j, byte1, i1, null, l2, 0, k1);
			if (class46.isUnwalkable) {
				tileSetting.method211(j, i, i1, k, class46.aBoolean757);
			}
			return;
		}
		if (k == 2) {
			int j3 = (i + 1) & 3;
			Object obj11;
			Object obj12;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj11 = class46.method578(2, 4 + i, l1, i2, j2, k2, -1);
				obj12 = class46.method578(2, j3, l1, i2, j2, k2, -1);
			} else {
				obj11 = new ObjectOnTile(j1, 4 + i, 2, i2, j2, l1, k2, class46.animationID, true);
				obj12 = new ObjectOnTile(j1, j3, 2, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method282(MapRegion.bitValues[i], ((Animable) (obj11)), i3, j, byte1, i1, ((Animable) (obj12)), l2, MapRegion.bitValues[j3], k1);
			if (class46.isUnwalkable) {
				tileSetting.method211(j, i, i1, k, class46.aBoolean757);
			}
			return;
		}
		if (k == 3) {
			Object obj5;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj5 = class46.method578(3, i, l1, i2, j2, k2, -1);
			} else {
				obj5 = new ObjectOnTile(j1, i, 3, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method282(MapRegion.highNybbleBitValues[i], ((Animable) (obj5)), i3, j, byte1, i1, null, l2, 0, k1);
			if (class46.isUnwalkable) {
				tileSetting.method211(j, i, i1, k, class46.aBoolean757);
			}
			return;
		}
		if (k == 9) {
			Object obj6;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj6 = class46.method578(k, i, l1, i2, j2, k2, -1);
			} else {
				obj6 = new ObjectOnTile(j1, i, k, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method284(i3, byte1, l2, 1, ((Animable) (obj6)), 1, k1, 0, j, i1);
			if (class46.isUnwalkable) {
				tileSetting.method212(class46.aBoolean757, class46.sizeX, class46.sizeY, i1, j, i);
			}
			return;
		}
		if (class46.isModelSolid) {
			if (i == 1) {
				int k3 = k2;
				k2 = j2;
				j2 = i2;
				i2 = l1;
				l1 = k3;
			} else if (i == 2) {
				int l3 = k2;
				k2 = i2;
				i2 = l3;
				l3 = j2;
				j2 = l1;
				l1 = l3;
			} else if (i == 3) {
				int i4 = k2;
				k2 = l1;
				l1 = i2;
				i2 = j2;
				j2 = i4;
			}
		}
		if (k == 4) {
			Object obj7;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj7 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			} else {
				obj7 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method283(i3, j, i * 512, k1, 0, l2, ((Animable) (obj7)), i1, byte1, 0, MapRegion.bitValues[i]);
			return;
		}
		if (k == 5) {
			int j4 = 16;
			int l4 = sceneGraph.method300(k1, i1, j);
			if (l4 > 0) {
				j4 = ObjectDef.forID((l4 >> 14) & 0x7fff).anInt775;
			}
			Object obj13;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj13 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			} else {
				obj13 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method283(i3, j, i * 512, k1, MapRegion.faceXOffset[i] * j4, l2, ((Animable) (obj13)), i1, byte1, MapRegion.faceYOffset[i] * j4, MapRegion.bitValues[i]);
			return;
		}
		if (k == 6) {
			Object obj8;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj8 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			} else {
				obj8 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method283(i3, j, i, k1, 0, l2, ((Animable) (obj8)), i1, byte1, 0, 256);
			return;
		}
		if (k == 7) {
			Object obj9;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj9 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			} else {
				obj9 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method283(i3, j, i, k1, 0, l2, ((Animable) (obj9)), i1, byte1, 0, 512);
			return;
		}
		if (k == 8) {
			Object obj10;
			if ((class46.animationID == -1) && (class46.childrenIDs == null)) {
				obj10 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			} else {
				obj10 = new ObjectOnTile(j1, 0, 4, i2, j2, l1, k2, class46.animationID, true);
			}
			sceneGraph.method283(i3, j, i, k1, 0, l2, ((Animable) (obj10)), i1, byte1, 0, 768);
		}
	}

	public static boolean method189(int i, byte[] is, int i_250_) { /** Bad method. */
		boolean bool = true;
		Packet packet = new Packet(is);
		int i_252_ = -1;
		for (;;) {
			int i_253_ = packet.method422 ();
			if (i_253_ == 0) {
				break;
			}
			i_252_ += i_253_;
			int i_254_ = 0;
			boolean bool_255_ = false;
			for (;;) {
				if (bool_255_) {
					int i_256_ = packet.method422 ();
					if (i_256_ == 0) {
						break;
					}
					packet.getUnsignedByte();
				} else {
					int i_257_ = packet.method422 ();
					if (i_257_ == 0) {
						break;
					}
					i_254_ += i_257_ - 1;
					int i_258_ = i_254_ & 0x3f;
					int i_259_ = (i_254_ >> 6) & 0x3f;
					int i_260_ = packet.getUnsignedByte() >> 2;
		int i_261_ = i_259_ + i;
		int i_262_ = i_258_ + i_250_;
		if ((i_261_ > 0) && (i_262_ > 0) && (i_261_ < 103) && (i_262_ < 103)) {
			ObjectDef class46 = ObjectDef.forID (i_252_);
			if ((i_260_ != 22) || !MapRegion.lowMem || class46.hasActions || class46.aBoolean736) {
				bool &= class46.method579 ();
				bool_255_ = true;
			}
		}
				}
			}
		}
		return bool;
	}

	public final void method190(int i, TileSetting aclass11[], int j, SceneGraph sceneGraph, byte abyte0[]) {
		label0:
		{
		Packet packet = new Packet(abyte0);
		int l = -1;
		do {
			int i1 = packet.method422();
			if (i1 == 0) {
				break label0;
			}
			l += i1;
			int j1 = 0;
			do {
				int k1 = packet.method422();
				if (k1 == 0) {
					break;
				}
				j1 += k1 - 1;
				int l1 = j1 & 0x3f;
				int i2 = (j1 >> 6) & 0x3f;
				int j2 = j1 >> 12;
								int k2 = packet.getUnsignedByte();
								int l2 = k2 >> 2;
				int i3 = k2 & 3;
				int j3 = i2 + i;
				int k3 = l1 + j;
				if ((j3 > 0) && (k3 > 0) && (j3 < 103) && (k3 < 103)) {
					int l3 = j2;
					if ((this.tileSettings[1][j3][k3] & 2) == 2) {
						l3--;
					}
					TileSetting tileSetting = null;
					if (l3 >= 0) {
						tileSetting = aclass11[l3];
					}
					this.method175(k3, sceneGraph, tileSetting, l2, j2, j3, l, i3);
				}
			} while (true);
		} while (true);
		}
	}

	private static int hueOffset  = (int) (Math.random() * 17D) - 8;
	private int[] hue;
	private int[] saturation;
	private int[] lightness;
	private int[] hueDivider;
	private int[] colourCount;
	private int[][][] heightMap;
	private byte[][][] overLay;
	public static int anInt131;
	private static int lightnessOffset = (int) (Math.random() * 33D) - 16;
	private byte[][][] objectShadowData;
	private int[][][] tileCullingBitmap;
	private byte[][][] tileShape;
	private static int faceXOffset[] = {
		1, 0, -1, 0
	};
	private int[][] tileLightness;
	private static int highNybbleBitValues[] = {
		16, 32, 64, 128
	};
	private byte[][][] underLay;
	private static int faceYOffset[] = {
		0, -1, 0, 1
	};
	public static int setZ = 99;
	private int xMapSize;
	private int yMapSize;
	private byte[][][] tileShapeRotation;
	private byte[][][] tileSettings;
	public static boolean lowMem = true;
	private static int bitValues[] = {
		1, 2, 4, 8
	};
}