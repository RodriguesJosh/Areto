package com.netty.model.player.trade;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:46:49 PM
 */
public class TradeManager {

	/**
	 * 
	 */
	private Trade trade;

	/**
	 * 
	 * @param trade
	 * 			The trade to set.
	 */
	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	/**
	 * 
	 * @return trade
	 * 			Returns the trade to get.
	 */
	public Trade getTrade() {
		return this.trade;
	}
}