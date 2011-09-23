package com.netty.model.player.minigame.barbarianassault;

import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 9:00:05 PM
 */
public class BarbarianAssault extends MiniGame {

	/**
	 * 
	 */
	private Role role;

	/**
	 * 
	 */
	private Style style;

	/**
	 * 
	 */
	private List<Wave> waveList;

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 * @param role
	 * 			The id to set.
	 * @param style
	 * 			The id to set.
	 */
	public BarbarianAssault(Player player, Role role, Style style) {
		super(player);
		this.setRole(role);
		if (this.getRole() == Role.ATTACKER) {
			this.getRole().setCallRole(Role.COLLECTOR);
			this.setStyle(style);
		}
		if (this.getRole() == Role.COLLECTOR) {
			this.getRole().setCallRole(Role.ATTACKER);
		}
		if (this.getRole() == Role.DEFENDER) {
			this.getRole().setCallRole(Role.HEALER);
		}
		if (this.getRole() == Role.HEALER) {
			this.getRole().setCallRole(Role.DEFENDER);
		}
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		return;
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
	 * @param role
	 * 			The id to set.
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Role getRole() {
		return this.role;
	}

	/**
	 * 
	 * @param style
	 * 			The id to set.
	 */
	public void setStyle(Style style) {
		this.style = style;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Style getStyle() {
		return this.style;
	}

	/**
	 * 
	 * @param waveList
	 * 			The id to set.
	 */
	public void setWaveList(List<Wave> waveList) {
		this.waveList = waveList;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public List<Wave> getWaveList() {
		return this.waveList;
	}
}