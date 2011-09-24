package com.netty.model.player.donation;

import java.util.Calendar;

import com.netty.model.item.Item;
import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:50:19 PM
 */
public class Donation {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private Calendar timeCalendar;

	/**
	 * 
	 */
	private Item boughtItem;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param timeCalendar
	 * 			The id to set.
	 * @param boughtItem
	 * 			The id to set.
	 */
	public Donation(Player player, Calendar timeCalendar, Item boughtItem) {
		this.setPlayer(player);
		this.setTimeCalendar(timeCalendar);
		this.setBoughtItem(boughtItem);
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * @param timeCalendar
	 * 			The id to set.
	 */
	public void setTimeCalendar(Calendar timeCalendar) {
		this.timeCalendar = timeCalendar;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Calendar getTimeCalendar() {
		return this.timeCalendar;
	}

	/**
	 * 
	 * @param boughtItem
	 * 			The id to set.
	 */
	public void setBoughtItem(Item boughtItem) {
		this.boughtItem = boughtItem;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Item getBoughtItem() {
		return this.boughtItem;
	}
}