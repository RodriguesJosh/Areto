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

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:19:57 PM
 */
public class AttackPlayerPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		Short playerIDShort = (Short) packetAttribute.getAttribute("PLAYER_ID");
		short playerID = playerIDShort.shortValue();// getLEShort();
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