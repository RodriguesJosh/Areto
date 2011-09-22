package com.netty.game.graphics.image;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import com.netty.game.graphics.DrawingArea;

public class GraphicsBuffer implements ImageProducer, ImageObserver {

	public GraphicsBuffer(int i, int j, Component component) {
		this.canvasWidth = i;
		this.canvasHeight = j;
		this.componentPixels = new int[i * j];
		this.colorModel = new DirectColorModel(32, 0xff0000, 65280, 255);
		this.image = component.createImage(this);
		this.sendToConsumer();
		component.prepareImage(this.image, this);
		this.sendToConsumer();
		component.prepareImage(this.image, this);
		this.sendToConsumer();
		component.prepareImage(this.image, this);
		this.initDrawingArea();
	}

	public void initDrawingArea() {
		DrawingArea.initDrawingArea(this.canvasHeight, this.canvasWidth, this.componentPixels);
	}

	public void drawGraphics(int i, Graphics g, int k) {
		this.sendToConsumer();
		g.drawImage(this.image, k, i, this);
	}

	@Override
	public synchronized void addConsumer(ImageConsumer imageconsumer) {
		this.imageConsumer = imageconsumer;
		imageconsumer.setDimensions(this.canvasWidth, this.canvasHeight);
		imageconsumer.setProperties(null);
		imageconsumer.setColorModel(this.colorModel);
		imageconsumer.setHints(14);
	}

	@Override
	public synchronized boolean isConsumer(ImageConsumer imageconsumer) {
		return this.imageConsumer == imageconsumer;
	}

	@Override
	public synchronized void removeConsumer(ImageConsumer imageconsumer) {
		if (this.imageConsumer == imageconsumer) {
			this.imageConsumer = null;
		}
	}

	@Override
	public void startProduction(ImageConsumer imageconsumer) {
		this.addConsumer(imageconsumer);
	}

	@Override
	public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
		System.out.println("TDLR");
	}

	private synchronized void sendToConsumer() {
		if (this.imageConsumer != null) {
			this.imageConsumer.setPixels(0, 0, this.canvasWidth, this.canvasHeight, this.colorModel, this.componentPixels, 0, this.canvasWidth);
			this.imageConsumer.imageComplete(2);
		}
	}

	@Override
	public boolean imageUpdate(Image image, int i, int j, int k, int l, int i1) {
		return true;
	}

	public int[] componentPixels;
	private int canvasWidth;
	private int canvasHeight;
	private ColorModel colorModel;
	private ImageConsumer imageConsumer;
	private Image image;
}