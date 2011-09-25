package com.netty.game.model.entity;

import com.netty.stuff.Animable;
import com.netty.stuff.Sequence;

public class Entity extends Animable {

	public void setPos(int i, int j, boolean flag) {
		if ((this.anim != -1) && (Sequence.anims[this.anim].priority == 1)) {
			this.anim = -1;
		}
		if (!flag) {
			int k = i - this.smallX[0];
			int l = j - this.smallY[0];
			if ((k >= -8) && (k <= 8) && (l >= -8) && (l <= 8)) {
				if (this.smallXYIndex < 9) {
					this.smallXYIndex++;
				}
				for (int i1 = this.smallXYIndex; i1 > 0; i1--) {
					this.smallX[i1] = this.smallX[i1 - 1];
					this.smallY[i1] = this.smallY[i1 - 1];
					this.pathRun[i1] = this.pathRun[i1 - 1];
				}
				this.smallX[0] = i;
				this.smallY[0] = j;
				this.pathRun[0] = false;
				return;
			}
		}
		this.smallXYIndex = 0;
		this.anInt1542 = 0;
		this.anInt1503 = 0;
		this.smallX[0] = i;
		this.smallY[0] = j;
		this.x = (this.smallX[0] * 128) + (this.boundDim * 64);
		this.y = (this.smallY[0] * 128) + (this.boundDim * 64);
	}

	public void method446() {
		this.smallXYIndex = 0;
		this.anInt1542 = 0;
	}

	public void updateHitData(int j, int k, int l) {
		for (int i1 = 0; i1 < 4; i1++) {
			if (this.hitsLoopCycle[i1] <= l) {
				this.hitDamages[i1] = k;
				this.hitMarkTypes[i1] = j;
				this.hitsLoopCycle[i1] = l + 70;
				return;
			}
		}
	}

	public void moveInDir(boolean flag, int i) {
		int j = this.smallX[0];
		int k = this.smallY[0];
		if (i == 0) {
			j--;
			k++;
		}
		if (i == 1) {
			k++;
		}
		if(i == 2) {
			j++;
			k++;
		}
		if (i == 3) {
			j--;
		}
		if (i == 4) {
			j++;
		}
		if (i == 5) {
			j--;
			k--;
		}
		if (i == 6) {
			k--;
		}
		if (i == 7) {
			j++;
			k--;
		}
		if ((this.anim != -1) && (Sequence.anims[this.anim].priority == 1)) {
			this.anim = -1;
		}
		if (this.smallXYIndex < 9) {
			this.smallXYIndex++;
		}
		for (int l = this.smallXYIndex; l > 0; l--) {
			this.smallX[l] = this.smallX[l - 1];
			this.smallY[l] = this.smallY[l - 1];
			this.pathRun[l] = this.pathRun[l - 1];
		}
		this.smallX[0] = j;
		this.smallY[0] = k;
		this.pathRun[0] = flag;
	}

	public int entScreenX;
	public int entScreenY;
	public int index = -1;

	public boolean isVisible() {
		return false;
	}

	protected Entity() {
		this.smallX = new int[10];
		this.smallY = new int[10];
		this.interactingEntity = -1;
		this.degreesToTurn = 32;
		this.runAnimIndex = -1;
		this.height = 200;
		this.standAnimIndex = -1;
		this.standTurnAnimIndex = -1;
		this.hitDamages = new int[4];
		this.hitMarkTypes = new int[4];
		this.hitsLoopCycle = new int[4];
		this.anInt1517 = -1;
		this.gfxID = -1;
		this.anim = -1;
		this.loopCycleStatus = -1000;
		this.textCycle = 100;
		this.boundDim = 1;
		this.aBoolean1541 = false;
		this.pathRun = new boolean[10];
		this.walkAnimIndex = -1;
		this.turn180AnimIndex = -1;
		this.turn90CWAnimIndex = -1;
		this.turn90CCWAnimIndex = -1;
	}

	public int[] smallX;
	public int[] smallY;
	public int interactingEntity;
	public int anInt1503;
	public int degreesToTurn;
	public int runAnimIndex;
	public String textSpoken;
	public int height;
	public int turnDirection;
	public int standAnimIndex;
	public int standTurnAnimIndex;
	public int fancyTextColourType;
	public int[] hitDamages;
	public int[] hitMarkTypes;
	public int[] hitsLoopCycle;
	public int anInt1517;
	public int anInt1518;
	public int anInt1519;
	public int gfxID;
	public int currentAnim;
	public int anInt1522;
	public int gfxDelay;
	public int graphicHeight;
	public int smallXYIndex;
	public int anim;
	public int anInt1527;
	public int anInt1528;
	public int animationDelay;
	public int anInt1530;
	public int fancyTextDrawType;
	public int loopCycleStatus;
	public int currentHealth;
	public int maxHealth;
	public int textCycle;
	public int time;
	public int faceX;
	public int faceY;
	public int boundDim;
	public boolean aBoolean1541;
	public int anInt1542;
	public int anInt1543;
	public int anInt1544;
	public int anInt1545;
	public int anInt1546;
	public int anInt1547;
	public int anInt1548;
	public int turnInfo;
	public int x;
	public int y;
	public int currentRotation;
	public boolean[] pathRun;
	public int walkAnimIndex;
	public int turn180AnimIndex;
	public int turn90CWAnimIndex;
	public int turn90CCWAnimIndex;
}