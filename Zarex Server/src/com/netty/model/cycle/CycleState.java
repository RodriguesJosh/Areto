package com.netty.model.cycle;

/**
 * The state in which the cycle is running
 * or it is not. In order to test the next
 * cycle, the previous cycle must be set to
 * "NOT_RUNNING" in order for the next cycle
 * to occur. If the cycle is still running, it
 * will wait until it is done with and move on
 * to the next one.
 * @author josh
 * @version 0.1
 * @since 0.1
 */
public enum CycleState {

	/**
	 * The state of the cycle is currently
	 * running.
	 */
	RUNNING,

	/**
	 * The state of the cycle is currently not
	 * running. Either the cycle is done with
	 * its execution or it must wait until the
	 * previous cycle ends.
	 */
	NOT_RUNNING;
}