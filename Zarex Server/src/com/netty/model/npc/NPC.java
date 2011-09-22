package com.netty.model.npc;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.Entity;
import com.netty.model.item.Item;
import com.netty.model.update.Transform;
import com.netty.model.update.UpdateFlag;

public class NPC extends Entity {

	private List<short[]> locationList;
	private Item[] itemDrops;
	private byte chance;
	private Transform transform;

	public NPC(int id) {
		this.setID(id);
		this.setLocationList(new ArrayList<short[]>());
	}

	public void setWalkableLocations(short minX, short minY, short maxX, short maxY) {
		short xAmount = (short) (maxX - minX);
		short yAmount = (short) (maxY - minY);
		for (short x = 0; x < xAmount; x++) {
			for (short y = 0; y < yAmount; y++) {
				short locationX = (short) (minX + x);
				short locationY = (short) (minY + y);
				this.getLocationList().add(new short[] { locationX, locationY });
			}
		}
	}

	public void setLocationList(List<short[]> locationList) {
		this.locationList = locationList;
	}

	public List<short[]> getLocationList() {
		return this.locationList;
	}

	public void setItemDrops(Item[] itemDrops) {
		this.itemDrops = itemDrops;
	}

	public Item[] getItemDrops() {
		return this.itemDrops;
	}

	public void setChance(byte chance) {
		this.chance = chance;
	}

	public byte getChance() {
		return this.chance;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
		if (transform != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.TRANSFORM);
		}
	}

	public Transform getTransform() {
		return this.transform;
	}
}