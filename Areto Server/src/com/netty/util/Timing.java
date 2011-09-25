package com.netty.util;

/**
 * A class for bench marking certain
 * tasks that you wish to optimize.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 5:52:49 PM
 */
public class Timing {

	/**
	 * The starting time that we benchmarked
	 * a specific task.
	 */
	private long startTime;

	/**
	 * Constructs a new benchmark for testing or
	 * optimizing the server if need be.
	 */
	public Timing() {
		this.setStartTime(System.currentTimeMillis());
	}

	/**
	 * Sets the start time for the benchmark
	 * when testing certain things.
	 * 
	 * @param startTime
	 * 			The starting time to set.
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the starting time for when you
	 * want to test/optimize something for
	 * speed.
	 * 
	 * @return startTime
	 * 			Returns the starting time.
	 */
	public long getStartTime() {
		return this.startTime;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ((System.currentTimeMillis() - this.getStartTime()) / 1000000.0) + "ms";
	}
}