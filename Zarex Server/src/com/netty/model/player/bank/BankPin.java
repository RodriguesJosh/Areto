package com.netty.model.player.bank;

import com.netty.model.player.Player;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:23:06 AM
 */
public class BankPin {

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 */
	private byte firstPin;

	/**
	 * 
	 */
	private byte secondPin;

	/**
	 * 
	 */
	private byte thirdPin;

	/**
	 * 
	 */
	private byte fourthPin;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public BankPin(Player player) {
		this.setPlayer(player);
		player.getPacketSender().getBank();
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
	 * @param firstPin
	 * 			The id to set.
	 */
	public void setFirstPin(byte firstPin) {
		this.firstPin = firstPin;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getFirstPin() {
		return this.firstPin;
	}

	/**
	 * 
	 * @param secondPin
	 * 			The id to set.
	 */
	public void setSecondPin(byte secondPin) {
		this.secondPin = secondPin;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getSecondPin() {
		return this.secondPin;
	}

	/**
	 * 
	 * @param thirdPin
	 * 			The id to set.
	 */
	public void setThirdPin(byte thirdPin) {
		this.thirdPin = thirdPin;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getThirdPin() {
		return this.thirdPin;
	}

	/**
	 * 
	 * @param fourthPin
	 * 			The id to set.
	 */
	public void setFourthPin(byte fourthPin) {
		this.fourthPin = fourthPin;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getFourthPin() {
		return this.fourthPin;
	}
}