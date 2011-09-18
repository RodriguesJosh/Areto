package com.netty.model.player.skill.fletching;

public class Fletching {

	private Arrow arrow;
	private Bolt bolt;
	private Bow bow;
	private Crossbow crossbow;
	private Dart dart;

	public void setArrow(Arrow arrow) {
		this.arrow = arrow;
	}

	public Arrow getArrow() {
		return this.arrow;
	}

	public void setBolt(Bolt bolt) {
		this.bolt = bolt;
	}

	public Bolt getBolt() {
		return this.bolt;
	}

	public void setBow(Bow bow) {
		this.bow = bow;
	}

	public Bow getBow() {
		return this.bow;
	}

	public void setCrossbow(Crossbow crossbow) {
		this.crossbow = crossbow;
	}

	public Crossbow getCrossbow() {
		return this.crossbow;
	}

	public void setDart(Dart dart) {
		this.dart = dart;
	}

	public Dart getDart() {
		return this.dart;
	}
}