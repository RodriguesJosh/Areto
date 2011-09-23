package com.netty.model.npc;

import java.util.ArrayList;
import java.util.List;

import com.netty.model.Entity;
import com.netty.model.item.Item;
import com.netty.model.update.Transform;
import com.netty.model.update.UpdateFlag;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:53:31 AM
 */
public class NPC extends Entity {

	/**
	 * 
	 */
	private List<short[]> locationList;
	/**
	 * 
	 */
	private Item[] itemDrops;
	/**
	 * 
	 */
	private byte chance;
	/**
	 * 
	 */
	private Transform transform;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public NPC(int id) {
		this.setID(id);
		this.setLocationList(new ArrayList<short[]>());
	}

	/**
	 * 
	 * @param minX
	 * 			The id to set.
	 * @param minY
	 * 			The id to set.
	 * @param maxX
	 * 			The id to set.
	 * @param maxY
	 * 			The id to set.
	 */
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

	/**
	 * 
	 * @param locationList
	 * 			The id to set.
	 */
	public void setLocationList(List<short[]> locationList) {
		this.locationList = locationList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<short[]> getLocationList() {
		return this.locationList;
	}

	/**
	 * 
	 * @param itemDrops
	 * 			The id to set.
	 */
	public void setItemDrops(Item[] itemDrops) {
		this.itemDrops = itemDrops;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item[] getItemDrops() {
		return this.itemDrops;
	}

	/**
	 * 
	 * @param chance
	 * 			The id to set.
	 */
	public void setChance(byte chance) {
		this.chance = chance;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getChance() {
		return this.chance;
	}

	/**
	 * 
	 * @param transform
	 * 			The id to set.
	 */
	public void setTransform(Transform transform) {
		this.transform = transform;
		if (transform != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.TRANSFORM);
		}
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Transform getTransform() {
		return this.transform;
	}
}