package com.netty.game.model;

import com.netty.game.graphics.DrawingArea;
import com.netty.game.graphics.texture.Rasterizer;
import com.netty.net.cache.OnDemandFetcher;
import com.netty.net.packet.Packet;
import com.netty.stuff.Animable;
import com.netty.stuff.Animation;
import com.netty.stuff.ModelTransform;
import com.netty.stuff.VertexNormal;

public class Model extends Animable {

	public static void clearCache() {
		Model.modelHeaderCache = null;
		Model.aBooleanArray1663 = null;
		Model.aBooleanArray1664 = null;
		Model.vertexSX = null;
		Model.vertexSY = null;
		Model.depthBuffer = null;
		Model.vertexMvX = null;
		Model.vertexMvY = null;
		Model.vertexMvZ = null;
		Model.depthListIndices = null;
		Model.faceLists = null;
		Model.anIntArray1673 = null;
		Model.anIntArrayArray1674 = null;
		Model.anIntArray1675 = null;
		Model.anIntArray1676 = null;
		Model.anIntArray1677 = null;
		Model.sine = null;
		Model.cosine = null;
		Model.hsl2RGB = null;
		Model.modelIntArray4 = null;
	}

	public static void initialize(int i, OnDemandFetcher onDemandFetcher) {
		Model.modelHeaderCache = new ModelHeader[i];
		Model.aOnDemandFetcher = onDemandFetcher;
	}

	public static void readHeader(byte abyte0[], int j) {
		if (abyte0 == null) {
			ModelHeader modelHeader = Model.modelHeaderCache[j] = new ModelHeader();
			modelHeader.modelVerticeCount = 0;
			modelHeader.modelTriangleCount = 0;
			modelHeader.modelTextureTriangleCount = 0;
			return;
		}
		Packet packet = new Packet(abyte0);
		packet.setPosition(abyte0.length - 18);
		ModelHeader class21_1 = Model.modelHeaderCache[j] = new ModelHeader();
		class21_1.modelData = abyte0;
		class21_1.modelVerticeCount = packet.getUnsignedShort();
		class21_1.modelTriangleCount = packet.getUnsignedShort();
		class21_1.modelTextureTriangleCount = packet.getUnsignedByte();
		int k = packet.getUnsignedByte();
		int l = packet.getUnsignedByte();
		int i1 = packet.getUnsignedByte();
		int j1 = packet.getUnsignedByte();
		int k1 = packet.getUnsignedByte();
		int l1 = packet.getUnsignedShort();
		int i2 = packet.getUnsignedShort();
		int j2 = packet.getUnsignedShort();
		int k2 = packet.getUnsignedShort();
		int l2 = 0;
		class21_1.vertexModOffset = l2;
		l2 += class21_1.modelVerticeCount;
		class21_1.triMeshLinkOffset = l2;
		l2 += class21_1.modelTriangleCount;
		class21_1.facePriorityBasePos = l2;
		if (l == 255) {
			l2 += class21_1.modelTriangleCount;
		} else {
			class21_1.facePriorityBasePos = -l - 1;
		}
		class21_1.tskinBasepos = l2;
		if (j1 == 1) {
			l2 += class21_1.modelTriangleCount;
		} else {
			class21_1.tskinBasepos = -1;
		}
		class21_1.drawTypeBasePos = l2;
		if (k == 1) {
			l2 += class21_1.modelTriangleCount;
		} else {
			class21_1.drawTypeBasePos = -1;
		}
		class21_1.vskinBasePos = l2;
		if (k1 == 1) {
			l2 += class21_1.modelVerticeCount;
		} else {
			class21_1.vskinBasePos = -1;
		}
		class21_1.alphaBasepos = l2;
		if (i1 == 1) {
			l2 += class21_1.modelTriangleCount;
		} else {
			class21_1.alphaBasepos = -1;
		}
		class21_1.triVPointOffset = l2;
		l2 += k2;
		class21_1.triColourOffset = l2;
		l2 += class21_1.modelTriangleCount * 2;
		class21_1.textureInfoBasePos = l2;
		l2 += class21_1.modelTextureTriangleCount * 6;
		class21_1.vertexXOffset = l2;
		l2 += l1;
		class21_1.vertexYOffset = l2;
		l2 += i2;
		class21_1.vertexZOffset = l2;
		l2 += j2;
	}

	public static void method461(int j) {
		Model.modelHeaderCache[j] = null;
	}

	public static Model method462(int j) {
		if (Model.modelHeaderCache == null) {
			return null;
		}
		ModelHeader modelHeader = Model.modelHeaderCache[j];
		if (modelHeader == null) {
			Model.aOnDemandFetcher.method548(j);
			return null;
		}
		return new Model(j);
	}

	public static boolean method463(int i) {
		if (Model.modelHeaderCache == null) {
			return false;
		}
		ModelHeader modelHeader = Model.modelHeaderCache[i];
		if (modelHeader == null) {
			Model.aOnDemandFetcher.method548(i);
			return false;
		}
		return true;
	}

	private Model() {
		this.oneSquareModel = false;
	}

	private Model(int i) {
		this.oneSquareModel = false;
		ModelHeader modelHeader = Model.modelHeaderCache[i];
		this.vertexCount = modelHeader.modelVerticeCount;
		this.triangleCount = modelHeader.modelTriangleCount;
		this.textureTriangleCount = modelHeader.modelTextureTriangleCount;
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		this.triangleA = new int[this.triangleCount];
		this.triangleB = new int[this.triangleCount];
		this.triangleC = new int[this.triangleCount];
		this.triPIndex = new int[this.textureTriangleCount];
		this.triMIndex = new int[this.textureTriangleCount];
		this.triNIndex = new int[this.textureTriangleCount];
		if (modelHeader.vskinBasePos >= 0) {
			this.vertexVSkin = new int[this.vertexCount];
		}
		if (modelHeader.drawTypeBasePos >= 0) {
			this.triangleDrawType = new int[this.triangleCount];
		}
		if (modelHeader.facePriorityBasePos >= 0) {
			this.facePriority = new int[this.triangleCount];
		} else {
			this.anInt1641 = -modelHeader.facePriorityBasePos - 1;
		}
		if (modelHeader.alphaBasepos >= 0) {
			this.triangleAlpha = new int[this.triangleCount];
		}
		if (modelHeader.tskinBasepos >= 0) {
			this.triangleTSkin = new int[this.triangleCount];
		}
		this.triangleColour = new int[this.triangleCount];
		Packet packet = new Packet(modelHeader.modelData);
		packet.setPosition(modelHeader.vertexModOffset);
		Packet stream_1 = new Packet(modelHeader.modelData);
		stream_1.setPosition(modelHeader.vertexXOffset);
		Packet stream_2 = new Packet(modelHeader.modelData);
		stream_2.setPosition(modelHeader.vertexYOffset);
		Packet stream_3 = new Packet(modelHeader.modelData);
		stream_3.setPosition(modelHeader.vertexZOffset);
		Packet stream_4 = new Packet(modelHeader.modelData);
		stream_4.setPosition(modelHeader.vskinBasePos);
		int k = 0;
		int l = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < this.vertexCount; j1++) {
			int k1 = packet.getUnsignedByte();
			int i2 = 0;
			if ((k1 & 1) != 0) {
				i2 = stream_1.method421();
			}
			int k2 = 0;
			if ((k1 & 2) != 0) {
				k2 = stream_2.method421();
			}
			int i3 = 0;
			if ((k1 & 4) != 0) {
				i3 = stream_3.method421();
			}
			this.vertexX[j1] = k + i2;
			this.vertexY[j1] = l + k2;
			this.vertexZ[j1] = i1 + i3;
			k = this.vertexX[j1];
			l = this.vertexY[j1];
			i1 = this.vertexZ[j1];
			if (this.vertexVSkin != null) {
				this.vertexVSkin[j1] = stream_4.getUnsignedByte();
			}
		}
		packet.setPosition(modelHeader.triColourOffset);
		stream_1.setPosition(modelHeader.drawTypeBasePos);
		stream_2.setPosition(modelHeader.facePriorityBasePos);
		stream_3.setPosition(modelHeader.alphaBasepos);
		stream_4.setPosition(modelHeader.tskinBasepos);
		for (int l1 = 0; l1 < this.triangleCount; l1++) {
			this.triangleColour[l1] = packet.getUnsignedShort();
			if (this.triangleDrawType != null) {
				this.triangleDrawType[l1] = stream_1.getUnsignedByte();
			}
			if (this.facePriority != null) {
				this.facePriority[l1] = stream_2.getUnsignedByte();
			}
			if (this.triangleAlpha != null) {
				this.triangleAlpha[l1] = stream_3.getUnsignedByte();
			}
			if (this.triangleTSkin != null) {
				this.triangleTSkin[l1] = stream_4.getUnsignedByte();
			}
		}
		packet.setPosition(modelHeader.triVPointOffset);
		stream_1.setPosition(modelHeader.triMeshLinkOffset);
		int j2 = 0;
		int l2 = 0;
		int j3 = 0;
		int k3 = 0;
		for (int l3 = 0; l3 < this.triangleCount; l3++) {
			int i4 = stream_1.getUnsignedByte();
			if (i4 == 1) {
				j2 = packet.method421() + k3;
				k3 = j2;
				l2 = packet.method421() + k3;
				k3 = l2;
				j3 = packet.method421() + k3;
				k3 = j3;
				this.triangleA[l3] = j2;
				this.triangleB[l3] = l2;
				this.triangleC[l3] = j3;
			}
			if (i4 == 2) {
				l2 = j3;
				j3 = packet.method421() + k3;
				k3 = j3;
				this.triangleA[l3] = j2;
				this.triangleB[l3] = l2;
				this.triangleC[l3] = j3;
			}
			if (i4 == 3) {
				j2 = j3;
				j3 = packet.method421() + k3;
				k3 = j3;
				this.triangleA[l3] = j2;
				this.triangleB[l3] = l2;
				this.triangleC[l3] = j3;
			}
			if (i4 == 4) {
				int k4 = j2;
				j2 = l2;
				l2 = k4;
				j3 = packet.method421() + k3;
				k3 = j3;
				this.triangleA[l3] = j2;
				this.triangleB[l3] = l2;
				this.triangleC[l3] = j3;
			}
		}
		packet.setPosition(modelHeader.textureInfoBasePos);
		for (int j4 = 0; j4 < this.textureTriangleCount; j4++) {
			this.triPIndex[j4] = packet.getUnsignedShort();
			this.triMIndex[j4] = packet.getUnsignedShort();
			this.triNIndex[j4] = packet.getUnsignedShort();
		}
	}

	public Model(int i, Model aclass30_sub2_sub4_sub6s[]) {
		this.oneSquareModel = false;
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		this.vertexCount = 0;
		this.triangleCount = 0;
		this.textureTriangleCount = 0;
		this.anInt1641 = -1;
		for (int k = 0; k < i; k++) {
			Model model = aclass30_sub2_sub4_sub6s[k];
			if (model != null) {
				this.vertexCount += model.vertexCount;
				this.triangleCount += model.triangleCount;
				this.textureTriangleCount += model.textureTriangleCount;
				flag |= model.triangleDrawType != null;
				if(model.facePriority != null) {
					flag1 = true;
				} else {
					if (this.anInt1641 == -1) {
						this.anInt1641 = model.anInt1641;
					}
					if (this.anInt1641 != model.anInt1641) {
						flag1 = true;
					}
				}
				flag2 |= model.triangleAlpha != null;
				flag3 |= model.triangleTSkin != null;
			}
		}
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		this.vertexVSkin = new int[this.vertexCount];
		this.triangleA = new int[this.triangleCount];
		this.triangleB = new int[this.triangleCount];
		this.triangleC = new int[this.triangleCount];
		this.triPIndex = new int[this.textureTriangleCount];
		this.triMIndex = new int[this.textureTriangleCount];
		this.triNIndex = new int[this.textureTriangleCount];
		if (flag) {
			this.triangleDrawType = new int[this.triangleCount];
		}
		if (flag1) {
			this.facePriority = new int[this.triangleCount];
		}
		if (flag2) {
			this.triangleAlpha = new int[this.triangleCount];
		}
		if (flag3) {
			this.triangleTSkin = new int[this.triangleCount];
		}
		this.triangleColour = new int[this.triangleCount];
		this.vertexCount = 0;
		this.triangleCount = 0;
		this.textureTriangleCount = 0;
		int l = 0;
		for (int i1 = 0; i1 < i; i1++) {
			Model model_1 = aclass30_sub2_sub4_sub6s[i1];
			if (model_1 != null) {
				for (int j1 = 0; j1 < model_1.triangleCount; j1++) {
					if (flag) {
						if (model_1.triangleDrawType == null) {
							this.triangleDrawType[this.triangleCount] = 0;
						} else {
							int k1 = model_1.triangleDrawType[j1];
							if ((k1 & 2) == 2) {
								k1 += l << 2;
							}
							this.triangleDrawType[this.triangleCount] = k1;
						}
					}
					if (flag1) {
						if (model_1.facePriority == null) {
							this.facePriority[this.triangleCount] = model_1.anInt1641;
						} else {
							this.facePriority[this.triangleCount] = model_1.facePriority[j1];
						}
					}
					if (flag2) {
						if (model_1.triangleAlpha == null) {
							this.triangleAlpha[this.triangleCount] = 0;
						} else {
							this.triangleAlpha[this.triangleCount] = model_1.triangleAlpha[j1];
						}
					}
					if (flag3 && (model_1.triangleTSkin != null)) {
						this.triangleTSkin[this.triangleCount] = model_1.triangleTSkin[j1];
					}
					this.triangleColour[this.triangleCount] = model_1.triangleColour[j1];
					this.triangleA[this.triangleCount] = this.method465(model_1, model_1.triangleA[j1]);
					this.triangleB[this.triangleCount] = this.method465(model_1, model_1.triangleB[j1]);
					this.triangleC[this.triangleCount] = this.method465(model_1, model_1.triangleC[j1]);
					this.triangleCount++;
				}
				for (int l1 = 0; l1 < model_1.textureTriangleCount; l1++) {
					this.triPIndex[this.textureTriangleCount] = this.method465(model_1, model_1.triPIndex[l1]);
					this.triMIndex[this.textureTriangleCount] = this.method465(model_1, model_1.triMIndex[l1]);
					this.triNIndex[this.textureTriangleCount] = this.method465(model_1, model_1.triNIndex[l1]);
					this.textureTriangleCount++;
				}
				l += model_1.textureTriangleCount;
			}
		}
	}

	public Model(Model aclass30_sub2_sub4_sub6s[]) {
		int i = 2;
		this.oneSquareModel = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		this.vertexCount = 0;
		this.triangleCount = 0;
		this.textureTriangleCount = 0;
		this.anInt1641 = -1;
		for (int k = 0; k < i; k++) {
			Model model = aclass30_sub2_sub4_sub6s[k];
			if (model != null) {
				this.vertexCount += model.vertexCount;
				this.triangleCount += model.triangleCount;
				this.textureTriangleCount += model.textureTriangleCount;
				flag1 |= model.triangleDrawType != null;
				if (model.facePriority != null) {
					flag2 = true;
				} else {
					if (this.anInt1641 == -1) {
						this.anInt1641 = model.anInt1641;
					}
					if (this.anInt1641 != model.anInt1641) {
						flag2 = true;
					}
				}
				flag3 |= model.triangleAlpha != null;
				flag4 |= model.triangleColour != null;
			}
		}
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		this.triangleA = new int[this.triangleCount];
		this.triangleB = new int[this.triangleCount];
		this.triangleC = new int[this.triangleCount];
		this.triangleHSLA = new int[this.triangleCount];
		this.triangleHSLB = new int[this.triangleCount];
		this.triangleHSLC = new int[this.triangleCount];
		this.triPIndex = new int[this.textureTriangleCount];
		this.triMIndex = new int[this.textureTriangleCount];
		this.triNIndex = new int[this.textureTriangleCount];
		if (flag1) {
			this.triangleDrawType = new int[this.triangleCount];
		}
		if (flag2) {
			this.facePriority = new int[this.triangleCount];
		}
		if (flag3) {
			this.triangleAlpha = new int[this.triangleCount];
		}
		if (flag4) {
			this.triangleColour = new int[this.triangleCount];
		}
		this.vertexCount = 0;
		this.triangleCount = 0;
		this.textureTriangleCount = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < i; j1++) {
			Model model_1 = aclass30_sub2_sub4_sub6s[j1];
			if (model_1 != null) {
				int k1 = this.vertexCount;
				for (int l1 = 0; l1 < model_1.vertexCount; l1++) {
					this.vertexX[this.vertexCount] = model_1.vertexX[l1];
					this.vertexY[this.vertexCount] = model_1.vertexY[l1];
					this.vertexZ[this.vertexCount] = model_1.vertexZ[l1];
					this.vertexCount++;
				}
				for (int i2 = 0; i2 < model_1.triangleCount; i2++) {
					this.triangleA[this.triangleCount] = model_1.triangleA[i2] + k1;
					this.triangleB[this.triangleCount] = model_1.triangleB[i2] + k1;
					this.triangleC[this.triangleCount] = model_1.triangleC[i2] + k1;
					this.triangleHSLA[this.triangleCount] = model_1.triangleHSLA[i2];
					this.triangleHSLB[this.triangleCount] = model_1.triangleHSLB[i2];
					this.triangleHSLC[this.triangleCount] = model_1.triangleHSLC[i2];
					if (flag1) {
						if (model_1.triangleDrawType == null) {
							this.triangleDrawType[this.triangleCount] = 0;
						} else {
							int j2 = model_1.triangleDrawType[i2];
							if ((j2 & 2) == 2) {
								j2 += i1 << 2;
							}
							this.triangleDrawType[this.triangleCount] = j2;
						}
					}
					if (flag2) {
						if (model_1.facePriority == null) {
							this.facePriority[this.triangleCount] = model_1.anInt1641;
						} else {
							this.facePriority[this.triangleCount] = model_1.facePriority[i2];
						}
					}
					if (flag3) {
						if (model_1.triangleAlpha == null) {
							this.triangleAlpha[this.triangleCount] = 0;
						} else {
							this.triangleAlpha[this.triangleCount] = model_1.triangleAlpha[i2];
						}
					}
					if (flag4 && (model_1.triangleColour != null)) {
						this.triangleColour[this.triangleCount] = model_1.triangleColour[i2];
					}
					this.triangleCount++;
				}
				for (int k2 = 0; k2 < model_1.textureTriangleCount; k2++) {
					this.triPIndex[this.textureTriangleCount] = model_1.triPIndex[k2] + k1;
					this.triMIndex[this.textureTriangleCount] = model_1.triMIndex[k2] + k1;
					this.triNIndex[this.textureTriangleCount] = model_1.triNIndex[k2] + k1;
					this.textureTriangleCount++;
				}
				i1 += model_1.textureTriangleCount;
			}
		}
		this.method466();
	}

	public Model(boolean flag, boolean flag1, boolean flag2, Model model) {
		this.oneSquareModel = false;
		this.vertexCount = model.vertexCount;
		this.triangleCount = model.triangleCount;
		this.textureTriangleCount = model.textureTriangleCount;
		if (flag2) {
			this.vertexX = model.vertexX;
			this.vertexY = model.vertexY;
			this.vertexZ = model.vertexZ;
		} else {
			this.vertexX = new int[this.vertexCount];
			this.vertexY = new int[this.vertexCount];
			this.vertexZ = new int[this.vertexCount];
			for (int j = 0; j < this.vertexCount; j++) {
				this.vertexX[j] = model.vertexX[j];
				this.vertexY[j] = model.vertexY[j];
				this.vertexZ[j] = model.vertexZ[j];
			}
		}
		if (flag) {
			this.triangleColour = model.triangleColour;
		} else {
			this.triangleColour = new int[this.triangleCount];
			System.arraycopy(model.triangleColour, 0, this.triangleColour, 0, this.triangleCount);

		}
		if (flag1) {
			this.triangleAlpha = model.triangleAlpha;
		} else {
			this.triangleAlpha = new int[this.triangleCount];
			if (model.triangleAlpha == null) {
				for (int l = 0; l < this.triangleCount; l++) {
					this.triangleAlpha[l] = 0;
				}
			} else {
				System.arraycopy(model.triangleAlpha, 0, this.triangleAlpha, 0, this.triangleCount);

			}
		}
		this.vertexVSkin = model.vertexVSkin;
		this.triangleTSkin = model.triangleTSkin;
		this.triangleDrawType = model.triangleDrawType;
		this.triangleA = model.triangleA;
		this.triangleB = model.triangleB;
		this.triangleC = model.triangleC;
		this.facePriority = model.facePriority;
		this.anInt1641 = model.anInt1641;
		this.triPIndex = model.triPIndex;
		this.triMIndex = model.triMIndex;
		this.triNIndex = model.triNIndex;
	}

	public Model(boolean flag, boolean flag1, Model model) {
		this.oneSquareModel = false;
		this.vertexCount = model.vertexCount;
		this.triangleCount = model.triangleCount;
		this.textureTriangleCount = model.textureTriangleCount;
		if (flag) {
			this.vertexY = new int[this.vertexCount];
			System.arraycopy(model.vertexY, 0, this.vertexY, 0, this.vertexCount);

		} else {
			this.vertexY = model.vertexY;
		}
		if (flag1) {
			this.triangleHSLA = new int[this.triangleCount];
			this.triangleHSLB = new int[this.triangleCount];
			this.triangleHSLC = new int[this.triangleCount];
			for (int k = 0; k < this.triangleCount; k++) {
				this.triangleHSLA[k] = model.triangleHSLA[k];
				this.triangleHSLB[k] = model.triangleHSLB[k];
				this.triangleHSLC[k] = model.triangleHSLC[k];
			}
			this.triangleDrawType = new int[this.triangleCount];
			if (model.triangleDrawType == null) {
				for (int l = 0; l < this.triangleCount; l++) {
					this.triangleDrawType[l] = 0;
				}
			} else {
				System.arraycopy(model.triangleDrawType, 0, this.triangleDrawType, 0, this.triangleCount);

			}
			super.vertexNormals = new VertexNormal[this.vertexCount];
			for (int j1 = 0; j1 < this.vertexCount; j1++) {
				VertexNormal vertexNormal = super.vertexNormals[j1] = new VertexNormal();
				VertexNormal class33_1 = model.vertexNormals[j1];
				vertexNormal.x = class33_1.x;
				vertexNormal.y = class33_1.y;
				vertexNormal.z = class33_1.z;
				vertexNormal.magnitude = class33_1.magnitude;
			}
			this.vertexNormalOffset = model.vertexNormalOffset;
		} else {
			this.triangleHSLA = model.triangleHSLA;
			this.triangleHSLB = model.triangleHSLB;
			this.triangleHSLC = model.triangleHSLC;
			this.triangleDrawType = model.triangleDrawType;
		}
		this.vertexX = model.vertexX;
		this.vertexZ = model.vertexZ;
		this.triangleColour = model.triangleColour;
		this.triangleAlpha = model.triangleAlpha;
		this.facePriority = model.facePriority;
		this.anInt1641 = model.anInt1641;
		this.triangleA = model.triangleA;
		this.triangleB = model.triangleB;
		this.triangleC = model.triangleC;
		this.triPIndex = model.triPIndex;
		this.triMIndex = model.triMIndex;
		this.triNIndex = model.triNIndex;
		super.modelHeight = model.modelHeight;
		this.maxY = model.maxY;
		this.diagonal2DAboveorigin = model.diagonal2DAboveorigin;
		this.diagonal3DAboveorigin = model.diagonal3DAboveorigin;
		this.diagonal3D = model.diagonal3D;
		this.minX = model.minX;
		this.maxZ = model.maxZ;
		this.minZ = model.minZ;
		this.maxX = model.maxX;
	}

	public void method464(Model model, boolean flag) {
		this.vertexCount = model.vertexCount;
		this.triangleCount = model.triangleCount;
		this.textureTriangleCount = model.textureTriangleCount;
		if (Model.anIntArray1622.length < this.vertexCount) {
			Model.anIntArray1622 = new int[this.vertexCount + 100];
			Model.anIntArray1623 = new int[this.vertexCount + 100];
			Model.anIntArray1624 = new int[this.vertexCount + 100];
		}
		this.vertexX = Model.anIntArray1622;
		this.vertexY = Model.anIntArray1623;
		this.vertexZ = Model.anIntArray1624;
		for (int k = 0; k < this.vertexCount; k++) {
			this.vertexX[k] = model.vertexX[k];
			this.vertexY[k] = model.vertexY[k];
			this.vertexZ[k] = model.vertexZ[k];
		}
		if (flag) {
			this.triangleAlpha = model.triangleAlpha;
		} else {
			if (Model.anIntArray1625.length < this.triangleCount) {
				Model.anIntArray1625 = new int[this.triangleCount + 100];
			}
			this.triangleAlpha = Model.anIntArray1625;
			if (model.triangleAlpha == null) {
				for (int l = 0; l < this.triangleCount; l++) {
					this.triangleAlpha[l] = 0;
				}
			} else {
				System.arraycopy(model.triangleAlpha, 0, this.triangleAlpha, 0, this.triangleCount);

			}
		}
		this.triangleDrawType = model.triangleDrawType;
		this.triangleColour = model.triangleColour;
		this.facePriority = model.facePriority;
		this.anInt1641 = model.anInt1641;
		this.triangleSkin = model.triangleSkin;
		this.vertexSkin = model.vertexSkin;
		this.triangleA = model.triangleA;
		this.triangleB = model.triangleB;
		this.triangleC = model.triangleC;
		this.triangleHSLA = model.triangleHSLA;
		this.triangleHSLB = model.triangleHSLB;
		this.triangleHSLC = model.triangleHSLC;
		this.triPIndex = model.triPIndex;
		this.triMIndex = model.triMIndex;
		this.triNIndex = model.triNIndex;
	}

	private int method465(Model model, int i) {
		int j = -1;
		int k = model.vertexX[i];
		int l = model.vertexY[i];
		int i1 = model.vertexZ[i];
		for (int j1 = 0; j1 < this.vertexCount; j1++) {
			if ((k != this.vertexX[j1]) || (l != this.vertexY[j1]) || (i1 != this.vertexZ[j1])) {
				continue;
			}
			j = j1;
			break;
		}
		if (j == -1) {
			this.vertexX[this.vertexCount] = k;
			this.vertexY[this.vertexCount] = l;
			this.vertexZ[this.vertexCount] = i1;
			if(model.vertexVSkin != null) {
				this.vertexVSkin[this.vertexCount] = model.vertexVSkin[i];
			}
			j = this.vertexCount++;
		}
		return j;
	}

	public void method466() {
		super.modelHeight = 0;
		this.diagonal2DAboveorigin = 0;
		this.maxY = 0;
		for (int i = 0; i < this.vertexCount; i++) {
			int j = this.vertexX[i];
			int k = this.vertexY[i];
			int l = this.vertexZ[i];
			if (-k > super.modelHeight) {
				super.modelHeight = -k;
			}
			if (k > this.maxY) {
				this.maxY = k;
			}
			int i1 = (j * j) + (l * l);
			if (i1 > this.diagonal2DAboveorigin) {
				this.diagonal2DAboveorigin = i1;
			}
		}
		this.diagonal2DAboveorigin = (int)(Math.sqrt(this.diagonal2DAboveorigin) + 0.98999999999999999D);
		this.diagonal3DAboveorigin = (int)(Math.sqrt((this.diagonal2DAboveorigin * this.diagonal2DAboveorigin) + (super.modelHeight * super.modelHeight)) + 0.98999999999999999D);
		this.diagonal3D = this.diagonal3DAboveorigin + (int)(Math.sqrt((this.diagonal2DAboveorigin * this.diagonal2DAboveorigin) + (this.maxY * this.maxY)) + 0.98999999999999999D);
	}

	public void method467() {
		super.modelHeight = 0;
		this.maxY = 0;
		for (int i = 0; i < this.vertexCount; i++) {
			int j = this.vertexY[i];
			if (-j > super.modelHeight) {
				super.modelHeight = -j;
			}
			if (j > this.maxY) {
				this.maxY = j;
			}
		}
		this.diagonal3DAboveorigin = (int)(Math.sqrt((this.diagonal2DAboveorigin * this.diagonal2DAboveorigin) + (super.modelHeight * super.modelHeight)) + 0.98999999999999999D);
		this.diagonal3D = this.diagonal3DAboveorigin + (int)(Math.sqrt((this.diagonal2DAboveorigin * this.diagonal2DAboveorigin) + (this.maxY * this.maxY)) + 0.98999999999999999D);
	}

	private void method468() {
		super.modelHeight = 0;
		this.diagonal2DAboveorigin = 0;
		this.maxY = 0;
		this.minX = 0xf423f;
		this.maxX = 0xfff0bdc1;
		this.maxZ = 0xfffe7961;
		this.minZ = 0x1869f;
		for (int j = 0; j < this.vertexCount; j++) {
			int k = this.vertexX[j];
			int l = this.vertexY[j];
			int i1 = this.vertexZ[j];
			if (k < this.minX) {
				this.minX = k;
			}
			if (k > this.maxX) {
				this.maxX = k;
			}
			if (i1 < this.minZ) {
				this.minZ = i1;
			}
			if (i1 > this.maxZ) {
				this.maxZ = i1;
			}
			if (-l > super.modelHeight) {
				super.modelHeight = -l;
			}
			if (l > this.maxY) {
				this.maxY = l;
			}
			int j1 = (k * k) + (i1 * i1);
			if (j1 > this.diagonal2DAboveorigin) {
				this.diagonal2DAboveorigin = j1;
			}
		}
		this.diagonal2DAboveorigin = (int) Math.sqrt(this.diagonal2DAboveorigin);
		this.diagonal3DAboveorigin = (int) Math.sqrt((this.diagonal2DAboveorigin * this.diagonal2DAboveorigin) + (super.modelHeight * super.modelHeight));
		this.diagonal3D = this.diagonal3DAboveorigin + (int) Math.sqrt((this.diagonal2DAboveorigin * this.diagonal2DAboveorigin) + (this.maxY * this.maxY));
	}

	public void method469() {
		if (this.vertexVSkin != null) {
			int ai[] = new int[256];
			int j = 0;
			for (int l = 0; l < this.vertexCount; l++) {
				int j1 = this.vertexVSkin[l];
				ai[j1]++;
				if (j1 > j) {
					j = j1;
				}
			}
			this.vertexSkin = new int[j + 1][];
			for (int k1 = 0; k1 <= j; k1++) {
				this.vertexSkin[k1] = new int[ai[k1]];
				ai[k1] = 0;
			}
			for (int j2 = 0; j2 < this.vertexCount; j2++) {
				int l2 = this.vertexVSkin[j2];
				this.vertexSkin[l2][ai[l2]++] = j2;
			}
			this.vertexVSkin = null;
		}
		if (this.triangleTSkin != null) {
			int ai1[] = new int[256];
			int k = 0;
			for (int i1 = 0; i1 < this.triangleCount; i1++) {
				int l1 = this.triangleTSkin[i1];
				ai1[l1]++;
				if (l1 > k) {
					k = l1;
				}
			}
			this.triangleSkin = new int[k + 1][];
			for (int i2 = 0; i2 <= k; i2++) {
				this.triangleSkin[i2] = new int[ai1[i2]];
				ai1[i2] = 0;
			}
			for (int k2 = 0; k2 < this.triangleCount; k2++) {
				int i3 = this.triangleTSkin[k2];
				this.triangleSkin[i3][ai1[i3]++] = k2;
			}
			this.triangleTSkin = null;
		}
	}

	public void method470(int i) {
		if (this.vertexSkin == null) {
			return;
		}
		if (i == -1) {
			return;
		}
		Animation animation = Animation.method531(i);
		if (animation == null) {
			return;
		}
		ModelTransform modelTransform = animation.myModelTransform;
		Model.vertexXModifier = 0;
		Model.vertexYModifier = 0;
		Model.vertexZModifier = 0;
		for (int k = 0; k < animation.stepCount; k++) {
			int l = animation.opcodeLinkTable[k];
			this.method472(modelTransform.opcodes[l], modelTransform.skinList[l], animation.modifier1[k], animation.modifier2[k], animation.modifier3[k]);
		}
	}

	public void method471(int ai[], int j, int k) {
		if (k == -1) {
			return;
		}
		if ((ai == null) || (j == -1)) {
			this.method470(k);
			return;
		}
		Animation animation = Animation.method531(k);
		if (animation == null) {
			return;
		}
		Animation class36_1 = Animation.method531(j);
		if (class36_1 == null) {
			this.method470(k);
			return;
		}
		ModelTransform modelTransform = animation.myModelTransform;
		Model.vertexXModifier = 0;
		Model.vertexYModifier = 0;
		Model.vertexZModifier = 0;
		int l = 0;
		int i1 = ai[l++];
		for (int j1 = 0; j1 < animation.stepCount; j1++) {
			int k1;
			for (k1 = animation.opcodeLinkTable[j1]; k1 > i1; i1 = ai[l++]) {
				;
			}
			if ((k1 != i1) || (modelTransform.opcodes[k1] == 0)) {
				this.method472(modelTransform.opcodes[k1], modelTransform.skinList[k1], animation.modifier1[j1], animation.modifier2[j1], animation.modifier3[j1]);
			}
		}
		Model.vertexXModifier = 0;
		Model.vertexYModifier = 0;
		Model.vertexZModifier = 0;
		l = 0;
		i1 = ai[l++];
		for (int l1 = 0; l1 < class36_1.stepCount; l1++) {
			int i2;
			for (i2 = class36_1.opcodeLinkTable[l1]; i2 > i1; i1 = ai[l++]) {
				;
			}
			if ((i2 == i1) || (modelTransform.opcodes[i2] == 0)) {
				this.method472(modelTransform.opcodes[i2], modelTransform.skinList[i2], class36_1.modifier1[l1], class36_1.modifier2[l1], class36_1.modifier3[l1]);
			}
		}
	}

	private void method472(int i, int ai[], int j, int k, int l) {
		int i1 = ai.length;
		if (i == 0) {
			int j1 = 0;
			Model.vertexXModifier = 0;
			Model.vertexYModifier = 0;
			Model.vertexZModifier = 0;
			for (int k2 = 0; k2 < i1; k2++) {
				int l3 = ai[k2];
				if (l3 < this.vertexSkin.length) {
					int ai5[] = this.vertexSkin[l3];
					for (int i5 = 0; i5 < ai5.length; i5++) {
						int j6 = ai5[i5];
						Model.vertexXModifier += this.vertexX[j6];
						Model.vertexYModifier += this.vertexY[j6];
						Model.vertexZModifier += this.vertexZ[j6];
						j1++;
					}
				}
			}
			if(j1 > 0) {
				Model.vertexXModifier = (Model.vertexXModifier / j1) + j;
				Model.vertexYModifier = (Model.vertexYModifier / j1) + k;
				Model.vertexZModifier = (Model.vertexZModifier / j1) + l;
				return;
			} else {
				Model.vertexXModifier = j;
				Model.vertexYModifier = k;
				Model.vertexZModifier = l;
				return;
			}
		}
		if (i == 1) {
			for (int k1 = 0; k1 < i1; k1++) {
				int l2 = ai[k1];
				if (l2 < this.vertexSkin.length) {
					int ai1[] = this.vertexSkin[l2];
					for(int i4 = 0; i4 < ai1.length; i4++) {
						int j5 = ai1[i4];
						this.vertexX[j5] += j;
						this.vertexY[j5] += k;
						this.vertexZ[j5] += l;
					}
				}
			}
			return;
		}
		if (i == 2) {
			for (int l1 = 0; l1 < i1; l1++) {
				int i3 = ai[l1];
				if (i3 < this.vertexSkin.length) {
					int ai2[] = this.vertexSkin[i3];
					for (int j4 = 0; j4 < ai2.length; j4++) {
						int k5 = ai2[j4];
						this.vertexX[k5] -= Model.vertexXModifier;
						this.vertexY[k5] -= Model.vertexYModifier;
						this.vertexZ[k5] -= Model.vertexZModifier;
						int k6 = (j & 0xff) * 8;
						int l6 = (k & 0xff) * 8;
						int i7 = (l & 0xff) * 8;
						if (i7 != 0) {
							int j7 = Model.sine[i7];
							int i8 = Model.cosine[i7];
							int l8 = ((this.vertexY[k5] * j7) + (this.vertexX[k5] * i8)) >> 16;
					this.vertexY[k5] = ((this.vertexY[k5] * i8) - (this.vertexX[k5] * j7)) >> 16;
			this.vertexX[k5] = l8;
						}
						if (k6 != 0) {
							int k7 = Model.sine[k6];
							int j8 = Model.cosine[k6];
							int i9 = ((this.vertexY[k5] * j8) - (this.vertexZ[k5] * k7)) >> 16;
				this.vertexZ[k5] = ((this.vertexY[k5] * k7) + (this.vertexZ[k5] * j8)) >> 16;
				this.vertexY[k5] = i9;
						}
						if (l6 != 0) {
							int l7 = Model.sine[l6];
							int k8 = Model.cosine[l6];
							int j9 = ((this.vertexZ[k5] * l7) + (this.vertexX[k5] * k8)) >> 16;
		this.vertexZ[k5] = ((this.vertexZ[k5] * k8) - (this.vertexX[k5] * l7)) >> 16;
			this.vertexX[k5] = j9;
						}
						this.vertexX[k5] += Model.vertexXModifier;
						this.vertexY[k5] += Model.vertexYModifier;
						this.vertexZ[k5] += Model.vertexZModifier;
					}
				}
			}
			return;
		}
		if (i == 3) {
			for (int i2 = 0; i2 < i1; i2++) {
				int j3 = ai[i2];
				if (j3 < this.vertexSkin.length) {
					int ai3[] = this.vertexSkin[j3];
					for (int k4 = 0; k4 < ai3.length; k4++) {
						int l5 = ai3[k4];
						this.vertexX[l5] -= Model.vertexXModifier;
						this.vertexY[l5] -= Model.vertexYModifier;
						this.vertexZ[l5] -= Model.vertexZModifier;
						this.vertexX[l5] = (this.vertexX[l5] * j) / 128;
						this.vertexY[l5] = (this.vertexY[l5] * k) / 128;
						this.vertexZ[l5] = (this.vertexZ[l5] * l) / 128;
						this.vertexX[l5] += Model.vertexXModifier;
						this.vertexY[l5] += Model.vertexYModifier;
						this.vertexZ[l5] += Model.vertexZModifier;
					}
				}
			}
			return;
		}
		if ((i == 5) && (this.triangleSkin != null) && (this.triangleAlpha != null)) {
			for (int j2 = 0; j2 < i1; j2++) {
				int k3 = ai[j2];
				if (k3 < this.triangleSkin.length) {
					int ai4[] = this.triangleSkin[k3];
					for (int l4 = 0; l4 < ai4.length; l4++) {
						int i6 = ai4[l4];
						this.triangleAlpha[i6] += j * 8;
						if (this.triangleAlpha[i6] < 0) {
							this.triangleAlpha[i6] = 0;
						}
						if (this.triangleAlpha[i6] > 255) {
							this.triangleAlpha[i6] = 255;
						}
					}
				}
			}
		}
	}

	public void method473() {
		for (int j = 0; j < this.vertexCount; j++) {
			int k = this.vertexX[j];
			this.vertexX[j] = this.vertexZ[j];
			this.vertexZ[j] = -k;
		}
	}

	public void method474(int i) {
		int k = Model.sine[i];
		int l = Model.cosine[i];
		for (int i1 = 0; i1 < this.vertexCount; i1++) {
			int j1 = ((this.vertexY[i1] * l) - (this.vertexZ[i1] * k)) >> 16;
		this.vertexZ[i1] = ((this.vertexY[i1] * k) + (this.vertexZ[i1] * l)) >> 16;
					this.vertexY[i1] = j1;
		}
	}

	public void method475(int i, int j, int l) {
		for (int i1 = 0; i1 < this.vertexCount; i1++) {
			this.vertexX[i1] += i;
			this.vertexY[i1] += j;
			this.vertexZ[i1] += l;
		}
	}

	public void method476(int i, int j) {
		for (int k = 0; k < this.triangleCount; k++) {
			if (this.triangleColour[k] == i) {
				this.triangleColour[k] = j;
			}
		}
	}

	public void method477() {
		for (int j = 0; j < this.vertexCount; j++) {
			this.vertexZ[j] = -this.vertexZ[j];
		}
		for (int k = 0; k < this.triangleCount; k++) {
			int l = this.triangleA[k];
			this.triangleA[k] = this.triangleC[k];
			this.triangleC[k] = l;
		}
	}

	public void method478(int i, int j, int l) {
		for (int i1 = 0; i1 < this.vertexCount; i1++) {
			this.vertexX[i1] = (this.vertexX[i1] * i) / 128;
			this.vertexY[i1] = (this.vertexY[i1] * l) / 128;
			this.vertexZ[i1] = (this.vertexZ[i1] * j) / 128;
		}
	}

	public void method479(int i, int j, int k, int l, int i1, boolean flag) {
		int j1 = (int)Math.sqrt((k * k) + (l * l) + (i1 * i1));
		int k1 = (j * j1) >> 8;
		if (this.triangleHSLA == null) {
			this.triangleHSLA = new int[this.triangleCount];
			this.triangleHSLB = new int[this.triangleCount];
			this.triangleHSLC = new int[this.triangleCount];
		}
		if (super.vertexNormals == null) {
			super.vertexNormals = new VertexNormal[this.vertexCount];
			for(int l1 = 0; l1 < this.vertexCount; l1++) {
				super.vertexNormals[l1] = new VertexNormal();
			}
		}
		for (int i2 = 0; i2 < this.triangleCount; i2++) {
			int j2 = this.triangleA[i2];
			int l2 = this.triangleB[i2];
			int i3 = this.triangleC[i2];
			int j3 = this.vertexX[l2] - this.vertexX[j2];
			int k3 = this.vertexY[l2] - this.vertexY[j2];
			int l3 = this.vertexZ[l2] - this.vertexZ[j2];
			int i4 = this.vertexX[i3] - this.vertexX[j2];
			int j4 = this.vertexY[i3] - this.vertexY[j2];
			int k4 = this.vertexZ[i3] - this.vertexZ[j2];
			int l4 = (k3 * k4) - (j4 * l3);
			int i5 = (l3 * i4) - (k4 * j3);
			int j5;
			for (j5 = (j3 * j4) - (i4 * k3); (l4 > 8192) || (i5 > 8192) || (j5 > 8192) || (l4 < -8192) || (i5 < -8192) || (j5 < -8192); j5 >>= 1) {
				l4 >>= 1;
			i5 >>= 1;
			}

			int k5 = (int)Math.sqrt((l4 * l4) + (i5 * i5) + (j5 * j5));
			if (k5 <= 0) {
				k5 = 1;
			}
			l4 = (l4 * 256) / k5;
			i5 = (i5 * 256) / k5;
			j5 = (j5 * 256) / k5;
			if((this.triangleDrawType == null) || ((this.triangleDrawType[i2] & 1) == 0)) {
				VertexNormal class33_2 = super.vertexNormals[j2];
				class33_2.x += l4;
				class33_2.y += i5;
				class33_2.z += j5;
				class33_2.magnitude++;
				class33_2 = super.vertexNormals[l2];
				class33_2.x += l4;
				class33_2.y += i5;
				class33_2.z += j5;
				class33_2.magnitude++;
				class33_2 = super.vertexNormals[i3];
				class33_2.x += l4;
				class33_2.y += i5;
				class33_2.z += j5;
				class33_2.magnitude++;
			} else {
				int l5 = i + (((k * l4) + (l * i5) + (i1 * j5)) / (k1 + (k1 / 2)));
				this.triangleHSLA[i2] = Model.method481(this.triangleColour[i2], l5, this.triangleDrawType[i2]);
			}
		}
		if (flag) {
			this.method480(i, k1, k, l, i1);
		} else {
			this.vertexNormalOffset = new VertexNormal[this.vertexCount];
			for (int k2 = 0; k2 < this.vertexCount; k2++) {
				VertexNormal vertexNormal = super.vertexNormals[k2];
				VertexNormal class33_1 = this.vertexNormalOffset[k2] = new VertexNormal();
				class33_1.x = vertexNormal.x;
				class33_1.y = vertexNormal.y;
				class33_1.z = vertexNormal.z;
				class33_1.magnitude = vertexNormal.magnitude;
			}
		}
		if (flag) {
			this.method466();
		} else {
			this.method468();
		}
	}

	public void method480(int i, int j, int k, int l, int i1) {
		for (int j1 = 0; j1 < this.triangleCount; j1++) {
			int k1 = this.triangleA[j1];
			int i2 = this.triangleB[j1];
			int j2 = this.triangleC[j1];
			if (this.triangleDrawType == null) {
				int i3 = this.triangleColour[j1];
				VertexNormal vertexNormal = super.vertexNormals[k1];
				int k2 = i + (((k * vertexNormal.x) + (l * vertexNormal.y) + (i1 * vertexNormal.z)) / (j * vertexNormal.magnitude));
				this.triangleHSLA[j1] = Model.method481(i3, k2, 0);
				vertexNormal = super.vertexNormals[i2];
				k2 = i + (((k * vertexNormal.x) + (l * vertexNormal.y) + (i1 * vertexNormal.z)) / (j * vertexNormal.magnitude));
				this.triangleHSLB[j1] = Model.method481(i3, k2, 0);
				vertexNormal = super.vertexNormals[j2];
				k2 = i + (((k * vertexNormal.x) + (l * vertexNormal.y) + (i1 * vertexNormal.z)) / (j * vertexNormal.magnitude));
				this.triangleHSLC[j1] = Model.method481(i3, k2, 0);
			} else if ((this.triangleDrawType[j1] & 1) == 0) {
				int j3 = this.triangleColour[j1];
				int k3 = this.triangleDrawType[j1];
				VertexNormal class33_1 = super.vertexNormals[k1];
				int l2 = i + (((k * class33_1.x) + (l * class33_1.y) + (i1 * class33_1.z)) / (j * class33_1.magnitude));
				this.triangleHSLA[j1] = Model.method481(j3, l2, k3);
				class33_1 = super.vertexNormals[i2];
				l2 = i + (((k * class33_1.x) + (l * class33_1.y) + (i1 * class33_1.z)) / (j * class33_1.magnitude));
				this.triangleHSLB[j1] = Model.method481(j3, l2, k3);
				class33_1 = super.vertexNormals[j2];
				l2 = i + (((k * class33_1.x) + (l * class33_1.y) + (i1 * class33_1.z)) / (j * class33_1.magnitude));
				this.triangleHSLC[j1] = Model.method481(j3, l2, k3);
			}
		}
		super.vertexNormals = null;
		this.vertexNormalOffset = null;
		this.vertexVSkin = null;
		this.triangleTSkin = null;
		if (this.triangleDrawType != null) {
			for (int l1 = 0; l1 < this.triangleCount; l1++) {
				if ((this.triangleDrawType[l1] & 2) == 2) {
					return;
				}
			}
		}
		this.triangleColour = null;
	}

	private static int method481(int i, int j, int k) {
		if ((k & 2) == 2) {
			if (j < 0) {
				j = 0;
			} else if (j > 127) {
				j = 127;
			}
			j = 127 - j;
			return j;
		}
		j = (j * (i & 0x7f)) >> 7;
			if (j < 2) {
				j = 2;
			} else if (j > 126) {
				j = 126;
			}
			return (i & 0xff80) + j;
	}

	public void method482(int j, int k, int l, int i1, int j1, int k1) {
		int i = 0;
		int l1 = Rasterizer.textureInt1;
		int i2 = Rasterizer.textureInt2;
		int j2 = Model.sine[i];
		int k2 = Model.cosine[i];
		int l2 = Model.sine[j];
		int i3 = Model.cosine[j];
		int j3 = Model.sine[k];
		int k3 = Model.cosine[k];
		int l3 = Model.sine[l];
		int i4 = Model.cosine[l];
		int j4 = ((j1 * l3) + (k1 * i4)) >> 16;
			for (int k4 = 0; k4 < this.vertexCount; k4++) {
				int l4 = this.vertexX[k4];
				int i5 = this.vertexY[k4];
				int j5 = this.vertexZ[k4];
				if (k != 0) {
					int k5 = ((i5 * j3) + (l4 * k3)) >> 16;
			i5 = ((i5 * k3) - (l4 * j3)) >> 16;
				l4 = k5;
				}
				if (i != 0) {
					int l5 = ((i5 * k2) - (j5 * j2)) >> 16;
			j5 = ((i5 * j2) + (j5 * k2)) >> 16;
				i5 = l5;
				}
				if (j != 0) {
					int i6 = ((j5 * l2) + (l4 * i3)) >> 16;
				j5 = ((j5 * i3) - (l4 * l2)) >> 16;
				l4 = i6;
				}
				l4 += i1;
				i5 += j1;
				j5 += k1;
				int j6 = ((i5 * i4) - (j5 * l3)) >> 16;
								j5 = ((i5 * l3) + (j5 * i4)) >> 16;
				i5 = j6;
				Model.depthBuffer[k4] = j5 - j4;
				Model.vertexSX[k4] = l1 + ((l4 << 9) / j5);
				Model.vertexSY[k4] = i2 + ((i5 << 9) / j5);
				if(this.textureTriangleCount > 0) {
					Model.vertexMvX[k4] = l4;
					Model.vertexMvY[k4] = i5;
					Model.vertexMvZ[k4] = j5;
				}
			}
			try {
				this.method483(false, false, 0);
			} catch (Exception _ex) {}
	}

	@Override
	public void method443(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2) {
		int j2 = ((l1 * i1) - (j1 * l)) >> 16;
				int k2 = ((k1 * j) + (j2 * k)) >> 16;
				int l2 = (this.diagonal2DAboveorigin * k) >> 16;
				int i3 = k2 + l2;
				if((i3 <= 50) || (k2 >= 3500)) {
					return;
				}
				int j3 = ((l1 * l) + (j1 * i1)) >> 16;
								int k3 = (j3 - this.diagonal2DAboveorigin) << 9;
								if ((k3 / i3) >= DrawingArea.viewportCenterX) {
									return;
								}
								int l3 = (j3 + this.diagonal2DAboveorigin) << 9;
								if ((l3 / i3) <= -DrawingArea.viewportCenterX) {
									return;
								}
								int i4 = ((k1 * k) - (j2 * j)) >> 16;
								int j4 = (this.diagonal2DAboveorigin * j) >> 16;
								int k4 = (i4 + j4) << 9;
								if ((k4 / i3) <= -DrawingArea.viewportCenterY) {
									return;
								}
								int l4 = j4 + ((super.modelHeight * k) >> 16);
								int i5 = (i4 - l4) << 9;
								if ((i5 / i3) >= DrawingArea.viewportCenterY) {
									return;
								}
								int j5 = l2 + ((super.modelHeight * j) >> 16);
								boolean flag = false;
								if ((k2 - j5) <= 50) {
									flag = true;
								}
								boolean flag1 = false;
								if ((i2 > 0) && Model.aBoolean1684) {
									int k5 = k2 - l2;
									if (k5 <= 50) {
										k5 = 50;
									}
									if (j3 > 0) {
										k3 /= i3;
										l3 /= k5;
									} else {
										l3 /= i3;
										k3 /= k5;
									}
									if (i4 > 0) {
										i5 /= i3;
										k4 /= k5;
									} else {
										k4 /= i3;
										i5 /= k5;
									}
									int i6 = Model.cursorXPos - Rasterizer.textureInt1;
									int k6 = Model.cursorYPos - Rasterizer.textureInt2;
									if ((i6 > k3) && (i6 < l3) && (k6 > i5) && (k6 < k4)) {
										if (this.oneSquareModel) {
											Model.resourceIDTAG[Model.resourceCount++] = i2;
										} else {
											flag1 = true;
										}
									}
								}
								int l5 = Rasterizer.textureInt1;
								int j6 = Rasterizer.textureInt2;
								int l6 = 0;
								int i7 = 0;
								if (i != 0) {
									l6 = Model.sine[i];
									i7 = Model.cosine[i];
								}
								for (int j7 = 0; j7 < this.vertexCount; j7++) {
									int k7 = this.vertexX[j7];
									int l7 = this.vertexY[j7];
									int i8 = this.vertexZ[j7];
									if (i != 0)
									{
										int j8 = ((i8 * l6) + (k7 * i7)) >> 16;
								i8 = ((i8 * i7) - (k7 * l6)) >> 16;
		k7 = j8;
									}
									k7 += j1;
									l7 += k1;
									i8 += l1;
									int k8 = ((i8 * l) + (k7 * i1)) >> 16;
		i8 = ((i8 * i1) - (k7 * l)) >> 16;
		k7 = k8;
		k8 = ((l7 * k) - (i8 * j)) >> 16;
		i8 = ((l7 * j) + (i8 * k)) >> 16;
		l7 = k8;
		Model.depthBuffer[j7] = i8 - k2;
		if (i8 >= 50) {
			Model.vertexSX[j7] = l5 + ((k7 << 9) / i8);
			Model.vertexSY[j7] = j6 + ((l7 << 9) / i8);
		} else {
			Model.vertexSX[j7] = -5000;
			flag = true;
		}
		if (flag || (this.textureTriangleCount > 0)) {
			Model.vertexMvX[j7] = k7;
			Model.vertexMvY[j7] = l7;
			Model.vertexMvZ[j7] = i8;
		}
								}
								try {
									this.method483(flag, flag1, i2);
								} catch (Exception _ex) {}
	}

	private void method483(boolean flag, boolean flag1, int i) {
		for (int j = 0; j < this.diagonal3D; j++) {
			Model.depthListIndices[j] = 0;
		}
		for (int k = 0; k < this.triangleCount; k++) {
			if ((this.triangleDrawType == null) || (this.triangleDrawType[k] != -1)) {
				int l = this.triangleA[k];
				int k1 = this.triangleB[k];
				int j2 = this.triangleC[k];
				int i3 = Model.vertexSX[l];
				int l3 = Model.vertexSX[k1];
				int k4 = Model.vertexSX[j2];
				if (flag && ((i3 == -5000) || (l3 == -5000) || (k4 == -5000))) {
					Model.aBooleanArray1664[k] = true;
					int j5 = ((Model.depthBuffer[l] + Model.depthBuffer[k1] + Model.depthBuffer[j2]) / 3) + this.diagonal3DAboveorigin;
					Model.faceLists[j5][Model.depthListIndices[j5]++] = k;
				} else {
					if (flag1 && this.method486(Model.cursorXPos, Model.cursorYPos, Model.vertexSY[l], Model.vertexSY[k1], Model.vertexSY[j2], i3, l3, k4)) {
						Model.resourceIDTAG[Model.resourceCount++] = i;
						flag1 = false;
					}
					if ((((i3 - l3) * (Model.vertexSY[j2] - Model.vertexSY[k1])) - ((Model.vertexSY[l] - Model.vertexSY[k1]) * (k4 - l3))) > 0) {
						Model.aBooleanArray1664[k] = false;
						Model.aBooleanArray1663[k] = (i3 < 0) || (l3 < 0) || (k4 < 0) || (i3 > DrawingArea.viewportRX) || (l3 > DrawingArea.viewportRX) || (k4 > DrawingArea.viewportRX);
						int k5 = ((Model.depthBuffer[l] + Model.depthBuffer[k1] + Model.depthBuffer[j2]) / 3) + this.diagonal3DAboveorigin;
						Model.faceLists[k5][Model.depthListIndices[k5]++] = k;
					}
				}
			}
		}
		if (this.facePriority == null) {
			for (int i1 = this.diagonal3D - 1; i1 >= 0; i1--) {
				int l1 = Model.depthListIndices[i1];
				if (l1 > 0) {
					int ai[] = Model.faceLists[i1];
					for(int j3 = 0; j3 < l1; j3++) {
						this.method484(ai[j3]);
					}
				}
			}
			return;
		}
		for (int j1 = 0; j1 < 12; j1++) {
			Model.anIntArray1673[j1] = 0;
			Model.anIntArray1677[j1] = 0;
		}
		for (int i2 = this.diagonal3D - 1; i2 >= 0; i2--) {
			int k2 = Model.depthListIndices[i2];
			if (k2 > 0) {
				int ai1[] = Model.faceLists[i2];
				for (int i4 = 0; i4 < k2; i4++) {
					int l4 = ai1[i4];
					int l5 = this.facePriority[l4];
					int j6 = Model.anIntArray1673[l5]++;
					Model.anIntArrayArray1674[l5][j6] = l4;
					if (l5 < 10) {
						Model.anIntArray1677[l5] += i2;
					} else if (l5 == 10) {
						Model.anIntArray1675[j6] = i2;
					} else {
						Model.anIntArray1676[j6] = i2;
					}
				}
			}
		}
		int l2 = 0;
		if ((Model.anIntArray1673[1] > 0) || (Model.anIntArray1673[2] > 0)) {
			l2 = (Model.anIntArray1677[1] + Model.anIntArray1677[2]) / (Model.anIntArray1673[1] + Model.anIntArray1673[2]);
		}
		int k3 = 0;
		if ((Model.anIntArray1673[3] > 0) || (Model.anIntArray1673[4] > 0)) {
			k3 = (Model.anIntArray1677[3] + Model.anIntArray1677[4]) / (Model.anIntArray1673[3] + Model.anIntArray1673[4]);
		}
		int j4 = 0;
		if ((Model.anIntArray1673[6] > 0) || (Model.anIntArray1673[8] > 0)) {
			j4 = (Model.anIntArray1677[6] + Model.anIntArray1677[8]) / (Model.anIntArray1673[6] + Model.anIntArray1673[8]);
		}
		int i6 = 0;
		int k6 = Model.anIntArray1673[10];
		int ai2[] = Model.anIntArrayArray1674[10];
		int ai3[] = Model.anIntArray1675;
		if (i6 == k6) {
			i6 = 0;
			k6 = Model.anIntArray1673[11];
			ai2 = Model.anIntArrayArray1674[11];
			ai3 = Model.anIntArray1676;
		}
		int i5;
		if (i6 < k6) {
			i5 = ai3[i6];
		} else {
			i5 = -1000;
		}
		for (int l6 = 0; l6 < 10; l6++) {
			while ((l6 == 0) && (i5 > l2)) {
				this.method484(ai2[i6++]);
				if ((i6 == k6) && (ai2 != Model.anIntArrayArray1674[11])) {
					i6 = 0;
					k6 = Model.anIntArray1673[11];
					ai2 = Model.anIntArrayArray1674[11];
					ai3 = Model.anIntArray1676;
				}
				if (i6 < k6) {
					i5 = ai3[i6];
				} else {
					i5 = -1000;
				}
			}
			while ((l6 == 3) && (i5 > k3)) {
				this.method484(ai2[i6++]);
				if ((i6 == k6) && (ai2 != Model.anIntArrayArray1674[11])) {
					i6 = 0;
					k6 = Model.anIntArray1673[11];
					ai2 = Model.anIntArrayArray1674[11];
					ai3 = Model.anIntArray1676;
				}
				if (i6 < k6) {
					i5 = ai3[i6];
				} else {
					i5 = -1000;
				}
			}
			while ((l6 == 5) && (i5 > j4)) {
				this.method484(ai2[i6++]);
				if ((i6 == k6) && (ai2 != Model.anIntArrayArray1674[11])) {
					i6 = 0;
					k6 = Model.anIntArray1673[11];
					ai2 = Model.anIntArrayArray1674[11];
					ai3 = Model.anIntArray1676;
				}
				if (i6 < k6) {
					i5 = ai3[i6];
				} else {
					i5 = -1000;
				}
			}
			int i7 = Model.anIntArray1673[l6];
			int ai4[] = Model.anIntArrayArray1674[l6];
			for (int j7 = 0; j7 < i7; j7++) {
				this.method484(ai4[j7]);
			}
		}
		while (i5 != -1000) {
			this.method484(ai2[i6++]);
			if ((i6 == k6) && (ai2 != Model.anIntArrayArray1674[11])) {
				i6 = 0;
				ai2 = Model.anIntArrayArray1674[11];
				k6 = Model.anIntArray1673[11];
				ai3 = Model.anIntArray1676;
			}
			if (i6 < k6) {
				i5 = ai3[i6];
			} else {
				i5 = -1000;
			}
		}
	}

	private void method484(int i) {
		if (Model.aBooleanArray1664[i]) {
			this.method485(i);
			return;
		}
		int j = this.triangleA[i];
		int k = this.triangleB[i];
		int l = this.triangleC[i];
		Rasterizer.aBoolean1462 = Model.aBooleanArray1663[i];
		if (this.triangleAlpha == null) {
			Rasterizer.anInt1465 = 0;
		} else {
			Rasterizer.anInt1465 = this.triangleAlpha[i];
		}
		int i1;
		if (this.triangleDrawType == null) {
			i1 = 0;
		} else {
			i1 = this.triangleDrawType[i] & 3;
		}
		if (i1 == 0) {
			Rasterizer.method374(Model.vertexSY[j], Model.vertexSY[k], Model.vertexSY[l], Model.vertexSX[j], Model.vertexSX[k], Model.vertexSX[l], this.triangleHSLA[i], this.triangleHSLB[i], this.triangleHSLC[i]);
			return;
		}
		if (i1 == 1) {
			Rasterizer.method376(Model.vertexSY[j], Model.vertexSY[k], Model.vertexSY[l], Model.vertexSX[j], Model.vertexSX[k], Model.vertexSX[l], Model.hsl2RGB[this.triangleHSLA[i]]);
			return;
		}
		if (i1 == 2) {
			int j1 = this.triangleDrawType[i] >> 2;
			int l1 = this.triPIndex[j1];
			int j2 = this.triMIndex[j1];
			int l2 = this.triNIndex[j1];
			Rasterizer.method378(Model.vertexSY[j], Model.vertexSY[k], Model.vertexSY[l], Model.vertexSX[j], Model.vertexSX[k], Model.vertexSX[l], this.triangleHSLA[i], this.triangleHSLB[i], this.triangleHSLC[i], Model.vertexMvX[l1], Model.vertexMvX[j2], Model.vertexMvX[l2], Model.vertexMvY[l1], Model.vertexMvY[j2], Model.vertexMvY[l2], Model.vertexMvZ[l1], Model.vertexMvZ[j2], Model.vertexMvZ[l2], this.triangleColour[i]);
			return;
		}
		if (i1 == 3) {
			int k1 = this.triangleDrawType[i] >> 2;
				int i2 = this.triPIndex[k1];
				int k2 = this.triMIndex[k1];
				int i3 = this.triNIndex[k1];
				Rasterizer.method378(Model.vertexSY[j], Model.vertexSY[k], Model.vertexSY[l], Model.vertexSX[j], Model.vertexSX[k], Model.vertexSX[l], this.triangleHSLA[i], this.triangleHSLA[i], this.triangleHSLA[i], Model.vertexMvX[i2], Model.vertexMvX[k2], Model.vertexMvX[i3], Model.vertexMvY[i2], Model.vertexMvY[k2], Model.vertexMvY[i3], Model.vertexMvZ[i2], Model.vertexMvZ[k2], Model.vertexMvZ[i3], this.triangleColour[i]);
		}
	}

	private void method485(int i) {
		int j = Rasterizer.textureInt1;
		int k = Rasterizer.textureInt2;
		int l = 0;
		int i1 = this.triangleA[i];
		int j1 = this.triangleB[i];
		int k1 = this.triangleC[i];
		int l1 = Model.vertexMvZ[i1];
		int i2 = Model.vertexMvZ[j1];
		int j2 = Model.vertexMvZ[k1];
		if (l1 >= 50) {
			Model.anIntArray1678[l] = Model.vertexSX[i1];
			Model.anIntArray1679[l] = Model.vertexSY[i1];
			Model.anIntArray1680[l++] = this.triangleHSLA[i];
		} else {
			int k2 = Model.vertexMvX[i1];
			int k3 = Model.vertexMvY[i1];
			int k4 = this.triangleHSLA[i];
			if (j2 >= 50) {
				int k5 = (50 - l1) * Model.modelIntArray4[j2 - l1];
				Model.anIntArray1678[l] = j + (((k2 + (((Model.vertexMvX[k1] - k2) * k5) >> 16)) << 9) / 50);
				Model.anIntArray1679[l] = k + (((k3 + (((Model.vertexMvY[k1] - k3) * k5) >> 16)) << 9) / 50);
				Model.anIntArray1680[l++] = k4 + (((this.triangleHSLC[i] - k4) * k5) >> 16);
			}
			if (i2 >= 50) {
				int l5 = (50 - l1) * Model.modelIntArray4[i2 - l1];
				Model.anIntArray1678[l] = j + (((k2 + (((Model.vertexMvX[j1] - k2) * l5) >> 16)) << 9) / 50);
				Model.anIntArray1679[l] = k + (((k3 + (((Model.vertexMvY[j1] - k3) * l5) >> 16)) << 9) / 50);
				Model.anIntArray1680[l++] = k4 + (((this.triangleHSLB[i] - k4) * l5) >> 16);
			}
		}
		if (i2 >= 50) {
			Model.anIntArray1678[l] = Model.vertexSX[j1];
			Model.anIntArray1679[l] = Model.vertexSY[j1];
			Model.anIntArray1680[l++] = this.triangleHSLB[i];
		} else {
			int l2 = Model.vertexMvX[j1];
			int l3 = Model.vertexMvY[j1];
			int l4 = this.triangleHSLB[i];
			if (l1 >= 50) {
				int i6 = (50 - i2) * Model.modelIntArray4[l1 - i2];
				Model.anIntArray1678[l] = j + (((l2 + (((Model.vertexMvX[i1] - l2) * i6) >> 16)) << 9) / 50);
				Model.anIntArray1679[l] = k + (((l3 + (((Model.vertexMvY[i1] - l3) * i6) >> 16)) << 9) / 50);
				Model.anIntArray1680[l++] = l4 + (((this.triangleHSLA[i] - l4) * i6) >> 16);
			}
			if (j2 >= 50) {
				int j6 = (50 - i2) * Model.modelIntArray4[j2 - i2];
				Model.anIntArray1678[l] = j + (((l2 + (((Model.vertexMvX[k1] - l2) * j6) >> 16)) << 9) / 50);
				Model.anIntArray1679[l] = k + (((l3 + (((Model.vertexMvY[k1] - l3) * j6) >> 16)) << 9) / 50);
				Model.anIntArray1680[l++] = l4 + (((this.triangleHSLC[i] - l4) * j6) >> 16);
			}
		}
		if (j2 >= 50) {
			Model.anIntArray1678[l] = Model.vertexSX[k1];
			Model.anIntArray1679[l] = Model.vertexSY[k1];
			Model.anIntArray1680[l++] = this.triangleHSLC[i];
		} else {
			int i3 = Model.vertexMvX[k1];
			int i4 = Model.vertexMvY[k1];
			int i5 = this.triangleHSLC[i];
			if (i2 >= 50) {
				int k6 = (50 - j2) * Model.modelIntArray4[i2 - j2];
				Model.anIntArray1678[l] = j + (((i3 + (((Model.vertexMvX[j1] - i3) * k6) >> 16)) << 9) / 50);
				Model.anIntArray1679[l] = k + (((i4 + (((Model.vertexMvY[j1] - i4) * k6) >> 16)) << 9) / 50);
				Model.anIntArray1680[l++] = i5 + (((this.triangleHSLB[i] - i5) * k6) >> 16);
			}
			if (l1 >= 50) {
				int l6 = (50 - j2) * Model.modelIntArray4[l1 - j2];
				Model.anIntArray1678[l] = j + (((i3 + (((Model.vertexMvX[i1] - i3) * l6) >> 16)) << 9) / 50);
				Model.anIntArray1679[l] = k + (((i4 + (((Model.vertexMvY[i1] - i4) * l6) >> 16)) << 9) / 50);
				Model.anIntArray1680[l++] = i5 + (((this.triangleHSLA[i] - i5) * l6) >> 16);
			}
		}
		int j3 = Model.anIntArray1678[0];
		int j4 = Model.anIntArray1678[1];
		int j5 = Model.anIntArray1678[2];
		int i7 = Model.anIntArray1679[0];
		int j7 = Model.anIntArray1679[1];
		int k7 = Model.anIntArray1679[2];
		if ((((j3 - j4) * (k7 - j7)) - ((i7 - j7) * (j5 - j4))) > 0) {
			Rasterizer.aBoolean1462 = false;
			if (l == 3) {
				if ((j3 < 0) || (j4 < 0) || (j5 < 0) || (j3 > DrawingArea.viewportRX) || (j4 > DrawingArea.viewportRX) || (j5 > DrawingArea.viewportRX)) {
					Rasterizer.aBoolean1462 = true;
				}
				int l7;
				if (this.triangleDrawType == null) {
					l7 = 0;
				} else {
					l7 = this.triangleDrawType[i] & 3;
				}
				if (l7 == 0) {
					Rasterizer.method374(i7, j7, k7, j3, j4, j5, Model.anIntArray1680[0], Model.anIntArray1680[1], Model.anIntArray1680[2]);
				} else if (l7 == 1) {
					Rasterizer.method376(i7, j7, k7, j3, j4, j5, Model.hsl2RGB[this.triangleHSLA[i]]);
				} else if (l7 == 2) {
					int j8 = this.triangleDrawType[i] >> 2;
					int k9 = this.triPIndex[j8];
					int k10 = this.triMIndex[j8];
					int k11 = this.triNIndex[j8];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5, Model.anIntArray1680[0], Model.anIntArray1680[1], Model.anIntArray1680[2], Model.vertexMvX[k9], Model.vertexMvX[k10], Model.vertexMvX[k11], Model.vertexMvY[k9], Model.vertexMvY[k10], Model.vertexMvY[k11], Model.vertexMvZ[k9], Model.vertexMvZ[k10], Model.vertexMvZ[k11], this.triangleColour[i]);
				} else if (l7 == 3) {
					int k8 = this.triangleDrawType[i] >> 2;
					int l9 = this.triPIndex[k8];
					int l10 = this.triMIndex[k8];
					int l11 = this.triNIndex[k8];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5, this.triangleHSLA[i], this.triangleHSLA[i], this.triangleHSLA[i], Model.vertexMvX[l9], Model.vertexMvX[l10], Model.vertexMvX[l11], Model.vertexMvY[l9], Model.vertexMvY[l10], Model.vertexMvY[l11], Model.vertexMvZ[l9], Model.vertexMvZ[l10], Model.vertexMvZ[l11], this.triangleColour[i]);
				}
			}
			if (l == 4) {
				if ((j3 < 0) || (j4 < 0) || (j5 < 0) || (j3 > DrawingArea.viewportRX) || (j4 > DrawingArea.viewportRX) || (j5 > DrawingArea.viewportRX) || (Model.anIntArray1678[3] < 0) || (Model.anIntArray1678[3] > DrawingArea.viewportRX)) {
					Rasterizer.aBoolean1462 = true;
				}
				int i8;
				if (this.triangleDrawType == null) {
					i8 = 0;
				} else {
					i8 = this.triangleDrawType[i] & 3;
				}
				if (i8 == 0) {
					Rasterizer.method374(i7, j7, k7, j3, j4, j5, Model.anIntArray1680[0], Model.anIntArray1680[1], Model.anIntArray1680[2]);
					Rasterizer.method374(i7, k7, Model.anIntArray1679[3], j3, j5, Model.anIntArray1678[3], Model.anIntArray1680[0], Model.anIntArray1680[2], Model.anIntArray1680[3]);
					return;
				}
				if (i8 == 1) {
					int l8 = Model.hsl2RGB[this.triangleHSLA[i]];
					Rasterizer.method376(i7, j7, k7, j3, j4, j5, l8);
					Rasterizer.method376(i7, k7, Model.anIntArray1679[3], j3, j5, Model.anIntArray1678[3], l8);
					return;
				}
				if (i8 == 2) {
					int i9 = this.triangleDrawType[i] >> 2;
					int i10 = this.triPIndex[i9];
					int i11 = this.triMIndex[i9];
					int i12 = this.triNIndex[i9];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5, Model.anIntArray1680[0], Model.anIntArray1680[1], Model.anIntArray1680[2], Model.vertexMvX[i10], Model.vertexMvX[i11], Model.vertexMvX[i12], Model.vertexMvY[i10], Model.vertexMvY[i11], Model.vertexMvY[i12], Model.vertexMvZ[i10], Model.vertexMvZ[i11], Model.vertexMvZ[i12], this.triangleColour[i]);
					Rasterizer.method378(i7, k7, Model.anIntArray1679[3], j3, j5, Model.anIntArray1678[3], Model.anIntArray1680[0], Model.anIntArray1680[2], Model.anIntArray1680[3], Model.vertexMvX[i10], Model.vertexMvX[i11], Model.vertexMvX[i12], Model.vertexMvY[i10], Model.vertexMvY[i11], Model.vertexMvY[i12], Model.vertexMvZ[i10], Model.vertexMvZ[i11], Model.vertexMvZ[i12], this.triangleColour[i]);
					return;
				}
				if (i8 == 3) {
					int j9 = this.triangleDrawType[i] >> 2;
					int j10 = this.triPIndex[j9];
					int j11 = this.triMIndex[j9];
					int j12 = this.triNIndex[j9];
					Rasterizer.method378(i7, j7, k7, j3, j4, j5, this.triangleHSLA[i], this.triangleHSLA[i], this.triangleHSLA[i], Model.vertexMvX[j10], Model.vertexMvX[j11], Model.vertexMvX[j12], Model.vertexMvY[j10], Model.vertexMvY[j11], Model.vertexMvY[j12], Model.vertexMvZ[j10], Model.vertexMvZ[j11], Model.vertexMvZ[j12], this.triangleColour[i]);
					Rasterizer.method378(i7, k7, Model.anIntArray1679[3], j3, j5, Model.anIntArray1678[3], this.triangleHSLA[i], this.triangleHSLA[i], this.triangleHSLA[i], Model.vertexMvX[j10], Model.vertexMvX[j11], Model.vertexMvX[j12], Model.vertexMvY[j10], Model.vertexMvY[j11], Model.vertexMvY[j12], Model.vertexMvZ[j10], Model.vertexMvZ[j11], Model.vertexMvZ[j12], this.triangleColour[i]);
				}
			}
		}
	}

	private boolean method486(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
		if ((j < k) && (j < l) && (j < i1)) {
			return false;
		}
		if ((j > k) && (j > l) && (j > i1)) {
			return false;
		}
		return !((i < j1) && (i < k1) && (i < l1)) && ((i <= j1) || (i <= k1) || (i <= l1));
	}

	public static Model aModel_1621 = new Model();
	private static int[] anIntArray1622 = new int[2000];
	private static int[] anIntArray1623 = new int[2000];
	private static int[] anIntArray1624 = new int[2000];
	private static int[] anIntArray1625 = new int[2000];
	public int vertexCount;
	public int vertexX[];
	public int vertexY[];
	public int vertexZ[];
	public int triangleCount;
	public int triangleA[];
	public int triangleB[];
	public int triangleC[];
	private int[] triangleHSLA;
	private int[] triangleHSLB;
	private int[] triangleHSLC;
	public int triangleDrawType[];
	private int[] facePriority;
	private int[] triangleAlpha;
	public int triangleColour[];
	private int anInt1641;
	private int textureTriangleCount;
	private int[] triPIndex;
	private int[] triMIndex;
	private int[] triNIndex;
	public int minX;
	public int maxX;
	public int maxZ;
	public int minZ;
	public int diagonal2DAboveorigin;
	public int maxY;
	private int diagonal3D;
	private int diagonal3DAboveorigin;
	public int anInt1654;
	private int[] vertexVSkin;
	private int[] triangleTSkin;
	public int vertexSkin[][];
	public int triangleSkin[][];
	public boolean oneSquareModel;
	public VertexNormal vertexNormalOffset[];
	private static ModelHeader[] modelHeaderCache;
	private static OnDemandFetcher aOnDemandFetcher;
	private static boolean[] aBooleanArray1663 = new boolean[4096];
	private static boolean[] aBooleanArray1664 = new boolean[4096];
	private static int[] vertexSX = new int[4096];
	private static int[] vertexSY = new int[4096];
	private static int[] depthBuffer = new int[4096];
	private static int[] vertexMvX = new int[4096];
	private static int[] vertexMvY = new int[4096];
	private static int[] vertexMvZ = new int[4096];
	private static int[] depthListIndices = new int[1500];
	private static int[][] faceLists = new int[1500][512];
	private static int[] anIntArray1673 = new int[12];
	private static int[][] anIntArrayArray1674 = new int[12][2000];
	private static int[] anIntArray1675 = new int[2000];
	private static int[] anIntArray1676 = new int[2000];
	private static int[] anIntArray1677 = new int[12];
	private static int[] anIntArray1678 = new int[10];
	private static int[] anIntArray1679 = new int[10];
	private static int[] anIntArray1680 = new int[10];
	private static int vertexXModifier;
	private static int vertexYModifier;
	private static int vertexZModifier;
	public static boolean aBoolean1684;
	public static int cursorXPos;
	public static int cursorYPos;
	public static int resourceCount;
	public static int[] resourceIDTAG = new int[1000];
	public static int sine[];
	public static int cosine[];
	private static int[] hsl2RGB;
	private static int[] modelIntArray4;

	static {
		Model.sine = Rasterizer.anIntArray1470;
		Model.cosine = Rasterizer.anIntArray1471;
		Model.hsl2RGB = Rasterizer.anIntArray1482;
		Model.modelIntArray4 = Rasterizer.anIntArray1469;
	}
}