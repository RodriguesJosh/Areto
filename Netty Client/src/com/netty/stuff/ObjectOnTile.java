package com.netty.stuff;

import com.netty.game.Client;
import com.netty.game.model.Model;
import com.netty.game.model.entity.object.ObjectDef;

public class ObjectOnTile extends Animable {

	@Override
	public Model getRotatedModel() {
		int j = -1;
		if (this.sequence != null) {
			// int k = Client.loopCycle - this.delay;
			// if ((k > 100) && (this.sequence.frameStep > 0)) {
			// 	k = 100;
			// }
			/** while (k > this.sequence.method258(this.frame)) {
				k -= this.sequence.method258(this.frame);
				this.frame++;
				if (this.frame < this.sequence.frameCount) {
					continue;
				}
				this.frame -= this.sequence.frameStep;
				if ((this.frame >= 0) && (this.frame < this.sequence.frameCount)) {
					continue;
				}
				this.sequence = null;
				break;
			} */
			// this.delay = Client.loopCycle - k;
			if (this.sequence != null) {
				j = this.sequence.frame2IDS[this.frame];
			}
		}
		ObjectDef class46;
		if (this.anIntArray1600 != null) {
			class46 = this.method457();
		} else {
			class46 = ObjectDef.forID(this.objectID);
		}
		if (class46 == null) {
			return null;
		} else {
			return class46.method578(this.anInt1611, this.anInt1612, this.anInt1603, this.anInt1604, this.anInt1605, this.anInt1606, j);
		}
	}

	private ObjectDef method457() {
		int i = -1;
		if (this.anInt1601 != -1) {
			VarBit varBit = VarBit.cache[this.anInt1601];
			@SuppressWarnings("unused")
			int k = varBit.configID;
			@SuppressWarnings("unused")
			int l = varBit.leastSignificantBit;
			@SuppressWarnings("unused")
			int i1 = varBit.mostSignificantBit;
			// int j1 = Client.anIntArray1232[i1 - l];
			// i = (ObjectOnTile.clientInstance.variousSettings[k] >> l) & j1;
		} else if(this.anInt1602 != -1) {
			// i = ObjectOnTile.clientInstance.variousSettings[this.anInt1602];
		}
		if ((i < 0) || (i >= this.anIntArray1600.length) || (this.anIntArray1600[i] == -1)) {
			return null;
		} else {
			return ObjectDef.forID(this.anIntArray1600[i]);
		}
	}

	public ObjectOnTile(int i, int j, int k, int l, int i1, int j1, int k1, int l1, boolean flag) {
		this.objectID = i;
		this.anInt1611 = k;
		this.anInt1612 = j;
		this.anInt1603 = j1;
		this.anInt1604 = l;
		this.anInt1605 = i1;
		this.anInt1606 = k1;
		if (l1 != -1) {
			this.sequence = Sequence.anims[l1];
			this.frame = 0;
			// this.delay = Client.loopCycle;
			if (flag && (this.sequence.frameStep != -1)) {
				this.frame = (int)(Math.random() * this.sequence.frameCount);
				this.delay -= (int)(Math.random() * this.sequence.method258(this.frame));
			}
		}
		ObjectDef class46 = ObjectDef.forID(this.objectID);
		this.anInt1601 = class46.configID1;
		this.anInt1602 = class46.configID;
		this.anIntArray1600 = class46.childrenIDs;
	}

	private int frame;
	private int[] anIntArray1600;
	private int anInt1601;
	private int anInt1602;
	private int anInt1603;
	private int anInt1604;
	private int anInt1605;
	private int anInt1606;
	private Sequence sequence;
	private int delay;
	public static Client clientInstance;
	private int objectID;
	private int anInt1611;
	private int anInt1612;
}