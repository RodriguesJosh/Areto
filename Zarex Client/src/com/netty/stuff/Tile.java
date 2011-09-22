package com.netty.stuff;

import com.netty.game.model.entity.object.GroundDecoration;
import com.netty.game.model.entity.object.GroundItemTile;
import com.netty.game.model.entity.object.InteractableObject;
import com.netty.game.model.entity.object.WallDecoration;
import com.netty.game.model.entity.object.WallObject;
import com.netty.net.cache.Node;

public class Tile extends Node {

	public Tile(int i, int j, int k) {
		this.interactableObjects = new InteractableObject[5];
		this.anIntArray1319 = new int[5];
		this.anInt1310 = this.tileZ = i;
		this.anInt1308 = j;
		this.anInt1309 = k;
	}

	public int tileZ;
	public int anInt1308;
	public int anInt1309;
	public int anInt1310;
	public PlainTile myPlainTile;
	public ShapedTile shapedTile;
	public WallObject wallObject;
	public WallDecoration wallDecoration;
	public GroundDecoration groundDecoration;
	public GroundItemTile groundItemTile;
	public int entityCount;
	public InteractableObject[] interactableObjects;
	public int[] anIntArray1319;
	public int anInt1320;
	public int logicHeight;
	public boolean aBoolean1322;
	public boolean aBoolean1323;
	public boolean aBoolean1324;
	public int anInt1325;
	public int anInt1326;
	public int anInt1327;
	public int anInt1328;
	public Tile tileBelowZero;
}