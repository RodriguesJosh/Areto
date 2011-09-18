package com.netty.model.player.minigame.barbarianassault;

import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

public class BarbarianAssault extends MiniGame {

	private Role role;
	private Style style;
	private List<Wave> waveList;

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

	@Override
	public void start() {}

	@Override
	public void end() {}

	@Override
	public MembershipState getMembershipState() {
		return MembershipState.FREE;
	}

	@Override
	public ThreateningState getThreateningState() {
		return ThreateningState.SAFE;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return this.role;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Style getStyle() {
		return this.style;
	}

	public void setWaveList(List<Wave> waveList) {
		this.waveList = waveList;
	}

	public List<Wave> getWaveList() {
		return this.waveList;
	}
}
