package com.netty.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class Execution {

	private static ScheduledExecutorService scheduledExecutorService;
	private static ThreadPoolExecutor threadPoolExecutor;

	static {
		Execution.setScheduledExecutorService(Executors.newSingleThreadScheduledExecutor());
		Execution.setThreadPoolExecutor((ThreadPoolExecutor) Executors.newCachedThreadPool());
	}

	public static void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		Execution.scheduledExecutorService = scheduledExecutorService;
	}

	public static ScheduledExecutorService getScheduledExecutorService() {
		return Execution.scheduledExecutorService;
	}

	public static void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
		Execution.threadPoolExecutor = threadPoolExecutor;
	}

	public static ThreadPoolExecutor getThreadPoolExecutor() {
		return Execution.threadPoolExecutor;
	}
}