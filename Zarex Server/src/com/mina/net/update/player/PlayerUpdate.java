package com.mina.net.update.player;

import java.util.Iterator;

import com.mina.model.player.PlayerMINA;
import com.mina.net.packet.PacketBuilderMINA;
import com.mina.net.packet.PacketMINA;
import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;
import com.netty.model.player.Player;
import com.netty.model.player.skill.SkillType;
import com.netty.model.update.Appearance;
import com.netty.model.update.FaceEntity;
import com.netty.model.update.ForceMovement;
import com.netty.model.update.UpdateFlag;
import com.netty.net.packet.PacketType;
import com.netty.net.update.EntityUpdate;
import com.netty.util.NameUtility;
import com.netty.world.World;

/**
 * A player updating class to represent vital player
 * updates that the player needs
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:36:11 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public class PlayerUpdate implements Runnable {

	/**
	 * The entity update for counting down.
	 */
	private EntityUpdate entityUpdate;

	/**
	 * The player to update.
	 */
	private PlayerMINA playerMINA;

	/**
	 * Constructs a new player updating task to update
	 * anything related to the player.
	 * 
	 * @param entityUpdate
	 * 			The entity update to set.
	 * @param playerMINA
	 * 			The player to set for updating.
	 */
	public PlayerUpdate(EntityUpdate entityUpdate, PlayerMINA playerMINA) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayerMINA(playerMINA);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if (this.getPlayerMINA().isMapChanging()) {
			// this.getPlayerMINA().getPacketSender().getMapRegion();
		}
		PacketBuilderMINA updateBlockBuilder = new PacketBuilderMINA();
		PacketBuilderMINA packetBuilderMINA = new PacketBuilderMINA((short) 81, PacketType.VARIABLE_SHORT);
		packetBuilderMINA.startBitAccess();
		this.updateThisPlayerMovement(packetBuilderMINA);
		this.updatePlayer(updateBlockBuilder, this.getPlayerMINA(), false, true);
		packetBuilderMINA.putBits(8, this.getPlayerMINA().getPlayerList().size());
		for (Iterator<Player> playerMINAIterate = this.getPlayerMINA().getPlayerList().iterator(); playerMINAIterate.hasNext();) {
			PlayerMINA playerMINA = (PlayerMINA) playerMINAIterate.next();
			if (World.getWorld().getPlayerList().contains(playerMINA) && !playerMINA.isTeleporting() && playerMINA.getLocation().isWithinDistance(this.getPlayerMINA().getLocation())) {
				this.updatePlayerMovement(packetBuilderMINA, playerMINA);
				if (this.getPlayerMINA().getUpdateFlags().isUpdateRequired()) {
					this.updatePlayer(updateBlockBuilder, playerMINA, false, false);
				}
			} else {
				playerMINAIterate.remove();
				packetBuilderMINA.putBits(1, 1);
				packetBuilderMINA.putBits(2, 3);
			}
		}
		for (Iterator<Player> playerIterate = World.getWorld().getPlayerList().iterator(); playerIterate.hasNext();) {
			if (this.getPlayerMINA().getPlayerList().size() >= 255) {
				break;
			}
			PlayerMINA playerMINA = (PlayerMINA) playerIterate.next();
			if ((playerMINA == this.getPlayerMINA()) || (this.getPlayerMINA().getPlayerList().contains(playerMINA))) {
				continue;
			}
			this.getPlayerMINA().getPlayerList().add(playerMINA);
			packetBuilderMINA.putBits(11, playerMINA.getIndex());
			packetBuilderMINA.putBits(1, 1);
			packetBuilderMINA.putBits(1, 1);
			packetBuilderMINA.putBits(5, playerMINA.getLocation().getY() - this.getPlayerMINA().getLocation().getY());
			packetBuilderMINA.putBits(5, playerMINA.getLocation().getX() - this.getPlayerMINA().getLocation().getX());
			this.updatePlayer(updateBlockBuilder, playerMINA, true, false);
		}
		if (!updateBlockBuilder.isEmpty()) {
			packetBuilderMINA.putBits(11, 2047);
			packetBuilderMINA.finishBitAccess();
			PacketMINA packetMINA = updateBlockBuilder.toPacketMINA();
			packetBuilderMINA.putBytes(packetMINA.getIOBuffer());
		} else {
			packetBuilderMINA.finishBitAccess();
		}
		this.getPlayerMINA().getIOSession().write(packetBuilderMINA.toPacket());
		this.getEntityUpdate().getCountDownLatch().countDown();
	}

	/**
	 * Update the player with the given "masks" mapped with
	 * a different update for the player.
	 * 
	 * @param packetBuilderMINA
	 * 			The packet builder to build packets.
	 * @param playerMINA
	 * 			The player to update.
	 * @param isAppearance
	 * 			Whether or not the player is updating his/her
	 * 			appearance.
	 * @param isNotChatting
	 * 			Whether or not the player is not chatting.
	 */
	public void updatePlayer(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA, boolean isAppearance, boolean isNotChatting) {
		if (!playerMINA.getUpdateFlags().isUpdateRequired() && !isAppearance) {
			return;
		}
		synchronized (playerMINA) {
			if (playerMINA.isPacket() && (playerMINA != this.getPlayerMINA()) && !isAppearance && !isNotChatting) {
				packetBuilderMINA.putBytes(playerMINA.getPacketMINA().getIOBuffer());
				return;
			}
			PacketBuilderMINA blockBuilderMINA = new PacketBuilderMINA();
			int mask = 0;
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_MOVEMENT)) {
				mask |= 0x400;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.GRAPHIC)) {
				mask |= 0x100;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.ANIMATION)) {
				mask |= 0x8;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_CHAT)) {
				mask |= 0x4;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.CHAT) && !isNotChatting) {
				mask |= 0x80;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_ENTITY)) {
				mask |= 0x1;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.APPEARANCE)) {
				mask |= 0x10;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_LOCATION)) {
				mask |= 0x2;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.HIT)) {
				mask |= 0x20;
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.HIT_TWO)) {
				mask |= 0x200;
			}
			if (mask >= 0x100) {
				mask |= 0x40;
				blockBuilderMINA.putByte((byte) (mask & 0xFF));
				blockBuilderMINA.putByte((byte) (mask >> 8));
			} else {
				blockBuilderMINA.putByte((byte) mask);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_MOVEMENT)) {
				this.updateForcedMovement(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.GRAPHIC)) {
				this.updateGraphic(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.ANIMATION)) {
				this.updateAnimation(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_CHAT)) {
				this.updateForcedChat(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.CHAT) && !isNotChatting) {
				this.updateChat(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_ENTITY)) {
				this.updateFaceEntity(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.APPEARANCE)) {
				this.updateAppearance(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_LOCATION)) {
				this.updateFaceLocation(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.HIT)) {
				this.updateHit(blockBuilderMINA, playerMINA);
			}
			if (playerMINA.getUpdateFlags().getUpdateFlag(UpdateFlag.HIT_TWO)) {
				this.updateHitTwo(blockBuilderMINA, playerMINA);
			}
			PacketMINA blockPacket = blockBuilderMINA.toPacketMINA();
			if ((playerMINA != this.getPlayerMINA()) && !isAppearance && !isNotChatting) {
				playerMINA.setPacket(blockPacket);
			}
			packetBuilderMINA.putBytes(blockPacket.getIOBuffer());
		}
	}

	/**
	 * Force the movement for a player.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the movement for.
	 */
	public void updateForcedMovement(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		ForceMovement forceMovement = playerMINA.getForceMovement();
		packetBuilderMINA.putByteC(forceMovement.getStartLocation().getX());
		packetBuilderMINA.putByteS(forceMovement.getStartLocation().getY());
		packetBuilderMINA.putByteS(forceMovement.getEndLocation().getX());
		packetBuilderMINA.putByteC(forceMovement.getEndLocation().getY());
		packetBuilderMINA.putShort(forceMovement.getStartSpeed());
		packetBuilderMINA.putShortA(forceMovement.getEndSpeed());
		packetBuilderMINA.putByte((byte) forceMovement.getFacingDirection());
	}

	/**
	 * Update the GFX (graphics) for the player.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the graphics for.
	 */
	public void updateGraphic(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		packetBuilderMINA.putLEShort(playerMINA.getGraphic().getID());
		packetBuilderMINA.putInt(playerMINA.getGraphic().getDelay());
	}

	/**
	 * Update an animation for the player.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the animation for.
	 */
	public void updateAnimation(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		packetBuilderMINA.putLEShort(playerMINA.getAnimation().getID());
		packetBuilderMINA.putByteC(playerMINA.getAnimation().getDelay());
	}

	/**
	 * Force the chat update.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the animation for.
	 */
	public void updateForcedChat(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		packetBuilderMINA.putString(playerMINA.getForceChat().getForceText());
	}

	/**
	 * Update the chat for the player.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the chat for.
	 */
	public void updateChat(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		packetBuilderMINA.putLEShort(((playerMINA.getChat().getColor() & 0xFF) << 8) | (playerMINA.getChat().getEffects() & 0xFF));
		packetBuilderMINA.putByte(playerMINA.getRank().getID());
		packetBuilderMINA.putByteC((byte) playerMINA.getChat().getText().getBytes().length);
		for (int i = playerMINA.getChat().getText().getBytes().length -1; i >= 0; i--) {
			packetBuilderMINA.putByte(playerMINA.getChat().getText().getBytes()[i]);
		}
	}

	/**
	 * Update the player's direction of where he/she
	 * wishes to face an entity.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the facing of the
	 * 			entity for.
	 */
	public void updateFaceEntity(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		FaceEntity faceEntity = playerMINA.getFaceEntity();
		packetBuilderMINA.putLEShort(faceEntity.getFaceEntity() == null ? -1 : faceEntity.getFaceEntity().getIndex());
	}

	/**
	 * Update the player's appearance.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the appearance for.
	 */
	public void updateAppearance(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		Appearance appearance = playerMINA.getAppearance();
		// Equipment equipment = player.getEquipment();
		PacketBuilderMINA playerPropsBuilderMINA = new PacketBuilderMINA();
		playerPropsBuilderMINA.putByte(appearance.getGender());
		for (int i = 0; i < 5; i++) {
			/** if (equipment.isSlotUsed((byte) i)) {
				playerPropsBuilder.putShort((short) (0x200 + equipment.getItem(i).getID()));
			} else { */
			playerPropsBuilderMINA.putByte((byte) 0);
			// }
		}
		// if (equipment.isSlotUsed(Equipment.getSlotChest())) {
		// 	playerPropsBuilder.putShort((short) (0x200 + equipment.getItem(Equipment.getSlotChest()).getID()));
		// } else {
		playerPropsBuilderMINA.putShort((short) (0x100 + appearance.getChest()));
		// }
		// if (equipment.isSlotUsed(Equipment.getSlotShield())){
		// 	playerPropsBuilder.putShort((short) (0x200 + equipment.getItem(Equipment.getSlotShield()).getID()));
		// } else {
		playerPropsBuilderMINA.putByte((byte) 0);
		// }
		// Item chestItem = equipment.getItem(Equipment.getSlotChest());
		// if (chestItem != null) {
		// 	if (Equipment.isEqual(EquipmentType.PLATEBODY, chestItem)) {
		// 		playerPropsBuilder.putShort((short) (0x200 + chestItem.getID()));
		// 	} else {
		// 		playerPropsBuilder.putShort((short) (0x200 + appearance.getArms()));
		// 	}
		// } else {
		playerPropsBuilderMINA.putShort((short) (0x100 + appearance.getArms()));
		// }
		// if (equipment.isSlotUsed(Equipment.getSlotLegs())) {
		// 	playerPropsBuilder.putShort((short) (0x200 + equipment.getItem(Equipment.getSlotLegs()).getID()));
		// } else {
		playerPropsBuilderMINA.putShort((short) (0x100 + appearance.getLegs()));
		// }
		// Item helm = equipment.getItem(Equipment.getSlotHelm());
		// if (helm != null) {
		// 	if (!Equipment.isEqual(EquipmentType.FULL_HELM, helm) && !Equipment.isEqual(EquipmentType.FULL_MASK, helm)) {
		// 		playerPropsBuilder.putShort((short) (0x100 + appearance.getHead()));
		// 	} else {
		// 		playerPropsBuilder.putByte((byte) 0);
		// 	}
		// } else {
		playerPropsBuilderMINA.putShort((short) (0x100 + appearance.getHead()));
		// }
		// if (equipment.isSlotUsed(Equipment.getSlotGloves())) {
		// 	playerPropsBuilder.putShort((short) (0x200 + equipment.getItem(Equipment.getSlotGloves()).getID()));
		// } else {
		playerPropsBuilderMINA.putShort((short) (0x100 + appearance.getHands()));
		// }
		// if (equipment.isSlotUsed(Equipment.getSlotBoots())) {
		// 	playerPropsBuilder.putShort((short) (0x200 + equipment.getItem(Equipment.getSlotBoots()).getID()));
		// } else {
		playerPropsBuilderMINA.putShort((short) (0x100 + appearance.getFeet()));
		// }
		// boolean fullHelm = false;
		// if (helm != null) {
		// 	fullHelm = !Equipment.isEqual(EquipmentType.FULL_HELM, helm);
		// }
		// if (fullHelm || (appearance.getGender() == 1)) {
		// 	playerPropsBuilder.putByte((byte) 0);
		// } else {
		playerPropsBuilderMINA.putShort((short) (0x100 + appearance.getBeard()));
		// }
		playerPropsBuilderMINA.putByte(appearance.getHairColor());
		playerPropsBuilderMINA.putByte(appearance.getTorsoColor());
		playerPropsBuilderMINA.putByte(appearance.getLegColor());
		playerPropsBuilderMINA.putByte(appearance.getFeetColor());
		playerPropsBuilderMINA.putByte(appearance.getSkinColor());
		playerPropsBuilderMINA.putShort((short) 0x328);
		playerPropsBuilderMINA.putShort((short) 0x337);
		playerPropsBuilderMINA.putShort((short) 0x333);
		playerPropsBuilderMINA.putShort((short) 0x334);
		playerPropsBuilderMINA.putShort((short) 0x335);
		playerPropsBuilderMINA.putShort((short) 0x336);
		playerPropsBuilderMINA.putShort((short) 0x338);
		playerPropsBuilderMINA.putLong(NameUtility.getNameToLong(playerMINA.getName()));
		playerPropsBuilderMINA.putByte((byte) 3);
		playerPropsBuilderMINA.putShort((short) 0);
		PacketMINA playerPacketMINA = playerPropsBuilderMINA.toPacketMINA();
		packetBuilderMINA.putByteC(playerPacketMINA.getPosition());
		packetBuilderMINA.putBytes(playerPacketMINA.getIOBuffer());
	}

	/**
	 * Update the location to face.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the facing of the
	 * 			location for.
	 */
	public void updateFaceLocation(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		if (playerMINA.getFaceLocation() == null) {
			packetBuilderMINA.putLEShortA(0);
			packetBuilderMINA.putLEShort(0);
		} else {
			packetBuilderMINA.putLEShortA((playerMINA.getFaceLocation().getFaceLocation().getX() * 2) + 1);
			packetBuilderMINA.putLEShort((playerMINA.getFaceLocation().getFaceLocation().getY() * 2) + 1);
		}
	}

	/**
	 * Update the first hit when in combat.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the hit for.
	 */
	public void updateHit(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		packetBuilderMINA.putByte(playerMINA.getHit().getDamage());
		packetBuilderMINA.putByteA(playerMINA.getHit().getHitType().getHitID());
		packetBuilderMINA.putByteC(playerMINA.getSkills()[SkillType.HITPOINT.getID()].getLevel());
		packetBuilderMINA.putByte((byte) playerMINA.getSkills()[SkillType.HITPOINT.getID()].getExperience());
	}

	/**
	 * Update the second hit when in combat.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the second hit for.
	 */
	public void updateHitTwo(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		packetBuilderMINA.putByte(playerMINA.getHitTwo().getDamage());
		packetBuilderMINA.putByteA(playerMINA.getHitTwo().getHitType().getHitID());
		packetBuilderMINA.putByteC(playerMINA.getSkills()[SkillType.HITPOINT.getID()].getLevel());
		packetBuilderMINA.putByte((byte) playerMINA.getSkills()[SkillType.HITPOINT.getID()].getExperience());
	}

	/**
	 * Update the current player's movement (your movement).
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 */
	public void updateThisPlayerMovement(PacketBuilderMINA packetBuilderMINA) {
		if (this.getPlayerMINA().isMapChanging() || this.getPlayerMINA().isTeleporting()) {
			packetBuilderMINA.putBits(1, 1);
			packetBuilderMINA.putBits(2, 3);
			packetBuilderMINA.putBits(2, this.getPlayerMINA().getLocation().getZ());
			packetBuilderMINA.putBits(1, 1);
			packetBuilderMINA.putBits(1, this.getPlayerMINA().getUpdateFlags().isUpdateRequired() ? 1 : 0);
			packetBuilderMINA.putBits(7, this.getPlayerMINA().getLocation().getLocalY());//this.getPlayer().getLastLocation()));
			packetBuilderMINA.putBits(7, this.getPlayerMINA().getLocation().getLocalX());//this.getPlayer().getLastLocation()));
		} else {
			if (this.getPlayerMINA().getWalkingDirection() == -1) {
				if (this.getPlayerMINA().getUpdateFlags().isUpdateRequired()) {
					packetBuilderMINA.putBits(1, 1);
					packetBuilderMINA.putBits(2, 0);
				} else {
					packetBuilderMINA.putBits(1, 0);
				}
			} else {
				if (this.getPlayerMINA().getRunningDirection() == -1) {
					packetBuilderMINA.putBits(1, 1);
					packetBuilderMINA.putBits(2, 1);
					packetBuilderMINA.putBits(3, this.getPlayerMINA().getWalkingDirection());
					packetBuilderMINA.putBits(1, this.getPlayerMINA().getUpdateFlags().isUpdateRequired() ? 1 : 0);
				} else {
					packetBuilderMINA.putBits(1, 1);
					packetBuilderMINA.putBits(2, 2);
					packetBuilderMINA.putBits(3, this.getPlayerMINA().getWalkingDirection());
					packetBuilderMINA.putBits(3, this.getPlayerMINA().getRunningDirection());
					packetBuilderMINA.putBits(1, this.getPlayerMINA().getUpdateFlags().isUpdateRequired() ? 1 : 0);
				}
			}
		}
	}

	/**
	 * Update the player's movement.
	 * 
	 * @param packetBuilderMINA
	 * 			The building of the packets to write.
	 * @param playerMINA
	 * 			The player to update the movement for.
	 */
	public void updatePlayerMovement(PacketBuilderMINA packetBuilderMINA, PlayerMINA playerMINA) {
		if (playerMINA.getWalkingDirection() == -1) {
			if (this.getPlayerMINA().getUpdateFlags().isUpdateRequired()) {
				packetBuilderMINA.putBits(1, 1);
				packetBuilderMINA.putBits(2, 0);
			} else {
				packetBuilderMINA.putBits(1, 0);
			}
		} else if (playerMINA.getRunningDirection() == -1) {
			packetBuilderMINA.putBits(1, 1);
			packetBuilderMINA.putBits(2, 1);
			packetBuilderMINA.putBits(3, playerMINA.getWalkingDirection());
			packetBuilderMINA.putBits(1, playerMINA.getUpdateFlags().isUpdateRequired() ? 1 : 0);
		} else {
			packetBuilderMINA.putBits(1, 1);
			packetBuilderMINA.putBits(2, 2);
			packetBuilderMINA.putBits(3, playerMINA.getWalkingDirection());
			packetBuilderMINA.putBits(3, playerMINA.getRunningDirection());
			packetBuilderMINA.putBits(1, playerMINA.getUpdateFlags().isUpdateRequired() ? 1 : 0);
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