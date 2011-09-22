package com.netty.model.player.skill.summoning;

public class Summoning {

	private DogPet dogPet;
	private EggPet eggPet;
	private HuntedPet huntedPet;
	private OtherPet otherPet;
	private Pouch pouch;
	private SoulWarPet soulWarPet;

	public void setDogPet(DogPet dogPet) {
		this.dogPet = dogPet;
	}

	public DogPet getDogPet() {
		return this.dogPet;
	}

	public void setEggPet(EggPet eggPet) {
		this.eggPet = eggPet;
	}

	public EggPet getEggPet() {
		return this.eggPet;
	}

	public void setHuntedPet(HuntedPet huntedPet) {
		this.huntedPet = huntedPet;
	}

	public HuntedPet getHuntedPet() {
		return this.huntedPet;
	}

	public void setOtherPet(OtherPet otherPet) {
		this.otherPet = otherPet;
	}

	public OtherPet getOtherPet() {
		return this.otherPet;
	}

	public void setPouch(Pouch pouch) {
		this.pouch = pouch;
	}

	public Pouch getPouch() {
		return this.pouch;
	}

	public void setSoulWarPet(SoulWarPet soulWarPet) {
		this.soulWarPet = soulWarPet;
	}

	public SoulWarPet getSoulWarPet() {
		return this.soulWarPet;
	}
}