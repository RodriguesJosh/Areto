package com.netty.model.player.trade;

import java.util.List;

import com.netty.model.item.Item;
import com.netty.model.player.Player;
import com.netty.model.player.container.Container;
import com.netty.model.player.container.ContainerType;

/**
 * A <code>Trade</code> class that is
 * used to generate a session between
 * two {@link Player}s who wish to give
 * and receive {@link Item}s to each
 * other.
 * @author Josh
 * @since 0.1
 */
public class Trade {

	/**
	 * The first <code>Player</code> that
	 * trades.
	 */
	private Player firstPlayer;

	/**
	 * The second <code>Player</code> who wishes
	 * to trade.
	 */
	private Player secondPlayer;

	/**
	 * A <code>Container</code> that contains a
	 * {@link List} of <code>Item</code>s for the
	 * first window of the <code>Trade</code> screen.
	 */
	private Container firstTradeContainer;

	/**
	 * A <code>Container</code> that contains a
	 * {@link List} of <code>Item</code>s for the
	 * second window of the <code>Trade</code> screen.
	 */
	private Container secondTradeContainer;

	/**
	 * Constructs a new <code>Trade</code> session
	 * between two <code>Player</code>s.
	 * @param firstPlayer
	 * 			The first <code>Player</code> that is
	 *			currently in the <code>Trade</code> session.
	 * @param secondPlayer
	 * 			The second <code>Player</code> that is
	 *			currently in the <code>Trade</code> session.
	 */
	public Trade(Player firstPlayer, Player secondPlayer) {
		this.setFirstPlayer(firstPlayer);
		this.setSecondPlayer(secondPlayer);
		this.setFirstTradeContainer(new Container(TradeConstants.MAX_TRADE_SLOTS, ContainerType.STACKABLE));
		this.setSecondTradeContainer(new Container(TradeConstants.MAX_TRADE_SLOTS, ContainerType.STACKABLE));
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public Player getFirstPlayer() {
		return this.firstPlayer;
	}

	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public Player getSecondPlayer() {
		return this.secondPlayer;
	}

	public void setFirstTradeContainer(Container firstTradeContainer) {
		this.firstTradeContainer = firstTradeContainer;
	}

	public Container getFirstTradeContainer() {
		return this.firstTradeContainer;
	}

	public void setSecondTradeContainer(Container secondTradeContainer) {
		this.secondTradeContainer = secondTradeContainer;
	}

	public Container getSecondTradeContainer() {
		return this.secondTradeContainer;
	}
}
