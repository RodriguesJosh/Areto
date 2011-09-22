package com.netty.net.update;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class EntityUpdate implements Runnable {

	private CountDownLatch countDownLatch;
	private List<Runnable> beforeUpdateList = new ArrayList<Runnable>();
	private List<Runnable> playerUpdateList = new ArrayList<Runnable>();
	private List<Runnable> npcUpdateList = new ArrayList<Runnable>();
	private List<Runnable> afterUpdateList = new ArrayList<Runnable>();

	@Override
	public void run() {
		// this.createExecutionableUpdates();
		// this.executeBefore();
		// this.executeUpdate();
		// this.executeAfter();
	}

	@SuppressWarnings("unused")
	private void createExecutionableUpdates() {
		/** this.getBeforeUpdateList().clear();
		this.getPlayerUpdateList().clear();
		this.getNPCUpdateList().clear();
		this.getAfterUpdateList().clear();
		for (Iterator<NPC> npcIterate = World.getWorld().getNPCList().iterator(); npcIterate.hasNext();) {
			NPC npc = npcIterate.next();
			this.getBeforeUpdateList().add(new BeforeNPCUpdate(this, npc));
			this.getAfterUpdateList().add(new AfterNPCUpdate(this, npc));
		}
		for (Iterator<Player> playerIterate = World.getWorld().getPlayerList().iterator(); playerIterate.hasNext();) {
			Player player = playerIterate.next();
			this.getBeforeUpdateList().add(new BeforePlayerUpdate(this, player));
			this.getPlayerUpdateList().add(new PlayerUpdate(this, player));
			this.getNPCUpdateList().add(new NPCUpdate(this, player));
			this.getAfterUpdateList().add(new AfterPlayerUpdate(this, player));
		} */
	}

	@SuppressWarnings("unused")
	private void executeBefore() {
		/** this.setCountDownLatch(new CountDownLatch(this.getBeforeUpdateList().size()));
		for (Runnable runnable : this.getBeforeUpdateList()) {
			Execution.getThreadPoolExecutor().submit(runnable);
		}
		try {
			this.getCountDownLatch().await(Constants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} */
	}

	@SuppressWarnings("unused")
	private void executeUpdate() {
		/** this.setCountDownLatch(new CountDownLatch(this.getPlayerUpdateList().size()));
		for (Runnable runnable : this.getPlayerUpdateList()) {
			Execution.getThreadPoolExecutor().submit(runnable);
		}
		try {
			this.getCountDownLatch().await(Constants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		this.setCountDownLatch(new CountDownLatch(this.getNPCUpdateList().size()));
		for (Runnable runnable : this.getNPCUpdateList()) {
			Execution.getThreadPoolExecutor().submit(runnable);
		}
		try {
			this.getCountDownLatch().await(Constants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} */
	}

	@SuppressWarnings("unused")
	private void executeAfter() {
		/** this.setCountDownLatch(new CountDownLatch(this.getAfterUpdateList().size()));
		for (Runnable runnable : this.getAfterUpdateList()) {
			Execution.getThreadPoolExecutor().submit(runnable);
		}
		try {
			this.getCountDownLatch().await(Constants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} */
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public CountDownLatch getCountDownLatch() {
		return this.countDownLatch;
	}

	public void setBeforeUpdateList(List<Runnable> beforeUpdateList) {
		this.beforeUpdateList = beforeUpdateList;
	}

	public List<Runnable> getBeforeUpdateList() {
		return this.beforeUpdateList;
	}

	public void setPlayerUpdateList(List<Runnable> playerUpdateList) {
		this.playerUpdateList = playerUpdateList;
	}

	public List<Runnable> getPlayerUpdateList() {
		return this.playerUpdateList;
	}

	public void setNPCUpdateList(List<Runnable> npcUpdateList) {
		this.npcUpdateList = npcUpdateList;
	}

	public List<Runnable> getNPCUpdateList() {
		return this.npcUpdateList;
	}

	public void setAfterUpdateList(List<Runnable> afterUpdateList) {
		this.afterUpdateList = afterUpdateList;
	}

	public List<Runnable> getAfterUpdateList() {
		return this.afterUpdateList;
	}
}