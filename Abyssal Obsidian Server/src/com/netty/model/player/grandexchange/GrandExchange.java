package com.netty.model.player.grandexchange;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:53:15 PM
 */
public class GrandExchange {

	/**
	 * 
	 */
	private Buy buy;

	/**
	 * 
	 */
	private Sell sell;

	/**
	 * 
	 * @param buy
	 * 			The id to set.
	 * @param sell
	 * 			The id to set.
	 */
	public GrandExchange(Buy buy, Sell sell) {
		this.setBuy(buy);
		this.setSell(sell);
	}

	/**
	 * 
	 * @param buy
	 * 			The id to set.
	 */
	public void setBuy(Buy buy) {
		this.buy = buy;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Buy getBuy() {
		return this.buy;
	}

	/**
	 * 
	 * @param sell
	 * 			The id to set.
	 */
	public void setSell(Sell sell) {
		this.sell = sell;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Sell getSell() {
		return this.sell;
	}
}