package com.netty.model.player.donation;

import java.util.Calendar;

import com.netty.model.item.Item;
import com.netty.model.player.Player;

public class Donation {

	private Player player;
	private Calendar timeCalendar;
	private Item boughtItem;

	public Donation(Player player, Calendar timeCalendar, Item boughtItem) {
		this.setPlayer(player);
		this.setTimeCalendar(timeCalendar);
		this.setBoughtItem(boughtItem);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setTimeCalendar(Calendar timeCalendar) {
		this.timeCalendar = timeCalendar;
	}

	public Calendar getTimeCalendar() {
		return this.timeCalendar;
	}

	public void setBoughtItem(Item boughtItem) {
		this.boughtItem = boughtItem;
	}

	public Item getBoughtItem() {
		return this.boughtItem;
	}
}