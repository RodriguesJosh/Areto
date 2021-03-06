package com.netty.model.combat.magic.ancient;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.model.combat.magic.Spell;
import com.netty.model.update.Animation;
import com.netty.model.update.Graphic;

/**
 * A teleportation spell used to teleport
 * to the Lassar location.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 5:35:37 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class LassarTeleport extends Spell {

	/*
	 * (non-Javadoc)
	 * @see com.netty.model.combat.magic.Spell#getAnimation()
	 */
	@Override
	public Animation getAnimation() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netty.model.combat.magic.Spell#getGraphic()
	 */
	@Override
	public Graphic getGraphic() {
		return null;
	}
}