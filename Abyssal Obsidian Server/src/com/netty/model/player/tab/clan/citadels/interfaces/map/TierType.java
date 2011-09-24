package com.netty.model.player.tab.clan.citadels.interfaces.map;

import com.netty.model.player.tab.clan.citadels.interfaces.customize.HotSpotFour;
import com.netty.model.player.tab.clan.citadels.interfaces.customize.HotSpotTwo;
import com.netty.model.player.tab.clan.citadels.skillplots.SkillPlots;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 11:13:28 PM
 */
public enum TierType {

	/**
	 * 
	 */
	ONE,

	/**
	 * 
	 */
	TWO,

	/**
	 * 
	 */
	THREE,

	/**
	 * 
	 */
	FOUR,

	/**
	 * 
	 */
	FIVE,

	/**
	 * 
	 */
	SIX,

	/**
	 * 
	 */
	SEVEN;

	/**
	 * 
	 */
	private SkillPlots[] skillPlots;

	/**
	 * 
	 */
	private HotSpotTwo[] hotSpotTwos;

	/**
	 * 
	 */
	private HotSpotFour[] hotSpotFours;

	/**
	 * 
	 */
	private byte percentageKept;

	/**
	 * 
	 */
	private short capPerResource;

	/**
	 * 
	 */
	private byte members;

	/**
	 * 
	 */
	private SkillPlots skillPlot;

	/**
	 * 
	 * @param skillPlots
	 * 			The skillPlots to set.
	 */
	public void setSkillPlots(SkillPlots[] skillPlots) {
		this.skillPlots = skillPlots;
	}

	/**
	 * 
	 * @return skillPlots
	 * 			Returns the skillPlots to get.
	 */
	public SkillPlots[] getSkillPlots() {
		return this.skillPlots;
	}

	/**
	 * 
	 * @param hotSpotTwos
	 * 			The hotSpotTwos to set.
	 */
	public void setHotSpotTwos(HotSpotTwo[] hotSpotTwos) {
		this.hotSpotTwos = hotSpotTwos;
	}

	/**
	 * 
	 * @return hotSpotTwos
	 * 			Returns the hotSpotTwos to get.
	 */
	public HotSpotTwo[] getHotSpotTwos() {
		return this.hotSpotTwos;
	}

	/**
	 * 
	 * @param hotSpotFours
	 * 			The hotSpotFours to set.
	 */
	public void setHotSpotFours(HotSpotFour[] hotSpotFours) {
		this.hotSpotFours = hotSpotFours;
	}

	/**
	 * 
	 * @return hotSpotFours
	 * 			Returns the hotSpotFours to get.
	 */
	public HotSpotFour[] getHotSpotFours() {
		return this.hotSpotFours;
	}

	/**
	 * 
	 * @param percentageKept
	 * 			The percentageKept to set.
	 */
	public void setPercentageKept(byte percentageKept) {
		this.percentageKept = percentageKept;
	}

	/**
	 * 
	 * @return percentageKept
	 * 			Returns the percentageKept to get.
	 */
	public byte getPercentageKept() {
		return this.percentageKept;
	}

	/**
	 * 
	 * @param capPerResource
	 * 			The capPerResource to set.
	 */
	public void setCapPerResource(short capPerResource) {
		this.capPerResource = capPerResource;
	}

	/**
	 * 
	 * @return capPerResource
	 * 			Returns the capPerResource to get.
	 */
	public short getCapPerResource() {
		return this.capPerResource;
	}

	/**
	 * 
	 * @param members
	 * 			The members to set.
	 */
	public void setMembers(byte members) {
		this.members = members;
	}

	/**
	 * 
	 * @return members
	 * 			Returns the members to get.
	 */
	public byte getMembers() {
		return this.members;
	}

	/**
	 * 
	 * @param skillPlot
	 * 			The skillPlot to set.
	 */
	public void setSkillPlot(SkillPlots skillPlot) {
		this.skillPlot = skillPlot;
	}

	/**
	 * 
	 * @return skillPlot
	 * 			Returns the skillPlot to get.
	 */
	public SkillPlots getSkillPlot() {
		return this.skillPlot;
	}
}