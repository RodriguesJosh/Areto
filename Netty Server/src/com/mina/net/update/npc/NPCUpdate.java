package com.mina.net.update.npc;

import java.util.Iterator;

import com.mina.model.player.PlayerMINA;
import com.mina.net.packet.PacketBuilderMINA;
import com.netty.model.npc.NPC;
import com.netty.model.update.FaceEntity;
import com.netty.model.update.UpdateFlag;
import com.netty.net.packet.PacketType;
import com.netty.net.update.EntityUpdate;
import com.netty.world.World;

public class NPCUpdate implements Runnable {

	private EntityUpdate entityUpdate;
	private PlayerMINA playerMINA;

	public NPCUpdate(EntityUpdate entityUpdate, PlayerMINA playerMINA) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayerMINA(playerMINA);
	}

	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	public void setPlayerMINA(PlayerMINA playerMINA) {
		this.playerMINA = playerMINA;
	}

	public PlayerMINA getPlayerMINA() {
		return this.playerMINA;
	}

	@Override
	public void run() {
		PacketBuilderMINA updateBlockBuilder = new PacketBuilderMINA();
		PacketBuilderMINA packetBuilderMINA = new PacketBuilderMINA((byte) 65, PacketType.VARIABLE_SHORT);
		packetBuilderMINA.startBitAccess();
		packetBuilderMINA.putBits(8, this.getPlayerMINA().getNPCList().size());
		for (Iterator<NPC> npcIterate = this.getPlayerMINA().getNPCList().iterator(); npcIterate.hasNext();) {
			NPC npc = npcIterate.next();
			if (World.getWorld().getNPCList().contains(npc) && !npc.isTeleporting() && npc.getLocation().isWithinDistance(this.getPlayerMINA().getLocation())) {
				this.updateNPCMovement(packetBuilderMINA, npc);
				if (npc.getUpdateFlags().isUpdateRequired()) {
					this.updateNPC(updateBlockBuilder, npc);
				}
			} else {
				npcIterate.remove();
				packetBuilderMINA.putBits(1, 1);
				packetBuilderMINA.putBits(2, 3);
			}
		}
		for (Iterator<NPC> npcIterate = World.getWorld().getNPCList().iterator(); npcIterate.hasNext();) {
			NPC npc = npcIterate.next();
			if (this.getPlayerMINA().getNPCList().size() >= 255) {
				break;
			}
			if (this.getPlayerMINA().getNPCList().contains(npc) || !this.getPlayerMINA().getLocation().isWithinDistance(npc.getLocation())) {
				continue;
			}
			this.getPlayerMINA().getNPCList().add(npc);
			packetBuilderMINA.putBits(14, World.getWorld().getNPCList().indexOf(npc));
			packetBuilderMINA.putBits(5, npc.getLocation().getY() - this.getPlayerMINA().getLocation().getY());
			packetBuilderMINA.putBits(5, npc.getLocation().getX() - this.getPlayerMINA().getLocation().getX());
			packetBuilderMINA.putBits(1, 0);
			packetBuilderMINA.putBits(12, npc.getID());
			packetBuilderMINA.putBits(1, npc.getUpdateFlags().isUpdateRequired() ? 1 : 0);
			if (npc.getUpdateFlags().isUpdateRequired()) {
				this.updateNPC(updateBlockBuilder, npc);
			}
		}
		if (!updateBlockBuilder.isEmpty()) {
			packetBuilderMINA.putBits(14, 16383);
			packetBuilderMINA.finishBitAccess();
			packetBuilderMINA.putBytes(updateBlockBuilder.toPacketMINA().getIOBuffer());
		} else {
			packetBuilderMINA.finishBitAccess();
		}
		this.getPlayerMINA().getIOSession().write(packetBuilderMINA.toPacketMINA());
		this.getEntityUpdate().getCountDownLatch().countDown();
	}

	private void updateNPC(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		synchronized (npc) {
			int mask = 0;
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.ANIMATION)) {
				mask |= 0x10;
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.HIT)) {
				mask |= 0x8;
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.GRAPHIC)) {
				mask |= 0x80;
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_ENTITY)) {
				mask |= 0x20;
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_CHAT)) {
				mask |= 0x1;
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.HIT_TWO)) {
				mask |= 0x40;
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.TRANSFORM)) {
				mask |= 0x2;
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_LOCATION)) {
				mask |= 0x4;
			}
			packetBuilderMINA.putByte((byte) mask);
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.ANIMATION)) {
				this.updateAnimation(packetBuilderMINA, npc);
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.HIT)) {
				this.updateHit(packetBuilderMINA, npc);
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.GRAPHIC)) {
				this.updateGraphic(packetBuilderMINA, npc);
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_ENTITY)) {
				this.updateFaceEntity(packetBuilderMINA, npc);
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_CHAT)) {
				this.updateForcedChat(packetBuilderMINA, npc);
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.HIT_TWO)) {
				this.updateHitTwo(packetBuilderMINA, npc);
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.TRANSFORM)) {
				this.updateTransform(packetBuilderMINA, npc);
			}
			if (this.getPlayerMINA().getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_LOCATION)) {
				this.updateFaceLocation(packetBuilderMINA, npc);
			}
		}
	}

	private void updateGraphic(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putShort((short) npc.getGraphic().getID());
		packetBuilderMINA.putInt(npc.getGraphic().getDelay());
	}

	private void updateAnimation(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putLEShort(npc.getAnimation().getID());
		packetBuilderMINA.putByte((byte) npc.getAnimation().getDelay());
	}

	private void updateForcedChat(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putString(npc.getForceChat().getForceText());
	}

	private void updateFaceEntity(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		FaceEntity faceEntity = npc.getFaceEntity();
		packetBuilderMINA.putLEShort(faceEntity.getFaceEntity() == null ? -1 : faceEntity.getFaceEntity().getIndex());
	}

	private void updateHit(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putByte(npc.getHit().getDamage());
		packetBuilderMINA.putByteA(npc.getHit().getDamage());
		// packetBuilder.putByteC(npc.getSkill().getLevel(SkillType.HITPOINT));
		// packetBuilder.putByte((byte) npc.getSkill().getExperience(SkillType.HITPOINT));
	}

	private void updateHitTwo(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putByte(npc.getHitTwo().getDamage());
		packetBuilderMINA.putByteS(npc.getHitTwo().getDamage());
		// packetBuilder.putByte((byte) npc.getSkill().getLevel(SkillType.HITPOINT));
		// packetBuilder.putByteC(npc.getSkill().getExperience(SkillType.HITPOINT));
	}

	private void updateTransform(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putLEShortA(npc.getTransform().getID());
	}

	private void updateFaceLocation(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		if (npc.getFaceLocation() == null) {
			packetBuilderMINA.putLEShortA(0);
			packetBuilderMINA.putLEShort(0);
		} else {
			packetBuilderMINA.putLEShortA((npc.getFaceLocation().getFaceLocation().getX() * 2) + 1);
			packetBuilderMINA.putLEShort((npc.getFaceLocation().getFaceLocation().getY() * 2) + 1);
		}
	}

	private void updateNPCMovement(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		if (npc.getWalkingDirection() == -1) {
			if (npc.getUpdateFlags().isUpdateRequired()) {
				packetBuilderMINA.putBits(1, 1);
				packetBuilderMINA.putBits(2, 0);
			} else {
				packetBuilderMINA.putBits(1, 0);
			}
		} else {
			packetBuilderMINA.putBits(1, 1);
			packetBuilderMINA.putBits(2, 1);
			packetBuilderMINA.putBits(3, npc.getWalkingDirection());
			packetBuilderMINA.putBits(1, npc.getUpdateFlags().isUpdateRequired() ? 1 : 0);
		}
	}
}
