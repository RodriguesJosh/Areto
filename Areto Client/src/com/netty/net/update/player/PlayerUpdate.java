package com.netty.net.update.player;

import com.netty.game.model.entity.player.Player;
import com.netty.net.packet.PacketBuilder;
import com.netty.net.update.EntityUpdate;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:44:17 PM
 */
public class PlayerUpdate implements Runnable {

	/**
	 * 
	 */
	private EntityUpdate entityUpdate;

	/**
	 * 
	 */
	private Player player;

	/**
	 * 
	 * @param entityUpdate
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public PlayerUpdate(EntityUpdate entityUpdate, Player player) {
		this.setEntityUpdate(entityUpdate);
		this.setPlayer(player);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		/** if (this.getPlayer().isMapChanging()) {
			this.getPlayer().getPacketSender().getMapRegion();
		}
		PacketBuilder updateBlockBuilder = new PacketBuilder();
		PacketBuilder packetBuilder = new PacketBuilder((short) 81, PacketType.VARIABLE_SHORT);
		packetBuilder.startBitAccess();
		this.updateThisPlayerMovement(packetBuilder);
		this.updatePlayer(updateBlockBuilder, this.getPlayer(), false, true);
		packetBuilder.putBits(8, this.getPlayer().getPlayerList().size());
		for (Iterator<Player> playerIterate = this.getPlayer().getPlayerList().iterator(); playerIterate.hasNext();) {
			Player player = playerIterate.next();
			if (World.getWorld().getPlayerList().contains(player) && !player.isTeleporting() && player.getLocation().isWithinDistance(this.getPlayer().getLocation())) {
				this.updatePlayerMovement(packetBuilder, player);
				if (this.getPlayer().getUpdateFlags().isUpdateRequired()) {
					this.updatePlayer(updateBlockBuilder, player, false, false);
				}
			} else {
				playerIterate.remove();
				packetBuilder.putBits(1, 1);
				packetBuilder.putBits(2, 3);
			}
		}
		for (Iterator<Player> playerIterate = World.getWorld().getPlayerList().iterator(); playerIterate.hasNext();) {
			if (this.getPlayer().getPlayerList().size() >= 255) {
				break;
			}
			Player player = playerIterate.next();
			if ((player == this.getPlayer()) || (this.getPlayer().getPlayerList().contains(player))) {
				continue;
			}
			this.getPlayer().getPlayerList().add(player);
			packetBuilder.putBits(11, player.getIndex());
			packetBuilder.putBits(1, 1);
			packetBuilder.putBits(1, 1);
			packetBuilder.putBits(5, player.getLocation().getY() - this.getPlayer().getLocation().getY());
			packetBuilder.putBits(5, player.getLocation().getX() - this.getPlayer().getLocation().getX());
			this.updatePlayer(updateBlockBuilder, player, true, false);
		}
		if (!updateBlockBuilder.isEmpty()) {
			packetBuilder.putBits(11, 2047);
			packetBuilder.finishBitAccess();
			Packet packet = updateBlockBuilder.toPacket();
			packetBuilder.putBytes(packet.getChannelBuffer(), 0, packet.getChannelBuffer().writerIndex());
		} else {
			packetBuilder.finishBitAccess();
		}
		this.getPlayer().getChannel().write(packetBuilder.toPacket());
		this.getEntityUpdate().getCountDownLatch().countDown(); */
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 * @param isAppearance
	 * 			The id to set.
	 * @param isNotChatting
	 * 			The id to set.
	 */
	public void updatePlayer(PacketBuilder packetBuilder, Player player, boolean isAppearance, boolean isNotChatting) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		if (!isAppearance || !isNotChatting) {
			return;
		}
		/** if (!player.getUpdateFlags().isUpdateRequired() && !isAppearance) {
			return;
		}
		synchronized (player) {
			if (player.isPacket() && (player != this.getPlayer()) && !isAppearance && !isNotChatting) {
				packetBuilder.putBytes(player.getPacket().getChannelBuffer());
				return;
			}
			PacketBuilder blockBuilder = new PacketBuilder();
			int mask = 0;
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_MOVEMENT)) {
				mask |= 0x400;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.GRAPHIC)) {
				mask |= 0x100;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.ANIMATION)) {
				mask |= 0x8;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_CHAT)) {
				mask |= 0x4;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.CHAT) && !isNotChatting) {
				mask |= 0x80;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_ENTITY)) {
				mask |= 0x1;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.APPEARANCE)) {
				mask |= 0x10;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_LOCATION)) {
				mask |= 0x2;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.HIT)) {
				mask |= 0x20;
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.HIT_TWO)) {
				mask |= 0x200;
			}
			if (mask >= 0x100) {
				mask |= 0x40;
				blockBuilder.putByte((byte) (mask & 0xFF));
				blockBuilder.putByte((byte) (mask >> 8));
			} else {
				blockBuilder.putByte((byte) mask);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_MOVEMENT)) {
				this.updateForcedMovement(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.GRAPHIC)) {
				this.updateGraphic(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.ANIMATION)) {
				this.updateAnimation(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.FORCE_CHAT)) {
				this.updateForcedChat(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.CHAT) && !isNotChatting) {
				this.updateChat(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_ENTITY)) {
				this.updateFaceEntity(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.APPEARANCE)) {
				this.updateAppearance(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.FACE_LOCATION)) {
				this.updateFaceLocation(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.HIT)) {
				this.updateHit(blockBuilder, player);
			}
			if (player.getUpdateFlags().getUpdateFlag(UpdateFlag.HIT_TWO)) {
				this.updateHitTwo(blockBuilder, player);
			}
			Packet blockPacket = blockBuilder.toPacket();
			if ((player != this.getPlayer()) && !isAppearance && !isNotChatting) {
				player.setPacket(blockPacket);
			}
			packetBuilder.putBytes(blockPacket.getChannelBuffer());
		} */
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateForcedMovement(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// ForceMovement forceMovement = player.getForceMovement();
		// packetBuilder.putByteC(forceMovement.getStartLocation().getX());
		// packetBuilder.putByteS(forceMovement.getStartLocation().getY());
		// packetBuilder.putByteS(forceMovement.getEndLocation().getX());
		// packetBuilder.putByteC(forceMovement.getEndLocation().getY());
		// packetBuilder.putShort(forceMovement.getStartSpeed());
		// packetBuilder.putShortA(forceMovement.getEndSpeed());
		// packetBuilder.putByte((byte) forceMovement.getFacingDirection());
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateGraphic(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// packetBuilder.putLEShort(player.getGraphic().getID());
		// packetBuilder.putInt(player.getGraphic().getDelay());
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateAnimation(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// packetBuilder.putLEShort(player.getAnimation().getID());
		// packetBuilder.putByteC(player.getAnimation().getDelay());
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateForcedChat(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// packetBuilder.putString(player.getForceChat().getForceText());
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateChat(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// packetBuilder.putLEShort(((player.getChat().getColor() & 0xFF) << 8) | (player.getChat().getEffects() & 0xFF));
		// packetBuilder.putByte(player.getRank().getID());
		// packetBuilder.putByteC((byte) player.getChat().getText().getBytes().length);
		// for (int i = player.getChat().getText().getBytes().length -1; i >= 0; i--) {
		// 	packetBuilder.putByte(player.getChat().getText().getBytes()[i]);
		// }
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateFaceEntity(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// FaceEntity faceEntity = player.getFaceEntity();
		// packetBuilder.putLEShort(faceEntity.getFaceEntity() == null ? -1 : faceEntity.getFaceEntity().getIndex());
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateAppearance(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// Appearance appearance = player.getAppearance();
		// PacketBuilder playerPropsBuilder = new PacketBuilder();
		// playerPropsBuilder.putByte(appearance.getGender());
		// for (int i = 0; i < 5; i++) {
		// 	playerPropsBuilder.putByte((byte) 0);
		// }
		// playerPropsBuilder.putShort((short) (0x100 + appearance.getChest()));
		// playerPropsBuilder.putByte((byte) 0);
		// playerPropsBuilder.putShort((short) (0x100 + appearance.getArms()));
		// playerPropsBuilder.putShort((short) (0x100 + appearance.getLegs()));
		// playerPropsBuilder.putShort((short) (0x100 + appearance.getHead()));
		// playerPropsBuilder.putShort((short) (0x100 + appearance.getHands()));
		// playerPropsBuilder.putShort((short) (0x100 + appearance.getFeet()));
		// playerPropsBuilder.putShort((short) (0x100 + appearance.getBeard()));
		// playerPropsBuilder.putByte(appearance.getHairColor());
		// playerPropsBuilder.putByte(appearance.getTorsoColor());
		// playerPropsBuilder.putByte(appearance.getLegColor());
		// playerPropsBuilder.putByte(appearance.getFeetColor());
		// playerPropsBuilder.putByte(appearance.getSkinColor());
		// playerPropsBuilder.putShort((short) 0x328);
		// playerPropsBuilder.putShort((short) 0x337);
		// playerPropsBuilder.putShort((short) 0x333);
		// playerPropsBuilder.putShort((short) 0x334);
		// playerPropsBuilder.putShort((short) 0x335);
		// playerPropsBuilder.putShort((short) 0x336);
		// playerPropsBuilder.putShort((short) 0x338);
		// playerPropsBuilder.putLong(NameUtility.getNameToLong(player.getName()));
		// playerPropsBuilder.putByte((byte) 3);
		// playerPropsBuilder.putShort((short) 0);
		// Packet playerPacket = playerPropsBuilder.toPacket();
		// ChannelBuffer cb = playerPacket.getChannelBuffer();
		// packetBuilder.putByteC(cb.writerIndex());
		// packetBuilder.putBytes(cb);
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateFaceLocation(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// if (player.getFaceLocation() == null) {
		// 	packetBuilder.putLEShortA(0);
		// 	packetBuilder.putLEShort(0);
		// } else {
		// 	packetBuilder.putLEShortA((player.getFaceLocation().getFaceLocation().getX() * 2) + 1);
		// 	packetBuilder.putLEShort((player.getFaceLocation().getFaceLocation().getY() * 2) + 1);
		// }
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateHit(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// packetBuilder.putByte(player.getHit().getDamage());
		// packetBuilder.putByteA((byte) player.getHit().getHitType().getHitID());
		// packetBuilder.putByteC(player.getSkills()[SkillType.HITPOINT.getID()].getLevel());
		// packetBuilder.putByte((byte) player.getSkills()[SkillType.HITPOINT.getID()].getExperience());
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updateHitTwo(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		// packetBuilder.putByte(player.getHitTwo().getDamage());
		// packetBuilder.putByteA((byte) player.getHitTwo().getHitType().getHitID());
		// packetBuilder.putByteC(player.getSkills()[SkillType.HITPOINT.getID()].getLevel());
		// packetBuilder.putByte((byte) player.getSkills()[SkillType.HITPOINT.getID()].getExperience());
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 */
	public void updateThisPlayerMovement(PacketBuilder packetBuilder) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		/** if (this.getPlayer().isMapChanging() || this.getPlayer().isTeleporting()) {
			packetBuilder.putBits(1, 1);
			packetBuilder.putBits(2, 3);
			packetBuilder.putBits(2, this.getPlayer().getLocation().getZ());
			packetBuilder.putBits(1, 1);
			packetBuilder.putBits(1, this.getPlayer().getUpdateFlags().isUpdateRequired() ? 1 : 0);
			packetBuilder.putBits(7, this.getPlayer().getLocation().getLocalY());
			packetBuilder.putBits(7, this.getPlayer().getLocation().getLocalX());
		} else {
			if (this.getPlayer().getWalkingDirection() == -1) {
				if (this.getPlayer().getUpdateFlags().isUpdateRequired()) {
					packetBuilder.putBits(1, 1);
					packetBuilder.putBits(2, 0);
				} else {
					packetBuilder.putBits(1, 0);
				}
			} else {
				if (this.getPlayer().getRunningDirection() == -1) {
					packetBuilder.putBits(1, 1);
					packetBuilder.putBits(2, 1);
					packetBuilder.putBits(3, this.getPlayer().getWalkingDirection());
					packetBuilder.putBits(1, this.getPlayer().getUpdateFlags().isUpdateRequired() ? 1 : 0);
				} else {
					packetBuilder.putBits(1, 1);
					packetBuilder.putBits(2, 2);
					packetBuilder.putBits(3, this.getPlayer().getWalkingDirection());
					packetBuilder.putBits(3, this.getPlayer().getRunningDirection());
					packetBuilder.putBits(1, this.getPlayer().getUpdateFlags().isUpdateRequired() ? 1 : 0);
				}
			}
		} */
	}

	/**
	 * 
	 * @param packetBuilder
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 */
	public void updatePlayerMovement(PacketBuilder packetBuilder, Player player) {
		if (packetBuilder == null) {
			throw new NullPointerException();
		}
		if (player == null) {
			throw new NullPointerException();
		}
		/** if (player.getWalkingDirection() == -1) {
			if (this.getPlayer().getUpdateFlags().isUpdateRequired()) {
				packetBuilder.putBits(1, 1);
				packetBuilder.putBits(2, 0);
			} else {
				packetBuilder.putBits(1, 0);
			}
		} else if (player.getRunningDirection() == -1) {
			packetBuilder.putBits(1, 1);
			packetBuilder.putBits(2, 1);
			packetBuilder.putBits(3, player.getWalkingDirection());
			packetBuilder.putBits(1, player.getUpdateFlags().isUpdateRequired() ? 1 : 0);
		} else {
			packetBuilder.putBits(1, 1);
			packetBuilder.putBits(2, 2);
			packetBuilder.putBits(3, player.getWalkingDirection());
			packetBuilder.putBits(3, player.getRunningDirection());
			packetBuilder.putBits(1, player.getUpdateFlags().isUpdateRequired() ? 1 : 0);
		} */
	}

	/**
	 * 
	 * @param entityUpdate
	 * 			The id to set.
	 */
	public void setEntityUpdate(EntityUpdate entityUpdate) {
		this.entityUpdate = entityUpdate;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public EntityUpdate getEntityUpdate() {
		return this.entityUpdate;
	}

	/**
	 * 
	 * @param player
	 * 			The id to set.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Player getPlayer() {
		return this.player;
	}
}