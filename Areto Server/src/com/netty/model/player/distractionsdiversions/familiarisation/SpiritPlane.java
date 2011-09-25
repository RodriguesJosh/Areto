package com.netty.model.player.distractionsdiversions.familiarisation;

import java.util.Queue;

import com.netty.model.item.Item;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 23, 2011 7:22:39 PM
 */
public class SpiritPlane {

	/**
	 * You have collected 60 raw shards
	 * Your mental focus reaches 0.
	 * You have been there for 20 minutes.
	 */

	/**
	 * 
	 */
	private Queue<Item> shardItem;

	/**
	 * 
	 */
	private byte focus;

	/**
	 * 
	 */
	private byte seconds;

	/**
	 * 
	 */
	private byte minutes;

	/**
	 * 
	 */
	private Familiar familiar;

	/**
	 * 
	 * @param shardItem
	 * 			The shardItem to set.
	 */
	public void setShardItem(Queue<Item> shardItem) {
		this.shardItem = shardItem;
	}

	/**
	 * 
	 * @return shardItem
	 * 			Returns the shardItem to get.
	 */
	public Queue<Item> getShardItem() {
		return this.shardItem;
	}

	/**
	 * 
	 * @param focus
	 * 			The focus to set.
	 */
	public void setFocus(byte focus) {
		this.focus = focus;
	}

	/**
	 * 
	 * @return focus
	 * 			Returns the focus to get.
	 */
	public byte getFocus() {
		return this.focus;
	}

	/**
	 * 
	 * @param seconds
	 * 			The seconds to set.
	 */
	public void setSeconds(byte seconds) {
		this.seconds = seconds;
	}

	/**
	 * 
	 * @return seconds
	 * 			Returns the seconds to get.
	 */
	public byte getSeconds() {
		return this.seconds;
	}

	/**
	 * 
	 * @param minutes
	 * 			The minutes to set.
	 */
	public void setMinutes(byte minutes) {
		this.minutes = minutes;
	}

	/**
	 * 
	 * @return minutes
	 * 			Returns the minutes to get.
	 */
	public byte getMinutes() {
		return this.minutes;
	}

	/**
	 * 
	 * @param familiar
	 * 			The familiar to set.
	 */
	public void setFamiliar(Familiar familiar) {
		this.familiar = familiar;
	}

	/**
	 * 
	 * @return familiar
	 * 			Returns the familiar to get.
	 */
	public Familiar getFamiliar() {
		return this.familiar;
	}
}