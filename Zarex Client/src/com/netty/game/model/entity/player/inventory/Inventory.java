package com.netty.game.model.entity.player.inventory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import com.netty.game.graphics.image.RGBImage;

public class Inventory {

	private Deque<Tab> tabList;
	private List<Integer> inventorySlotList;
	private RGBImage inventoryRGBImage;

	public Inventory() {
		this.setTabList((Deque<Tab>) Collections.unmodifiableCollection(new ArrayDeque<Tab>()));
		for (short s = 0; s < 13; s++) {
			this.getTabList().add(new Tab(s));
		}
		this.setInventorySlotList(new ArrayList<Integer>());
	}

	public void setTabList(Deque<Tab> tabList) {
		this.tabList = tabList;
	}

	public Deque<Tab> getTabList() {
		return this.tabList;
	}

	public void setInventorySlotList(List<Integer> inventorySlotList) {
		this.inventorySlotList = inventorySlotList;
	}

	public List<Integer> getInventorySlotList() {
		return this.inventorySlotList;
	}

	public void setInventoryRGBImage(RGBImage inventoryRGBImage) {
		this.inventoryRGBImage = inventoryRGBImage;
	}

	public RGBImage getInventoryRGBImage() {
		return this.inventoryRGBImage;
	}
}