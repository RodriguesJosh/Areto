package com.netty.model.player.skill.firemaking;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.netty.model.player.Player;
import com.netty.model.player.skill.SkillType;
import com.netty.model.update.Animation;

public class Firemaking {

	private List<Fire> fireList;
	private ConcurrentMap<Integer, Log> logMap;

	public void execute(Player player) {
		this.setLogMap(new ConcurrentHashMap<Integer, Log>());
		for (int i = 0; i < this.getFireList().size(); i++) {
			if (player.getLocation().equals(this.getFireList().get(i).getFireLocation())) {
				player.getPacketSender().getMessage("You cannot light a fire here.");
				return;
			}
		}
		if (player.getSkills()[SkillType.FIREMAKING.getID()].getLevel() < this.getLogMap().get(0).getLevel()) {
			player.getPacketSender().getMessage("You must have a level of " + this.getLogMap().get(0).getLevel() + " in order to firemake this log.");
			return;
		}
		Fire fire = new Fire(player.getLocation(), System.currentTimeMillis(), 733);
		this.getFireList().add(fire);
		player.setAnimation(new Animation(fire.getAnimationID(), 0));
		player.getSkills()[SkillType.FIREMAKING.getID()].addExperience(this.getLogMap().get(0).getExperience());
		/** Walking away from it. */
	}

	public Log getLog(int logID) {
		int[] logIDs = { 1281, 1308, 1307, 1309, 1306 };
		Log[] logTypes = {
				Log.ACHEY, Log.OAK, Log.WILLOW, Log.TEAK, Log.ARCTIC_PINE, Log.MAPLE, Log.MAHOGANY, Log.EUCALYPTUS,
				Log.YEW, Log.MAGIC, Log.CURSED_MAGIC
		};
		for (int i : logIDs) {
			if (logID == i) {
				return logTypes[i];
			}
		}
		return Log.NORMAL;
	}

	public void setFireList(List<Fire> fireList) {
		this.fireList = fireList;
	}

	public List<Fire> getFireList() {
		return this.fireList;
	}

	public void setLogMap(ConcurrentMap<Integer, Log> logMap) {
		this.logMap = logMap;
	}

	public ConcurrentMap<Integer, Log> getLogMap() {
		return this.logMap;
	}
}