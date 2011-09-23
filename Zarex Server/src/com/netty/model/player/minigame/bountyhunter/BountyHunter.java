package com.netty.model.player.minigame.bountyhunter;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;
import com.netty.world.Location;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:10:21 PM
 */
public class BountyHunter extends MiniGame {

	/**
	 * 
	 */
	private Crate crate;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param crate
	 * 			The id to set.
	 */
	public BountyHunter(Player player, Crate crate) {
		super(player);
		this.setCrate(crate);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
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

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
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

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#getMembershipState()
	 */
	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
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
	 * @param crate
	 * 			The id to set.
	 */
	public void setCrate(Crate crate) {
		this.crate = crate;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Crate getCrate() {
		return this.crate;
	}
}