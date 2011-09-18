package com.netty.model.cycle;

import java.util.Queue;

/**
 * Represents a single {@code Cycle} in the server.
 * The {@code Cycle} will only contain its state
 * along with how many cycles it has to wait before
 * it will execute itself.
 * @author josh
 * @version 0.1
 * @since 0.1
 */
public abstract class Cycle {

	/**
	 * The amount of cycles to wait until
	 * it executes.
	 */
	private byte waitingCycles;

	/**
	 * Its state as to whether or not it is
	 * running/being executed at the moment.
	 */
	private CycleState cycleState;

	/**
	 * Constructs a new {@code Cycle} that will
	 * execute itself when the number of waiting
	 * cycles is at zero.
	 * @param waitingCycles
	 * 			The amount of cycles to wait before
	 * 			this cycle can do anything.
	 */
	public Cycle(byte waitingCycles) {
		this.setWaitingCycles(waitingCycles);
		this.setCycleState(CycleState.RUNNING);
	}

	/**
	 * Execute this cycle once the previous
	 * one is terminated.
	 */
	public abstract void executeCycle();

	/**
	 * Terminate this cycle once everthing
	 * inside the {@code Cycle} has occurred.
	 */
	public abstract void terminateCycle();

	/**
	 * Creates an amount of cycles to wait
	 * before the execution of this one.
	 * @param waitingCycles
	 * 			The amount of cycles to wait.
	 */
	public void setWaitingCycles(byte waitingCycles) {
		this.waitingCycles = waitingCycles;
	}

	/**
	 * Gets the amount of waiting cycles before
	 * this one can occur.
	 * @return waitingCycles
	 * 			The amount of cycles to wait.
	 */
	public byte getWaitingCycles() {
		return this.waitingCycles;
	}

	/**
	 * Creates a {@link Queue} that will provide
	 * us with executed cycles that will be used
	 * throughout the server.
	 * @param cycleState
	 * 			The state of the {@code Cycle}.
	 */
	public void setCycleState(CycleState cycleState) {
		this.cycleState = cycleState;
	}

	/**
	 * Gets the state of the cycle; if it is
	 * being executed or not.
	 * @return cycleState
	 * 			The state of the {@code Cycle}.
	 */
	public CycleState getCycleState() {
		return this.cycleState;
	}
}