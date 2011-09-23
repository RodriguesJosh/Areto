package com.netty.net.update;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.netty.model.npc.NPC;
import com.netty.model.player.Player;
import com.netty.net.NetworkConstants;
import com.netty.net.update.npc.AfterNPCUpdate;
import com.netty.net.update.npc.BeforeNPCUpdate;
import com.netty.net.update.npc.NPCUpdate;
import com.netty.net.update.player.AfterPlayerUpdate;
import com.netty.net.update.player.BeforePlayerUpdate;
import com.netty.net.update.player.PlayerUpdate;
import com.netty.util.Execution;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 5:38:26 PM
 */
public class EntityUpdate implements Runnable {

	/**
	 * 
	 */
	private CountDownLatch countDownLatch;

	/**
	 * 
	 */
	private List<Runnable> beforeUpdateList = new Vector<Runnable>();

	/**
	 * 
	 */
	private List<Runnable> playerUpdateList = new Vector<Runnable>();

	/**
	 * 
	 */
	private List<Runnable> npcUpdateList = new Vector<Runnable>();

	/**
	 * 
	 */
	private List<Runnable> afterUpdateList = new Vector<Runnable>();

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.createExecutionableUpdates();
		this.executeBefore();
		this.executeUpdate();
		this.executeAfter();
	}

	/**
	 * 
	 */
	public void createExecutionableUpdates() {
		this.getBeforeUpdateList().clear();
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
		}
	}

	/**
	 * 
	 */
	public void executeBefore() {
		this.setCountDownLatch(new CountDownLatch(this.getBeforeUpdateList().size()));
		for (Runnable runnable : this.getBeforeUpdateList()) {
			Execution.getThreadPoolExecutor().submit(runnable);
		}
		try {
			this.getCountDownLatch().await(NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void executeUpdate() {
		this.setCountDownLatch(new CountDownLatch(this.getPlayerUpdateList().size()));
		for (Runnable runnable : this.getPlayerUpdateList()) {
			Execution.getThreadPoolExecutor().submit(runnable);
		}
		try {
			this.getCountDownLatch().await(NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		this.setCountDownLatch(new CountDownLatch(this.getNPCUpdateList().size()));
		for (Runnable runnable : this.getNPCUpdateList()) {
			Execution.getThreadPoolExecutor().submit(runnable);
		}
		try {
			this.getCountDownLatch().await(NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void executeAfter() {
		this.setCountDownLatch(new CountDownLatch(this.getAfterUpdateList().size()));
		for (Runnable runnable : this.getAfterUpdateList()) {
			Execution.getThreadPoolExecutor().submit(runnable);
		}
		try {
			this.getCountDownLatch().await(NetworkConstants.CYCLE_TIME, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * 
	 * @param countDownLatch
	 * 			The count down until next update to
	 * 			set.
	 */
	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	/**
	 * 
	 * @return countDownLatch
	 */
	public CountDownLatch getCountDownLatch() {
		return this.countDownLatch;
	}

	/**
	 * 
	 * @param beforeUpdateList
	 * 			The player's before updating list to
	 * 			set.
	 */
	public void setBeforeUpdateList(List<Runnable> beforeUpdateList) {
		this.beforeUpdateList = beforeUpdateList;
	}

	/**
	 * 
	 * @return beforeUpdateList
	 */
	public List<Runnable> getBeforeUpdateList() {
		return this.beforeUpdateList;
	}

	/**
	 * 
	 * @param playerUpdateList
	 * 			The player's updating list to set.
	 */
	public void setPlayerUpdateList(List<Runnable> playerUpdateList) {
		this.playerUpdateList = playerUpdateList;
	}

	/**
	 * 
	 * @return playerUpdateList
	 */
	public List<Runnable> getPlayerUpdateList() {
		return this.playerUpdateList;
	}

	/**
	 * 
	 * @param npcUpdateList
	 * 			The npc's updating list to set.
	 */
	public void setNPCUpdateList(List<Runnable> npcUpdateList) {
		this.npcUpdateList = npcUpdateList;
	}

	/**
	 * 
	 * @return npcUpdateList
	 */
	public List<Runnable> getNPCUpdateList() {
		return this.npcUpdateList;
	}

	/**
	 * 
	 * @param afterUpdateList
	 * 			The player's and npc's after updating
	 * 			list to set.
	 */
	public void setAfterUpdateList(List<Runnable> afterUpdateList) {
		this.afterUpdateList = afterUpdateList;
	}

	/**
	 * 
	 * @return afterUpdateList
	 */
	public List<Runnable> getAfterUpdateList() {
		return this.afterUpdateList;
	}
}