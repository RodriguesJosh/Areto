package com.netty.model.player.skill.agility;

public enum Ticket {

	ONE(240, 264), TEN(2480, 2728), TWENTY_FIVE(6500, 7150), ONE_HUNDRED(28000, 30800), ONE_THOUSAND(320000, 352000);

	private int experience;
	private int glovesExperience;

	private Ticket(int experience, int glovesExperience) {
		this.setExperience(experience);
		this.setGlovesExperience(glovesExperience);
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setGlovesExperience(int glovesExperience) {
		this.glovesExperience = glovesExperience;
	}

	public int getGlovesExperience() {
		return this.glovesExperience;
	}
}