package com.netty.game;

import java.awt.Frame;
import java.awt.Graphics;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:21:56 PM
 */
public class RSFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -429138665848536598L;

	/**
	 * 
	 */
	private RSApplet rsApplet;

	/**
	 * 
	 * @param rsApplet
	 * 			The id to set.
	 * @param width
	 * 			The id to set.
	 * @param height
	 * 			The id to set.
	 */
	public RSFrame(RSApplet rsApplet, int width, int height) {
		this.setRSApplet(rsApplet);
		this.setTitle("Jagex");
		this.setResizable(false);
		this.setVisible(true);
		this.toFront();
		this.setSize(width + 8, height + 28);
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#getGraphics()
	 */
	@Override
	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		g.translate(4, 24);
		return g;
	}

	/* (non-Javadoc)
	 * @see java.awt.Container#update(java.awt.Graphics)
	 */
	@Override
	public void update(Graphics g) {
		this.getRSApplet().update(g);
	}

	/* (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		this.getRSApplet().paint(g);
	}

	/**
	 * 
	 * @param rsApplet
	 * 			The id to set.
	 */
	public void setRSApplet(RSApplet rsApplet) {
		this.rsApplet = rsApplet;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RSApplet getRSApplet() {
		return this.rsApplet;
	}
}