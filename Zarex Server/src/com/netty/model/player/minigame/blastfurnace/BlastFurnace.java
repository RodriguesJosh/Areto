package com.netty.model.player.minigame.blastfurnace;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:07:33 PM
 */
public class BlastFurnace extends MiniGame {

	/**
	 * 
	 */
	private ConveyorBelt conveyorBelt;

	/**
	 * 
	 */
	private FurnaceStove furnaceStove;

	/**
	 * 
	 */
	private HeatPump heatPump;

	/**
	 * 
	 */
	private TemperatureGauge temperatureGauge;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public BlastFurnace(Player player) {
		super(player);
		this.setConveyorBelt(new ConveyorBelt());
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		if (this.getFurnaceStove().getGrateColor().equals(GrateColor.HOT)) {
			this.setHeatPump(new HeatPump());
		}
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() {
		return;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getMembershipState()
	 */
	@Override
	public MembershipState getMembershipState() {
		return MembershipState.MEMBER;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getThreateningState()
	 */
	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	/**
	 * 
	 * @param conveyorBelt
	 * 			The id to set.
	 */
	public void setConveyorBelt(ConveyorBelt conveyorBelt) {
		this.conveyorBelt = conveyorBelt;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ConveyorBelt getConveyorBelt() {
		return this.conveyorBelt;
	}

	/**
	 * 
	 * @param furnaceStove
	 * 			The id to set.
	 */
	public void setFurnaceStove(FurnaceStove furnaceStove) {
		this.furnaceStove = furnaceStove;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public FurnaceStove getFurnaceStove() {
		return this.furnaceStove;
	}

	/**
	 * 
	 * @param heatPump
	 * 			The id to set.
	 */
	public void setHeatPump(HeatPump heatPump) {
		this.heatPump = heatPump;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public HeatPump getHeatPump() {
		return this.heatPump;
	}

	/**
	 * 
	 * @param temperatureGauge
	 * 			The id to set.
	 */
	public void setTemperatureGauge(TemperatureGauge temperatureGauge) {
		this.temperatureGauge = temperatureGauge;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public TemperatureGauge getTemperatureGauge() {
		return this.temperatureGauge;
	}
}
