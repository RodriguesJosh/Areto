package com.netty.model.player.skill.dungeoneering.doors;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:02:46 AM
 */
public class Door {

	/**
	 * 
	 */
	private BasicDoor basicDoor;

	/**
	 * 
	 */
	private SkillDoor skillDoor;

	/**
	 * 
	 * @param basicDoor
	 * 			The id to set.
	 */
	public void setBasicDoor(BasicDoor basicDoor) {
		this.basicDoor = basicDoor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BasicDoor getBasicDoor() {
		return this.basicDoor;
	}

	/**
	 * 
	 * @param skillDoor
	 * 			The id to set.
	 */
	public void setSkillDoor(SkillDoor skillDoor) {
		this.skillDoor = skillDoor;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public SkillDoor getSkillDoor() {
		return this.skillDoor;
	}
}