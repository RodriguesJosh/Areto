package com.netty.model.player.skill.cooking;

import com.netty.model.player.Player;

public class Cooking {

	private BakedPotato bakedPotato;
	private Bread bread;
	private Brewing brewing;
	private Cake cake;
	private Dairy dairy;
	private FireType fireType;
	private Fish fish;
	private GnomeCooking gnomeCooking;
	private HotDrink hotDrink;
	private Meat meat;
	private Pie pie;
	private Pizza pizza;
	private PotatoToppings potatoToppings;
	private Snails snails;
	private Stew stew;
	private Wine wine;

	public void execute(Player player) {}

	public void setBakedPotato(BakedPotato bakedPotato) {
		this.bakedPotato = bakedPotato;
	}

	public BakedPotato getBakedPotato() {
		return this.bakedPotato;
	}

	public void setBread(Bread bread) {
		this.bread = bread;
	}

	public Bread getBread() {
		return this.bread;
	}

	public void setBrewing(Brewing brewing) {
		this.brewing = brewing;
	}

	public Brewing getBrewing() {
		return this.brewing;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

	public Cake getCake() {
		return this.cake;
	}

	public void setDairy(Dairy dairy) {
		this.dairy = dairy;
	}

	public Dairy getDairy() {
		return this.dairy;
	}

	public void setFireType(FireType fireType) {
		this.fireType = fireType;
	}

	public FireType getFireType() {
		return this.fireType;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

	public Fish getFish() {
		return this.fish;
	}

	public void setGnomeCooking(GnomeCooking gnomeCooking) {
		this.gnomeCooking = gnomeCooking;
	}

	public GnomeCooking getGnomeCooking() {
		return this.gnomeCooking;
	}

	public void setHotDrink(HotDrink hotDrink) {
		this.hotDrink = hotDrink;
	}

	public HotDrink getHotDrink() {
		return this.hotDrink;
	}

	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	public Meat getMeat() {
		return this.meat;
	}

	public void setPie(Pie pie) {
		this.pie = pie;
	}

	public Pie getPie() {
		return this.pie;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Pizza getPizza() {
		return this.pizza;
	}

	public void setPotatoToppings(PotatoToppings potatoToppings) {
		this.potatoToppings = potatoToppings;
	}

	public PotatoToppings getPotatoToppings() {
		return this.potatoToppings;
	}

	public void setSnails(Snails snails) {
		this.snails = snails;
	}

	public Snails getSnails() {
		return this.snails;
	}

	public void setStew(Stew stew) {
		this.stew = stew;
	}

	public Stew getStew() {
		return this.stew;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}

	public Wine getWine() {
		return this.wine;
	}
}