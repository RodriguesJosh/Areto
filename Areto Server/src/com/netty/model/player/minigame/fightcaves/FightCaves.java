package com.netty.model.player.minigame.fightcaves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.minigame.MembershipState;
import com.netty.model.player.minigame.MiniGame;
import com.netty.model.player.minigame.ThreateningState;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 10:40:12 PM
 */
public class FightCaves extends MiniGame {

	/**
	 * 
	 */
	private List<Wave> waveList;

	/**
	 * 
	 * @param player
	 *			The id to set.
	 */
	public FightCaves(Player player) {
		super(player);
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#start()
	 */
	@Override
	public void start() {
		this.getPlayer().setTeleport(Teleport.FIGHT_CAVES);
		this.setWaveList(new ArrayList<Wave>(FightCavesConstants.MAX_FIGHT_CAVE_WAVES));
		Wave[] waves = {
				new Wave(Monster.TZ_KIH),
				new Wave(Monster.TZ_KIH, Monster.TZ_KIH),
				new Wave(Monster.TZ_KEK),
				new Wave(Monster.TZ_KEK, Monster.TZ_KEK_MINI),
				new Wave(Monster.TZ_KEK, Monster.TZ_KEK_MINI, Monster.TZ_KEK_MINI),
				new Wave(Monster.TZ_KEK, Monster.TZ_KEK),
				new Wave(Monster.TOK_XIL),
				new Wave(Monster.TOK_XIL, Monster.TZ_KIH)
		};
		List<Wave> registeredList = Arrays.asList(waves);
		this.getWaveList().addAll(registeredList);
		for (Iterator<Wave> waveIterator = registeredList.iterator(); waveIterator.hasNext();) {
			// Wave wave = waveIterator.next();
			// Monster[] monsters = wave.getMonsters();

		}
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.minigame.MiniGame#end()
	 */
	@Override
	public void end() { /** Get the tokens after you've killed JAD. */

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
	 * @param waveList
	 *			The id to set.
	 */
	public void setWaveList(List<Wave> waveList) {
		this.waveList = waveList;
	}

	/**
	 * 
	 * @return
	 *			The id to set.
	 */
	public List<Wave> getWaveList() {
		return this.waveList;
	}
}
