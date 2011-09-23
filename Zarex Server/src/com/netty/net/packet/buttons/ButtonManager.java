package com.netty.net.packet.buttons;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:38:01 PM
 */
public class ButtonManager {

	/**
	 * 
	 */
	private ButtonHandler[] buttonHandlers;

	/**
	 * 
	 * @param buttonHandlers
	 * 			The id to set.
	 */
	public void setButtonHandlers(ButtonHandler[] buttonHandlers) {
		this.buttonHandlers = buttonHandlers;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ButtonHandler[] getButtonHandlers() {
		return this.buttonHandlers;
	}
}