package com.netty.net.update.npc;

import com.netty.game.model.entity.npc.NPC;
import com.netty.game.model.entity.player.Player;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.update.EntityUpdate;

public class NPCUpdate implements Runnable {

	private EntityUpdate entityUpdate;
	private Player player;

	public NPCUpdate(EntityUpdate entityUpdate, Player player) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayer(player);
	}

	@Override
	public void run() {
		/** PacketBuilder updateBlockBuilder = new PacketBuilder();
		PacketBuilder packetBuilder = new PacketBuilder((short) 65, PacketType.VARIABLE_SHORT);
		packetBuilder.startBitAccess();
		packetBuilder.putBits(8, this.getPlayer().getNPCList().size());
		for (Iterator<NPC> npcIterate = this.getPlayer().getNPCList().iterator(); npcIterate.hasNext();) {
			NPC npc = npcIterate.next();
			if (World.getWorld().getNPCList().contains(npc) && !npc.isTeleporting() && npc.getLocation().isWithinDistance(this.getPlayer().getLocation())) {
				this.updateNPCMovement(packetBuilder, npc);
				if (npc.getUpdateFlags().isUpdateRequired()) {
					this.updateNPC(updateBlockBuilder, npc);
				}
			} else {
				npcIterate.remove();
				packetBuilder.putBits(1, 1);
				packetBuilder.putBits(2, 3);
			}
		}
		for (Iterator<NPC> npcIterate = World.getWorld().getNPCList().iterator(); npcIterate.hasNext();) {
			NPC npc = npcIterate.next();
			if (this.getPlayer().getNPCList().size() >= 255) {
				break;
			}
			if (this.getPlayer().getNPCList().contains(npc) || !this.getPlayer().getLocation().isWithinDistance(npc.getLocation())) {
				continue;
			}
			this.getPlayer().getNPCList().add(npc);
			packetBuilder.putBits(14, World.getWorld().getNPCList().indexOf(npc));
			packetBuilder.putBits(5, npc.getLocation().getY() - this.getPlayer().getLocation().getY());
			packetBuilder.putBits(5, npc.getLocation().getX() - this.getPlayer().getLocation().getX());
			packetBuilder.putBits(1, 0);
			packetBuilder.putBits(12, npc.getID());
			packetBuilder.putBits(1, npc.getUpdateFlags().isUpdateRequired() ? 1 : 0);
			if (npc.getUpdateFlags().isUpdateRequired()) {
				this.updateNPC(updateBlockBuilder, npc);
			}
		}
		if (!updateBlockBuilder.isEmpty()) {
			packetBuilder.putBits(14, 16383);
			packetBuilder.finishBitAccess();
			packetBuilder.putBytes(updateBlockBuilder.toPacket().getChannelBuffer());
		} else {
			packetBuilder.finishBitAccess();
		}
		this.getPlayer().getChannel().write(packetBuilder.toPacket());
		this.getEntityUpdate().getCountDownLatch().countDown(); */
	}

	@SuppressWarnings("unused")
	private void updateNPC(PacketBuilder packetBuilder, NPC npc) {
		/** synchronized (npc) {
			int mask = 0;
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.ANIMATION)) {
				mask |= 0x10;
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.HIT)) {
				mask |= 0x8;
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.GRAPHIC)) {
				mask |= 0x80;
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_ENTITY)) {
				mask |= 0x20;
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_CHAT)) {
				mask |= 0x1;
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.HIT_TWO)) {
				mask |= 0x40;
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.TRANSFORM)) {
				mask |= 0x2;
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_LOCATION)) {
				mask |= 0x4;
			}
			packetBuilder.putByte((byte) mask);
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.ANIMATION)) {
				this.updateAnimation(packetBuilder, npc);
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.HIT)) {
				this.updateHit(packetBuilder, npc);
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.GRAPHIC)) {
				this.updateGraphic(packetBuilder, npc);
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_ENTITY)) {
				this.updateFaceEntity(packetBuilder, npc);
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_CHAT)) {
				this.updateForcedChat(packetBuilder, npc);
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.HIT_TWO)) {
				this.updateHitTwo(packetBuilder, npc);
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.TRANSFORM)) {
				this.updateTransform(packetBuilder, npc);
			}
			if (this.getPlayer().getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_LOCATION)) {
				this.updateFaceLocation(packetBuilder, npc);
			}
		} */
	}

	@SuppressWarnings("unused")
	private void updateGraphic(PacketBuilder packetBuilder, NPC npc) {
		// packetBuilder.putShort((short) npc.getGraphic().getID());
		// packetBuilder.putInt(npc.getGraphic().getDelay());
	}

	@SuppressWarnings("unused")
	private void updateAnimation(PacketBuilder packetBuilder, NPC npc) {
		// packetBuilder.putLEShort(npc.getAnimation().getID());
		// packetBuilder.putByte((byte) npc.getAnimation().getDelay());
	}

	@SuppressWarnings("unused")
	private void updateForcedChat(PacketBuilder packetBuilder, NPC npc) {
		// packetBuilder.putString(npc.getForceChat().getForceText());
	}

	@SuppressWarnings("unused")
	private void updateFaceEntity(PacketBuilder packetBuilder, NPC npc) {
		// FaceEntity faceEntity = npc.getFaceEntity();
		// packetBuilder.putLEShort(faceEntity.getFaceEntity() == null ? -1 : faceEntity.getFaceEntity().getIndex());
	}

	@SuppressWarnings("unused")
	private void updateHit(PacketBuilder packetBuilder, NPC npc) {
		// packetBuilder.putByte(npc.getHit().getDamage());
		// packetBuilder.putByteA(npc.getHit().getDamage());
		// packetBuilder.putByteC(npc.getSkill().getLevel(SkillType.HITPOINT));
		// packetBuilder.putByte((byte) npc.getSkill().getExperience(SkillType.HITPOINT));
	}

	@SuppressWarnings("unused")
	private void updateHitTwo(PacketBuilder packetBuilder, NPC npc) {
		// packetBuilder.putByte(npc.getHitTwo().getDamage());
		// packetBuilder.putByteS(npc.getHitTwo().getDamage());
		// packetBuilder.putByte((byte) npc.getSkill().getLevel(SkillType.HITPOINT));
		// packetBuilder.putByteC(npc.getSkill().getExperience(SkillType.HITPOINT));
	}

	@SuppressWarnings("unused")
	private void updateTransform(PacketBuilder packetBuilder, NPC npc) {
		// packetBuilder.putLEShortA(npc.getTransform().getID());
	}

	@SuppressWarnings("unused")
	private void updateFaceLocation(PacketBuilder packetBuilder, NPC npc) {
		// if (npc.getFaceLocation() == null) {
		// 	packetBuilder.putLEShortA(0);
		// 	packetBuilder.putLEShort(0);
		// } else {
		// 	packetBuilder.putLEShortA((npc.getFaceLocation().getFaceLocation().getX() * 2) + 1);
		// 	packetBuilder.putLEShort((npc.getFaceLocation().getFaceLocation().getY() * 2) + 1);
		// }
	}

	@SuppressWarnings("unused")
	private void updateNPCMovement(PacketBuilder packetBuilder, NPC npc) {
		// if (npc.getWalkingDirection() == -1) {
		// 	if (npc.getUpdateFlags().isUpdateRequired()) {
		// 		packetBuilder.putBits(1, 1);
		// 		packetBuilder.putBits(2, 0);
		// 	} else {
		// 		packetBuilder.putBits(1, 0);
		// 	}
		// } else {
		// 	packetBuilder.putBits(1, 1);
		// 	packetBuilder.putBits(2, 1);
		// 	packetBuilder.putBits(3, npc.getWalkingDirection());
		// 	packetBuilder.putBits(1, npc.getUpdateFlags().isUpdateRequired() ? 1 : 0);
		// }
	}

	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}