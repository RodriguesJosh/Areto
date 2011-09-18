package com.netty.model.player.minigame.barbarianassault;

public enum Style {

	ONE(AttackStyle.CONTROLLED, AttackStyle.BRONZE, AttackStyle.WIND), TWO(AttackStyle.ACCURATE, AttackStyle.IRON, AttackStyle.WATER),
	THREE(AttackStyle.AGGRESSIVE, AttackStyle.STEEL, AttackStyle.EARTH), FOUR(AttackStyle.DEFENSIVE, AttackStyle.MITHRIL, AttackStyle.FIRE);

	private AttackStyle[] attackStyle;

	private Style(AttackStyle... attackStyle) {
		this.setAttackStyle(attackStyle);
	}

	public void setAttackStyle(AttackStyle... attackStyle) {
		this.attackStyle = attackStyle;
	}

	public AttackStyle[] getAttackStyle() {
		return this.attackStyle;
	}
}