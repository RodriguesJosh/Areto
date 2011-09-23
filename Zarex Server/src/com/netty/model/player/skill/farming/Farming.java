package com.netty.model.player.skill.farming;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:11:55 AM
 */
public class Farming {

	/**
	 * 
	 */
	private Allotment allotment;

	/**
	 * 
	 */
	private Flower flower;

	/**
	 * 
	 */
	private Herb herb;

	/**
	 * 
	 */
	private Seeds seeds;

	/**
	 * 
	 */
	private Tools tools;

	/**
	 * 
	 * @param allotment
	 * 			The id to set.
	 */
	public void setAllotment(Allotment allotment) {
		this.allotment = allotment;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Allotment getAllotment() {
		return this.allotment;
	}

	/**
	 * 
	 * @param flower
	 * 			The id to set.
	 */
	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Flower getFlower() {
		return this.flower;
	}

	/**
	 * 
	 * @param herb
	 * 			The id to set.
	 */
	public void setHerb(Herb herb) {
		this.herb = herb;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Herb getHerb() {
		return this.herb;
	}

	/**
	 * 
	 * @param seeds
	 * 			The id to set.
	 */
	public void setSeeds(Seeds seeds) {
		this.seeds = seeds;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Seeds getSeeds() {
		return this.seeds;
	}

	/**
	 * 
	 * @param tools
	 * 			The id to set.
	 */
	public void setTools(Tools tools) {
		this.tools = tools;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Tools getTools() {
		return this.tools;
	}
}