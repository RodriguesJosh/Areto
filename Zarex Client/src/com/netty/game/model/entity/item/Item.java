package com.netty.game.model.entity.item;

import com.netty.game.model.Model;
import com.netty.stuff.Animable;

public class Item extends Animable {

	@Override
	public Model getRotatedModel() {
		ItemDef itemDef = ItemDef.forID(this.id);
		return itemDef.method201(this.itemCount);
	}

	public Item() {}

	public int id;
	public int x;
	public int y;
	public int itemCount;
}