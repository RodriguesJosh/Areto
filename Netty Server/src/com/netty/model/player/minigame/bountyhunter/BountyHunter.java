package com.netty.model.player.minigame.bountyhunter;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.world.Location;

public class BountyHunter extends MiniGame {

	private Crate crate;

	public BountyHunter(Player player, Crate crate) {
		super(player);
		this.setCrate(crate);
	}

	@Override
	public void start() {
		if ((this.getCrate() instanceof LowCrate) && this.getCrate().isLevelNeeded()) {
			this.getPlayer().setLocation(new Location((short) 0, (short) 0, (byte) 0));
		}  else if ((this.getCrate() instanceof MediumCrate) && this.getCrate().isLevelNeeded()) {
			this.getPlayer().setLocation(new Location((short) 0, (short) 0, (byte) 0));
		}  else if ((this.getCrate() instanceof HighCrate) && this.getCrate().isLevelNeeded()) {
			this.getPlayer().setLocation(new Location((short) 0, (short) 0, (byte) 0));
		}
	}

	@Override
	public void end() {
		if (this.getCrate() instanceof LowCrate) {
			this.getPlayer().setLocation(new Location((short) 0, (short) 0, (byte) 0));
		}  else if (this.getCrate() instanceof MediumCrate) {
			this.getPlayer().setLocation(new Location((short) 0, (short) 0, (byte) 0));
		}  else if (this.getCrate() instanceof HighCrate) {
			this.getPlayer().setLocation(new Location((short) 0, (short) 0, (byte) 0));
		}
	}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setCrate(Crate crate) {
		this.crate = crate;
	}

	public Crate getCrate() {
		return this.crate;
	}
}
