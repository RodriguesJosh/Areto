package com.netty.model.player.skill;

import com.netty.model.player.Player;

public class Skill {

	private Player player;
	private byte id;
	private byte level;
	private int experience;

	public Skill(Player player, byte id) {
		this.setPlayer(player);
		this.setID(id);
		if (this.getID() == 3) {
			this.setLevel((byte) 10);
			this.setExperience(1184);
		} else {
			this.setLevel((byte) 1);
			this.setExperience(83);
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setID(byte id) {
		this.id = id;
	}

	public byte getID() {
		return this.id;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public byte getLevel() {
		return this.level;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}

	public void addLevel(int level) {
		byte addedLevel = this.getLevel();
		addedLevel += level;
		this.setLevel(addedLevel);
		this.getPlayer().getPacketSender().getSkills(this.getID());
	}

	public void removeLevel(int level) {
		byte removedLevel = this.getLevel();
		removedLevel -= level;
		this.setLevel(removedLevel);
		this.getPlayer().getPacketSender().getSkills(this.getID());
	}

	public void addExperience(int experience) {
		int addedExperience = this.getExperience();
		addedExperience += experience;
		this.setExperience(addedExperience);
		this.getPlayer().getPacketSender().getSkills(this.getID());
	}

	public void removeExperience(int experience) {
		int removedExperience = this.getExperience();
		removedExperience -= experience;
		this.setExperience(removedExperience);
		this.getPlayer().getPacketSender().getSkills(this.getID());
	}
}