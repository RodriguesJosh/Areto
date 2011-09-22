package com.netty.model.player;

public class Energy {

	private double energyAmount;

	public Energy(double energyAmount) {
		this.setEnergyAmount(energyAmount);
	}

	public void setEnergyAmount(double energyAmount) {
		this.energyAmount = energyAmount;
	}

	public double getEnergyAmount() {
		return this.energyAmount;
	}
}