package com.netty.net.packet.npc;

import com.netty.model.Entity;
import com.netty.model.combat.AttackType;
import com.netty.model.combat.CombatType;
import com.netty.model.combat.RangeCombat;
import com.netty.model.combat.magic.MagicCombat;
import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.player.Player;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:22:19 PM
 */
public class AttackNPCPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		int npcID = ((Integer) packetAttribute.getAttribute("NPC_ID")).intValue() & 0xFF;
		Entity entity = World.getWorld().getNPCList().get(npcID);
		if (player.isMaging()) {
			player.setCombat(new MagicCombat(player, entity, CombatType.MAGIC, AttackType.ACCURATE));
		} else if (player.isMeleeing()) {
			player.setCombat(new MeleeCombat(player, entity, CombatType.MELEE, AttackType.ACCURATE));
		} else if (player.isRanging()) {
			player.setCombat(new RangeCombat(player, entity, CombatType.RANGE, AttackType.ACCURATE));
		}
	}
}