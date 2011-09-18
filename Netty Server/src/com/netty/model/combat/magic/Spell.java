package com.netty.model.combat.magic;

import com.netty.model.update.Animation;
import com.netty.model.update.Graphic;

public abstract class Spell {

	public abstract Animation getAnimation();
	public abstract Graphic getGraphic();
}