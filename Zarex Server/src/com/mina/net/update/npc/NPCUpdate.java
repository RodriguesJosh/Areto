package com.mina.net.update.npc;

import java.util.Iterator;

import com.mina.model.player.PlayerMINA;
import com.mina.net.packet.PacketBuilderMINA;
import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;
import com.netty.model.npc.NPC;
import com.netty.model.update.FaceEntity;
import com.netty.model.update.UpdateFlag;
import com.netty.net.packet.PacketType;
import com.netty.net.update.EntityUpdate;
import com.netty.world.World;

/**
 * A class to represent the updating of an NPC.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:33:31 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public class NPCUpdate implements Runnable {

	/**
	 * The entity update to count down until the next
	 * update.
	 */
	private EntityUpdate entityUpdate;

	/**
	 * The player to update the NPCs for.
	 */
	private PlayerMINA playerMINA;

	/**
	 * Constructs a new NPC updating system to update
	 * any vital parts within an NPC.
	 * 
	 * @param entityUpdate
	 * 			The entity update to set.
	 * @param playerMINA
	 * 			The player to set.
	 */
	public NPCUpdate(EntityUpdate entityUpdate, PlayerMINA playerMINA) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayerMINA(playerMINA);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
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

	/**
	 * Updates an NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The npc to update.
	 */
	public void updateNPC(PacketBuilderMINA packetBuilderMINA, NPC npc) {
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

	/**
	 * Update the GFX of an NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The npc to update the GFX (graphics) for.
	 */
	public void updateGraphic(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putShort((short) npc.getGraphic().getID());
		packetBuilderMINA.putInt(npc.getGraphic().getDelay());
	}

	/**
	 * Update the animation of an NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The npc to update the animation for.
	 */
	public void updateAnimation(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putLEShort(npc.getAnimation().getID());
		packetBuilderMINA.putByte((byte) npc.getAnimation().getDelay());
	}

	/**
	 * Update the forced chat for the NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The npc to update the forced chat for.
	 */
	public void updateForcedChat(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putString(npc.getForceChat().getForceText());
	}

	/**
	 * Update the direction of an NPC that it wishes
	 * to face towards an entity.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The npc to update the facing entity
	 * 			for.
	 */
	public void updateFaceEntity(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		FaceEntity faceEntity = npc.getFaceEntity();
		packetBuilderMINA.putLEShort(faceEntity.getFaceEntity() == null ? -1 : faceEntity.getFaceEntity().getIndex());
	}

	/**
	 * Update the first hit for the NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The npc to update the first hit for.
	 */
	public void updateHit(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putByte(npc.getHit().getDamage());
		packetBuilderMINA.putByteA(npc.getHit().getDamage());
		// packetBuilder.putByteC(npc.getSkill().getLevel(SkillType.HITPOINT));
		// packetBuilder.putByte((byte) npc.getSkill().getExperience(SkillType.HITPOINT));
	}

	/**
	 * Update the second hit for the NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The player to update the second hit for.
	 */
	public void updateHitTwo(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putByte(npc.getHitTwo().getDamage());
		packetBuilderMINA.putByteS(npc.getHitTwo().getDamage());
		// packetBuilder.putByte((byte) npc.getSkill().getLevel(SkillType.HITPOINT));
		// packetBuilder.putByteC(npc.getSkill().getExperience(SkillType.HITPOINT));
	}

	/**
	 * Update the transformation of an NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The player to update the transformation
	 * 			for.
	 */
	public void updateTransform(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		packetBuilderMINA.putLEShortA(npc.getTransform().getID());
	}

	/**
	 * Update the facing of the location for the NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The player to update the facing of the
	 * 			location for.
	 */
	public void updateFaceLocation(PacketBuilderMINA packetBuilderMINA, NPC npc) {
		if (npc.getFaceLocation() == null) {
			packetBuilderMINA.putLEShortA(0);
			packetBuilderMINA.putLEShort(0);
		} else {
			packetBuilderMINA.putLEShortA((npc.getFaceLocation().getFaceLocation().getX() * 2) + 1);
			packetBuilderMINA.putLEShort((npc.getFaceLocation().getFaceLocation().getY() * 2) + 1);
		}
	}

	/**
	 * Update the movement of the NPC.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param npc
	 * 			The npc to update the movement for.
	 */
	public void updateNPCMovement(PacketBuilderMINA packetBuilderMINA, NPC npc) {
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

	/**
	 * Sets the entity update for counting down
	 * the ticks until the next update occurs.
	 * 
	 * @param entityUpdate
	 * 			The entity update to set.
	 */
	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	/**
	 * Gets the entity update to count down
	 * the ticks.
	 * 
	 * @return entityUpdate
	 * 			Returns the entity update to get.
	 */
	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	/**
	 * Sets the player for the after task of the
	 * player updating system.
	 * 
	 * @param playerMINA
	 * 			The player to set.
	 */
	public void setPlayerMINA(PlayerMINA playerMINA) {
		this.playerMINA = playerMINA;
	}

	/**
	 * Gets the player for the after task of the
	 * player updating system.
	 * 
	 * @return playerMINA
	 * 			Returns the player to get.
	 */
	public PlayerMINA getPlayerMINA() {
		return this.playerMINA;
	}
}