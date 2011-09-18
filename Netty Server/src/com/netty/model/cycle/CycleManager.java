package com.netty.model.cycle;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.netty.util.Execution;

/**
 * Handles every known cycle on the server. In
 * order for cycles to become executed, you must
 * wait until the previous cycle is done with
 * and then you can move on to the next one. This
 * is a must if you wish to stop packet spamming
 * along with mass clicking.
 * @author josh
 * @version 0.1
 * @since 0.1
 */
public class CycleManager implements Runnable {

	/**
	 * A {@link List} of unexecuted cycles yet
	 * to occur.
	 */
	private Queue<Cycle> unexecutedCycleList;

	/**
	 * A {@code List} filled with cycles that
	 * are being executed.
	 */
	private Queue<Cycle> cycleList;

	/**
	 * Constructs a new {@code CycleManager} that
	 * will handle of the cycles that occur on the
	 * server.
	 */
	public CycleManager() {
		this.setCycleList(new PriorityBlockingQueue<Cycle>());
		this.setUnexecutedCycleList(new ConcurrentLinkedQueue<Cycle>());
		Execution.getScheduledExecutorService().scheduleAtFixedRate(this, 0, CycleConstants.DEFAULT_CYCLE_TIME, TimeUnit.MILLISECONDS);
	}

	/**
	 * Adds a cycle to the unexecuted {@code List}.
	 * If the previous cycle is done waiting, it
	 * will execute itself.
	 * @param cycle
	 */
	public void addCycle(final Cycle cycle) {
		if (cycle.getWaitingCycles() == 0) {
			Execution.getScheduledExecutorService().execute(new Runnable() {
				@Override
				public void run() {
					cycle.executeCycle();
				}
			});
		}
		synchronized (this.getUnexecutedCycleList()) {
			this.getUnexecutedCycleList().add(cycle);
		}
	}

	/**
	 * Add all the previous cycles that have yet
	 * to be executed into the {@code List} that
	 * contains executed cycles. Once it is done
	 * with its execution, remove it.
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (this.getCycleList()) {
			Cycle cycle;
			while ((cycle = this.getUnexecutedCycleList().poll()) != null) {
				this.getCycleList().add(cycle);
			}
		}
		for (Iterator<Cycle> cycleIterator = this.getCycleList().iterator(); cycleIterator.hasNext();) {
			Cycle cycle = cycleIterator.next();
			if (cycle == null) {
				return;
			}
			if (cycle.getCycleState() == CycleState.RUNNING) {
				return;
			}
			cycleIterator.remove();
		}
	}

	/**
	 * Creates a {@link Queue} that will provide
	 * us with unexecuted cycles that have yet
	 * to occur.
	 * @param unexecutedCycleList
	 * 			The unexecuted {@code Queue} list.
	 */
	public void setUnexecutedCycleList(Queue<Cycle> unexecutedCycleList) {
		this.unexecutedCycleList = unexecutedCycleList;
	}

	/**
	 * Gets the {@code Queue} of unexecuted cycles.
	 * @return unexecutedCycleList
	 * 			The {@code Queue} that contains
	 * 			{@code Cycle}s that need to be executed.
	 */
	public Queue<Cycle> getUnexecutedCycleList() {
		return this.unexecutedCycleList;
	}

	/**
	 * Creates a {@link Queue} that will provide
	 * us with executed cycles that will be used
	 * throughout the server.
	 * @param cycleList
	 * 			The executed {@code Queue} list.
	 */
	public void setCycleList(Queue<Cycle> cycleList) {
		this.cycleList = cycleList;
	}

	/**
	 * Gets the {@code Queue} of executed cycles.
	 * @return cycleList
	 * 			The {@ Queue} that contains {@code Cycle}s
	 * 			that are being executed.
	 */
	public Queue<Cycle> getCycleList() {
		return this.cycleList;
	}
}