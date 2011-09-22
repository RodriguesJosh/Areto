package com.netty.model.player.skill.slayer;

public enum Master {

	TURAEL(3, -1, null), SPRIA(3, -1, null), MAZCHNA(20, -1, new String[] { "Priest in Peril" }), ACHTRYN(20, -1, new String[] { "Priest in Peril" }),
	VANNAKA(40, -1, null), CHAELDAR(70, -1, new String[] { "Lost City" }), SUMONA(85, 35, new String[] { "Smoking Kills" }),
	DURADEL(100, 50, new String[] { "Shilo Village" }), LAPALOK(100, 50, new String[] { "Shilo Village" }),
	KURADEL(110, 75, new String[] { "Ancient Cavern" });

	private int combatNeeded;
	private int slayerNeeded;
	private String[] questsNeeded;

	private Master(int combatNeeded, int slayerNeeded, String[] questsNeeded) {
		this.setCombatNeeded(combatNeeded);
		this.setSlayerNeeded(slayerNeeded);
		this.setQuestsNeeded(questsNeeded);
	}

	public void setCombatNeeded(int combatNeeded) {
		this.combatNeeded = combatNeeded;
	}

	public int getCombatNeeded() {
		return this.combatNeeded;
	}

	public void setSlayerNeeded(int slayerNeeded) {
		this.slayerNeeded = slayerNeeded;
	}

	public int getSlayerNeeded() {
		return this.slayerNeeded;
	}

	public void setQuestsNeeded(String[] questsNeeded) {
		this.questsNeeded = questsNeeded;
	}

	public String[] getQuestsNeeded() {
		return this.questsNeeded;
	}
}