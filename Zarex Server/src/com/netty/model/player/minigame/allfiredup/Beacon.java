package com.netty.model.player.minigame.allfiredup;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:57:10 PM
 */
public class Beacon {

	/**
	 * 
	 */
	private Log log;

	/**
	 * 
	 * @param log
	 * 			The id to set.
	 */
	public Beacon(Log log) {
		this.setLog(log);
	}

	/**
	 * 
	 * @param log
	 * 			The id to set.
	 */
	public void setLog(Log log) {
		this.log = log;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Log getLog() {
		return this.log;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isLit() {
		return (this.getLog() != null) && (this.getLog().getBurnTime() > 0);
	}
}