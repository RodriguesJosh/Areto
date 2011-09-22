package com.netty.model.player.skill.fishing;

public enum Fish {

	CRAYFISH, SHRIMP, KARAMBWANJI, SARDINE, HERRING, ANCHOVY, MACKEREL, OYSTER, CASKET, SEAWEED, TROUT, COD, PIKE, SLIMEY_EEL, SALMON, FROG_SPAWN, TUNA,
	CAVE_EEL, RAINBOW_FISH, LOBSTER, BASS, SWORDFISH, LAVA_EEL, MONKFISH, KARAMBWAN, SHARK, SEA_TURTLE, MANTA_RAY, CAVEFISH, ROCKTAIL;

	private Tools tools;

	public void setTools(Tools tools) {
		this.tools = tools;
	}

	public Tools getTools() {
		return this.tools;
	}
}