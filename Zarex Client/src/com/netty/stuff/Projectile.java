package com.netty.stuff;

import com.netty.game.model.Model;

public class Projectile extends Animable {

	public void method455(int i, int j, int k, int l) {
		if (!this.aBoolean1579) {
			double d = l - this.anInt1580;
			double d2 = j - this.anInt1581;
			double d3 = Math.sqrt((d * d) + (d2 * d2));
			this.aDouble1585 = this.anInt1580 + ((d * this.radius) / d3);
			this.aDouble1586 = this.anInt1581 + ((d2 * this.radius) / d3);
			this.aDouble1587 = this.drawHeight;
		}
		double d1 = (this.speedTime + 1) - i;
		this.aDouble1574 = (l - this.aDouble1585) / d1;
		this.aDouble1575 = (j - this.aDouble1586) / d1;
		this.aDouble1576 = Math.sqrt((this.aDouble1574 * this.aDouble1574) + (this.aDouble1575 * this.aDouble1575));
		if (!this.aBoolean1579) {
			this.aDouble1577 = -this.aDouble1576 * Math.tan(this.slope * 0.02454369D);
		}
		this.aDouble1578 = (2D * (k - this.aDouble1587 - (this.aDouble1577 * d1))) / (d1 * d1);
	}

	@Override
	public Model getRotatedModel() {
		Model model = this.spotAnim.getModel();
		if (model == null) {
			return null;
		}
		int j = -1;
		if (this.spotAnim.animationSequence != null) {
			j = this.spotAnim.animationSequence.frame2IDS[this.eclapsedFrames];
		}
		Model model_1 = new Model(true, Animation.method532(j), false, model);
		if (j != -1) {
			model_1.method469();
			model_1.method470(j);
			model_1.triangleSkin = null;
			model_1.vertexSkin = null;
		}
		if ((this.spotAnim.resizeXY != 128) || (this.spotAnim.resizeZ != 128)) {
			model_1.method478(this.spotAnim.resizeXY, this.spotAnim.resizeXY, this.spotAnim.resizeZ);
		}
		model_1.method474(this.anInt1596);
		model_1.method479(64 + this.spotAnim.modelBrightness, 850 + this.spotAnim.modelShadow, -30, -50, -30, true);
		return model_1;
	}

	public Projectile(int i, int j, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
		this.aBoolean1579 = false;
		this.spotAnim = SpotAnim.cache[l2];
		this.plane = k1;
		this.anInt1580 = j2;
		this.anInt1581 = i2;
		this.drawHeight = l1;
		this.delayTime = l;
		this.speedTime = i1;
		this.slope = i;
		this.radius = j1;
		this.lockOn = k2;
		this.endHeight = j;
		this.aBoolean1579 = false;
	}

	public void method456(int i) {
		this.aBoolean1579 = true;
		this.aDouble1585 += this.aDouble1574 * i;
		this.aDouble1586 += this.aDouble1575 * i;
		this.aDouble1587 += (this.aDouble1577 * i) + (0.5D * this.aDouble1578 * i * i);
		this.aDouble1577 += this.aDouble1578 * i;
		this.anInt1595 = ((int) (Math.atan2(this.aDouble1574, this.aDouble1575) * 325.94900000000001D) + 1024) & 0x7ff;
		this.anInt1596 = (int) (Math.atan2(this.aDouble1577, this.aDouble1576) * 325.94900000000001D) & 0x7ff;
		if (this.spotAnim.animationSequence != null) {
			for (this.duration += i; this.duration > this.spotAnim.animationSequence.method258(this.eclapsedFrames);) {
				this.duration -= this.spotAnim.animationSequence.method258(this.eclapsedFrames) + 1;
				this.eclapsedFrames++;
				if (this.eclapsedFrames >= this.spotAnim.animationSequence.frameCount) {
					this.eclapsedFrames = 0;
				}
			}
		}
	}

	public int delayTime;
	public int speedTime;
	private double aDouble1574;
	private double aDouble1575;
	private double aDouble1576;
	private double aDouble1577;
	private double aDouble1578;
	private boolean aBoolean1579;
	private int anInt1580;
	private int anInt1581;
	private int drawHeight;
	public int endHeight;
	public double aDouble1585;
	public double aDouble1586;
	public double aDouble1587;
	private int slope;
	private int radius;
	public int lockOn;
	private SpotAnim spotAnim;
	private int eclapsedFrames;
	private int duration;
	public int anInt1595;
	private int anInt1596;
	public int plane;
}