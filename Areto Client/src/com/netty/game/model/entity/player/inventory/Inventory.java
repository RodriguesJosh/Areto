package com.netty.game.model.entity.player.inventory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import com.netty.game.graphics.image.RGBImage;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:54:13 PM
 */
public class Inventory {

	/**
	 * 
	 */
	private Deque<Tab> tabList;

	/**
	 * 
	 */
	private List<Integer> inventorySlotList;

	/**
	 * 
	 */
	private RGBImage inventoryRGBImage;

	/**
	 * 
	 */
	public Inventory() {
		this.setTabList((Deque<Tab>) Collections.unmodifiableCollection(new ArrayDeque<Tab>()));
		for (short s = 0; s < 13; s++) {
			this.getTabList().add(new Tab(s));
		}
		this.setInventorySlotList(new ArrayList<Integer>());
	}

	/**
	 * 
	 * @param tabList
	 * 			The id to set.
	 */
	public void setTabList(Deque<Tab> tabList) {
		this.tabList = tabList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Deque<Tab> getTabList() {
		return this.tabList;
	}

	/**
	 * 
	 * @param inventorySlotList
	 * 			The id to set.
	 */
	public void setInventorySlotList(List<Integer> inventorySlotList) {
		this.inventorySlotList = inventorySlotList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Integer> getInventorySlotList() {
		return this.inventorySlotList;
	}

	/**
	 * 
	 * @param inventoryRGBImage
	 * 			The id to set.
	 */
	public void setInventoryRGBImage(RGBImage inventoryRGBImage) {
		this.inventoryRGBImage = inventoryRGBImage;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RGBImage getInventoryRGBImage() {
		return this.inventoryRGBImage;
	}
}