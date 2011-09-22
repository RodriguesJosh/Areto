package com.netty.model.player.minigame.blastfurnace;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class BlastFurnace extends MiniGame {

	private ConveyorBelt conveyorBelt;
	private FurnaceStove furnaceStove;
	private HeatPump heatPump;
	private TemperatureGauge temperatureGauge;

	public BlastFurnace(Player player) {
		super(player);
		this.setConveyorBelt(new ConveyorBelt());
	}

	@Override
	public void start() {
		if (this.getFurnaceStove().getGrateColor().equals(GrateColor.HOT)) {
			this.setHeatPump(new HeatPump());
		}
	}

	@Override
	public void end() {}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setConveyorBelt(ConveyorBelt conveyorBelt) {
		this.conveyorBelt = conveyorBelt;
	}

	public ConveyorBelt getConveyorBelt() {
		return this.conveyorBelt;
	}

	public void setFurnaceStove(FurnaceStove furnaceStove) {
		this.furnaceStove = furnaceStove;
	}

	public FurnaceStove getFurnaceStove() {
		return this.furnaceStove;
	}

	public void setHeatPump(HeatPump heatPump) {
		this.heatPump = heatPump;
	}

	public HeatPump getHeatPump() {
		return this.heatPump;
	}

	public void setTemperatureGauge(TemperatureGauge temperatureGauge) {
		this.temperatureGauge = temperatureGauge;
	}

	public TemperatureGauge getTemperatureGauge() {
		return this.temperatureGauge;
	}
}
