package com.netty.game.model.entity.npc;

import com.netty.game.model.Model;
import com.netty.game.model.entity.Entity;
import com.netty.game.model.entity.EntityDef;
import com.netty.stuff.Animation;
import com.netty.stuff.Sequence;
import com.netty.stuff.SpotAnim;

public class NPC extends Entity {

	private Model method450() {
		if ((super.anim >= 0) && (super.animationDelay == 0)) {
			int k = Sequence.anims[super.anim].frame2IDS[super.anInt1527];
			int i1 = -1;
			if ((super.anInt1517 >= 0) && (super.anInt1517 != super.standAnimIndex)) {
				i1 = Sequence.anims[super.anInt1517].frame2IDS[super.anInt1518];
			}
			return this.desc.method164(i1, k, Sequence.anims[super.anim].animationFlowControl);
		}
		int l = -1;
		if (super.anInt1517 >= 0) {
			l = Sequence.anims[super.anInt1517].frame2IDS[super.anInt1518];
		}
		return this.desc.method164(-1, l, null);
	}

	@Override
	public Model getRotatedModel() {
		if (this.desc == null) {
			return null;
		}
		Model model = this.method450();
		if (model == null) {
			return null;
		}
		super.height = model.modelHeight;
		if ((super.gfxID != -1) && (super.currentAnim != -1)) {
			SpotAnim spotAnim = SpotAnim.cache[super.gfxID];
			Model model_1 = spotAnim.getModel();
			if (model_1 != null) {
				int j = spotAnim.animationSequence.frame2IDS[super.currentAnim];
				Model model_2 = new Model(true, Animation.method532(j), false, model_1);
				model_2.method475(0, -super.graphicHeight, 0);
				model_2.method469();
				model_2.method470(j);
				model_2.triangleSkin = null;
				model_2.vertexSkin = null;
				if ((spotAnim.resizeXY != 128) || (spotAnim.resizeZ != 128)) {
					model_2.method478(spotAnim.resizeXY, spotAnim.resizeXY, spotAnim.resizeZ);
				}
				model_2.method479(64 + spotAnim.modelBrightness, 850 + spotAnim.modelShadow, -30, -50, -30, true);
				Model aModel[] = {
						model, model_2
				};
				model = new Model(aModel);
			}
		}
		if (this.desc.boundDim == 1) {
			model.oneSquareModel = true;
		}
		return model;
	}

	@Override
	public boolean isVisible() {
		return this.desc != null;
	}

	public NPC() {}

	public EntityDef desc;
}