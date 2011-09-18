package com.netty.model.player.skill.dungeoneering.doors;

public class Door {

	private BasicDoor basicDoor;
	private SkillDoor skillDoor;

	public void setBasicDoor(BasicDoor basicDoor) {
		this.basicDoor = basicDoor;
	}

	public BasicDoor getBasicDoor() {
		return this.basicDoor;
	}

	public void setSkillDoor(SkillDoor skillDoor) {
		this.skillDoor = skillDoor;
	}

	public SkillDoor getSkillDoor() {
		return this.skillDoor;
	}
}