package com.netty.model.player.bank;

import com.netty.model.player.Player;

public class BankPin {

	private Player player;
	private byte firstPin;
	private byte secondPin;
	private byte thirdPin;
	private byte fourthPin;

	public BankPin(Player player) {
		this.setPlayer(player);
		player.getPacketSender().getBank();
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setFirstPin(byte firstPin) {
		this.firstPin = firstPin;
	}

	public byte getFirstPin() {
		return this.firstPin;
	}

	public void setSecondPin(byte secondPin) {
		this.secondPin = secondPin;
	}

	public byte getSecondPin() {
		return this.secondPin;
	}

	public void setThirdPin(byte thirdPin) {
		this.thirdPin = thirdPin;
	}

	public byte getThirdPin() {
		return this.thirdPin;
	}

	public void setFourthPin(byte fourthPin) {
		this.fourthPin = fourthPin;
	}

	public byte getFourthPin() {
		return this.fourthPin;
	}
}