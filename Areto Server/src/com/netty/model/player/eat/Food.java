package com.netty.model.player.eat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:51:25 PM
 */
public enum Food {

	/**
	 * 
	 */
	CRAYFISH(317),

	/**
	 * 
	 */
	ANCHOVIES(317),

	/**
	 * 
	 */
	GARDEN_PIE(317),

	/**
	 * 
	 */
	SHRIMP(317),

	/**
	 * 
	 */
	COOKED_CHICKEN(317),

	/**
	 * 
	 */
	COOKED_MEAT(317),

	/**
	 * 
	 */
	SARDINE(317),

	/**
	 * 
	 */
	BREAD(317),

	/**
	 * 
	 */
	HERRING(317),
	/**
	 * 
	 */
	MACKEREL(317),

	/**
	 * 
	 */
	TROUT(317),

	/**
	 * 
	 */
	COD(317),

	/**
	 * 
	 */
	PIKE(317),

	/**
	 * 
	 */
	SALMON(317),

	/**
	 * 
	 */
	TUNA(317),

	/**
	 * 
	 */
	CAKE(317),

	/**
	 * 
	 */
	LOBSTER(317),

	/**
	 * 
	 */
	BASS(317),

	/**
	 * 
	 */
	SWORDFISH(317),

	/**
	 * 
	 */
	BOTTLE_OF_WINE(317),

	/**
	 * 
	 */
	POTATO_WITH_CHEESE(317),

	/**
	 * 
	 */
	MONKFISH(317),

	/**
	 * 
	 */
	ANCHOVY_PIZZA(317),

	/**
	 * 
	 */
	SHARK(317),

	/**
	 * 
	 */
	SEA_TURTLE(317),

	/**
	 * 
	 */
	PINEAPPLE_PIZZA(317),

	/**
	 * 
	 */
	MANTA_RAY(317),

	/**
	 * 
	 */
	TUNA_POTATO(317),
	/**
	 * 
	 */
	WILD_PIE(317),

	/**
	 * 
	 */
	SUMMER_PIE(317),

	/**
	 * 
	 */
	ROCKTAIL(317),

	/**
	 * 
	 */
	BARON_SHARK(317),

	/**
	 * 
	 */
	JUJU_GUMBO(317);

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private byte gainedHealth;

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	private Food(int id) {
		this.setID(id);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * 
	 * @param gainedHealth
	 * 			The id to set.
	 */
	public void setGainedHealth(byte gainedHealth) {
		this.gainedHealth = gainedHealth;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public byte getGainedHealth() {
		return this.gainedHealth;
	}
}