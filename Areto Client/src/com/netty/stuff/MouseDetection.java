package com.netty.stuff;

import com.netty.game.Client;

public class MouseDetection implements Runnable {

	@Override
	public void run() {
		while (this.running)  {
			synchronized (this.syncObject) {
				if (this.coordsIndex < 500) {
					this.coordsX[this.coordsIndex] = this.client.mouseX;
					this.coordsY[this.coordsIndex] = this.client.mouseY;
					this.coordsIndex++;
				}
			}
			try {
				Thread.sleep(50L);
			} catch (Exception _ex) {}
		}
	}

	public MouseDetection(Client client) {
		this.syncObject = new Object();
		this.coordsY = new int[500];
		this.running = true;
		this.coordsX = new int[500];
		this.client = client;
	}

	private Client client;
	public final Object syncObject;
	public final int[] coordsY;
	public boolean running;
	public final int[] coordsX;
	public int coordsIndex;
}