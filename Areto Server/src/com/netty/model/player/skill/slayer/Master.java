package com.netty.model.player.skill.slayer;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:36:13 AM
 */
public enum Master {

	/**
	 * 
	 */
	TURAEL(3, -1, null),

	/**
	 * 
	 */
	SPRIA(3, -1, null),

	/**
	 * 
	 */
	MAZCHNA(20, -1, new String[] { "Priest in Peril" }),

	/**
	 * 
	 */
	ACHTRYN(20, -1, new String[] { "Priest in Peril" }),

	/**
	 * 
	 */
	VANNAKA(40, -1, null),

	/**
	 * 
	 */
	CHAELDAR(70, -1, new String[] { "Lost City" }),

	/**
	 * 
	 */
	SUMONA(85, 35, new String[] { "Smoking Kills" }),

	/**
	 * 
	 */
	DURADEL(100, 50, new String[] { "Shilo Village" }),

	/**
	 * 
	 */
	LAPALOK(100, 50, new String[] { "Shilo Village" }),

	/**
	 * 
	 */
	KURADEL(110, 75, new String[] { "Ancient Cavern" });

	/**
	 * 
	 */
	private int combatNeeded;

	/**
	 * 
	 */
	private int slayerNeeded;

	/**
	 * 
	 */
	private String[] questsNeeded;

	/**
	 * 
	 * @param combatNeeded
	 * 			The id to set.
	 * @param slayerNeeded
	 * 			The id to set.
	 * @param questsNeeded
	 * 			The id to set.
	 */
	private Master(int combatNeeded, int slayerNeeded, String[] questsNeeded) {
		this.setCombatNeeded(combatNeeded);
		this.setSlayerNeeded(slayerNeeded);
		this.setQuestsNeeded(questsNeeded);
	}

	/**
	 * 
	 * @param combatNeeded
	 * 			The id to set.
	 */
	public void setCombatNeeded(int combatNeeded) {
		this.combatNeeded = combatNeeded;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getCombatNeeded() {
		return this.combatNeeded;
	}

	/**
	 * 
	 * @param slayerNeeded
	 * 			The id to set.
	 */
	public void setSlayerNeeded(int slayerNeeded) {
		this.slayerNeeded = slayerNeeded;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getSlayerNeeded() {
		return this.slayerNeeded;
	}

	/**
	 * 
	 * @param questsNeeded
	 * 			The id to set.
	 */
	public void setQuestsNeeded(String[] questsNeeded) {
		this.questsNeeded = questsNeeded;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String[] getQuestsNeeded() {
		return this.questsNeeded;
	}
}