package com.netty.net.packet.player;

import java.util.Random;

import com.netty.model.player.Player;
import com.netty.model.update.FaceEntity;
import com.netty.model.update.UpdateFlag;
import com.netty.net.packet.PacketAttribute;
import com.netty.net.packet.PacketHandler;
import com.netty.world.Location;
import com.netty.world.World;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:17:09 PM
 */
public class FollowPacketHandler implements PacketHandler {

	/* (non-Javadoc)
	 * @see com.netty.net.packet.PacketHandler#handlePacket(com.netty.net.packet.PacketAttribute, com.netty.model.player.Player)
	 */
	@Override
	public void handlePacket(PacketAttribute packetAttribute, Player player) {
		Integer followIDInteger = (Integer) packetAttribute.getAttribute("FOLLOW_ID");
		int followID = followIDInteger.intValue();// getLEShort() & 0xFF;
		Player followPlayer = World.getWorld().getPlayerList().get(followID);
		short entityX = followPlayer.getLocation().getX();
		short entityY = followPlayer.getLocation().getY();
		short playerX = followPlayer.getLocation().getX();
		short playerY = followPlayer.getLocation().getY();
		boolean isWithinDistance = player.getLocation().isWithinDistance(new Location(entityX, entityY, player.getLocation().getZ()));
		if (!isWithinDistance) {
			return;
		}
		player.setFaceEntity(new FaceEntity(followPlayer));
		player.getUpdateFlags().setUpdateFlag(UpdateFlag.FACE_ENTITY);
		if ((entityY == playerY) && (entityX == playerX)) {
			Random random = new Random();
			switch (random.nextInt(3)) {
				case 0:
					// this.walkTo(player, 0, this.getMovement(playerX, entityX - 1));
					break;
				case 1:
					// this.walkTo(player, 0, this.getMovement(playerX, entityX + 1));
					break;
				case 2:
					// this.walkTo(player, 0, this.getMovement(playerY, entityY + 1));
					break;
				case 3:
					// this.walkTo(player, 0, this.getMovement(playerY, entityY - 1));
					break;
			}
		}
		if (player.getWalking().isRunning() && !isWithinDistance) {
			if ((entityY > playerY) && (entityX == playerX)) {
				// this.walkTo(player, 0, this.getMovement(playerY, entityY - 1) + this.getMovement(playerY, entityY - 1));
			} else if ((entityY < playerY) && (entityX == playerX)) {
				// this.walkTo(player, 0, this.getMovement(playerY, entityY + 1) + this.getMovement(playerY, entityY + 1));
			} else if ((entityX > playerX) && (entityY == playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX - 1) + this.getMovement(playerX, entityX - 1), 0);
			} else if ((entityX < playerX) && (entityY == playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX + 1) + this.getMovement(playerX, entityX + 1), 0);
			} else if ((entityX < playerX) && (entityY < playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX + 1) + this.getMovement(playerX, entityX + 1), this.getMovement(playerY, entityY + 1) + this.getMovement(playerY, entityY + 1));
			} else if ((entityX > playerX) && (entityY > playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX - 1) + this.getMovement(playerX, entityX - 1), this.getMovement(playerY, entityY - 1) + this.getMovement(playerY, entityY - 1));
			} else if ((entityX < playerX) && (entityY > playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX + 1) + this.getMovement(playerX, entityX + 1), this.getMovement(playerY, entityY - 1) + this.getMovement(playerY, entityY - 1));
			} else if ((entityX > playerX) && (entityY < playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX + 1) + this.getMovement(playerX, entityX + 1), this.getMovement(playerY, entityY - 1) + this.getMovement(playerY, entityY - 1));
			}
		} else {
			if ((entityY > playerY) && (entityX == playerX)) {
				// this.walkTo(player, 0, this.getMovement(playerY, entityY - 1));
			} else if ((entityY < playerY) && (entityX == playerX)) {
				// this.walkTo(player, 0, this.getMovement(playerY, entityY + 1));
			} else if ((entityX > playerX) && (entityY == playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX - 1), 0);
			} else if ((entityX < playerX) && (entityY == playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX + 1), 0);
			} else if ((entityX < playerX) && (entityY < playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX + 1), this.getMovement(playerY, entityY + 1));
			} else if ((entityX > playerX) && (entityY > playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX - 1), this.getMovement(playerY, entityY - 1));
			} else if ((entityX < playerX) && (entityY > playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX + 1), this.getMovement(playerY, entityY - 1));
			} else if ((entityX > playerX) && (entityY < playerY)) {
				// this.walkTo(player, this.getMovement(playerX, entityX - 1), this.getMovement(playerY, entityY + 1));
			}
		}
	}

	/**
	 * 
	 */
	public void walkTo(/** Player player, int i, int j*/) {
		/** c.newWalkCmdSteps = 0;
		if (++c.newWalkCmdSteps > 50) {
			c.newWalkCmdSteps = 0;
		}
		int k = c.getX() + i;
		k -= player.getLocation().getRegionX() * 8;
		c.newWalkCmdX[0] = c.newWalkCmdY[0] = 0;
		int l = c.getY() + j;
		l -= player.getLocation().getRegionY() * 8;
		for (int n = 0; n < c.newWalkCmdSteps; n++) {
			c.newWalkCmdX[n] += k;
			c.newWalkCmdY[n] += l;
		} */
	}

	/**
	 * 
	 * @param place1
	 * 			The id to set.
	 * @param place2
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public int getMovement(int place1, int place2) {
		if ((place1 - place2) == 0) {
			return 0;
		} else if ((place1 - place2) < 0) {
			return 1;
		} else if ((place1 - place2) > 0) {
			return -1;
		}
		return 0;
	}
}