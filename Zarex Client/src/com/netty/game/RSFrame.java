package com.netty.game;

import java.awt.Frame;
import java.awt.Graphics;

public class RSFrame extends Frame {

	private static final long serialVersionUID = -429138665848536598L;
	private RSApplet rsApplet;

	public RSFrame(RSApplet rsApplet, int width, int height) {
		this.setRSApplet(rsApplet);
		this.setTitle("Jagex");
		this.setResizable(false);
		this.setVisible(true);
		this.toFront();
		this.setSize(width + 8, height + 28);
	}

	@Override
	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		g.translate(4, 24);
		return g;
	}

	@Override
	public void update(Graphics g) {
		this.getRSApplet().update(g);
	}

	@Override
	public void paint(Graphics g) {
		this.getRSApplet().paint(g);
	}

	public void setRSApplet(RSApplet rsApplet) {
		this.rsApplet = rsApplet;
	}

	public RSApplet getRSApplet() {
		return this.rsApplet;
	}
}