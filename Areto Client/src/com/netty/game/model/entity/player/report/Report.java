package com.netty.game.model.entity.player.report;

import com.netty.game.model.entity.player.Rule;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:54:44 PM
 */
public class Report {

	/**
	 * 
	 */
	private String message;

	/**
	 * 
	 */
	private Rule ruleBroken;

	/**
	 * 
	 */
	private byte blackMarks;

	/**
	 * 
	 * @param message
	 * 			The id to set.
	 * @param ruleBroken
	 * 			The id to set.
	 * @param blackMarks
	 * 			The id to set.
	 */
	public Report(String message, Rule ruleBroken, byte blackMarks) {
		this.setMessage(message);
		this.setRuleBroken(ruleBroken);
		this.setBlackMarks(blackMarks);
	}

	/**
	 * 
	 * @param message
	 * 			The id to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * 
	 * @param ruleBroken
	 * 			The id to set.
	 */
	public void setRuleBroken(Rule ruleBroken) {
		this.ruleBroken = ruleBroken;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Rule getRuleBroken() {
		return this.ruleBroken;
	}

	/**
	 * 
	 * @param blackMarks
	 * 			The id to set.
	 */
	public void setBlackMarks(byte blackMarks) {
		this.blackMarks = blackMarks;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getBlackMarks() {
		return this.blackMarks;
	}
}