package com.netty.model.player.grandexchange;

public class GrandExchange {

	private Buy buy;
	private Sell sell;

	public GrandExchange(Buy buy, Sell sell) {
		this.setBuy(buy);
		this.setSell(sell);
	}

	public void setBuy(Buy buy) {
		this.buy = buy;
	}

	public Buy getBuy() {
		return this.buy;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

	public Sell getSell() {
		return this.sell;
	}
}