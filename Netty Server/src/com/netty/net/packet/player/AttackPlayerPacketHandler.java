package com.netty.net.packet.player;

import com.netty.model.combat.AttackType;
import com.netty.model.combat.CombatType;
import com.netty.model.combat.RangeCombat;
import com.netty.model.combat.magic.MagicCombat;
import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.player.Player;
import com.netty.model.update.FaceEntity;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

public class AttackPlayerPacketHandler implements PacketHandler {

	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		short playerID = (Short) packetAttribute.getAttribute("PLAYER_ID");// getLEShort();
		Player playerEnemy = World.getWorld().getPlayerList().get(playerID);
		player.setFaceEntity(new FaceEntity(playerEnemy));
		if (player.isMaging()) {
			player.setCombat(new MagicCombat(player, playerEnemy, CombatType.MAGIC, AttackType.ACCURATE));
		} else if (player.isMeleeing()) {
			player.setCombat(new MeleeCombat(player, playerEnemy, CombatType.MELEE, AttackType.ACCURATE));
		} else if (player.isRanging()) {
			player.setCombat(new RangeCombat(player, playerEnemy, CombatType.RANGE, AttackType.ACCURATE));
		}
	}
}