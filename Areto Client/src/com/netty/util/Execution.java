package com.netty.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:49:25 PM
 */
public class Execution {

	/**
	 * 
	 */
	private static ScheduledExecutorService scheduledExecutorService;

	/**
	 * 
	 */
	private static ThreadPoolExecutor threadPoolExecutor;

	/**
	 * 
	 */
	static {
		Execution.setScheduledExecutorService(Executors.newSingleThreadScheduledExecutor());
		Execution.setThreadPoolExecutor((ThreadPoolExecutor) Executors.newCachedThreadPool());
	}

	/**
	 * 
	 * @param scheduledExecutorService
	 * 			The id to set.
	 */
	public static void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		Execution.scheduledExecutorService = scheduledExecutorService;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static ScheduledExecutorService getScheduledExecutorService() {
		return Execution.scheduledExecutorService;
	}

	/**
	 * 
	 * @param threadPoolExecutor
	 * 			The id to set.
	 */
	public static void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
		Execution.threadPoolExecutor = threadPoolExecutor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public static ThreadPoolExecutor getThreadPoolExecutor() {
		return Execution.threadPoolExecutor;
	}
}