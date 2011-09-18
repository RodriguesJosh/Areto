package com.netty.model.player.skill.farming;

public class Farming {

	private Allotment allotment;
	private Flower flower;
	private Herb herb;
	private Seeds seeds;
	private Tools tools;

	public void setAllotment(Allotment allotment) {
		this.allotment = allotment;
	}

	public Allotment getAllotment() {
		return this.allotment;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setHerb(Herb herb) {
		this.herb = herb;
	}

	public Herb getHerb() {
		return this.herb;
	}

	public void setSeeds(Seeds seeds) {
		this.seeds = seeds;
	}

	public Seeds getSeeds() {
		return this.seeds;
	}

	public void setTools(Tools tools) {
		this.tools = tools;
	}

	public Tools getTools() {
		return this.tools;
	}
}