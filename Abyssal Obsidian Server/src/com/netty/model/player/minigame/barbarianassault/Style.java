package com.netty.model.player.minigame.barbarianassault;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:01:55 PM
 */
public enum Style {

	/**
	 * 
	 */
	ONE(AttackStyle.CONTROLLED, AttackStyle.BRONZE, AttackStyle.WIND),

	/**
	 * 
	 */
	TWO(AttackStyle.ACCURATE, AttackStyle.IRON, AttackStyle.WATER),

	/**
	 * 
	 */
	THREE(AttackStyle.AGGRESSIVE, AttackStyle.STEEL, AttackStyle.EARTH),

	/**
	 * 
	 */
	FOUR(AttackStyle.DEFENSIVE, AttackStyle.MITHRIL, AttackStyle.FIRE);

	/**
	 * 
	 */
	private AttackStyle[] attackStyle;

	/**
	 * 
	 * @param attackStyle
	 * 			The id to set.
	 */
	private Style(AttackStyle... attackStyle) {
		this.setAttackStyle(attackStyle);
	}

	/**
	 * 
	 * @param attackStyle
	 * 			The id to set.
	 */
	public void setAttackStyle(AttackStyle... attackStyle) {
		this.attackStyle = attackStyle;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public AttackStyle[] getAttackStyle() {
		return this.attackStyle;
	}
}