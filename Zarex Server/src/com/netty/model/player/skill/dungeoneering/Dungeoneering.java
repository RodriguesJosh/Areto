package com.netty.model.player.skill.dungeoneering;

public class Dungeoneering {

	private Floor[] floors;

	public Dungeoneering() {
		this.setFloors(new Floor[61]);
	}

	public void setFloors(Floor[] floors) {
		this.floors = floors;
	}

	public Floor[] getFloors() {
		return this.floors;
	}
}