package com.netty.stuff;

import com.netty.game.model.Model;

public class StillGraphic extends Animable {

	public StillGraphic(int i, int j, int l, int i1, int j1, int k1, int l1) {
		this.transformCompleted = false;
		this.spotAnim = SpotAnim.cache[i1];
		this.plane = i;
		this.x = l1;
		this.y = k1;
		this.worldZ = j1;
		this.stillGraphicsLoopCycle = j + l;
	}

	@Override
	public Model getRotatedModel() {
		Model model = this.spotAnim.getModel();
		if (model == null) {
			return null;
		}
		int j = this.spotAnim.animationSequence.frame2IDS[this.eclapsedFrames];
		Model model_1 = new Model(true, Animation.method532(j), false, model);
		if (!this.transformCompleted) {
			model_1.method469();
			model_1.method470(j);
			model_1.triangleSkin = null;
			model_1.vertexSkin = null;
		}
		if ((this.spotAnim.resizeXY != 128) || (this.spotAnim.resizeZ != 128)) {
			model_1.method478(this.spotAnim.resizeXY, this.spotAnim.resizeXY, this.spotAnim.resizeZ);
		}
		if (this.spotAnim.rotation != 0) {
			if (this.spotAnim.rotation == 90) {
				model_1.method473();
			}
			if (this.spotAnim.rotation == 180) {
				model_1.method473();
				model_1.method473();
			}
			if (this.spotAnim.rotation == 270) {
				model_1.method473();
				model_1.method473();
				model_1.method473();
			}
		}
		model_1.method479(64 + this.spotAnim.modelBrightness, 850 + this.spotAnim.modelShadow, -30, -50, -30, true);
		return model_1;
	}

	public void method454(int i) {
		for (this.duration += i; this.duration > this.spotAnim.animationSequence.method258(this.eclapsedFrames);) {
			this.duration -= this.spotAnim.animationSequence.method258(this.eclapsedFrames) + 1;
			this.eclapsedFrames++;
			if ((this.eclapsedFrames >= this.spotAnim.animationSequence.frameCount) && ((this.eclapsedFrames < 0) || (this.eclapsedFrames >= this.spotAnim.animationSequence.frameCount))) {
				this.eclapsedFrames = 0;
				this.transformCompleted = true;
			}
		}
	}

	public int plane;
	public int x;
	public int y;
	public int worldZ;
	public int stillGraphicsLoopCycle;
	public boolean transformCompleted;
	private SpotAnim spotAnim;
	private int eclapsedFrames;
	private int duration;
}